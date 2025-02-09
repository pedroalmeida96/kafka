# Microservices Spring Boot Application with Kafka, Schema Registry, Zookeeper, MariaDB, Minikube and Helm

## Table of Contents

- [Overview](#overview)
- [Components](#components)
    - [Spring Boot Microservices](#spring-boot-microservices)
    - [Kafka Ecosystem](#kafka-ecosystem)
    - [MariaDB](#mariadb)
- [Kubernetes](#kubernetes)
    - [Minikube setup instructions](#minikube-setup-instructions)
    - [Accessing Services](#accessing-services)

## Overview:

This project demonstrates a basic microservices architecture using **Spring Boot**, integrated with **Kafka**, **Schema
Registry**,
**Zookeeper**, and **MariaDB**. The architecture includes a **Producer Service** and a **Consumer Service**
communicating through Kafka.
The deployment is managed using **Helm** and **Minikube** for container orchestration and cluster management.

## Components:

### Spring Boot Microservices:

**Producer Service:** Publishes messages to Kafka topics.

**Consumer Service:** Consumes and processes messages from Kafka topics.

### Kafka Ecosystem:

**Kafka:** Acts as the messaging system, enabling communication between services.

**Schema Registry:** Ensures message format compatibility and consistency by managing message schemas.

**Zookeeper:** Coordinates and manages Kafka brokers in the distributed system.

### MariaDB:

**MariaDB** is utilized as the relational database management system for storing application data.

### Helm & Minikube

**Helm:** Manages the deployment of services as charts, simplifying Kubernetes configurations.

**Minikube:** Provides a lightweight local Kubernetes cluster for testing and development.

## Prerequisites

Before running the project, ensure the following are installed on your system:

- Minikube
- Helm
- kubectl
- Java
- Gradle

## Kubernetes:

### Minikube setup instructions

```
git clone https://github.com/pedroalmeida96/kafka
cd <directory>
minikube start
cd kafkaconsumer
eval $(minikube docker-env)
docker build -t kafka-consumer:latest .
cd ..
cd kafkaproducer
docker build -t kafka-producer:latest .
helm install release-1.0.0 ./helm --values helm/values.yaml
minikube service kafka-consumer --url -->> resulting <kafka-consumer-ip>:<kafka-consumer-port>
minikube service kafka-producer --url -->> resulting <kafka-producer-ip>:<kafka-producer-port>
```

### Accessing Services:

| Method | URL                                                         | Description             |
|--------|-------------------------------------------------------------|-------------------------|
| `GET`  | `http://<kafka-consumer-ip>:<kafka-consumer-port>/employee` | Retrieve all employees. |
| `POST` | `http://<kafka-producer-ip>:<kafka-producer-port>/event`    | Add a new employee.     |

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

$ helm create helm /* creates folder helm with structure inside - content of templates to be deleted entirelly */
$ helm install release-1.0.0 ./helm
$ helm get manifest release-1.0.0 /* see what is deployed under release-1.0.0 */ 
$ helm uninstall release-1.0.0
$ helm ls
$ helm upgrade release-1.0.0 ./helm /* No helm values being used, just changes done and upgrade */ 
$ helm upgrade release-1.0.0 ./helm --values helm/values.yaml /* Specify helm values and its directory */
```
