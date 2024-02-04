package com.pedroalmeida.kafkaproducer.service;

import com.pedroalmeida.common.Event;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventService {
    @Value("${kafka.topic.names.mytopic}")
    private String topicName;

    private final KafkaTemplate<String, Event> kafkaTemplate;

    public void sendEvent(Event event) {
        log.info("Sending event: {}", event);
        kafkaTemplate.send(topicName, event);
    }
}
