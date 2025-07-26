import java.util.HashMap;
import java.util.Map;

public class MergeMaps {
    public static void main(String[] args) {
        // Example Maps
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        // Merged Map
        Map<String, Integer> mergedMap = new HashMap<>(map1);

        // Merge map2 into mergedMap
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            mergedMap.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }

        // Output: {A=1, B=5, C=4}
        System.out.println("Merged Map: " + mergedMap);
    }
}
