import java.util.*;

// Interface for Department functionality
interface Department {
    void assignDepartment(String deptName);
    String getDepartmentDetails();
}

// Abstract class with encapsulation
abstract class Employee implements Department {
    private int employeeId;
    private String name;
    private double baseSalary;
    private String department;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Encapsulation: Getters and Setters
    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    // Abstract method
    public abstract double calculateSalary();

    // Concrete method
    public void displayDetails() {
        System.out.println("ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: ₹" + baseSalary);
        System.out.println("Department: " + department);
        System.out.println("Total Salary: ₹" + calculateSalary());
    }

    // Implementing Department interface
    @Override
    public void assignDepartment(String deptName) {
        this.department = deptName;
    }

    @Override
    public String getDepartmentDetails() {
        return department;
    }
}

// Full-time employee class
class FullTimeEmployee extends Employee {
    private double bonus;

    public FullTimeEmployee(int employeeId, String name, double baseSalary, double bonus) {
        super(employeeId, name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + bonus;
    }
}

// Part-time employee class
class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int employeeId, String name, double baseSalary, int hoursWorked, double hourlyRate) {
        super(employeeId, name, baseSalary); // baseSalary can be minimum guarantee or 0
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + (hoursWorked * hourlyRate);
    }
}

// Main class to demonstrate polymorphism

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        FullTimeEmployee emp1 = new FullTimeEmployee(101, "Amit", 50000, 10000);
        emp1.assignDepartment("Engineering");

        PartTimeEmployee emp2 = new PartTimeEmployee(102, "Riya", 0, 80, 300);
        emp2.assignDepartment("Support");

        employees.add(emp1);
        employees.add(emp2);

        // Polymorphic processing
        for (Employee emp : employees) {
            System.out.println("--------------");
            emp.displayDetails();
        }
    }
}
