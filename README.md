# Role-Based Access Control in Spring Security

## Overview
This application demonstrates how to implement secure endpoints and role-based access control (RBAC) using Spring Security, MySQL, and custom authentication.

---

## Features
- Role management
- Endpoint protection
- Custom authentication

---

## Folder Structure and Files

### Main Files and Directories

#### **`src/main/java/com/cloudnativeplayground/rbac`**
- **`Application.java`**: The main entry point for the Spring Boot application.

#### **`config/`**
- **`SecurityConfig.java`**: Configures Spring Security, defines authentication and authorization settings, and secures endpoints.

#### **`controller/`**
- **`UserController.java`**: Contains REST endpoints to manage user-related operations.

#### **`entity/`**
- **`Role.java`**: Represents the role entity with fields like `id` and `name`.
- **`User.java`**: Represents the user entity with fields like `id`, `username`, `password`, and associated roles.

#### **`repository/`**
- **`RoleRepository.java`**: Handles database operations for roles.
- **`UserRepository.java`**: Handles database operations for users.

#### **`service/`**
- **`RoleService.java`**: Provides business logic for role management.
- **`UserService.java`**: Provides business logic for user management.

#### **`src/main/resources/`**
- **`application.properties`**: Contains configuration details such as database connection settings.
- **`data.sql`**: Provides initial seed data for roles and users.

#### **`src/test/java/com/cloudnativeplayground/rbac`**
- **`UserControllerTest.java`**: Contains unit tests for `UserController`.

---

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven
- MySQL
- Git

### Steps to Build and Run
1. Clone the repository:
   ```bash
   git clone https://github.com/cloudnativeplayground/role-based-access-control-in-spring-security.git
   cd role-based-access-control-in-spring-security
   ```

2. Update MySQL credentials in `src/main/resources/application.properties`.

3. Build the application:
   ```bash
   mvn clean install
   ```

4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

---

## REST API Usage

### Endpoints
- **POST /api/users**: Create a new user.
- **GET /api/users**: Get a list of all users (requires admin role).
- **POST /api/roles**: Create a new role (requires admin role).
- **GET /api/roles**: Get a list of all roles (requires admin role).

### Sample API Calls

#### Using Bash

**Create a new user:**
```bash
curl -X POST \
  -H "Content-Type: application/json" \
  -d '{"username": "john", "password": "password", "roles": ["USER"]}' \
  http://localhost:8080/api/users
```

**Get all users:**
```bash
curl -X GET \
  -H "Authorization: Bearer <TOKEN>" \
  http://localhost:8080/api/users
```

#### Using PowerShell

**Create a new user:**
```powershell
Invoke-RestMethod -Uri "http://localhost:8080/api/users" -Method POST -Body '{"username": "john", "password": "password", "roles": ["USER"]}' -ContentType "application/json"
```

**Get all users:**
```powershell
Invoke-RestMethod -Uri "http://localhost:8080/api/users" -Method GET -Headers @{Authorization="Bearer <TOKEN>"}
```

---

## Testing
Run tests using the following command:
```bash
mvn test
```

---

## License
This project is licensed under the GNU General Public License v3.0. See the LICENSE file for details.

---

## Maintainer
Aditya Pratap Bhuyan, Senior Architect, Developer, Instructor, and Author.  
[LinkedIn](https://linkedin.com/in/adityabhuyan)