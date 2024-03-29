package com.pedroalmeida.kafkaconsumer.service;

import com.pedroalmeida.kafkaconsumer.model.EmployeeEntity;
import com.pedroalmeida.kafkaconsumer.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void saveEmployee(EmployeeEntity employeeEntity) {
        employeeRepository.save(employeeEntity);
    }
}
