import java.util.regex.*;

public class UsernameValidator {
    public static boolean isValidUsername(String username) {
        // Regex: start with letter, followed by letters/numbers/underscores, length 5–15
        String regex = "^[A-Za-z][A-Za-z0-9_]{4,14}$";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(username);
        
        return matcher.matches();
    }

    public static void main(String[] args) {
        // Test cases
        String[] usernames = {
            "user_123",   //  Valid
            "123user",    //  Invalid
            "us",         //  Invalid
            "UserName_01",//  Valid
            "user@name"   //  Invalid
        };
        
        for (String username : usernames) {
            System.out.println(username + " → " + 
                (isValidUsername(username) ? "Valid" : "Invalid"));
        }
    }
}
