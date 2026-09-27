package com.paygo.riesgo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnalisisServiceTest {

    @Test
    void debeClasificarComoAprobadaCuandoNoExcedeEl70PorCiento() {
        var service = new AnalisisService(null);
        var resultado = service.determinarSituacion(1000.0, 650.0);

        assertEquals("Aprobada", resultado);
    }

    @Test
    void debeClasificarComoObservadaCuandoSuperaEl70PorCiento() {
        var service = new AnalisisService(null);
        var resultado = service.determinarSituacion(1000.0, 800.0);

        assertEquals("Observada", resultado);
    }
}
