import java.util.Scanner;

class NumberGuessingGame {

    public static void main(String[] args) {
        System.out.println("Think of a number between 1 and 100, and I will try to guess it!");

        Scanner scanner = new Scanner(System.in);
        int low = 1;
        int high = 100;
        boolean correct = false;

        while (!correct && low <= high) {
            int guess = generateGuess(low, high);
            System.out.println("Is your number " + guess + "?");
            String feedback = getUserFeedback(scanner);

            switch (feedback.toLowerCase()) {
                case "low":
                    low = guess + 1;
                    break;
                case "high":
                    high = guess - 1;
                    break;
                case "correct":
                    System.out.println("Yay! I guessed your number: " + guess);
                    correct = true;
                    break;
                default:
                    System.out.println("Invalid input. Please type 'low', 'high', or 'correct'.");
            }
        }

        if (!correct) {
            System.out.println("Hmm, something went wrong. Maybe the feedback wasn't consistent.");
        }

        scanner.close();
    }

    public static int generateGuess(int low, int high) {
        return (low + high) / 2;
    }

    public static String getUserFeedback(Scanner scanner) {
        System.out.print("Enter feedback (low / high / correct): ");
        return scanner.nextLine();
    }
}
