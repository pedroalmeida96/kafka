package com.pedroalmeida.kafkaproducer.controller;

import com.pedroalmeida.kafkaproducer.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/message")
public class MessageController {

    private final MessageService messageService;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        messageService.sendMessage(message);
        return ResponseEntity.ok().body("Message sent successfully: " + message);
    }

}
