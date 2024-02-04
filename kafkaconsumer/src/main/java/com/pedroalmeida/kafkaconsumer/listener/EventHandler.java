package com.pedroalmeida.kafkaconsumer.listener;

import com.pedroalmeida.common.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EventHandler {

    @KafkaListener(topics = "pedroalmeida.eventTopic", groupId = "mygroup")
    public void consumeEvent(Event event) {
        log.info("Event received: {}", event);
    }

}
