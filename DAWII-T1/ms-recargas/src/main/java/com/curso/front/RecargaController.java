package com.curso.front;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/recargas")
public class RecargaController {

    private final TarjetaClient tarjetaClient;
    private final RecargaServicio recargaServicio;
    private final RabbitTemplate rabbitTemplate;

    public RecargaController(TarjetaClient tarjetaClient, RecargaServicio recargaServicio, RabbitTemplate rabbitTemplate) {
        this.tarjetaClient = tarjetaClient;
        this.recargaServicio = recargaServicio;
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping
    public List<Recarga> listarRecargas() {
        return recargaServicio.listar();
    }

    @PostMapping
    public ResponseEntity<Recarga> registrarRecarga(@RequestBody Recarga recarga) {
        TarjetaResponse tarjeta = tarjetaClient.getTarjeta(recarga.getIdTarjeta());
        if (tarjeta == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        recarga.setSaldoDisponible(tarjeta.getSaldoDisponible());
        if (recarga.getFechaRecarga() == null) {
            recarga.setFechaRecarga(LocalDate.now());
        }

        Recarga registrada = recargaServicio.registrar(recarga);

        rabbitTemplate.convertAndSend(
                "sulca-exchange",
                "sulca.recarga",
                new RecargaMessage(
                        registrada.getIdRecarga(),
                        registrada.getIdTarjeta(),
                        registrada.getSaldoDisponible(),
                        registrada.getMontoRecarga(),
                        registrada.getFechaRecarga()
                )
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(registrada);
    }
}
