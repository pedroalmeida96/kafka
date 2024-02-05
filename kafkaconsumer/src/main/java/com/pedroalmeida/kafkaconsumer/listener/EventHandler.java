package com.pedroalmeida.kafkaconsumer.listener;

import com.pedroalmeida.common.Event;
import com.pedroalmeida.kafkaconsumer.model.EmployeeEntity;
import com.pedroalmeida.kafkaconsumer.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventHandler {

    private final EmployeeService employeeService;

    @KafkaListener(topics = "pedroalmeida.eventTopic", groupId = "mygroup")
    public void consumeEvent(Event event) {
        log.info("Event received: {}", event);
        var employeeEntity = EmployeeEntity.builder().name(event.getData().getName()).build();
        employeeService.saveEmployee(employeeEntity);
    }

}
