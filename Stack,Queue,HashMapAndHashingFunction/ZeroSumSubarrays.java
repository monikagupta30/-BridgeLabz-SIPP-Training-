import java.util.*;

public class ZeroSumSubarrays {

    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        Map<Integer, List<Integer>> sumIndicesMap = new HashMap<>();
        List<int[]> result = new ArrayList<>();

        int sum = 0;
        sumIndicesMap.put(0, new ArrayList<>());
        sumIndicesMap.get(0).add(-1);  // To handle subarrays starting at index 0

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sumIndicesMap.containsKey(sum)) {
                for (int startIndex : sumIndicesMap.get(sum)) {
                    result.add(new int[]{startIndex + 1, i});
                }
            }

            sumIndicesMap.putIfAbsent(sum, new ArrayList<>());
            sumIndicesMap.get(sum).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 1, 3, -4, -2, -2};

        List<int[]> subarrays = findZeroSumSubarrays(arr);

        System.out.println("Zero-sum subarrays (startIndex to endIndex):");
        for (int[] pair : subarrays) {
            System.out.println(Arrays.toString(pair));
        }
    }
}
