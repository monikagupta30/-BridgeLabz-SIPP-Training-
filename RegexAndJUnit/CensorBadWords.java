public class CensorBadWords {
    public static void main(String[] args) {
        String text = "This is a damn bad example with some stupid words.";

        // List of bad words (can be expanded)
        String[] badWords = { "damn", "stupid" };

        for (String badWord : badWords) {
            // Use regex with word boundaries to replace only whole words (case-insensitive)
            text = text.replaceAll("(?i)\\b" + badWord + "\\b", "****");
        }

        System.out.println(text);
    }
}
