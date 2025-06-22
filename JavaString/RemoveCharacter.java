import java.util.Scanner;

class RemoveCharacter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.print("Enter the character to remove: ");
        char toRemove = scanner.next().charAt(0);

        String result = removeCharacter(input, toRemove);

        System.out.println("Modified String: " + result);
    }

    public static String removeCharacter(String str, char ch) {
        StringBuilder result = new StringBuilder();

        for (char current : str.toCharArray()) {
            if (current != ch) {
                result.append(current);
            }
        }

        return result.toString();
    }
}
