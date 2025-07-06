import java.util.Scanner;

// Node class for storing student info
class Student {
    int roll;
    String name, grade;
    int age;
    Student next;

    Student(int roll, String name, int age, String grade) {
        this.roll = roll;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

// Singly Linked List to manage student records
class StudentList {
    Student head = null;

    // Add student at beginning
    void addFirst(Student s) {
        s.next = head;
        head = s;
    }

    // Add student at end
    void addLast(Student s) {
        if (head == null) {
            head = s;
        } else {
            Student temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = s;
        }
    }

    // Delete student by roll number
    void delete(int roll) {
        if (head == null) return;

        if (head.roll == roll) {
            head = head.next;
            return;
        }

        Student temp = head;
        while (temp.next != null && temp.next.roll != roll)
            temp = temp.next;

        if (temp.next != null)
            temp.next = temp.next.next;
    }

    // Search student by roll number
    void search(int roll) {
        Student temp = head;
        while (temp != null) {
            if (temp.roll == roll) {
                System.out.println("Found: " + temp.name + ", Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found.");
    }

    // Update grade by roll number
    void update(int roll, String newGrade) {
        Student temp = head;
        while (temp != null) {
            if (temp.roll == roll) {
                temp.grade = newGrade;
                System.out.println("Grade updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found.");
    }

    // Display all student records
    void displayAll() {
        if (head == null) {
            System.out.println("No student records.");
            return;
        }

        Student temp = head;
        System.out.println("Student Records:");
        while (temp != null) {
            System.out.println("Roll: " + temp.roll + ", Name: " + temp.name +
                    ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }
}

public class StudentRecordManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentList list = new StudentList();

        while (true) {
            System.out.println("\n--- Student Menu ---");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Delete by Roll");
            System.out.println("4. Search by Roll");
            System.out.println("5. Update Grade");
            System.out.println("6. Display All");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter Roll, Name, Age, Grade: ");
                    Student s1 = new Student(sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
                    list.addFirst(s1);
                    break;

                case 2:
                    System.out.print("Enter Roll, Name, Age, Grade: ");
                    Student s2 = new Student(sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
                    list.addLast(s2);
                    break;

                case 3:
                    System.out.print("Enter Roll to Delete: ");
                    list.delete(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter Roll to Search: ");
                    list.search(sc.nextInt());
                    break;

                case 5:
                    System.out.print("Enter Roll and New Grade: ");
                    list.update(sc.nextInt(), sc.next());
                    break;

                case 6:
                    list.displayAll();  // ✅ CORRECT METHOD NAME
                    break;

                case 7:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}





















