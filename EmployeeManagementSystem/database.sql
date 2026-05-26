CREATE DATABASE IF NOT EXISTS employee_management;

USE employee_management;

CREATE TABLE IF NOT EXISTS employees (
    employee_id INT PRIMARY KEY AUTO_INCREMENT,
    employee_name VARCHAR(100),
    department VARCHAR(100),
    salary DOUBLE,
    email VARCHAR(100)
);

INSERT INTO employees (employee_name, department, salary, email) VALUES
('Aarav Sharma', 'IT', 55000.00, 'aarav.sharma@example.com'),
('Priya Verma', 'HR', 42000.00, 'priya.verma@example.com'),
('Rohan Mehta', 'Finance', 61000.00, 'rohan.mehta@example.com');
