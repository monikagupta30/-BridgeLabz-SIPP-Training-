class Student {
    // Static variable shared across all students
    static String universityName = "National Institute of Technology";
    static int totalStudents = 0;

    // Final variable - cannot be modified after assignment
    private final int rollNumber;

    // Instance variables
    private String name;
    private String grade;

    // Constructor using 'this' to resolve ambiguity
    public Student(int rollNumber, String name, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        totalStudents++; // Increment student count on creation
    }

    // Static method to display total students
    public static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }

    // Method to update grade
    public void updateGrade(String newGrade) {
        this.grade = newGrade;
        System.out.println("Grade updated to: " + grade);
    }

    // Method to display student details
    public void displayStudentDetails() {
        System.out.println("University Name : " + universityName);
        System.out.println("Roll Number     : " + rollNumber);
        System.out.println("Name            : " + name);
        System.out.println("Grade           : " + grade);
        System.out.println("-----------------------------------");
    }

    // Main method for testing
    public static void main(String[] args) {
        Student stu1 = new Student(101, "Anjali Mehra", "A");
        Student stu2 = new Student(102, "Ravi Kumar", "B+");

        // Display total students
        Student.displayTotalStudents();

        // Use instanceof before performing operations
        if (stu1 instanceof Student) {
            stu1.displayStudentDetails();
            stu1.updateGrade("A+");
        }

        if (stu2 instanceof Student) {
            stu2.displayStudentDetails();
        }
    }
}
