import java.util.regex.*;

public class HexColorValidator {
    public static boolean isValidHexColor(String color) {
        // Regex: starts with # and followed by exactly 6 hex digits (case-insensitive)
        String regex = "^#[A-Fa-f0-9]{6}$";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(color);
        
        return matcher.matches();
    }

    public static void main(String[] args) {
        // Test cases
        String[] colors = {
            "#FFA500",   
            "#ff4500",   
            "#123",      
            "FFA500",    
            "#12FG34"    
        };
        
        for (String color : colors) {
            System.out.println(color + " → " + 
                (isValidHexColor(color) ? "Valid" : "Invalid"));
        }
    }
}
