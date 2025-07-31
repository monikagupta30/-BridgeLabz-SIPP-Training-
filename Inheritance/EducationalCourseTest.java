//Superclass
class Course {
    protected String courseName;
    protected int duration;

    //Constructor
    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }
 
    //Method to display details
    public void displayDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + "hours");
    }
}

//SubClass Onlineclass
class OnlineCourse extends Course {
    protected String platform;
    protected boolean isRecorded;

    public OnlineCourse(String courseName, int duration, String platform, boolean isRacorded) {
        super(courseName,duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}

//Subclass PaidOnlineCourse
class PaidOnlineCourse extends OnlineCourse {
    private double fee;
    private double discount;

    public PaidOnlineCourse(String courseName,int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Course Fee:  ₹" + fee);
        System.out.println("Dicount: " + discount + "%");
        System.out.println("Final Price:  ₹" + calculateFinalFee());
    }

        public double calculateFinalFee() {
            return fee - (fee * discount / 100);
        }
}

//Main class to test
public class EducationalCourseTest {
    public static void main(String[] args) {
        PaidOnlineCourse poc = new PaidOnlineCourse("Java Programming", 40, "Coursera", true, 5000.0,20.0);
        poc.displayDetails();
    }
}




























