<!-- PROJECT LOGO -->
<p align="center">
  <img src="https://cdn-icons-png.flaticon.com/512/6146/6146577.png" alt="Microservices Logo" height="300" width="300"/>
</p>

<h1 align="center">🚀 Microservices with Spring Boot — Learning Journey</h1>

<p align="center">
  Hands-on implementation of modern <b>Microservices Architecture</b> using <b>Spring Boot</b> and <b>Spring Cloud</b>, following the Udemy course  
  <a href="https://www.udemy.com/course/microservices-with-spring-boot/?couponCode=UPGRADE02223" target="_blank">
  <i>"Microservices with Spring Boot"</i> by Shabbir Dawoodi</a>.
</p>

---

## 🧠 About the Project

This repository documents my journey of learning **Microservices Architecture** — from foundational concepts to advanced deployment and monitoring techniques.

Each module focuses on a specific concept, building a complete distributed microservice ecosystem that includes:

- Independent deployable services  
- Service Discovery and Configuration Management  
- Centralized logging, tracing, and fault tolerance  
- CI/CD and Cloud Deployment  

---

## 🧩 Microservices Implemented

| Service | Description | Port |
|----------|--------------|------|
| 🛒 **ProductService** | Manages product information | `8080` |
| 📦 **OrderService** | Handles order placement and tracking | `8081` |
| 💳 **PaymentService** | Processes payments for orders | `8082` |
| ⚙️ **ConfigServer** | Centralized configuration for all services | `9296` |
| 🌐 **ServiceRegistry (Eureka)** | Service Discovery and Registration | `8761` |

> All services communicate via **REST APIs** and are registered with **Eureka Server**.  
> Configuration is managed through **Spring Cloud Config Server**.

---

## ⚙️ Tech Stack

| Category | Tools / Frameworks |
|-----------|--------------------|
| **Language** | Java 17 |
| **Framework** | Spring Boot 2.7.18 |
| **Cloud Stack** | Spring Cloud 2021.0.8 |
| **Database** | MySQL |
| **Service Discovery** | Netflix Eureka |
| **Config Management** | Spring Cloud Config Server |
| **Tracing & Monitoring** | Sleuth + Zipkin |
| **Resilience** | Resilience4j |
| **Containerization** | Docker |
| **Orchestration** | Kubernetes |
| **Security** | OAuth2, Okta |
| **CI/CD** | GitHub Actions / Jenkins |
| **Deployment** | Google Cloud Platform (GCP) |

---

## 🧰 Versions Required

| Component | Version |
|------------|----------|
| **Java (JDK)** | 17 |
| **Spring Boot** | 2.7.18 |
| **Spring Cloud** | 2021.0.8 |
| **Maven** | 3.8+ |
| **MySQL** | 8.0+ |
| **Zipkin (for tracing)** | 2.23+ |
| **Docker Desktop** | Latest |
| **Kubernetes (Minikube)** | v1.32+ |
| **IntelliJ IDEA / VS Code** | Any recent version |

---

## 🏗️ Architecture Overview

```text
                   +------------------+
                   |  Config Server   |
                   |  (Port: 9296)    |
                   +--------+---------+
                            |
                            v
+----------------+   +--------------+   +----------------+
| ProductService |<->| OrderService |<->| PaymentService |
|   (8080)       |   |   (8081)     |   |    (8082)     |
+----------------+   +--------------+   +----------------+
          |                   |                  |
          +--------> Eureka Service Registry <---+
                       (Port: 8761)

                       
```
## Each service:

- Registers itself to **Eureka Server**
- Fetches configuration from **Config Server**
- Logs and traces requests via **Sleuth** & **Zipkin**

# 🧬 Key Learning Outcomes

### 🌱 Core Microservice Concepts
- Difference between **Monolithic**, **SOA**, and **Microservice architectures**
- Designing loosely coupled and independently deployable services

### 🧰 Building Production-Ready Microservices

- Creating **Spring Boot REST APIs**
- Using **Spring Data JPA** and **MySQL** for persistence
- Implementing **Feign Clients** for inter-service communication

### ⚙️ Configuration & Discovery

- Centralized configuration via **Spring Cloud Config Server**
- Service registration and discovery using **Eureka Server**

### 🛡️ Resilience & Security

- Using **Resilience4j** for fault tolerance (*Circuit Breaker, Retry, Bulkhead*)
- Implementing **OAuth2 authentication** with **Okta**

### 🐳 Containerization & Orchestration

- Packaging services into **Docker** containers  
- Deploying and orchestrating with **Kubernetes**

### ☁️ CI/CD & Cloud Deployment

- Automating builds with **GitHub Actions** / **Jenkins**  
- Deploying services to **Google Cloud Platform (GCP)**

### 🔎 Distributed Tracing & Logging

- Integrating **Sleuth** and **Zipkin** for request tracing  
- Aggregating logs for better observability

---

# 🧑‍💻 How to Run Locally

#### 1️⃣ Clone the repository
```bash
git clone https://github.com/<your-username>/springboot-microservices-course.git
cd springboot-microservices-course
```
#### 2️⃣ Start Config Server
```bash
mvn spring-boot:run -f ConfigServer/pom.xml
```
### 3️⃣ Run Eureka Service Registry
```bash
mvn spring-boot:run -f ServiceRegistry/pom.xml
```
### 4️⃣ Start each microservice
```bash
mvn spring-boot:run -f ProductService/pom.xml
mvn spring-boot:run -f OrderService/pom.xml
mvn spring-boot:run -f PaymentService/pom.xml
```
### 5️⃣ Run Zipkin (optional)
```bash
docker run -d -p 9411:9411 openzipkin/zipkin
```
---

# 🧾 License

This project is for **educational and learning purposes** only.  
Feel free to **explore**, **fork**, and **contribute** improvements — while giving credit to the original course author and this repository.

---

# 🌟 Acknowledgments

Special thanks to:

- **Shabbir Dawoodi** — for the excellent *Microservices with Spring Boot* course  
- The **Spring & Spring Cloud Community** — for providing robust tools that power modern distributed systems

