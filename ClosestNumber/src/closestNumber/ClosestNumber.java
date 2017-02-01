package closestNumber;

// Given a target integer T and an integer array A sorted in ascending order, 
// find the index i in A such that A[i] is closest to T.

// There can be duplicate elements in the array, and we can return any of the 
// indices with same value.

public class ClosestNumber {

	public int closest(int[] array, int target) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int left = 0, right = array.length - 1;
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (array[mid] == target) {
				return mid;
			} else if (array[mid] < target) {
				left = mid;
			} else {
				right = mid;
			}
		}
		// up to this point, left == right - 1
		return Math.abs(array[left] - target) <= Math.abs(array[right] - target) ? left : right;
	}

	// Time complexity is O(log(n)).
	// Space complexity is O(1).
}
