package com.pedroalmeida.kafkaconsumer.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class MessageHandler {

    @KafkaListener(topics = "${topicName}", groupId = "group_id")
    public void consumeMessage(String message) throws IOException {
        log.info("Message received: {}", message);
    }

}
