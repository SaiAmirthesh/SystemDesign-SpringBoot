# System Design Practice – Spring Boot

This repository contains backend system design projects implemented using **Spring Boot**.
The goal of this repository is to practice designing and building backend systems using proper architecture and engineering principles.

Currently, this repository includes the following project:

* URL Shortener Service

---

## Purpose

This repository is created to:

* Practice backend system design
* Learn how real-world backend systems are built
* Understand database design and REST API design
* Implement layered architecture using Spring Boot
* Improve backend engineering skills

---

## Tech Stack

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* H2 Database
* Maven
* Lombok

---

## Current Project

| Project       | Concepts Covered                                                               |
| ------------- | ------------------------------------------------------------------------------ |
| URL Shortener | REST API Design, Database Design, Indexing, Transactions, Redirects, Analytics |

---

## Standard Project Architecture

All projects follow **Layered Architecture**:

```id="qsy9l3"
Controller → Service → Repository → Database
```

### Layer Responsibilities

| Layer      | Responsibility                      |
| ---------- | ----------------------------------- |
| Controller | Handles HTTP requests and responses |
| Service    | Business logic                      |
| Repository | Database operations                 |
| Entity     | Database table mapping              |
| DTO        | Request/Response objects            |
| Util       | Helper classes                      |
| Exception  | Global error handling               |

---

## Concepts Practiced

* REST API Design
* Layered Architecture
* Database Design
* Indexing
* Transactions
* URL Redirection (HTTP 302)
* Unique Short Code Generation
* Access Count Tracking

---

## How to Use This Repository

For each project:

1. Understand the problem statement
2. Design the database schema
3. Design API endpoints
4. Implement layered architecture
5. Add validation and exception handling
6. Test APIs using Postman
7. Document the system design

---

## Folder Structure

```id="m9glpd"
system-design-projects
│
└── url-shortener
```

---

## Future Improvements

* Add Redis caching
* Add custom short URLs
* Add link expiry feature
* Add Docker support
* Deploy project to cloud (AWS / Render)

---

## Goal

The goal of this repository is to become strong in:

* Backend Development
* System Design
* Spring Boot Development
* Database Design
* REST API Development

---

## Author

**Sai Amirthesh**

    