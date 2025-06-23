import java.util.Scanner;

class PalindromeChecker {
    // Attribute
    String text;

    // Constructor
    PalindromeChecker(String text) {
        this.text = text;
    }

    // Method to check if the text is a palindrome
    boolean isPalindrome() {
        String cleanText = text.replaceAll("\\s+", "").toLowerCase();
        int left = 0;
        int right = cleanText.length() - 1;

        while (left < right) {
            if (cleanText.charAt(left) != cleanText.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Method to display result
    void displayResult() {
        System.out.println("\nInput Text: " + text);
        if (isPalindrome()) {
            System.out.println("Result: It is a Palindrome.");
        } else {
            System.out.println("Result: It is NOT a Palindrome.");
        }
    }
}

class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input from user
        System.out.print("Enter text to check for palindrome: ");
        String inputText = scanner.nextLine();

        // Create PalindromeChecker object
        PalindromeChecker checker = new PalindromeChecker(inputText);

        // Display result
        checker.displayResult();
    }
}
