package com.paygo.tarjetas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TarjetaServiceTest {

    @Test
    void debeDeterminarSaldoDisponible() {
        var service = new TarjetaService();
        var tarjeta = service.buscarPorId(1L);

        assertEquals(1200.0, tarjeta.getSaldoDisponible());
    }
}
