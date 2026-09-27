package com.paygo.tarjetas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarjetas")
public class TarjetaController {

    private final TarjetaService tarjetaService;

    public TarjetaController(TarjetaService tarjetaService) {
        this.tarjetaService = tarjetaService;
    }

    @GetMapping
    public List<Tarjeta> listarTarjetas() {
        return tarjetaService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarjeta> consultarTarjeta(@PathVariable Long id) {
        Tarjeta tarjeta = tarjetaService.buscarPorId(id);
        if (tarjeta == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(tarjeta);
    }

    @PostMapping
    public ResponseEntity<Tarjeta> registrarTarjeta(@RequestBody Tarjeta tarjeta) {
        Tarjeta registrada = tarjetaService.registrar(tarjeta);
        return ResponseEntity.status(HttpStatus.CREATED).body(registrada);
    }
}
