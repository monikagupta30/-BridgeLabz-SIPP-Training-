import java.util.LinkedList;
import java.util.ListIterator;

public class NthFromEnd {
    public static String findNthFromEnd(LinkedList<String> list, int n) {
        // Create two iterators
        ListIterator<String> fast = list.listIterator();
        ListIterator<String> slow = list.listIterator();

        // Move 'fast' pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (!fast.hasNext()) return null; // n is greater than the size
            fast.next();
        }

        // Move both pointers until 'fast' reaches the end
        while (fast.hasNext()) {
            fast.next();
            slow.next();
        }

        return slow.next(); // 'slow' now points to the Nth element from end
    }

    public static void main(String[] args) {
        LinkedList<String> input = new LinkedList<>();
        input.add("A");
        input.add("B");
        input.add("C");
        input.add("D");
        input.add("E");

        int N = 2;
        String result = findNthFromEnd(input, N);
        System.out.println("Nth element from end: " + result);  // Output: D
    }
}
