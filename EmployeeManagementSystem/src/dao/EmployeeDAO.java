package dao;

import java.sql.SQLException;
import java.util.List;

import model.Employee;

public interface EmployeeDAO {
    boolean addEmployee(Employee employee) throws SQLException;

    List<Employee> getAllEmployees() throws SQLException;

    Employee getEmployeeById(int employeeId) throws SQLException;

    boolean updateEmployee(Employee employee) throws SQLException;

    boolean deleteEmployee(int employeeId) throws SQLException;

    List<Employee> sortEmployeesBySalary() throws SQLException;

    List<Employee> getEmployeesByDepartment(String department) throws SQLException;
}
