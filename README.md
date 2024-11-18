# Chatbot AI System

This is a Chatbot AI System built using Java Spring Boot for the backend and HTML, CSS, and JavaScript for the frontend. The system integrates a robust authentication mechanism using Spring Security and JWT, and supports interaction history storage via MySQL.

## Features

### Backend:
- Built with Java Spring Boot.
- JWT-based Authentication for secure user sessions.
- Database Operations using Spring Data JPA with MySQL.
- AI-powered chatbot logic for responses.
- APIs for interaction history and user authentication.

### Frontend:
- Simple interface using HTML, CSS, and JavaScript.
- Handles user login and chatbot interaction.
- Displays chat history fetched from the backend.

### Database:
MySQL database to store:
- User information.
- Chat history.

---

## Tech Stack

### Backend:
- Java Spring Boot
- Spring Security
- Spring Data JPA
- MySQL
- JSON Web Tokens (JWT)

### Frontend:
- HTML
- CSS
- JavaScript

---

## Setup Instructions

### Prerequisites:
- Java 17 or later
- Maven
- MySQL Server
- Node.js (optional, for advanced frontend)
- Git

---

### Steps to Run

#### Backend Setup
1. Clone the repository:
    ```bash
    git clone https://github.com/your-repo/chatbot-ai-system.git
    cd chatbot-ai-system/backend
    ```

2. Update MySQL credentials in `application.properties`:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/chatbot_db
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=update
    ```

3. Build and run the application:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

#### Frontend Setup
1. Navigate to the frontend directory:
    ```bash
    cd ../frontend
    ```

2. Open `index.html` in a browser.

---

## How DAO Classes Are Automatically Generated

### In Spring Boot with JPA:
- **Repositories**: You create interfaces extending `JpaRepository` or `CrudRepository`. For example:
    ```java
    @Repository
    public interface UserRepository extends JpaRepository<User, Long> {}
    ```
  Spring automatically implements this interface at runtime, creating a DAO class with CRUD operations.

- **Entity Classes**: Define entity classes annotated with `@Entity`, which map to database tables. For example:
    ```java
    @Entity
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String username;
        private String password;
    }
    ```

  Spring generates proxies and handles queries automatically using JPA criteria or native queries.

---

## MySQL and Spring Boot Connection Using JPA

### Database Configuration:
- Set up your MySQL credentials in `application.properties`.

### Spring Boot Auto-Configuration:
- With the dependency `spring-boot-starter-data-jpa`, Spring Boot handles connection pooling and entity management.

### Entities and Repositories:
- Entity classes represent database tables, while repository interfaces perform CRUD operations.

### Database Interaction:
- Use the `JpaRepository` interface methods for queries like `findAll()`, `save()`, and `deleteById()`.

---

## Frontend Features

### Authentication:
- Users log in using a form in `index.html`.
- The frontend sends login requests to the backend using the `fetch` API.
- JWT tokens are stored in `localStorage` for subsequent authenticated requests.

### Chatbot Interaction:
- Users input text into a chatbot interface.
- Messages are sent to the backend API for AI processing.
- Responses are displayed dynamically on the frontend.

### Chat History:
- After a successful login, the frontend fetches chat history from the backend.
- Chat history is rendered in the UI.

---

## Authentication and History Storage

### Authentication:
- The backend uses Spring Security with JWT for authentication.

#### Steps:
1. The user logs in with credentials.
2. The backend validates credentials and generates a JWT token.
3. The token is used for subsequent requests to access chat history and interact with the chatbot.

### Chat History Storage:
- Chat messages are stored in a `Message` entity in the MySQL database.
- Each message has a relationship with a `User` entity to track ownership.

#### Example Schema:
    ```java
    @Entity
    public class Message {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        private User user;

        private String content;
        private String response;
        private LocalDateTime timestamp;
    }
    ```

---

## Future Enhancements
- Add a more sophisticated AI engine for chatbot responses.
- Use React or Angular for a richer frontend experience.
- Implement real-time chat using WebSockets.
