import java.util.*;

public class SymmetricDifference {
    public static Set<Integer> symmetricDifference(Set<Integer> set1, Set<Integer> set2) {
        // Step 1: Union
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);

        // Step 2: Intersection
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        // Step 3: Symmetric Difference = Union - Intersection
        union.removeAll(intersection);

        return union;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        Set<Integer> result = symmetricDifference(set1, set2);
        System.out.println("Symmetric Difference: " + result);  // Output: [1, 2, 4, 5]
    }
}
