import java.util.ArrayList;

class SchoolSystemDemo {

    // Course class (shared among students)
    static class Course {
        private String courseName;
        private ArrayList<Student> enrolledStudents;

        public Course(String courseName) {
            this.courseName = courseName;
            this.enrolledStudents = new ArrayList<>();
        }

        public String getCourseName() {
            return courseName;
        }

        public void enrollStudent(Student student) {
            if (!enrolledStudents.contains(student)) {
                enrolledStudents.add(student);
            }
        }

        public void displayEnrolledStudents() {
            System.out.println("Course: " + courseName);
            for (Student s : enrolledStudents) {
                System.out.println("  Student: " + s.getName());
            }
            System.out.println();
        }
    }

    // Student class (can enroll in many courses)
    static class Student {
        private String name;
        private ArrayList<Course> enrolledCourses;

        public Student(String name) {
            this.name = name;
            this.enrolledCourses = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public void enrollInCourse(Course course) {
            if (!enrolledCourses.contains(course)) {
                enrolledCourses.add(course);
                course.enrollStudent(this); // Bidirectional association
            }
        }

        public void viewCourses() {
            System.out.println("Student: " + name);
            for (Course c : enrolledCourses) {
                System.out.println("  Enrolled in: " + c.getCourseName());
            }
            System.out.println();
        }
    }

    // School class (aggregates students)
    static class School {
        private String schoolName;
        private ArrayList<Student> students;

        public School(String schoolName) {
            this.schoolName = schoolName;
            this.students = new ArrayList<>();
        }

        public void addStudent(Student student) {
            if (!students.contains(student)) {
                students.add(student);
            }
        }

        public void displayAllStudents() {
            System.out.println("School: " + schoolName);
            for (Student s : students) {
                System.out.println("  Student: " + s.getName());
            }
            System.out.println();
        }
    }

    // Main method
    public static void main(String[] args) {
        // Create school
        School school = new School("Sunrise High School");

        // Create students
        Student alice = new Student("Alice");
        Student bob = new Student("Bob");

        // Create courses
        Course math = new Course("Mathematics");
        Course physics = new Course("Physics");
        Course cs = new Course("Computer Science");

        // Enroll students in courses
        alice.enrollInCourse(math);
        alice.enrollInCourse(cs);

        bob.enrollInCourse(physics);
        bob.enrollInCourse(math);

        // Add students to school
        school.addStudent(alice);
        school.addStudent(bob);

        // Display school info
        school.displayAllStudents();

        // View enrolled courses for each student
        alice.viewCourses();
        bob.viewCourses();

        // View enrolled students for each course
        math.displayEnrolledStudents();
        physics.displayEnrolledStudents();
        cs.displayEnrolledStudents();
    }
}
