class Patient {
    // Static variable shared by all patients
    static String hospitalName = "CityCare Multispeciality Hospital";
    static int totalPatients = 0;

    // Final variable to uniquely identify each patient
    private final int patientID;

    // Instance variables
    private String name;
    private int age;
    private String ailment;

    // Constructor using 'this' to resolve ambiguity
    public Patient(int patientID, String name, int age, String ailment) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++; // Increase count on each patient creation
    }

    // Static method to get total number of patients
    public static void getTotalPatients() {
        System.out.println("Total Patients Admitted: " + totalPatients);
    }

    // Method to display patient details
    public void displayPatientDetails() {
        System.out.println("Hospital Name : " + hospitalName);
        System.out.println("Patient ID    : " + patientID);
        System.out.println("Name          : " + name);
        System.out.println("Age           : " + age);
        System.out.println("Ailment       : " + ailment);
        System.out.println("----------------------------------");
    }

    // Main method to test functionality
    public static void main(String[] args) {
        Patient p1 = new Patient(1, "Neha Singh", 28, "Fever");
        Patient p2 = new Patient(2, "Raj Malhotra", 45, "Fracture");

        // Display total number of patients
        Patient.getTotalPatients();

        // Use instanceof to check object type before accessing details
        if (p1 instanceof Patient) {
            p1.displayPatientDetails();
        }

        if (p2 instanceof Patient) {
            p2.displayPatientDetails();
        }
    }
}
