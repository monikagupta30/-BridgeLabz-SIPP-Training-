import java.io.*;

public class StudentDataStreamDemo {
    public static void main(String[] args) {
        String fileName = "students.dat";

        // Sample student data
        int[] rollNumbers = {101, 102, 103};
        String[] names = {"Alice", "Bob", "Charlie"};
        double[] gpas = {3.8, 3.5, 3.9};

        // Write data to binary file
        writeStudentData(fileName, rollNumbers, names, gpas);

        // Read and display data from binary file
        readStudentData(fileName);
    }

    // Write student data to binary file
    public static void writeStudentData(String fileName, int[] rollNumbers, String[] names, double[] gpas) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            for (int i = 0; i < rollNumbers.length; i++) {
                dos.writeInt(rollNumbers[i]);
                dos.writeUTF(names[i]);
                dos.writeDouble(gpas[i]);
            }
            System.out.println("Student data written successfully to '" + fileName + "'");
        } catch (IOException e) {
            System.out.println("Error writing student data: " + e.getMessage());
        }
    }

    // Read student data from binary file
    public static void readStudentData(String fileName) {
        System.out.println("\nReading student data from file:");
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            while (true) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll: " + roll + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (EOFException e) {
            // End of file reached (normal condition)
            System.out.println("\nEnd of student data.");
        } catch (IOException e) {
            System.out.println("Error reading student data: " + e.getMessage());
        }
    }
}
