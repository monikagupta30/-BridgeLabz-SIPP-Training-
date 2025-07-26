import java.util.*;

public class SetToSortedList {
    public static List<Integer> convertAndSort(Set<Integer> set) {
        List<Integer> sortedList = new ArrayList<>(set);  // Convert set to list
        Collections.sort(sortedList);                     // Sort the list in ascending order
        return sortedList;
    }

    public static void main(String[] args) {
        Set<Integer> inputSet = new HashSet<>(Arrays.asList(5, 3, 9, 1));
        List<Integer> sortedList = convertAndSort(inputSet);
        System.out.println("Sorted List: " + sortedList);  // Output: [1, 3, 5, 9]
    }
}
