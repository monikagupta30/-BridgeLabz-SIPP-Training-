public class RotationPointFinder {
	 //Method to find the index of the smallest element
	public static int findRotationPoint(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		
		while (left < right) {
			int mid = left + (right - left) / 2;
			
			//If mid element is greater than right, th smallest is in th right half
			if(arr[mid] > arr[right]) {
				left = mid + 1;
			}
			//Else, its in the left half including mid
			else {
				right = mid;
			}
		}
		
		//At this point, left == right and points to the smallest element
		return left;
	}
		public static void main(String[] args) {
			int[] rotatedArray = {15,4,7,18,9,13,2};
			int rotationIndex = findRotationPoint(rotatedArray);
			
			System.out.println("Rotation point index: " + rotationIndex);
			System.out.println("smallest element: " + rotatedArray[rotationIndex]);
		}
}