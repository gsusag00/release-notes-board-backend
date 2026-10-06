# Release Notes Board - Backend

## Prerequisites

Before running the application, ensure the following software is installed:

- Java 21 or higher
- Maven 3.9 or higher
- PostgreSQL 16 or higher

## Local Startup

### 1. Create the database

    CREATE DATABASE release_notes;

### 2. Configure datasource properties

Update `application.properties` (or `application.yml`) with your PostgreSQL credentials.

Example:

    spring.datasource.url=jdbc:postgresql://localhost:5432/release_notes
    spring.datasource.username=postgres
    spring.datasource.password=postgres

### 3. Start the application

Using Maven:

    mvn spring-boot:run

Alternatively:

    mvn clean package
    java -jar target/*.jar

The API will be available at:

    http://localhost:8080

### 4. Flyway migrations

Database migrations are executed automatically during application startup.

## Architecture Decisions

### Layered Architecture

The application follows a layered architecture:

    Controller
        ↓
    Service
        ↓
    Repository
        ↓
    Database

Responsibilities:

- Controllers expose REST endpoints.
- Services contain business logic.
- Repositories handle persistence operations.
- DTOs define the API contract.

## Project Structure

    src/main/java
    ├── items
    │ ├── controller
    │ | ├── request
    | | └── response
    │ ├── service
    │ └── repository
    ├── applications
    │ ├── controller
    | | └── response
    │ ├── service
    │ └── repository
    ├── status
    ├── exception
    └── config

### Main Components

- Controllers handle HTTP requests and responses.
- Services contain business logic and workflow validation.
- Repositories provide access to persisted data.
- DTOs define request and response payloads.
- DTOs have been separated into request and response folders for better organization
- Exception handlers provide consistent error responses.
- Configuration classes manage application-specific settings.

## Assumptions

The following assumptions were made during implementation:

- It's assumed that an item's status goes from `DRAFT` to `REVIEW` and then finally to `PUBLISHED`
- The item's status can go back at any point
- Newly created items start with the `DRAFT` status.
- Applications must exist before items can be created.
- Status transitions are managed through a dedicated operation.
- Item listing is paginated by default.
