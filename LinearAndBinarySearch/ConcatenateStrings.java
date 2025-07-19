public class ConcatenateStrings {
	public static void main(String[] args) {
		
		//Sample array of strings
		String[] words = {"Java"," ","is"," ","fun","!"};
		
		//Concatenate using stringBuffer
		String result = concatenateStrings(words);
		
		//Output
		System.out.println("Concatenate strings: " + result);
	}
	
	public static String concatenateStrings(String[] strings) {
		StringBuffer sb = new StringBuffer();
		
		for(String word : strings) {
			sb.append(word);
		}
		return sb.toString();
	}
}