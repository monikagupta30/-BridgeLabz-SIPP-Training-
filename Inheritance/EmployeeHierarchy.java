//Superclass
class Employee {
    String name;
    int id;
    double salary;
    
    //Contructor
    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id; 
        this.salary = salary;
    }
    
    //Method to dispaly details
    void displayDetails() {
        System.out.println("Employee name:" + name);
        System.out.println("ID:" + id);
        System.out.println("Salary: ₹" + salary);
    }
}

//Subclass Manager
class Manager extends Employee {
    int teamSize;
    Manager(String name, int id, double salary, int teamSize) {
        super(name,id,salary);
        this.teamSize = teamSize;
    }
    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Manager");
        System.out.println("Team Size" + teamSize);
    }
}

//Subclass Developer
class Developer extends Employee {
    String programmingLanguage;
    Developer(String name, int id, double salary, String programmingLanguage) {
        super(name,id,salary);
        this.programmingLanguage = programmingLanguage;
    }
    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Developer");
        System.out.println("Programming Language" + programmingLanguage);
    }
}

//Subclass Intern
class Intern extends Employee {
    String university;
    Intern(String name, int id, double salary, String university) {
        super(name,id,salary);
        this.university = university;
    }
    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Intern");
        System.out.println("University" + university);
    }
}

//Main class to test
public class EmployeeHierarchy {
    public static void main(String[] args) {
        Employee manager = new Manager("Ayush Gupta",101,95000,9);
        Employee developer = new Developer("Saloni Gupta",102,65000,"Java");
        Employee intern = new Intern("Monika Gupta",103,30000,"IIT Delhi");

        //Display details using polymorphism
        System.out.println("=== Manager Details ===");
        manager.displayDetails();
        System.out.println("\n=== Developer Details ===");
        developer.displayDetails();
        System.out.println("\n=== Intern Details ===");
        intern.displayDetails();
    }
}






















