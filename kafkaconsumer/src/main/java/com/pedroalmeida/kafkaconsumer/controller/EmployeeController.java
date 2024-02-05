package com.pedroalmeida.kafkaconsumer.controller;

import com.pedroalmeida.kafkaconsumer.model.EmployeeEntity;
import com.pedroalmeida.kafkaconsumer.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/employee")
@RestController
@RequiredArgsConstructor
public class  EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<EmployeeEntity> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

}
