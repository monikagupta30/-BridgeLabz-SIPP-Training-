import java.util.Scanner;

class SubstringOccurrences {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the main string: ");
        String mainString = scanner.nextLine();

        System.out.print("Enter the substring to search for: ");
        String subString = scanner.nextLine();

        int count = countOccurrences(mainString, subString);

        System.out.println("The substring occurs " + count + " times.");
    }

    public static int countOccurrences(String main, String sub) {
        int count = 0;
        int index = 0;

        while ((index = main.indexOf(sub, index)) != -1) {
            count++;
            index = index + sub.length(); 
        }

        return count;
    }
}
