import java.util.regex.*;

public class CreditCardValidator {
    public static boolean isValidCreditCard(String cardNumber) {
        // Visa: Starts with 4, length 16 digits
        String visaRegex = "^4\\d{15}$";
        // MasterCard: Starts with 5, length 16 digits
        String masterRegex = "^5\\d{15}$";

        return cardNumber.matches(visaRegex) || cardNumber.matches(masterRegex);
    }

    public static void main(String[] args) {
        String[] testCards = {
            "4123456789012345", //  Visa
            "5123456789012345", //  MasterCard
            "412345678901234",  //  Invalid (15 digits)
            "6123456789012345", //  Invalid (starts with 6)
            "51234567890123456" //  Invalid (17 digits)
        };

        for (String card : testCards) {
            System.out.println(card + " → " + (isValidCreditCard(card) ? "Valid" : "Invalid"));
        }
    }
}
