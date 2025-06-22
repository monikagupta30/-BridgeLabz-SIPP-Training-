import java.util.Scanner;

class PalindromeCheck {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String cleanInput = input.toLowerCase().replaceAll("\\s+", "");

        String reversed = "";
        for (int i = cleanInput.length() - 1; i >= 0; i--) {
            reversed += cleanInput.charAt(i);
        }

        if (cleanInput.equals(reversed)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is NOT a palindrome.");
        }
    }
}
