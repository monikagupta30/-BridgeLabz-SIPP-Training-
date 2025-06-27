import java.util.ArrayList;

class HospitalSystemDemo {

    // Patient class
    static class Patient {
        private String name;
        private ArrayList<Doctor> doctors;

        public Patient(String name) {
            this.name = name;
            this.doctors = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public void addDoctor(Doctor doctor) {
            if (!doctors.contains(doctor)) {
                doctors.add(doctor);
            }
        }

        public void viewDoctors() {
            System.out.println("Patient: " + name + " has consulted:");
            for (Doctor d : doctors) {
                System.out.println("  Doctor: " + d.getName() + " (" + d.getSpecialization() + ")");
            }
            System.out.println();
        }
    }

    // Doctor class
    static class Doctor {
        private String name;
        private String specialization;
        private ArrayList<Patient> patients;

        public Doctor(String name, String specialization) {
            this.name = name;
            this.specialization = specialization;
            this.patients = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public String getSpecialization() {
            return specialization;
        }

        public void consult(Patient patient) {
            if (!patients.contains(patient)) {
                patients.add(patient);
                patient.addDoctor(this); // Bidirectional association
            }
            System.out.println("Consultation: Dr. " + name + " is consulting patient " + patient.getName());
        }

        public void viewPatients() {
            System.out.println("Dr. " + name + " (" + specialization + ") has seen:");
            for (Patient p : patients) {
                System.out.println("  Patient: " + p.getName());
            }
            System.out.println();
        }
    }

    // Hospital class (contains lists of doctors and patients)
    static class Hospital {
        private String hospitalName;
        private ArrayList<Doctor> doctors;
        private ArrayList<Patient> patients;

        public Hospital(String hospitalName) {
            this.hospitalName = hospitalName;
            this.doctors = new ArrayList<>();
            this.patients = new ArrayList<>();
        }

        public void addDoctor(Doctor doctor) {
            doctors.add(doctor);
        }

        public void addPatient(Patient patient) {
            patients.add(patient);
        }

        public void displayHospitalInfo() {
            System.out.println("Hospital: " + hospitalName);
            System.out.println("Doctors:");
            for (Doctor d : doctors) {
                System.out.println("  " + d.getName() + " (" + d.getSpecialization() + ")");
            }
            System.out.println("Patients:");
            for (Patient p : patients) {
                System.out.println("  " + p.getName());
            }
            System.out.println();
        }
    }

    // Main method
    public static void main(String[] args) {
        // Create hospital
        Hospital hospital = new Hospital("City Care Hospital");

        // Create doctors
        Doctor drSmith = new Doctor("Smith", "Cardiologist");
        Doctor drBrown = new Doctor("Brown", "Neurologist");

        // Create patients
        Patient john = new Patient("John");
        Patient emily = new Patient("Emily");

        // Add to hospital
        hospital.addDoctor(drSmith);
        hospital.addDoctor(drBrown);
        hospital.addPatient(john);
        hospital.addPatient(emily);

        // Consultations (communication + association)
        drSmith.consult(john);
        drSmith.consult(emily);
        drBrown.consult(emily);

        // Display hospital info
        hospital.displayHospitalInfo();

        // View patient-doctor relationships
        drSmith.viewPatients();
        drBrown.viewPatients();

        john.viewDoctors();
        emily.viewDoctors();
    }
}
