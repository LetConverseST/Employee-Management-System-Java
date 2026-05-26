package model;

public class Employee {
    private int employeeId;
    private String employeeName;
    private String department;
    private double salary;
    private String email;

    public Employee() {
    }

    public Employee(String employeeName, String department, double salary, String email) {
        this.employeeName = employeeName;
        this.department = department;
        this.salary = salary;
        this.email = email;
    }

    public Employee(int employeeId, String employeeName, String department, double salary, String email) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.department = department;
        this.salary = salary;
        this.email = email;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("%-5d %-25s %-20s %-12.2f %-30s",
                employeeId, employeeName, department, salary, email);
    }
}
