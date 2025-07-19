import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountWordInFile {
    public static void main(String[] args) {
        String filePath = "example.txt";     // Path to your file
        String targetWord = "java";          // Word to search (case-sensitive)
        int count = 0;

        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");  // Split line into words using whitespace
                for (String word : words) {
                    if (word.equals(targetWord)) {
                        count++;
                    }
                }
            }

            br.close();
            System.out.println("The word \"" + targetWord + "\" appears " + count + " times in the file.");
        } catch (IOException e) {
            System.out.println("Error reading the file:");
            e.printStackTrace();
        }
    }
}
