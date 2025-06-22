import java.util.Scanner;

class ToggleCase {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String toggled = toggleCase(input);

        System.out.println("Toggled string: " + toggled);
    }

    public static String toggleCase(String str) {
        StringBuilder result = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                result.append(Character.toLowerCase(ch));
            } else if (Character.isLowerCase(ch)) {
                result.append(Character.toUpperCase(ch));
            } else {
                result.append(ch); 
            }
        }

        return result.toString();
    }
}
