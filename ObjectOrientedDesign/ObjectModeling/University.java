import java.util.ArrayList;

class UniversitySystemDemo {

    // Faculty class (can exist independently of any Department)
    static class Faculty {
        private String name;
        private String designation;

        public Faculty(String name, String designation) {
            this.name = name;
            this.designation = designation;
        }

        public void displayFaculty() {
            System.out.println("  Faculty: " + name + ", " + designation);
        }
    }

    // Department class (part of University - Composition)
    static class Department {
        private String deptName;
        private ArrayList<Faculty> facultyMembers;

        public Department(String deptName) {
            this.deptName = deptName;
            this.facultyMembers = new ArrayList<>();
        }

        public void addFaculty(Faculty faculty) {
            facultyMembers.add(faculty); // Aggregation
        }

        public void displayDepartment() {
            System.out.println("Department: " + deptName);
            for (Faculty f : facultyMembers) {
                f.displayFaculty();
            }
            System.out.println();
        }
    }

    // University class (owns Departments - Composition)
    static class University {
        private String universityName;
        private ArrayList<Department> departments;

        public University(String universityName) {
            this.universityName = universityName;
            this.departments = new ArrayList<>();
        }

        public void addDepartment(Department dept) {
            departments.add(dept);
        }

        public void displayUniversityStructure() {
            System.out.println("University: " + universityName);
            for (Department d : departments) {
                d.displayDepartment();
            }
        }

        // "Delete" university by clearing departments
        public void deleteUniversity() {
            System.out.println("\nDeleting University: " + universityName);
            departments.clear(); // Composition: departments deleted with university
            System.out.println("All departments deleted.");
        }
    }

    // Main method
    public static void main(String[] args) {
        // Independent faculty (exists before assignment)
        Faculty profA = new Faculty("Dr. Alice", "Professor");
        Faculty profB = new Faculty("Dr. Bob", "Associate Professor");
        Faculty profC = new Faculty("Dr. Charlie", "Lecturer");

        // Create university
        University uni = new University("Global Tech University");

        // Create departments (composition)
        Department csDept = new Department("Computer Science");
        Department eeDept = new Department("Electrical Engineering");

        // Add faculty to departments (aggregation)
        csDept.addFaculty(profA);
        csDept.addFaculty(profC);

        eeDept.addFaculty(profB);

        // Add departments to university
        uni.addDepartment(csDept);
        uni.addDepartment(eeDept);

        // Display university structure
        uni.displayUniversityStructure();

        // Delete university (departments will be lost)
        uni.deleteUniversity();

        // Faculty still exists
        System.out.println("\nIndependent Faculty Members (still exist):");
        profA.displayFaculty();
        profB.displayFaculty();
        profC.displayFaculty();
    }
}
