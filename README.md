# Employee Management System

A console-based Employee Management System built using Core Java, JDBC, and MySQL.  
This project demonstrates Java backend fundamentals including CRUD operations, layered architecture, DAO pattern, exception handling, input validation, and database connectivity using `PreparedStatement`.

---

## Project Overview

The application allows users to manage employee records through a console-based interface while demonstrating concepts such as:

- Core Java
- JDBC
- OOP Principles
- Collections Framework
- Layered Architecture
- DAO Pattern
- MySQL Integration
- Exception Handling

---

## Technologies Used

- Java
- JDBC
- MySQL
- Collections Framework
- Exception Handling
- OOP
- DAO Pattern

---

## Features

- Add Employee
- View All Employees
- Search Employee by ID
- Update Employee Details
- Delete Employee
- Sort Employees by Salary
- Filter Employees by Department
- Input Validation
- SQL Exception Handling
- Console Menu System

---

## Project Structure

```text
EmployeeManagementSystem/
│
├── src/
│   ├── model/
│   │   └── Employee.java
│   │
│   ├── dao/
│   │   ├── EmployeeDAO.java
│   │   └── EmployeeDAOImpl.java
│   │
│   ├── db/
│   │   └── DBConnection.java
│   │
│   ├── service/
│   │   └── EmployeeService.java
│   │
│   ├── util/
│   │   └── InputValidator.java
│   │
│   └── main/
│       └── Main.java
│
├── database.sql
├── README.md
└── .gitignore
```

---

## Database Setup

### Step 1 — Create Database

Run the following SQL commands:

```sql
CREATE DATABASE IF NOT EXISTS employee_management;

USE employee_management;
```

### Step 2 — Run SQL Script

Execute the `database.sql` file included in the project.

This will create the required `employees` table automatically.

---

## MySQL Connector Setup

Download MySQL Connector/J from the official MySQL website:

https://dev.mysql.com/downloads/connector/j/

Place the downloaded JAR file inside the `lib` folder.

Expected structure:

```text
EmployeeManagementSystem/lib/mysql-connector-j.jar
```

---

## Configure Database Credentials

Open:

```text
src/db/DBConnection.java
```

Update the following values according to your MySQL configuration:

```java
private static final String USERNAME = "root";
private static final String PASSWORD = "root";
```

---

## Compile and Run

### Windows PowerShell

Run these commands from inside the project folder:

```powershell
javac -cp ".;lib/mysql-connector-j.jar" -d out src/model/*.java src/dao/*.java src/db/*.java src/service/*.java src/util/*.java src/main/*.java

java -cp "out;lib/mysql-connector-j.jar" main.Main
```

### macOS/Linux

```bash
javac -cp ".:lib/mysql-connector-j.jar" -d out src/model/*.java src/dao/*.java src/db/*.java src/service/*.java src/util/*.java src/main/*.java

java -cp "out:lib/mysql-connector-j.jar" main.Main
```

---

## Sample Console Output

```text
==============================================
        EMPLOYEE MANAGEMENT SYSTEM
==============================================

--------------- Main Menu ---------------
1. Add Employee
2. View Employees
3. Search Employee
4. Update Employee
5. Delete Employee
6. Sort by Salary
7. Filter by Department
8. Exit
-----------------------------------------

Enter your choice: 2

ID    Name                      Department           Salary       Email
--------------------------------------------------------------------------------------------
1     Aarav Sharma              IT                   55000.00     aarav.sharma@example.com
2     Priya Verma               HR                   42000.00     priya.verma@example.com
3     Rohan Mehta               Finance              61000.00     rohan.mehta@example.com
```

---

## Learning Outcomes

Through this project, the following concepts were practiced:

- Applying OOP principles in Java
- Implementing layered architecture
- Using DAO pattern for database operations
- Writing secure SQL queries using `PreparedStatement`
- Handling exceptions in database-driven applications
- Validating user input in console applications
- Using Java Collections Framework (`ArrayList`, `Comparator`)
- Managing MySQL database connectivity with JDBC

---

## Future Improvements

- GUI integration using JavaFX or Swing
- Authentication and role-based access
- REST API migration using Spring Boot
- Docker containerization
- Unit testing with JUnit

---

## Author

Shivam Tiwari
