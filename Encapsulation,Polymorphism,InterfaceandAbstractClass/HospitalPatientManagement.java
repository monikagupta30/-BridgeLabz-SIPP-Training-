import java.util.*;

// Interface for Medical Records
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// Abstract Class Patient
abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    // Encapsulated medical history
    private List<String> medicalHistory = new ArrayList<>();

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Getters
    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    protected List<String> getMedicalHistory() {
        return medicalHistory;
    }

    // Abstract Method
    public abstract double calculateBill();

    // Concrete Method
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// InPatient Subclass
class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double roomRate;

    public InPatient(String patientId, String name, int age, int daysAdmitted, double roomRate) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.roomRate = roomRate;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * roomRate;
    }

    @Override
    public void addRecord(String record) {
        getMedicalHistory().add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for In-Patient:");
        for (String record : getMedicalHistory()) {
            System.out.println("- " + record);
        }
    }
}

// OutPatient Subclass
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;

    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        getMedicalHistory().add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for Out-Patient:");
        for (String record : getMedicalHistory()) {
            System.out.println("- " + record);
        }
    }
}

// Main Class
public class HospitalPatientManagement {
    public static void main(String[] args) {
        // Create patients
        Patient p1 = new InPatient("IP101", "Ravi Sharma", 45, 4, 2500);
        Patient p2 = new OutPatient("OP202", "Anjali Mehta", 30, 800);

        // Polymorphic list
        List<Patient> patientList = Arrays.asList(p1, p2);

        // Process each patient
        for (Patient p : patientList) {
            System.out.println("\n-------------------------------");
            p.getPatientDetails();

            if (p instanceof MedicalRecord) {
                MedicalRecord mr = (MedicalRecord) p;
                mr.addRecord("Initial checkup");
                mr.addRecord("Blood test and diagnosis");
                mr.viewRecords();
            }

            System.out.println("Total Bill: ₹" + p.calculateBill());
        }
    }
}
