import java.util.ArrayList;

class UniversitySystemDemo {

    // Professor class
    static class Professor {
        private String name;
        private ArrayList<Course> coursesTaught;

        public Professor(String name) {
            this.name = name;
            this.coursesTaught = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        // Communication: assign professor to a course
        public void assignCourse(Course course) {
            if (!coursesTaught.contains(course)) {
                coursesTaught.add(course);
                course.setProfessor(this); // Link course to professor
                System.out.println("Professor " + name + " assigned to course: " + course.getCourseName());
            }
        }

        public void viewCoursesTaught() {
            System.out.println("Professor: " + name + " teaches:");
            for (Course c : coursesTaught) {
                System.out.println("  - " + c.getCourseName());
            }
            System.out.println();
        }
    }

    // Student class
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

        // Communication: enroll student in a course
        public void enrollCourse(Course course) {
            if (!enrolledCourses.contains(course)) {
                enrolledCourses.add(course);
                course.addStudent(this); // Add student to course as well
                System.out.println(name + " enrolled in course: " + course.getCourseName());
            }
        }

        public void viewEnrolledCourses() {
            System.out.println("Student: " + name + " enrolled in:");
            for (Course c : enrolledCourses) {
                System.out.println("  - " + c.getCourseName() + " (Taught by: " +
                        (c.getProfessor() != null ? c.getProfessor().getName() : "TBA") + ")");
            }
            System.out.println();
        }
    }

    // Course class
    static class Course {
        private String courseName;
        private Professor professor;
        private ArrayList<Student> students;

        public Course(String courseName) {
            this.courseName = courseName;
            this.students = new ArrayList<>();
        }

        public String getCourseName() {
            return courseName;
        }

        public Professor getProfessor() {
            return professor;
        }

        public void setProfessor(Professor professor) {
            this.professor = professor;
        }

        public void addStudent(Student student) {
            if (!students.contains(student)) {
                students.add(student);
            }
        }

        public void viewStudents() {
            System.out.println("Course: " + courseName + " Enrolled Students:");
            for (Student s : students) {
                System.out.println("  - " + s.getName());
            }
            System.out.println();
        }
    }

    // Main method
    public static void main(String[] args) {
        // Create students
        Student alice = new Student("Alice");
        Student bob = new Student("Bob");

        // Create professors
        Professor profSmith = new Professor("Dr. Smith");
        Professor profJones = new Professor("Dr. Jones");

        // Create courses
        Course math = new Course("Mathematics");
        Course physics = new Course("Physics");
        Course cs = new Course("Computer Science");

        // Assign professors to courses
        profSmith.assignCourse(math);
        profJones.assignCourse(cs);

        // Students enroll in courses
        alice.enrollCourse(math);
        alice.enrollCourse(cs);

        bob.enrollCourse(physics); // course without professor yet
        bob.enrollCourse(math);

        // View details
        alice.viewEnrolledCourses();
        bob.viewEnrolledCourses();

        profSmith.viewCoursesTaught();
        profJones.viewCoursesTaught();

        math.viewStudents();
        physics.viewStudents();
        cs.viewStudents();
    }
}
