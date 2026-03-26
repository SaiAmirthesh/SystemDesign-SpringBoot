** URL Shortener – Spring Boot **

A simple URL Shortener REST API built using Spring Boot.
This application allows users to create short URLs, redirect to original URLs, update URLs, delete URLs, and track access statistics.

- Features
    Create short URL
    Redirect short URL → Original URL
    Update existing short URL
    Delete short URL
    Track number of times a short URL is accessed
    H2 Database integration
    RESTful API design
    Layered Architecture (Controller → Service → Repository → Database)

- Tech Stack
  Java
  Spring Boot
  Spring Web
  Spring Data JPA
  H2 Database
  Lombok
  Maven

  - Project Structure
    ``
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
    ``
  
- API Endpoints
    Method	Endpoint	Description
    POST	/api/shorten	Create short URL
    GET	/api/shorten/{shortCode}	Get URL details
    GET	/{shortCode}	Redirect to original URL
    PUT	/api/shorten/{shortCode}	Update URL
    DELETE	/api/shorten/{shortCode}	Delete URL
    GET	/api/shorten/{shortCode}/stats	Get URL statistics