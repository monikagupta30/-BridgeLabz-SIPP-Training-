import java.util.*;

public class PatientIDPrinting {
    public static void main(String[] args) {
        List<String> patientIDs = Arrays.asList(
            "P001", "P002", "P003", "P004", "P005"
        );

        System.out.println(" Patient IDs for Admin Verification:");
        
        // Using method reference instead of lambda
        patientIDs.forEach(System.out::println);
    }
}
