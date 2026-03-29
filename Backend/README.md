# URL Shortener – Spring Boot

A simple URL Shortener REST API built using Spring Boot.
This application allows users to create short URLs, redirect to original URLs, update URLs, delete URLs, and track access statistics.

---

## Features

* Create short URL
* Redirect short URL → Original URL
* Update existing short URL
* Delete short URL
* Track number of times a short URL is accessed
* H2 Database integration
* RESTful API design
* Layered Architecture (Controller → Service → Repository → Database)

---

## Tech Stack

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* H2 Database
* Lombok
* Maven

---

## Project Structure

```
url-shortener
│
├── controller      → Handles API requests
├── service         → Business logic
├── repository      → Database operations
├── model           → Entity classes
├── util            → Short code generator
├── exception       → Error handling
└── resources
    └── application.properties
```

---

## API Endpoints

| Method | Endpoint                       | Description              |
| ------ | ------------------------------ | ------------------------ |
| POST   | /api/shorten                   | Create short URL         |
| GET    | /api/shorten/{shortCode}       | Get URL details          |
| GET    | /{shortCode}                   | Redirect to original URL |
| PUT    | /api/shorten/{shortCode}       | Update URL               |
| DELETE | /api/shorten/{shortCode}       | Delete URL               |
| GET    | /api/shorten/{shortCode}/stats | Get URL statistics       |

---

## How to Run

1. Clone the repository
2. Open the project in IntelliJ / Eclipse
3. Run the Spring Boot application
4. Use Postman to test APIs
5. Access H2 console to view database

---

## H2 Database Console

* URL: `http://localhost:8080/h2-console`
* JDBC URL: `jdbc:h2:file:./data/urlshortenerdb`


---

## Concepts Used

* REST API Design
* Layered Architecture
* Database Indexing
* Transactions (`@Transactional`)
* URL Redirection (HTTP 302)
* Unique Short Code Generation
* Access Analytics Tracking

---

## Future Improvements

* Custom short URLs
* Link expiry
* Redis caching
* User authentication
* Docker deployment
* Frontend UI

---

## Author

**Sai Amirthesh**

