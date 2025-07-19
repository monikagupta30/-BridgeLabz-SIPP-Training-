public class PeakElementFinder {
	public static int findPeak(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		
		while (left <= right) {
			int mid = left + (right - left) / 2;
			
			//Handle edge elements separately
			boolean leftOK = (mid == 0) || (arr[mid] > arr[mid - 1]);
			boolean rightOK = (mid == arr.length - 1) || (arr[mid] > arr[mid + 1]);
			
			if(leftOK && rightOK) {
				return arr[mid]; //peak found
			} else if (mid > 0 && arr[mid] < arr[mid - 1]) {
				right = mid - 1; // move to left half
			} else {
				left = mid + 1; // move to right half
			}
		}
		return -1; //no peak found(should not happen)
	}
	
	public static void main(String[] args) {
		int[] arr = {1,4,15,8,0,3,2};
		int peak = findPeak(arr);
		System.out.println("Peak Element: " + peak);
	}
}