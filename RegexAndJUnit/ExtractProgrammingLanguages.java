import java.util.regex.*;
import java.util.*;

public class ExtractProgrammingLanguages {
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        // List of programming languages to match
        String[] languages = {"Java", "Python", "JavaScript", "C", "C\\+\\+", "C#", "Go", "Ruby", "PHP", "Swift", "Kotlin"};
        
        // Create regex pattern from list (case-sensitive here)
        String regex = "\\b(" + String.join("|", languages) + ")\\b";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        List<String> foundLanguages = new ArrayList<>();
        while (matcher.find()) {
            foundLanguages.add(matcher.group());
        }

        System.out.println(String.join(", ", foundLanguages));
    }
}
