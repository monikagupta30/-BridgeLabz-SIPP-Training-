class Course {
    // Instance variables
    private String courseName;
    private int duration; // in weeks
    private double fee;

    // Class variable (common for all courses)
    private static String instituteName = "BridgeLabz Institute";

    // Constructor
    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method to display course details
    public void displayCourseDetails() {
        System.out.println("Institute Name: " + instituteName);
        System.out.println("Course Name   : " + courseName);
        System.out.println("Duration      : " + duration + " weeks");
        System.out.println("Fee           : ₹" + fee);
        System.out.println();
    }

    // Static method to update the institute name
    public static void updateInstituteName(String newName) {
        instituteName = newName;
    }

    // Main method to test the Course class
    public static void main(String[] args) {
        // Create course objects
        Course course1 = new Course("Java Programming", 6, 4500);
        Course course2 = new Course("Web Development", 8, 6000);

        // Display course details before updating institute name
        System.out.println("Courses Before Updating Institute Name:");
        course1.displayCourseDetails();
        course2.displayCourseDetails();

        // Update institute name
        Course.updateInstituteName("TechBridge Academy");

        // Display course details after update
        System.out.println("Courses After Updating Institute Name:");
        course1.displayCourseDetails();
        course2.displayCourseDetails();
    }
}
