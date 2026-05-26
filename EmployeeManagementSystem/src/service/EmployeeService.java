package service;

import java.sql.SQLException;
import java.util.List;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.Employee;
import util.InputValidator;

public class EmployeeService {
    private final EmployeeDAO employeeDAO;

    public EmployeeService() {
        this.employeeDAO = new EmployeeDAOImpl();
    }

    public boolean addEmployee(Employee employee) throws SQLException {
        validateEmployee(employee);
        return employeeDAO.addEmployee(employee);
    }

    public List<Employee> getAllEmployees() throws SQLException {
        return employeeDAO.getAllEmployees();
    }

    public Employee getEmployeeById(int employeeId) throws SQLException {
        validateEmployeeId(employeeId);
        return employeeDAO.getEmployeeById(employeeId);
    }

    public boolean updateEmployee(Employee employee) throws SQLException {
        validateEmployeeId(employee.getEmployeeId());
        validateEmployee(employee);
        return employeeDAO.updateEmployee(employee);
    }

    public boolean deleteEmployee(int employeeId) throws SQLException {
        validateEmployeeId(employeeId);
        return employeeDAO.deleteEmployee(employeeId);
    }

    public List<Employee> sortEmployeesBySalary() throws SQLException {
        return employeeDAO.sortEmployeesBySalary();
    }

    public List<Employee> getEmployeesByDepartment(String department) throws SQLException {
        if (InputValidator.isNullOrEmpty(department)) {
            throw new IllegalArgumentException("Department cannot be empty.");
        }

        return employeeDAO.getEmployeesByDepartment(department.trim());
    }

    private void validateEmployee(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee details cannot be null.");
        }

        if (!InputValidator.isValidName(employee.getEmployeeName())) {
            throw new IllegalArgumentException("Employee name cannot be empty.");
        }

        if (InputValidator.isNullOrEmpty(employee.getDepartment())) {
            throw new IllegalArgumentException("Department cannot be empty.");
        }

        if (!InputValidator.isValidSalary(employee.getSalary())) {
            throw new IllegalArgumentException("Salary must be greater than 0.");
        }

        if (!InputValidator.isValidEmail(employee.getEmail())) {
            throw new IllegalArgumentException("Please enter a valid email address.");
        }
    }

    private void validateEmployeeId(int employeeId) {
        if (employeeId <= 0) {
            throw new IllegalArgumentException("Employee ID must be greater than 0.");
        }
    }
}
