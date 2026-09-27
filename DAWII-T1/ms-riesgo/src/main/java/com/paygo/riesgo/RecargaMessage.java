package com.paygo.riesgo;

import java.time.LocalDate;

public record RecargaMessage(
        Long idRecarga,
        Long idTarjeta,
        Double saldoDisponible,
        Double montoRecarga,
        LocalDate fechaRecarga
) {
}
