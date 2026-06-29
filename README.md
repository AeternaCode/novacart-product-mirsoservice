# NOVACART PRODUCT SERVICE

A Spring Boot based REST API for managing product and category information in an e-commerce system.

## Features

* Category Management (CRUD)
* Product Management (CRUD)
* Input Validation using Jakarta Validation
* Global Exception Handling
* Pagination
* Sorting
* Soft Delete
* Audit Fields (Created At, Updated At, Created By, Updated By)
* OpenAPI / Swagger Documentation
* Flyway Database Migration
* Logging with SLF4J

## Tech Stack

### Backend

* Java 21
* Spring Boot
* Spring Data JPA
* Hibernate

### Database

* MySQL
* Flyway Migration

### Documentation

* Swagger / OpenAPI

### Build Tool

* Gradle

---

## Prerequisites

Before running the application, ensure the following are installed:

* JDK 21
* MySQL Server
* Git
* Gradle (optional if using Gradle Wrapper)
* IntelliJ IDEA / VS Code / Eclipse

---

## Clone Repository

```bash
git clone <repository-url>
cd <project-folder>
```

---

## Database Setup

Start MySQL server and create a database:

```sql
CREATE DATABASE product_service_db;
```

Update the database configuration in:

```properties
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/product_service_db
spring.datasource.username=root
spring.datasource.password=your_password
```

---

## Build Project

Using Gradle Wrapper:

```bash
./gradlew clean build
```

Windows:

```bash
gradlew.bat clean build
```

---

## Run Application

```bash
./gradlew bootRun
```

or

```bash
gradlew.bat bootRun
```

Alternatively, run the main Spring Boot application class directly from your IDE.

---

## Flyway Migration

Database tables and seed data are automatically created using Flyway migrations during application startup.

No manual table creation is required.

---

## Swagger Documentation

After application startup:

```text
http://localhost:8080/swagger-ui/index.html
```

Use Swagger UI to explore and test APIs.

---

## API Testing

You can test APIs using:

* Swagger UI
* Postman

---

## Project Structure

```text
src
├── controller
├── service
├── repository
├── entity
├── dto
├── mapper
├── exception
├── config
├── utils
└── db
    └── migration
```

---

## Implemented Features

### Categories

* Create Category
* Update Category
* Get Category By Id
* Get All Categories
* Soft Delete Category

### Products

* Create Product
* Update Product
* Get Product By Id
* Get All Products
* Soft Delete Product

### Common Features

* Validation
* Pagination
* Sorting
* Logging
* Exception Handling
* Flyway Migration
* Auditing

---

## Future Improvements

* Dynamic Filtering using JPA Specifications
* Redis Caching
* Docker Support
* Authentication & Authorization (JWT)
* Unit and Integration Testing

```
```
