// Base class
class Employee {
    public int employeeID;          // Public - accessible anywhere
    protected String department;    // Protected - accessible in subclass
    private double salary;          // Private - accessible only through methods

    // Constructor
    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // Public method to set salary
    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Invalid salary amount.");
        }
    }

    // Public method to get salary
    public double getSalary() {
        return salary;
    }

    // Method to display employee details
    public void displayEmployeeDetails() {
        System.out.println("Employee ID : " + employeeID);
        System.out.println("Department  : " + department);
        System.out.println("Salary      : ₹" + salary);
        System.out.println();
    }
}

// Subclass
class Manager extends Employee {
    private String level;

    // Constructor
    public Manager(int employeeID, String department, double salary, String level) {
        super(employeeID, department, salary);
        this.level = level;
    }

    // Display manager-specific details
    public void displayManagerInfo() {
        System.out.println("Manager Details:");
        System.out.println("Employee ID : " + employeeID);    // public
        System.out.println("Department  : " + department);    // protected
        System.out.println("Level       : " + level);
        System.out.println();
    }
}

// Main class
class EmployeeRecords {
    public static void main(String[] args) {
        // Create Employee object
        Employee emp1 = new Employee(101, "Finance", 45000.00);
        emp1.displayEmployeeDetails();

        // Modify salary
        emp1.setSalary(48000.00);
        System.out.println("Updated Salary: ₹" + emp1.getSalary());
        System.out.println();

        // Create Manager object
        Manager mgr1 = new Manager(201, "IT", 75000.00, "Senior");
        mgr1.displayEmployeeDetails();   // inherited
        mgr1.displayManagerInfo();       // subclass-specific
    }
}
