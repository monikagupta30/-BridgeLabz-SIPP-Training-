import java.util.regex.*;
import java.util.*;

public class EmailExtractor {
    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org";

        // Regex for matching email addresses
        String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.println("Extracted Email Addresses:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
