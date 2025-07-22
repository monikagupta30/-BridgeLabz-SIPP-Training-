import java.util.*;

// === Abstract Course Type ===
abstract class CourseType {
    private String title;
    private int credits;

    public CourseType(String title, int credits) {
        this.title = title;
        this.credits = credits;
    }

    public String getTitle() {
        return title;
    }

    public int getCredits() {
        return credits;
    }

    public abstract String getEvaluationMethod();

    @Override
    public String toString() {
        return String.format("%s (%d Credits) - %s", title, credits, getEvaluationMethod());
    }
}

// === Subclasses for Evaluation Types ===
class ExamCourse extends CourseType {
    public ExamCourse(String title, int credits) {
        super(title, credits);
    }

    @Override
    public String getEvaluationMethod() {
        return "Exam-Based";
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String title, int credits) {
        super(title, credits);
    }

    @Override
    public String getEvaluationMethod() {
        return "Assignment-Based";
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String title, int credits) {
        super(title, credits);
    }

    @Override
    public String getEvaluationMethod() {
        return "Research-Based";
    }
}

// === Generic Course Class with Bounded Type ===
class Course<T extends CourseType> {
    private String courseCode;
    private T courseType;

    public Course(String courseCode, T courseType) {
        this.courseCode = courseCode;
        this.courseType = courseType;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public T getCourseType() {
        return courseType;
    }

    public void displayInfo() {
        System.out.println(courseCode + " - " + courseType);
    }
}

// === Utility Class Using Wildcards ===
class CourseUtils {
    public static void displayAllCourses(List<? extends Course<? extends CourseType>> courses) {
        for (Course<? extends CourseType> course : courses) {
            course.displayInfo();
        }
    }
}

// === Main Driver Class ===
public class UniversityCourseSystem {
    public static void main(String[] args) {
        // Create Exam-based courses
        Course<ExamCourse> math101 = new Course<>("MATH101", new ExamCourse("Calculus I", 4));
        Course<ExamCourse> phy102 = new Course<>("PHY102", new ExamCourse("Physics I", 3));

        // Create Assignment-based courses
        Course<AssignmentCourse> eng201 = new Course<>("ENG201", new AssignmentCourse("Technical Writing", 2));
        Course<AssignmentCourse> cs202 = new Course<>("CS202", new AssignmentCourse("Software Engineering", 3));

        // Create Research-based courses
        Course<ResearchCourse> ai301 = new Course<>("AI301", new ResearchCourse("AI Research Project", 6));
        Course<ResearchCourse> ds302 = new Course<>("DS302", new ResearchCourse("Data Science Thesis", 6));

        // Collect all courses in a common list
        List<Course<? extends CourseType>> allCourses = new ArrayList<>();
        allCourses.add(math101);
        allCourses.add(phy102);
        allCourses.add(eng201);
        allCourses.add(cs202);
        allCourses.add(ai301);
        allCourses.add(ds302);

        // Display all courses using wildcard method
        System.out.println("=== University Course Catalog ===");
        CourseUtils.displayAllCourses(allCourses);
    }
}
