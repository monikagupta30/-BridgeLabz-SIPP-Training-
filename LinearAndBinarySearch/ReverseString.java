import java.util.Scanner;

class ReverseString {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//Input
		System.out.println("Enter a string: ");
		String input = scanner.nextLine();
		
		//Reverse using stringbuilder
		StringBuilder sb = new StringBuilder();
		sb.append(input);
		sb.reverse();
		
		//Output
		String reversed = sb.toString();
		System.out.println("Reversed String: " + reversed);
		
		scanner.close();
	}
}
