package com.pedroalmeida.kafkaproducer.controller;

import com.pedroalmeida.common.Employee;
import com.pedroalmeida.common.Event;
import com.pedroalmeida.kafkaproducer.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/event")
public class EventController {

    private final EventService eventService;

    @PostMapping
    public ResponseEntity<String> sendEvent() {

        Event event = new Event(UUID.randomUUID().toString(), null);

        eventService.sendEvent(event);
        return ResponseEntity.ok().body("Sent event: " + event);
    }

}
