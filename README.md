# Microservices Spring Boot Application with Kafka, Schema Registry, Zookeeper, MariaDB

## Table of Contents

- [Introduction](#introduction)
- [Components](#components)
  - [Spring Boot Microservices](#spring-boot-microservices)
  - [Kafka, Schema Registry, Zookeeper](#kafka-schema-registry-zookeeper)
  - [MariaDB](#mariadb)
- [Prerequisites](#prerequisites)
  - [Setup Instructions](#setup-instructions)
  - [Accessing Services](#accessing-services)
- [Kubernetes](#kubernetes)

## Introduction:

This README provides an overview of a basic microservices architecture implemented using Spring Boot framework along with Kafka, Schema Registry, Zookeeper, and MariaDB. The application comprises one consumer and one producer service communicating through Kafka messaging system. Docker Compose is utilized to orchestrate and manage the containers.

## Components:
### Spring Boot Microservices:
Producer Service: This service generates messages and publishes them to Kafka topics.

Consumer Service: This service consumes messages from Kafka topics and processes them accordingly.

### Kafka, Schema Registry, Zookeeper:
Kafka is used as the messaging system to facilitate communication between the producer and consumer services.
Schema Registry:

Schema Registry is employed to manage schemas for Kafka messages ensuring compatibility and consistency in message formats.
Zookeeper:

Zookeeper serves as the coordination service for distributed systems and is necessary for managing Kafka brokers.

### MariaDB:
MariaDB is utilized as the relational database management system for storing application data.

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

| Method   | URL                               | Description                                                                                 |
| -------- |-----------------------------------|---------------------------------------------------------------------------------------------|
| `GET`    | `http://localhost:8081/employee`  | Retrieve all employees.                                                                     |
| `POST`   | `http://localhost:8081/event`     | Add a new employee.                                                                         |


## Kubernetes:

Minikube deployment instructions:
```
minikube start
cd kafkaconsumer
eval $(minikube docker-env)
docker build -t kafka-consumer:latest .
cd ..
cd kafkaproducer
docker build -t kafka-producer:latest .
helm install release-1.0.0 ./helm --values helm/values.yaml
kubectl get all
kubectl rollout restart deployment
minikube service kafka-consumer --url -->> Use resulting urls to send requests
minikube service kafka-producer --url -->> Use the resulting to send requests

minikube tunnel /* starts a tunnel in minikube to be able to send http requests to localhost:8080 */
```

Other useful commands:
```
minikube version
minikube
docker context use default
minikube status

minikube delete
minikube start
minikube ip

kubectl get service
kubectl get pods
kubectl get all
kubectl get node

kubectl delete --all pods --namespace=default
kubectl delete --all deployments --namespace=default

kubectl rollout restart deployment <pod>
kubectl rollout restart deployment -->> restarts all
```

https://helm.sh/docs/intro/install/
https://www.youtube.com/watch?v=jUYNS90nq8U&t

helm
```
$ helm create helm /* creates folder helm with structure inside - content of templates to be deleted entirelly */
$ helm install release-1.0.0 ./helm
$ helm get manifest release-1.0.0 /* see what is deployed under release-1.0.0 */ 
$ helm uninstall release-1.0.0
$ helm ls
$ helm upgrade release-1.0.0 ./helm /* No helm values being used, just changes done and upgrade */ 
$ helm upgrade release-1.0.0 ./helm --values helm/values.yaml /* Specify helm values and its directory */
```
