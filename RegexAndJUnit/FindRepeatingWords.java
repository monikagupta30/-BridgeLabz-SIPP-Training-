import java.util.regex.*;
import java.util.*;

public class FindRepeatingWords {
    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";

        // Regex to match consecutive repeating words (case-insensitive)
        String regex = "\\b(\\w+)\\b\\s+\\1\\b";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        Set<String> repeatingWords = new LinkedHashSet<>();
        while (matcher.find()) {
            repeatingWords.add(matcher.group(1));
        }

        System.out.println(String.join(", ", repeatingWords));
    }
}
