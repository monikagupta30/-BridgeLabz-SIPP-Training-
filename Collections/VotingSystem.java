import java.util.*;

public class VotingSystem {
    public static void main(String[] args) {
        // Votes cast in order (Candidate name in order of arrival)
        List<String> voteOrder = Arrays.asList("Alice", "Bob", "Alice", "Carol", "Bob", "Alice");

        // Store total votes using HashMap
        Map<String, Integer> voteCount = new HashMap<>();

        // Maintain order of vote casting using LinkedHashMap (Candidate -> Votes received at that point)
        Map<String, Integer> voteTimeline = new LinkedHashMap<>();

        for (String candidate : voteOrder) {
            // Count votes
            voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);
            // Record vote cast order
            voteTimeline.put(candidate, voteCount.get(candidate));
        }

        // Display vote timeline (order in which candidates received their votes)
        System.out.println("Vote Timeline (LinkedHashMap):");
        for (Map.Entry<String, Integer> entry : voteTimeline.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " vote(s) so far");
        }

        // Sort results by candidate name using TreeMap
        Map<String, Integer> sortedResults = new TreeMap<>(voteCount);

        // Display sorted results
        System.out.println("\nFinal Results (Sorted by Candidate Name - TreeMap):");
        for (Map.Entry<String, Integer> entry : sortedResults.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " vote(s)");
        }
    }
}
