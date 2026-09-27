package com.paygo.riesgo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalisisService {

    private final AnalisisRepository analisisRepository;

    public AnalisisService(AnalisisRepository analisisRepository) {
        this.analisisRepository = analisisRepository;
    }

    public String determinarSituacion(Double saldoDisponible, Double montoRecarga) {
        if (saldoDisponible == null || saldoDisponible <= 0) {
            return "Observada";
        }
        double porcentaje = (montoRecarga / saldoDisponible) * 100;
        return porcentaje <= 70 ? "Aprobada" : "Observada";
    }

    public Analisis registrarAnalisis(RecargaMessage mensaje) {
        String situacion = determinarSituacion(mensaje.saldoDisponible(), mensaje.montoRecarga());
        Analisis analisis = new Analisis(
                mensaje.idRecarga(),
                mensaje.idTarjeta(),
                mensaje.saldoDisponible(),
                mensaje.montoRecarga(),
                mensaje.fechaRecarga(),
                situacion
        );
        return analisisRepository.save(analisis);
    }

    public List<Analisis> listar() {
        return analisisRepository.findAll();
    }
}
