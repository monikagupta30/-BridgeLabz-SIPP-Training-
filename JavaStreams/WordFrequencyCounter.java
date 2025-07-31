import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class WordFrequencyCounter {

    public static void main(String[] args) {
        String filePath = "sample.txt";  // Replace with your file path
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Read and count words
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                // Remove punctuation, convert to lowercase
                line = line.replaceAll("[^a-zA-Z ]", "").toLowerCase();

                // Split into words
                String[] words = line.split("\\s+");

                // Count word frequency
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        // Sort entries by value (frequency) in descending order
        List<Entry<String, Integer>> sortedEntries = new ArrayList<>(wordCountMap.entrySet());
        sortedEntries.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        // Display top 5 words
        System.out.println("Top 5 most frequent words:");
        for (int i = 0; i < Math.min(5, sortedEntries.size()); i++) {
            Entry<String, Integer> entry = sortedEntries.get(i);
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
