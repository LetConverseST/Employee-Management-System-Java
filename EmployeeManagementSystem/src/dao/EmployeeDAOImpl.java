package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import db.DBConnection;
import model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
    private static final String INSERT_EMPLOYEE =
            "INSERT INTO employees (employee_name, department, salary, email) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL_EMPLOYEES =
            "SELECT employee_id, employee_name, department, salary, email FROM employees";
    private static final String SELECT_EMPLOYEE_BY_ID =
            "SELECT employee_id, employee_name, department, salary, email FROM employees WHERE employee_id = ?";
    private static final String UPDATE_EMPLOYEE =
            "UPDATE employees SET employee_name = ?, department = ?, salary = ?, email = ? WHERE employee_id = ?";
    private static final String DELETE_EMPLOYEE =
            "DELETE FROM employees WHERE employee_id = ?";
    private static final String SELECT_EMPLOYEES_BY_DEPARTMENT =
            "SELECT employee_id, employee_name, department, salary, email FROM employees WHERE department = ?";

    @Override
    public boolean addEmployee(Employee employee) throws SQLException {
        Connection connection = DBConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE)) {

            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setString(2, employee.getDepartment());
            preparedStatement.setDouble(3, employee.getSalary());
            preparedStatement.setString(4, employee.getEmail());

            return preparedStatement.executeUpdate() > 0;
        }
    }

    @Override
    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        Connection connection = DBConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                employees.add(mapResultSetToEmployee(resultSet));
            }
        }

        return employees;
    }

    @Override
    public Employee getEmployeeById(int employeeId) throws SQLException {
        Connection connection = DBConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID)) {

            preparedStatement.setInt(1, employeeId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToEmployee(resultSet);
                }
            }
        }

        return null;
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        Connection connection = DBConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE)) {

            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setString(2, employee.getDepartment());
            preparedStatement.setDouble(3, employee.getSalary());
            preparedStatement.setString(4, employee.getEmail());
            preparedStatement.setInt(5, employee.getEmployeeId());

            return preparedStatement.executeUpdate() > 0;
        }
    }

    @Override
    public boolean deleteEmployee(int employeeId) throws SQLException {
        Connection connection = DBConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE)) {

            preparedStatement.setInt(1, employeeId);
            return preparedStatement.executeUpdate() > 0;
        }
    }

    @Override
    public List<Employee> sortEmployeesBySalary() throws SQLException {
        List<Employee> employees = getAllEmployees();

        // Sorting in Java demonstrates Collections Framework usage for academic review.
        employees.sort(Comparator.comparingDouble(Employee::getSalary));
        return employees;
    }

    @Override
    public List<Employee> getEmployeesByDepartment(String department) throws SQLException {
        List<Employee> employees = new ArrayList<>();
        Connection connection = DBConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEES_BY_DEPARTMENT)) {

            preparedStatement.setString(1, department);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    employees.add(mapResultSetToEmployee(resultSet));
                }
            }
        }

        return employees;
    }

    private Employee mapResultSetToEmployee(ResultSet resultSet) throws SQLException {
        return new Employee(
                resultSet.getInt("employee_id"),
                resultSet.getString("employee_name"),
                resultSet.getString("department"),
                resultSet.getDouble("salary"),
                resultSet.getString("email")
        );
    }
}
