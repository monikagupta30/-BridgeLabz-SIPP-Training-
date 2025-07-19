import java.util.Scanner;
import java.util.HashSet;

class RemoveDuplicates {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//Input
		System.out.println("Enter a string: ");
		String input = scanner.nextLine();
		
		//Remove duplicates
		String result = removeDuplicates(input);
		
		//Output
		System.out.println("String withour duplicates: " + result);
		
		scanner.close();
	}
	public static String removeDuplicates(String input) {
		HashSet<Character> seen = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		
		for (char ch : input.toCharArray()) {
			if (!seen.contains(ch)) {
				seen.add(ch);
				sb.append(ch);
			}
		}
		
		return sb.toString();
	}
}