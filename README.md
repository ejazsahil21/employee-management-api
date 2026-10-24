# 👨‍💼 Employee Management REST API 🚀

A RESTful Employee Management API built using **Java, Spring Boot, Spring Data JPA, Hibernate, and MySQL**. This project demonstrates CRUD operations, layered architecture, request validation, pagination, sorting, and centralized exception handling.

## ✨ Features

- ✅ Create and manage employee records
- ✅ Retrieve employee details by ID
- ✅ Fetch all employees
- ✅ Update existing employee information
- ✅ Delete employee records
- ✅ Pagination and sorting
- ✅ Request validation using Jakarta Bean Validation
- ✅ Centralized exception handling using `@RestControllerAdvice`
- ✅ DTO-based request and response handling
- ✅ Database integration using Spring Data JPA and Hibernate
- ✅ REST API testing using Postman

## 🛠️ Tech Stack

- **Language:** Java
- **Backend Framework:** Spring Boot
- **ORM:** Hibernate
- **Persistence:** Spring Data JPA
- **Database:** MySQL
- **Validation:** Jakarta Bean Validation
- **Build Tool:** Maven
- **API Testing:** Postman
- **IDE:** IntelliJ IDEA

## 🏗️ Project Architecture

The application follows a layered architecture to separate responsibilities and keep the code maintainable.

```text
src/main/java/com/api/
├── controller/
│   └── EmployeeController.java
├── dto/
│   ├── APIResponse.java
│   ├── EmployeeDto.java
│   └── ErrorDto.java
├── entity/
│   └── Employee.java
├── exception/
│   ├── GlobalExceptionHandler.java
│   └── RecordNotFoundException.java
├── repository/
│   └── EmployeeRepository.java
├── service/
│   ├── EmployeeService.java
│   └── EmployeeServiceImpl.java
└── ApiDemoApplication.java
```

### 📦 Layer Responsibilities

- **Controller:** Receives HTTP requests and returns API responses.
- **Service:** Contains business logic.
- **Repository:** Performs database operations.
- **Entity:** Represents the employee database table.
- **DTO:** Transfers request and response data.
- **Exception:** Handles application errors centrally.

## 🔗 API Operations

The API supports the following employee management operations. Update the endpoint paths below if your controller uses different mappings.

| Operation | HTTP Method | Purpose |
|---|---|---|
| Create Employee | POST | Add a new employee |
| Get All Employees | GET | Retrieve employee records |
| Get Employee by ID | GET | Retrieve a specific employee |
| Update Employee | PUT | Update employee details |
| Delete Employee | DELETE | Remove an employee |
| Pagination & Sorting | GET | Retrieve records page by page in a specified order |

## ⚙️ How to Run the Project

### 1. Prerequisites

Install the following:

- JDK 21
- Maven (or use the included Maven Wrapper)
- MySQL Server
- IntelliJ IDEA or another Java IDE
- Postman

### 2. Clone the Repository

```bash
git clone https://github.com/ejazsahil21/employee-management-api.git
cd employee-management-api
```

### 3. Configure MySQL

Create a database in MySQL:

```sql
CREATE DATABASE employee_db;
```

Configure your database connection in `src/main/resources/application.properties`.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
```

Set the `DB_USERNAME` and `DB_PASSWORD` environment variables to your local MySQL credentials. Never commit actual passwords or other secrets to GitHub.

Use the JPA schema-generation setting appropriate for your project and development environment.

### 4. Run the Application

On Windows, from the project root, run:

```powershell
.\mvnw.cmd spring-boot:run
```

Alternatively, open the project in IntelliJ IDEA and run `ApiDemoApplication.java`.

### 5. Test with Postman

Start the application and send requests to the configured local server, using the endpoint mappings defined in `EmployeeController.java`.

Example base URL (if the application runs on port 8080):

```text
http://localhost:8080
```

## 🎯 Learning Outcomes

This project demonstrates practical knowledge of:

- Building REST APIs with Spring Boot
- Designing layered backend applications
- Implementing CRUD operations
- Integrating MySQL with Spring Data JPA
- Using DTOs and entity classes
- Validating incoming requests
- Handling exceptions consistently
- Implementing pagination and sorting
- Testing APIs with Postman

## 👨‍💻 Author

**Sahil Ejaz**

- GitHub: [@ejazsahil21](https://github.com/ejazsahil21)

---

⭐ If you find this project useful, consider giving the repository a star!
