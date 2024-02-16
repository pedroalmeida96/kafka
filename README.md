# Microservices Spring Boot Application with Kafka, Schema Registry, Zookeeper, MariaDB

## Table of Contents

- [Introduction](#introduction)
- [Components](#components)
  - [Spring Boot Microservices](#spring-boot-microservices)
  - [Apache Kafka](#apache-kafka)

## Introduction:

This README provides an overview of a basic microservices architecture implemented using Spring Boot framework along with Kafka, Schema Registry, Zookeeper, and MariaDB. The application comprises one consumer and one producer service communicating through Kafka messaging system. Docker Compose is utilized to orchestrate and manage the containers.

## Components:
### Spring Boot Microservices:
Producer Service: This service generates messages and publishes them to Kafka topics.

Consumer Service: This service consumes messages from Kafka topics and processes them accordingly.

### Apache Kafka:
Kafka is used as the messaging system to facilitate communication between the producer and consumer services.
Schema Registry:

Schema Registry is employed to manage schemas for Kafka messages ensuring compatibility and consistency in message formats.
Zookeeper:

Zookeeper serves as the coordination service for distributed systems and is necessary for managing Kafka brokers.

### MariaDB:
MariaDB is utilized as the relational database management system for storing application data.

### Docker Compose:
Docker Compose is used for defining and running multi-container Docker applications. It simplifies the deployment process by enabling containerization of the entire application stack.

## Prerequisites:
Docker and docker-compose installed on the host machine.

### Setup Instructions:

```
git clone https://github.com/pedroalmeida96/kafka
cd <directory>
docker-compose pull
docker-compose up
```

Once the containers are up and running, the microservices should be accessible.

### Accessing Services:

| Method   | URL                                                               | Description                                                                                 |
| -------- |-------------------------------------------------------------------|---------------------------------------------------------------------------------------------|
| `GET`    | `http://localhost:8079/event`                                     | Retrieve all employees.                                                                     |
| `POST`   | `http://localhost:8081/event`                                     | Add a new employee.                                                                         |


## KAFKA PLAYGROUND REPOSITORY

error handling

multiple consumers and producers

SWAGGER