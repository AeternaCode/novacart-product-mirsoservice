# NOVACART PRODUCT SERVICE

A Spring Boot 4 based REST API responsible for managing products and categories in the NovaCart E-Commerce platform.

---

# Features

## Product Management

- Create Product
- Update Product
- Get Product By Id
- Get All Products
- Soft Delete Product

## Category Management

- Create Category
- Update Category
- Get Category By Id
- Get All Categories
- Soft Delete Category

## Common Features

- Input Validation (Jakarta Validation)
- Global Exception Handling
- Pagination
- Sorting
- Dynamic Filtering (JPA Specifications)
- Soft Delete
- Auditing
- Logging (SLF4J)
- OpenAPI / Swagger Documentation
- Flyway Database Migration

---

# Tech Stack

## Backend

- Java 21
- Spring Boot 4
- Spring Data JPA
- Hibernate

## Database

- MySQL
- Flyway

## Build Tool

- Gradle (Wrapper)

## Code Quality

- JaCoCo
- SonarQube Community Edition

## CI

- GitHub Actions
- Self Hosted Runner

---

# Prerequisites

Install the following before running the project.

- JDK 21
- MySQL 8+
- Git
- Docker Desktop (for SonarQube)
- Gradle (Optional, Gradle Wrapper is included)
- IntelliJ IDEA / VS Code

---

# Clone Repository

```bash
git clone <repository-url>

cd novacart-product-service
```

---

# Database Setup

Create the database.

```sql
CREATE DATABASE product_service_db;
```

---

# Configure Database

Update

```text
src/main/resources/application.properties
```

Example

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/product_service_db
spring.datasource.username=root
spring.datasource.password=your_password
```

---

# Flyway Migration

Flyway automatically creates and updates the database schema.

No manual table creation is required.

Simply start the application.

---

# Local SonarQube Setup

SonarQube is **not required** to run the application.

It is only required if you want to perform local code analysis.

## Step 1

Start SonarQube using Docker.

Example:

```bash
docker start sonarqube
```

or start your Docker Compose stack if applicable.

The SonarQube dashboard should be available at

```text
http://localhost:9000
```

---

## Step 2

Create a file named

```text
gradle-local.properties
```

in the project root.

Example:

```properties
sonar.host.url=http://localhost:9000
sonar.token=YOUR_SONAR_TOKEN
```

> **Note**
>
> This file is intentionally ignored by Git and must never be committed.

---

# Build Project

Linux / macOS

```bash
./gradlew clean build
```

Windows

```bash
gradlew.bat clean build
```

---

# Run Application

Linux / macOS

```bash
./gradlew bootRun
```

Windows

```bash
gradlew.bat bootRun
```

---

# Run SonarQube Analysis

After SonarQube is running locally and `gradle-local.properties` has been configured:

Linux / macOS

```bash
./gradlew sonar
```

Windows

```bash
gradlew.bat sonar
```

---

# Generate JaCoCo Report

Linux / macOS

```bash
./gradlew jacocoTestReport
```

Windows

```bash
gradlew.bat jacocoTestReport
```

The HTML report will be generated under

```text
build/reports/jacoco/test/html/index.html
```

---

# Swagger Documentation

After the application starts

```text
http://localhost:8080/swagger-ui/index.html
```

---

# API Testing

The APIs can be tested using

- Swagger UI
- Postman

---

# Project Structure

```text
src
├── controller
├── service
├── repository
├── specification
├── entity
├── dto
├── mapper
├── config
├── exception
├── utils
└── db
    └── migration
```

---

# CI Pipeline

The project uses GitHub Actions with a self-hosted runner.

The CI pipeline performs:

- Checkout Repository
- Setup Java 21
- Restore Gradle Cache
- Build Project
- Execute Tests
- Generate JaCoCo Coverage Report
- Run SonarQube Analysis
- Upload JaCoCo Report Artifact

The pipeline runs automatically on Pull Requests:

- `feature/* → develop`
- `develop → master`

It can also be triggered manually using GitHub Actions.

---

# Implemented Features

## Categories

- Create Category
- Update Category
- Get Category By Id
- Get All Categories
- Soft Delete Category

## Products

- Create Product
- Update Product
- Get Product By Id
- Get All Products
- Soft Delete Product

## Shared Features

- Validation
- Pagination
- Sorting
- JPA Specifications
- Soft Delete
- Auditing
- Flyway Migration
- Logging
- Exception Handling
- OpenAPI Documentation

---

# Future Improvements

- Unit Testing (JUnit + Mockito)
- Integration Testing
- Redis Caching
- JWT Authentication & Authorization
- Docker Compose
- Kubernetes Deployment
- API Gateway Integration