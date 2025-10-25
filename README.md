# 🚀 Microservices Spring Boot Application with Kafka, Schema Registry, Zookeeper, MariaDB, Prometheus, Grafana, Minikube & Helm

## 📑 Table of Contents

- [🌐 Overview](#-overview)
- [⚙️ Components](#️-components)
    - [🧩 Spring Boot Microservices](#-spring-boot-microservices)
    - [📡 Kafka Ecosystem](#-kafka-ecosystem)
    - [🗄️ MariaDB](#️-mariadb)
    - [📊 Monitoring (Prometheus & Grafana)](#-monitoring-prometheus--grafana)
- [🧰 Prerequisites](#-prerequisites)
- [☸️ Kubernetes](#kubernetes)
    - [🏗️ Minikube Setup Instructions](#minikube-setup-instructions)
    - [🌍 Accessing Services](#accessing-services)

---

## 🌐 Overview

This project showcases a **microservices architecture** built with **Spring Boot**, leveraging **Kafka**, **Schema Registry**, **Zookeeper**, and **MariaDB**.  
It features:
- A **Producer Service** that sends events to Kafka topics
- A **Consumer Service** that processes messages from Kafka
- **Prometheus & Grafana** for monitoring
- Deployment via **Helm** on **Minikube** for local Kubernetes orchestration.

---

## ⚙️ Components

### 🧩 Spring Boot Microservices

- **Producer Service:** Publishes messages to Kafka topics
- **Consumer Service:** Consumes and processes messages from Kafka topics  
  Both expose **Actuator** endpoints for health checks and metrics (`/actuator/prometheus`).

---

### 📡 Kafka Ecosystem

- **Kafka:** Central messaging backbone for service communication
- **Schema Registry:** Maintains Avro schemas and enforces compatibility
- **Zookeeper:** Coordinates Kafka brokers and ensures cluster stability

---

### 🗄️ MariaDB

Used as the **relational database** for persisting business data.

---

### 📊 Monitoring (Prometheus & Grafana)

- **Prometheus:** Scrapes metrics from Spring Boot Actuator and other services for performance insights
- **Grafana:** Visualizes metrics through dashboards

📁 Folder structure:

```text
monitoring/
├── prometheus/
│   └── prometheus.yml
└── grafana/
    └── provisioning/
        ├── dashboards/
        │   ├── dashboards.yml
        │   └── my-dashboard.json
        └── datasources/
            └── datasource.yml
```

## 🧰 Prerequisites

Before setting up the project, make sure the following tools are installed and properly configured on your system:

### 🧱 Development
- **Java 17+** — to build and run Spring Boot microservices
- **Maven** — for dependency management and project builds
- **Postman** — to test and validate REST APIs

### 🐳 Containerization
- **Docker** — to build, run, and manage containers locally

### ☸️ Kubernetes & Deployment
- **Minikube** — to create a local Kubernetes cluster
- **kubectl** — to interact with the cluster and manage resources
- **Helm** — to simplify Kubernetes deployments and manage Helm charts

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


```
sudo chown $USER /var/run/docker.sock
docker stop $(docker ps -aq) && docker rm $(docker ps -aq)
docker-compose pull && docker-compose up -d
```