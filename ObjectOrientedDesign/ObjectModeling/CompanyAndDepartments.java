import java.util.ArrayList;

// Main class
class CompanyCompositionDemo {

    // Employee class (can't exist without a Department)
    static class Employee {
        private String name;
        private String role;

        public Employee(String name, String role) {
            this.name = name;
            this.role = role;
        }

        public void displayEmployee() {
            System.out.println("    Employee: " + name + ", Role: " + role);
        }
    }

    // Department class (can't exist without a Company)
    static class Department {
        private String deptName;
        private ArrayList<Employee> employees;

        public Department(String deptName) {
            this.deptName = deptName;
            this.employees = new ArrayList<>();
        }

        public void addEmployee(String name, String role) {
            employees.add(new Employee(name, role));
        }

        public void displayDepartment() {
            System.out.println("  Department: " + deptName);
            for (Employee e : employees) {
                e.displayEmployee();
            }
        }
    }

    // Company class (owns departments and employees)
    static class Company {
        private String companyName;
        private ArrayList<Department> departments;

        public Company(String companyName) {
            this.companyName = companyName;
            this.departments = new ArrayList<>();
        }

        public void addDepartment(Department dept) {
            departments.add(dept);
        }

        public void displayCompanyStructure() {
            System.out.println("Company: " + companyName);
            for (Department d : departments) {
                d.displayDepartment();
            }
        }

        // "Deleting" company (simulate by clearing departments)
        public void closeCompany() {
            System.out.println("Company " + companyName + " is closing...");
            departments.clear(); // All departments and employees deleted
            System.out.println("All departments and employees removed.");
        }
    }

    // Main method
    public static void main(String[] args) {
        // Create company
        Company company = new Company("TechCorp");

        // Create departments
        Department devDept = new Department("Development");
        devDept.addEmployee("Alice", "Software Engineer");
        devDept.addEmployee("Bob", "Backend Developer");

        Department hrDept = new Department("HR");
        hrDept.addEmployee("Clara", "HR Manager");
        hrDept.addEmployee("David", "Recruiter");

        // Add departments to company
        company.addDepartment(devDept);
        company.addDepartment(hrDept);

        // Display full structure
        company.displayCompanyStructure();

        // Close company (delete all departments and employees)
        company.closeCompany();
    }
}
