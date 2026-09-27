package com.curso.front;

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

    public static final String SULCA_EXCHANGE = "sulca-exchange";
    public static final String SULCA_QUEUE = "sulca-queue";
    public static final String SULCA_ROUTING_KEY = "sulca.recarga";

    @Bean
    public DirectExchange sulcaExchange() {
        return new DirectExchange(SULCA_EXCHANGE);
    }

    @Bean
    public Queue sulcaQueue() {
        return new Queue(SULCA_QUEUE, true);
    }

    @Bean
    public Binding sulcaBinding(Queue sulcaQueue, DirectExchange sulcaExchange) {
        return BindingBuilder.bind(sulcaQueue).to(sulcaExchange).with(SULCA_ROUTING_KEY);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
