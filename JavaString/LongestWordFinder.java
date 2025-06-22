import java.util.Scanner;

class LongestWordFinder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        String longestWord = findLongestWord(sentence);

        System.out.println("The longest word is: " + longestWord);
    }

    public static String findLongestWord(String sentence) {
        String[] words = sentence.split("\\s+"); 
        String longest = "";

        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }
}
