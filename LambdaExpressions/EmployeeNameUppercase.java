import java.util.*;

public class EmployeeNameUppercase {
    public static void main(String[] args) {
        List<String> employeeNames = Arrays.asList(
            "Abhi", "Monika", "Chirag", "Priya"
        );

        System.out.println(" Employee Names in Uppercase for HR Letter:");

        // Using method reference String::toUpperCase in a stream
        employeeNames.stream()
                     .map(String::toUpperCase)
                     .forEach(System.out::println);
    }
}
