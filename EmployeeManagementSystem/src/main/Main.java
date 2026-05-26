package main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import db.DBConnection;
import model.Employee;
import service.EmployeeService;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final EmployeeService employeeService = new EmployeeService();

    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("        EMPLOYEE MANAGEMENT SYSTEM");
        System.out.println("==============================================");

        boolean running = true;

        while (running) {
            displayMenu();
            int choice = readInt("Enter your choice: ");

            try {
                switch (choice) {
                    case 1:
                        addEmployee();
                        break;
                    case 2:
                        viewEmployees();
                        break;
                    case 3:
                        searchEmployee();
                        break;
                    case 4:
                        updateEmployee();
                        break;
                    case 5:
                        deleteEmployee();
                        break;
                    case 6:
                        sortEmployeesBySalary();
                        break;
                    case 7:
                        filterEmployeesByDepartment();
                        break;
                    case 8:
                        running = false;
                        System.out.println("Thank you for using Employee Management System.");
                        break;
                    default:
                        System.out.println("Invalid menu choice. Please select 1 to 8.");
                }
            } catch (IllegalArgumentException exception) {
                System.out.println("Validation Error: " + exception.getMessage());
            } catch (SQLException exception) {
                System.out.println("Database Error: " + exception.getMessage());
            } catch (Exception exception) {
                System.out.println("Unexpected Error: " + exception.getMessage());
            }
        }

        scanner.close();
        DBConnection.closeConnection();
    }

    private static void displayMenu() {
        System.out.println();
        System.out.println("--------------- Main Menu ---------------");
        System.out.println("1. Add Employee");
        System.out.println("2. View Employees");
        System.out.println("3. Search Employee");
        System.out.println("4. Update Employee");
        System.out.println("5. Delete Employee");
        System.out.println("6. Sort by Salary");
        System.out.println("7. Filter by Department");
        System.out.println("8. Exit");
        System.out.println("-----------------------------------------");
    }

    private static void addEmployee() throws SQLException {
        System.out.println();
        System.out.println("Add Employee");

        Employee employee = readEmployeeDetails();
        boolean isAdded = employeeService.addEmployee(employee);

        if (isAdded) {
            System.out.println("Employee added successfully.");
        } else {
            System.out.println("Employee could not be added.");
        }
    }

    private static void viewEmployees() throws SQLException {
        List<Employee> employees = employeeService.getAllEmployees();
        printEmployees(employees);
    }

    private static void searchEmployee() throws SQLException {
        int employeeId = readInt("Enter employee ID to search: ");
        Employee employee = employeeService.getEmployeeById(employeeId);

        if (employee == null) {
            System.out.println("No employee found with ID: " + employeeId);
        } else {
            printTableHeader();
            System.out.println(employee);
        }
    }

    private static void updateEmployee() throws SQLException {
        int employeeId = readInt("Enter employee ID to update: ");
        Employee existingEmployee = employeeService.getEmployeeById(employeeId);

        if (existingEmployee == null) {
            System.out.println("No employee found with ID: " + employeeId);
            return;
        }

        System.out.println("Current Employee Details:");
        printTableHeader();
        System.out.println(existingEmployee);

        System.out.println();
        System.out.println("Enter New Employee Details");
        Employee updatedEmployee = readEmployeeDetails();
        updatedEmployee.setEmployeeId(employeeId);

        boolean isUpdated = employeeService.updateEmployee(updatedEmployee);

        if (isUpdated) {
            System.out.println("Employee updated successfully.");
        } else {
            System.out.println("Employee could not be updated.");
        }
    }

    private static void deleteEmployee() throws SQLException {
        int employeeId = readInt("Enter employee ID to delete: ");
        Employee employee = employeeService.getEmployeeById(employeeId);

        if (employee == null) {
            System.out.println("No employee found with ID: " + employeeId);
            return;
        }

        System.out.print("Are you sure you want to delete this employee? (yes/no): ");
        String confirmation = scanner.nextLine();

        if (!"yes".equalsIgnoreCase(confirmation.trim())) {
            System.out.println("Delete operation cancelled.");
            return;
        }

        boolean isDeleted = employeeService.deleteEmployee(employeeId);

        if (isDeleted) {
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee could not be deleted.");
        }
    }

    private static void sortEmployeesBySalary() throws SQLException {
        List<Employee> employees = employeeService.sortEmployeesBySalary();
        printEmployees(employees);
    }

    private static void filterEmployeesByDepartment() throws SQLException {
        String department = readString("Enter department: ");
        List<Employee> employees = employeeService.getEmployeesByDepartment(department);
        printEmployees(employees);
    }

    private static Employee readEmployeeDetails() {
        String employeeName = readString("Enter employee name: ");
        String department = readString("Enter department: ");
        double salary = readDouble("Enter salary: ");
        String email = readString("Enter email: ");

        return new Employee(employeeName, department, salary, email);
    }

    private static String readString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    private static int readInt(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();

            try {
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException exception) {
                System.out.println("Invalid number. Please enter a valid integer.");
            }
        }
    }

    private static double readDouble(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();

            try {
                return Double.parseDouble(input.trim());
            } catch (NumberFormatException exception) {
                System.out.println("Invalid salary. Please enter a valid decimal number.");
            }
        }
    }

    private static void printEmployees(List<Employee> employees) {
        if (employees == null || employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        printTableHeader();

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private static void printTableHeader() {
        System.out.printf("%-5s %-25s %-20s %-12s %-30s%n",
                "ID", "Name", "Department", "Salary", "Email");
        System.out.println("--------------------------------------------------------------------------------------------");
    }
}
