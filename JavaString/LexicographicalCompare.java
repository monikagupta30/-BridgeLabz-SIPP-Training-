import java.util.Scanner;

class LexicographicalCompare {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter String 1: ");
        String str1 = scanner.nextLine();

        System.out.print("Enter String 2: ");
        String str2 = scanner.nextLine();

        int result = compareStrings(str1, str2);

        if (result < 0) {
            System.out.println("\"" + str1 + "\" comes before \"" + str2 + "\" in lexicographical order");
        } else if (result > 0) {
            System.out.println("\"" + str1 + "\" comes after \"" + str2 + "\" in lexicographical order");
        } else {
            System.out.println("Both strings are equal");
        }
    }

    public static int compareStrings(String s1, String s2) {
        int len = Math.min(s1.length(), s2.length());

        for (int i = 0; i < len; i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);

            if (ch1 != ch2) {
                return ch1 - ch2;  
            }
        }

        return s1.length() - s2.length();
    }
}
