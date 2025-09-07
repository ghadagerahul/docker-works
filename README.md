# docker-works

**Docker Project and Learning Materials**

A hands-on repository to containerize Spring Boot applications using Docker, aiding learning and practical applications.

---

## Contents

- **[Overview](#overview)**
- **[Prerequisites](#prerequisites)**
- **[Project Structure](#project-structure)**
- **[Building & Running with Docker](#building--running-with-docker)**
- **[Using Docker Compose (if applicable)](#docker-compose-support)**
- **[Best Practices](#best-practices)**
- **[Learning Resources](#learning-resources)**
- **[License](#license)**

---

### Overview

This project demonstrates how to:

- Build a Docker image for a Spring Boot application.
- Run the application as a container.
- (Optional) Use Docker Compose for multi-container setups.
- Lay a learning foundation for Docker tools and workflows in Spring Boot.

---

### Prerequisites

Ensure you have the following installed:

- Java Development Kit (Java 8+ preferred)
- Docker (Docker Engine / Docker Desktop)
- (Optional) Docker Compose, if using multi-container setup

---

### Project Structure

```
docker-works/
├── src/
│   └── ... – Spring Boot application source
├── Dockerfile
├── docker-compose.yml (if present)
└── README.md
```

---

### Building & Running with Docker

#### 1. Build the Application JAR

```bash
# If using Maven
./mvnw clean package

# Or if using Gradle
./gradlew build
```

#### 2. Create the Docker Image

```dockerfile
# Example Dockerfile
FROM openjdk:17-alpine
WORKDIR /app
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
```

Build your image:

```bash
docker build -t docker-works-springboot .
```

#### 3. Run the Container

```bash
docker run -p 8080:8080 docker-works-springboot
```

Visit `http://localhost:8080` to access your running application.

---

### Docker Compose Support *(if present)*

If a `docker-compose.yml` exists, it may define services like:

```yaml
version: '3.8'
services:
  app:
    build: .
    ports:
      - "8080:8080"
    depends_on:
      - db
  db:
    image: postgres:latest
    environment:
      POSTGRES_USER: youruser
      POSTGRES_PASSWORD: yourpass
      POSTGRES_DB: yourdb
    ports:
      - "5432:5432"
```

To run:

```bash
docker-compose up --build
```

This sets up both your Spring Boot app and a PostgreSQL container together.

---

### Best Practices

- **Use a Minimal Base Image**: Opt for lightweight images like OpenJDK Alpine variants.
- **Run as Non-root**: Create and switch to a non-root user inside the container for security.
- **Layer Caching**: Organize Dockerfile instructions to maximize layer reuse (e.g., copying dependencies separately).
- **Multi-stage Builds**: For optimized images, consider separating build and runtime stages.
- **Expose Only Necessary Ports**: Keep your Docker surface minimal and explicit.
- **Use Docker Compose**: Great tool for orchestrating multi-container projects.

---

### Learning Resources

- [Spring Boot with Docker - Official Guide](https://spring.io/guides/gs/spring-boot-docker)
- [Spring Boot Docker - Topical Guide](https://spring.p2hp.com/guides/topicals/spring-boot-docker/index.html)
- [Baeldung Tutorial: Dockerizing Spring Boot](https://www.baeldung.com/dockerizing-spring-boot-application)

These are excellent references for deepening your Docker skills in Java environments.

---

### License

*(If applicable, specify your project’s license here, e.g., MIT, Apache 2.0.)*
