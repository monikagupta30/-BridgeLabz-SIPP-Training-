// Base class
class Student {
    public int rollNumber;         // Public - accessible anywhere
    protected String name;         // Protected - accessible in subclass
    private double CGPA;           // Private - accessed via public methods

    // Constructor
    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    // Public method to get CGPA
    public double getCGPA() {
        return CGPA;
    }

    // Public method to set CGPA
    public void setCGPA(double CGPA) {
        if (CGPA >= 0.0 && CGPA <= 10.0) {
            this.CGPA = CGPA;
        } else {
            System.out.println("Invalid CGPA. Please enter a value between 0.0 and 10.0.");
        }
    }

    // Method to display student info
    public void displayStudentInfo() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name       : " + name);
        System.out.println("CGPA       : " + CGPA);
        System.out.println();
    }
}

// Subclass
class PostgraduateStudent extends Student {
    private String specialization;

    public PostgraduateStudent(int rollNumber, String name, double CGPA, String specialization) {
        super(rollNumber, name, CGPA); // Call parent constructor
        this.specialization = specialization;
    }

    // Method specific to PostgraduateStudent
    public void displayPostgradInfo() {
        System.out.println("Postgraduate Student:");
        System.out.println("Name           : " + name);  // Accessing protected member
        System.out.println("Specialization : " + specialization);
    }
}

// Main class to test
class UniversityManagement {
    public static void main(String[] args) {
        // Create a Student object
        Student s1 = new Student(101, "Rahul Sharma", 8.5);
        s1.displayStudentInfo();

        // Modify CGPA
        s1.setCGPA(9.2);
        System.out.println("Updated CGPA: " + s1.getCGPA());
        System.out.println();

        // Create a PostgraduateStudent object
        PostgraduateStudent pg1 = new PostgraduateStudent(201, "Anjali Mehra", 9.4, "Computer Science");
        pg1.displayStudentInfo();       // Inherited method
        pg1.displayPostgradInfo();      // Subclass-specific method
    }
}
