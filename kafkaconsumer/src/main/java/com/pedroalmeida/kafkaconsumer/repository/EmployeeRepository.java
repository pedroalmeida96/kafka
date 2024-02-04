package com.pedroalmeida.kafkaconsumer.repository;

import com.pedroalmeida.kafkaconsumer.model.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

}