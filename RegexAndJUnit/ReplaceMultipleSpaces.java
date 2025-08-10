public class ReplaceMultipleSpaces {
    public static void main(String[] args) {
        String text = "This   is   an   example     with   multiple   spaces.";

        // Replace multiple spaces with a single space
        String result = text.replaceAll("\\s+", " ");

        System.out.println("Original: " + text);
        System.out.println("Modified: " + result);
    }
}
