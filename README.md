# URLShortner

A high-performance, minimalist URL shortening service built with **Spring Boot** and **React**. This project demonstrates professional backend system design and a sleek, modern frontend architecture.

---

## Key Features

### Backend (Spring Boot)
- **Fast Redirection**: Uses HTTP 302 Found for high-speed URL forwarding.
- **Atomic Analytics**: Real-time access tracking with `accessCount` (Stats).
- **CRUD Operations**: Complete REST API for managing shortened links.
- **Safe Deletion**: Transactional integrity for all database modifications.
- **CORS Enabled**: Seamless integration with modern frontend frameworks.

### Frontend (React + Vite)
- **SPA Architecture**: Powered by `react-router-dom` for instantaneous navigation.
- **Real-time Search**: Instant filtering of your link database.
- **Modal Driven**: Sleek modal interfaces for creating and updating links.
- **Responsive**: Fully optimized for desktop and mobile viewing.

---

## Tech Stack

### Backend
- **Java 17+**
- **Spring Boot 3.x** (Web, Data JPA)
- **H2 Database** (File-based persistence)
- **Lombok** (Boilerplate reduction)

### Frontend
- **React 19**
- **Vite** (Build tool)
- **React Router 7** (Navigation)
- **Vanilla CSS** (Minimalist design system)

---

## Project Structure

```text
URLShortner/
├── Backend/          # Spring Boot application
│   ├── src/main/java # Controller, Service, Repository, Model
│   └── data/         # H2 Database files
└── frontend/         # React/Vite application
    ├── src/components# Modular UI components
    └── src/pages     # Route-based page views
```

---

## Getting Started

### Prerequisites
- JDK 17 or higher
- Node.js & npm

### Running the Backend
1. Navigate to the `Backend` directory.
2. Run `./mvnw spring-boot:run` (or use your IDE).
3. The API will be available at `http://localhost:8080`.

### Running the Frontend
1. Navigate to the `frontend` directory.
2. Install dependencies: `npm install`.
3. Start the dev server: `npm run dev`.
4. Open your browser at `http://localhost:5173`.

---

##  API Endpoints

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `POST` | `/api/shorten` | Create a new short URL |
| `GET` | `/api/shorten/all` | List all saved URLs |
| `GET` | `/api/{shortCode}` | Redirect to original URL |
| `PUT` | `/api/shorten/{shortCode}` | Update a destination URL |
| `DELETE` | `/api/shorten/{shortCode}` | Delete a short URL |
| `GET` | `/api/shorten/{shortCode}/stats` | Get detailed click stats |

---

##  Author
**Sai Amirthesh**
- [GitHub](https://github.com/SaiAmirthesh)
- [Project Repository](https://github.com/SaiAmirthesh/URLShortner)
- [Project Page](https://roadmap.sh/projects/url-shortening-service)
