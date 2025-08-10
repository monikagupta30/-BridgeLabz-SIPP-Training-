import java.util.regex.*;
import java.util.*;

public class LinkExtractor {
    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info.";

        // Regex to match http or https URLs
        String regex = "(https?://[\\w.-]+(?:\\.[\\w.-]+)+(?:/[\\w./?%&=-]*)?)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        List<String> links = new ArrayList<>();

        while (matcher.find()) {
            links.add(matcher.group());
        }

        // Print extracted links
        System.out.println("Extracted Links:");
        System.out.println(String.join(", ", links));
    }
}
