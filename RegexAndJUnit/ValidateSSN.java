import java.util.regex.*;

public class ValidateSSN {
    public static void main(String[] args) {
        String[] testSSNs = {
            "My SSN is 123-45-6789.",
            "Invalid SSN 123456789"
        };

        // Regex for SSN format: 3 digits - 2 digits - 4 digits
        String regex = "\\b\\d{3}-\\d{2}-\\d{4}\\b";

        Pattern pattern = Pattern.compile(regex);

        for (String text : testSSNs) {
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                System.out.println(" \"" + matcher.group() + "\" is valid");
            } else {
                System.out.println(" \"" + text + "\" is invalid");
            }
        }
    }
}
