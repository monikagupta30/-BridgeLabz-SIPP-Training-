import java.util.*;

public class ListRotator {
    public static List<Integer> rotateList(List<Integer> list, int positions) {
        int size = list.size();
        // Normalize the positions (handle positions > size or negative values)
        positions = positions % size;

        // Create a new list with rotated elements
        List<Integer> rotated = new ArrayList<>();
        rotated.addAll(list.subList(positions, size));  // Elements from 'positions' to end
        rotated.addAll(list.subList(0, positions));     // Elements from start to 'positions'

        return rotated;
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(10, 20, 30, 40, 50);
        int rotateBy = 2;
        List<Integer> result = rotateList(input, rotateBy);
        System.out.println(result);  // Output: [30, 40, 50, 10, 20]
    }
}
