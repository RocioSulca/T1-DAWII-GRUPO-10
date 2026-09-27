package com.paygo.riesgo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RecargaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RecargaConsumer.class);

    private final AnalisisService analisisService;

    public RecargaConsumer(AnalisisService analisisService) {
        this.analisisService = analisisService;
    }

    @RabbitListener(queues = RabbitMQConfig.RIESGO_QUEUE)
    public void consumir(RecargaMessage mensaje) {
        LOGGER.info("Mensaje recibido de la cola Sulca: {}", mensaje);
        Analisis analisis = analisisService.registrarAnalisis(mensaje);
        LOGGER.info("Análisis registrado: idRecarga={}, situacion={}", analisis.getIdRecarga(), analisis.getSituacion());
    }
}
