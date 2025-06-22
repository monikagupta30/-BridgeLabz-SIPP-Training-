import java.util.Scanner;

class MostFrequentCharacter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        char mostFrequent = findMostFrequentCharacter(input);

        System.out.println("Most Frequent Character: '" + mostFrequent + "'");
    }

    public static char findMostFrequentCharacter(String str) {
        int[] freq = new int[256];

        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }

        int max = 0;
        char result = ' ';

        for (int i = 0; i < str.length(); i++) {
            if (freq[str.charAt(i)] > max) {
                max = freq[str.charAt(i)];
                result = str.charAt(i);
            }
        }

        return result;
    }
}
