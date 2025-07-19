import java.util.Arrays;

public class SearchChallenge {

    // Part 1: Linear Search for First Missing Positive Integer
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Put each number in its correct position (index = num - 1)
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] with nums[nums[i] - 1]
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        // Step 2: Find the first index where nums[i] != i + 1
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    // Part 2: Binary Search for target value
    public static int binarySearch(int[] sortedArr, int target) {
        int left = 0;
        int right = sortedArr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (sortedArr[mid] == target) {
                return mid;
            } else if (sortedArr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Not found
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        int target = 4;

        // Copy the array for binary search
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);

        int missing = firstMissingPositive(nums);
        int index = binarySearch(sortedNums, target);

        System.out.println("First Missing Positive Integer: " + missing);
        System.out.println("Index of " + target + " in sorted array: " + index);
    }
}
