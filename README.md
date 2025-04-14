# 🛍️ E-Commerce Web App

This is a full-stack e-commerce application built using **Spring Boot**, **MySQL**, and a **static HTML/CSS/JS frontend**. It provides a responsive shopping experience with features like product listings, user authentication, cart functionality, and is integrated with **Jenkins CI/CD** for streamlined development and deployment.

---

## 🚀 Features

- 🔐 User Registration & Login  
- 🛒 Add to Cart & View Cart  
- 📦 Dynamic Product Listings from MySQL  
- 🔄 CI/CD pipeline with Jenkins  
- 🐳 Dockerized Backend and Frontend  
- 🌐 CORS Configured for Cross-Origin Requests  

---

## 🧱 Tech Stack

| Layer       | Technology              |
|-------------|--------------------------|
| Frontend    | HTML, CSS, JavaScript    |
| Backend     | Spring Boot (Java 17)    |
| Database    | MySQL (Dockerized)       |
| CI/CD       | Jenkins (Docker-based)   |
| DevOps      | Docker, Docker Compose   |

---

## 📁 Project Structure

```
ecommerce-app/
│
├── backend/
│   ├── src/
│   ├── pom.xml
│   └── docker-compose.yml
│
├── frontend/
│   ├── index.html
│   ├── login.html
│   ├── register.html
│   ├── cart.html
│   ├── profile.html
│   ├── Dockerfile
│   └── docker-compose.yml
│
├── Jenkinsfile
└── README.md
```

---

## ⚙️ Setup Instructions

### 🔧 Prerequisites

- Docker & Docker Compose  
- Git  
- Jenkins (running on Docker)  
- Java 17+ (for manual local backend testing)  

---

### 🐳 Run Application via Docker

#### Backend

```bash
cd backend
docker-compose up --build
```

#### Frontend

```bash
cd frontend
docker-compose up --build
```

---

### 🧪 Run Locally (Without Docker)

1. **Backend:**
   - Import Spring Boot project in IDE
   - Update `application.properties` to match your local MySQL credentials
   - Run `EcommerceApplication.java`

2. **Frontend:**
   - Open `index.html` using Live Server or your browser
   - Ensure API calls point to `http://localhost:8080`

---

## 🔄 CI/CD with Jenkins

1. Jenkins container runs at `http://localhost:9090`
2. Pipeline builds:
   - Backend via `maven:3.8-eclipse-temurin-17`
   - Frontend via Nginx Dockerfile
   - Deployment via Docker Compose
3. Triggered via GitHub webhook

---

## ✅ Status

- ✔️ Backend connected to MySQL  
- ✔️ Frontend integrated  
- ✔️ CORS enabled  
- ✔️ Docker Compose working  
- ✔️ CI/CD functional through Jenkins  

---

## 🔗 API Endpoints

| Method | Endpoint                       | Description               |
|--------|--------------------------------|---------------------------|
| POST   | `/api/users`                   | Register a new user       |
| POST   | `/api/users/login`            | Authenticate user login   |
| GET    | `/api/products`               | Get all products          |
| POST   | `/api/cart/add`               | Add item to cart          |
| GET    | `/api/cart/user/{userId}`     | Get cart items for user   |
| PUT    | `/api/cart/increase`          | Increase quantity         |
| PUT    | `/api/cart/decrease`          | Decrease quantity         |
| DELETE | `/api/cart/remove`            | Remove item from cart     |

---

## 🧠 What I Learned

- **Spring Boot**  
  → Learned how to create RESTful APIs, use Spring Data JPA for database interactions, and structure a backend with controllers, services, and repositories.

- **MySQL**  
  → Understood schema design, how to seed data using SQL dumps, and configure connections between Spring Boot and MySQL using Docker networking.

- **Docker & Docker Compose**  
  → Gained hands-on experience with containerizing applications, writing Dockerfiles, using volumes, and orchestrating multi-service apps using Docker Compose.

- **HTML, CSS & JavaScript**  
  → Practiced frontend development with dynamic fetch API calls, basic UI design principles, and local storage management (for user sessions).

- **CORS (Cross-Origin Resource Sharing)**  
  → Learned how to enable and configure CORS in Spring Boot to allow safe communication between frontend and backend services.

- **Jenkins**  
  → Explored how to set up a Jenkins pipeline using `Jenkinsfile`, run builds inside Docker containers, and integrate CI/CD workflows for automation.

- **CI/CD Concepts**  
  → Understood continuous integration by automatically building and packaging code, and continuous deployment using Docker containers.

- **Version Control with Git & GitHub**  
  → Learned how to structure repositories, commit meaningful changes, and push both frontend and backend to a single repository for collaboration.

---


## 👤 Author

**Likhith Kumar Yaramala**  
🎓 Master's in Computer Science  

---

## 📜 License

This project is licensed under the **MIT License**.
