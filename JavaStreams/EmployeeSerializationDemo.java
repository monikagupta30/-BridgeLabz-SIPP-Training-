import java.io.*;
import java.util.*;

// Employee class must implement Serializable
class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Display method
    public void display() {
        System.out.println("ID: " + id +
                           ", Name: " + name +
                           ", Department: " + department +
                           ", Salary: " + salary);
    }
}

public class EmployeeSerializationDemo {

    private static final String FILE_NAME = "employees.ser";

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();

        // Add sample employees
        employeeList.add(new Employee(1, "Alice", "HR", 50000));
        employeeList.add(new Employee(2, "Bob", "IT", 60000));
        employeeList.add(new Employee(3, "Charlie", "Finance", 55000));

        // Serialize employee list to file
        serializeEmployees(employeeList);

        // Deserialize and display
        List<Employee> deserializedList = deserializeEmployees();
        if (deserializedList != null) {
            System.out.println("\nDeserialized Employees:");
            for (Employee emp : deserializedList) {
                emp.display();
            }
        }
    }

    // Method to serialize employee list
    public static void serializeEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
            System.out.println("Employees serialized successfully to '" + FILE_NAME + "'");
        } catch (IOException e) {
            System.out.println("Serialization failed: " + e.getMessage());
        }
    }

    // Method to deserialize employee list
    public static List<Employee> deserializeEmployees() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            List<Employee> employees = (List<Employee>) ois.readObject();
            return employees;
        } catch (IOException e) {
            System.out.println("Deserialization failed: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Employee class not found: " + e.getMessage());
        }
        return null;
    }
}
