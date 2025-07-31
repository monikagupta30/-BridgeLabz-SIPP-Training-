class Employee {
    // Static variable shared by all Employee objects
    static String companyName = "Tech Solutions Pvt. Ltd.";
    static int totalEmployees = 0;

    // Final variable to store unchangeable employee ID
    private final int id;

    // Instance variables
    private String name;
    private String designation;

    // Constructor using 'this' keyword
    public Employee(int id, String name, String designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        totalEmployees++; // Increments every time a new employee is created
    }

    // Static method to display total employees
    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    // Method to display employee details
    public void displayEmployeeDetails() {
        System.out.println("Company Name: " + companyName);
        System.out.println("Employee ID : " + id);
        System.out.println("Name        : " + name);
        System.out.println("Designation : " + designation);
    }

    // Main method for testing
    public static void main(String[] args) {
        Employee emp1 = new Employee(101, "Monika Gupta", "Software Engineer");
        Employee emp2 = new Employee(102, "Amit Verma", "QA Analyst");

        // Display total employees
        Employee.displayTotalEmployees();

        // Check instance type before displaying details
        if (emp1 instanceof Employee) {
            emp1.displayEmployeeDetails();
        }

        if (emp2 instanceof Employee) {
            emp2.displayEmployeeDetails();
        }
    }
}
