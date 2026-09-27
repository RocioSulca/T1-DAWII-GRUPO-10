package com.paygo.riesgo;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String RIESGO_EXCHANGE = "sulca-exchange";
    public static final String RIESGO_QUEUE = "sulca-queue";
    public static final String RIESGO_ROUTING_KEY = "sulca.recarga";

    @Bean
    public DirectExchange riesgoExchange() {
        return new DirectExchange(RIESGO_EXCHANGE);
    }

    @Bean
    public Queue riesgoQueue() {
        return new Queue(RIESGO_QUEUE, true);
    }

    @Bean
    public Binding riesgoBinding(Queue riesgoQueue, DirectExchange riesgoExchange) {
        return BindingBuilder.bind(riesgoQueue).to(riesgoExchange).with(RIESGO_ROUTING_KEY);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
