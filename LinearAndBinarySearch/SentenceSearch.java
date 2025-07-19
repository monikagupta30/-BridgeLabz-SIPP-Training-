public class SentenceSearch {
	 
	//Method to serach for the word in sentences
	public static String findSentenceWithWord(String[] sentences, String word) {
		for(String sentence : sentences) {
			if(sentence.toLowerCase().contains(word.toLowerCase())) {
				return sentence; //Return the first matching sentence
			}
		}
		return "Not Found"; //No match found
	}
	
	public static void main(String[] args) {
		
		//Array of sentences
		String[] sentences = { "The sky is blue.",
	            "Java is a popular programming language.",
	            "Practice makes perfect.",
	            "Linear search is simple but inefficient."
		};
		
		//Word to search for
		String targetWord = "java";
		
		//Search and print result
		String result = findSentenceWithWord(sentences, targetWord);
		System.out.println("Result: " + result);
	}
}