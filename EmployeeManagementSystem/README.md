# Employee Management System

A professional console-based Employee Management System built using Core Java, JDBC, and MySQL. This project follows a clean layered architecture and demonstrates OOP, DAO pattern, input validation, exception handling, and database operations using `PreparedStatement`.

## Project Overview

The application allows users to manage employee records from a console menu. It is designed as a realistic beginner-to-intermediate academic project suitable for a 3rd-year Computer Science Engineering resume.

## Technologies Used

- Java
- JDBC
- MySQL
- Collections Framework
- Exception Handling
- OOP
- DAO Pattern

## Features

- Add Employee
- View All Employees
- Search Employee by ID
- Update Employee
- Delete Employee
- Sort Employees by Salary
- Filter Employees by Department
- Input Validation
- SQL Exception Handling
- Console Menu System

## Project Structure

```text
EmployeeManagementSystem/
|
├── src/
│   ├── model/
│   │   └── Employee.java
│   ├── dao/
│   │   ├── EmployeeDAO.java
│   │   └── EmployeeDAOImpl.java
│   ├── db/
│   │   └── DBConnection.java
│   ├── service/
│   │   └── EmployeeService.java
│   ├── util/
│   │   └── InputValidator.java
│   └── main/
│       └── Main.java
├── database.sql
├── README.md
└── lib/
    └── mysql-connector-j.jar
```

## Database Setup

1. Open MySQL Workbench or MySQL command line.
2. Run the script from `database.sql`.
3. Confirm that the database `employee_management` and table `employees` are created.

```sql
CREATE DATABASE IF NOT EXISTS employee_management;
USE employee_management;
```

## MySQL Connector Setup

Download MySQL Connector/J from the official MySQL website and place the JAR file inside the `lib` folder.

Expected path:

```text
EmployeeManagementSystem/lib/mysql-connector-j.jar
```

## Configure Database Credentials

Open `src/db/DBConnection.java` and update these values if your MySQL username or password is different:

```java
private static final String USERNAME = "root";
private static final String PASSWORD = "root";
```

## Compile and Run

From inside the `EmployeeManagementSystem` folder:

### Windows PowerShell

```powershell
javac -cp ".;lib/mysql-connector-j.jar" -d out src/model/*.java src/dao/*.java src/db/*.java src/service/*.java src/util/*.java src/main/*.java
java -cp "out;lib/mysql-connector-j.jar" main.Main
```

### macOS/Linux

```bash
javac -cp ".:lib/mysql-connector-j.jar" -d out src/model/*.java src/dao/*.java src/db/*.java src/service/*.java src/util/*.java src/main/*.java
java -cp "out:lib/mysql-connector-j.jar" main.Main
```

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

## Screenshots

Add screenshots here after running the project:

- Main Menu
- Add Employee
- View Employees
- Search Employee
- Update Employee

## Learning Outcomes

- Applying OOP principles in Java
- Implementing layered architecture
- Using DAO pattern for database operations
- Writing safe SQL queries with `PreparedStatement`
- Handling user input and exceptions in console applications
- Using `ArrayList` and `Comparator` from the Collections Framework
