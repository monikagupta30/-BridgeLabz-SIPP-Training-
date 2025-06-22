import java.util.Scanner;

class WordReplacer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        System.out.print("Enter the word to replace: ");
        String oldWord = scanner.nextLine();

        System.out.print("Enter the new word: ");
        String newWord = scanner.nextLine();

        String result = replaceWord(sentence, oldWord, newWord);

        System.out.println("Modified sentence: " + result);
    }

    public static String replaceWord(String sentence, String oldWord, String newWord) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (word.equals(oldWord)) {
                result.append(newWord);
            } else {
                result.append(word);
            }
            result.append(" ");  
        }

        return result.toString().trim();
    }
}
