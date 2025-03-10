# Movie Management System

## Introduction
The Movie Management System is a RESTful API built using Spring Boot that allows users to perform CRUD operations on movies. It also supports search functionality based on various criteria such as title, director, genre, rating, and language.

## Prerequisites
Before running this project, ensure you have the following installed:
- **Java JDK 17** or higher
- **Maven**
- **MySQL** (Installed and running)
- An IDE (**IntelliJ IDEA, Eclipse, or VS Code**)

## Setup Instructions

### Step 1: Set up the Database
1. Open **MySQL Workbench** or any MySQL client.
2. Connect to your local MySQL server.
3. The application will automatically create a database named `moviedb` when it starts, thanks to the `createDatabaseIfNotExist=true` parameter in `application.properties`.

### Step 2: Create the Spring Boot Project
Create a new folder for your project and organize it as follows:
```
movie-management/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/moviemanagement/
│   │   │       ├── controller/
│   │   │       ├── dto/
│   │   │       ├── entity/
│   │   │       ├── exception/
│   │   │       ├── repository/
│   │   │       ├── service/
│   │   │       │   └── impl/
│   │   │       └── MoviemanagementApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/java/
└── pom.xml
```

### Step 3: Configure the Application
Update `application.properties` with your MySQL credentials:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/moviedb?createDatabaseIfNotExist=true
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
server.port=8080
```

### Step 4: Build the Project
Run the following command from the project root directory:
```bash
mvn clean install
```

### Step 5: Run the Application
To start the Spring Boot application, execute:
```bash
mvn spring-boot:run
```
The server will start and be available at `http://localhost:8080`.

## API Endpoints

### CRUD Operations
#### Create a Movie (POST)
```http
POST http://localhost:8080/api/movies
```

#### Get All Movies (GET)
```http
GET http://localhost:8080/api/movies
```

#### Get a Specific Movie (GET)
```http
GET http://localhost:8080/api/movies/1
```

#### Update a Movie (PUT)
```http
PUT http://localhost:8080/api/movies/1
```

#### Delete a Movie (DELETE)
```http
DELETE http://localhost:8080/api/movies/1
```

### Search Operations
#### Search by Title
```http
GET http://localhost:8080/api/movies/search/title?title=Shawshank
```

## Project Structure
The project follows the **MVC (Model-View-Controller)** pattern:
- **Model**: Represents the data structure (Entities, DTOs)
- **View**: JSON responses in a REST API
- **Controller**: Handles HTTP requests (`MovieController`)
- **Service**: Business logic (`MovieService`, `MovieServiceImpl`)
- **Repository**: Database interactions (`MovieRepository`)

## Features
- Full **CRUD** operations
- Data validation using **Jakarta Validation**
- Exception handling for:
    - Resource not found
    - Validation errors
    - General errors
- Search functionality by:
    - Title
    - Director
    - Genre
    - Rating
    - Language
- DTO pattern to separate API contracts from database entities
- Automatic timestamps for creation and updates
