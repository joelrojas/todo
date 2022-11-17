package com.example.todo.consumer;

import com.example.todo.config.RabbitMqConfig;
import com.example.todo.dto.MessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    private Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @RabbitListener(queues = RabbitMqConfig.QUEUE)
    public void listener(MessageDto messageDto) {
        if(messageDto.getMessage().length() < 10) {
            LOGGER.error("EL MENSAJE ES INVALIDO");
            throw new RuntimeException();
        }
        LOGGER.info("Mensaje recibido: {}", messageDto.toString());

    }
}
