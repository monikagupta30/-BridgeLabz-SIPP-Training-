import java.util.regex.*;

public class LicensePlateValidator {
    public static boolean isValidLicensePlate(String plate) {
        // Regex: 2 uppercase letters + 4 digits
        String regex = "^[A-Z]{2}\\d{4}$";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(plate);
        
        return matcher.matches();
    }

    public static void main(String[] args) {
        // Test cases
        String[] plates = {
            "AB1234",   
            "A12345",   
            "AB12345",  
            "XY9876",   
            "ab1234",   
            "A1234B"    
        };
        
        for (String plate : plates) {
            System.out.println(plate + " → " + 
                (isValidLicensePlate(plate) ? "Valid" : "Invalid"));
        }
    }
}
