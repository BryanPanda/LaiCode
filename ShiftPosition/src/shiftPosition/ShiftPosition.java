package shiftPosition;

// LeetCode #153 (Find Minimum in Rotated Sorted Array).

// Given an integer array A, A is sorted in ascending order first then shifted by 
// an arbitrary number of positions. For Example, A = {3, 4, 5, 1, 2} (shifted left by 2 positions).
// Find the index of the smallest number.

// Assumption: there are no duplicate elements in the array

public class ShiftPosition {

	public int getIndexOfMinNumber(int[] array) {
		if (array == null || array.length == 0) {
			return -1;
		}
		// guaranteed that array != null && array.length > 0
		int left = 0, right = array.length - 1;
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (array[left] > array[mid]) {
				right = mid;
			} else if (array[mid] > array[right]) {
				left = mid;
			} else {
				return left;
			}
		}
		// up to this point, left == right - 1;
		return array[left] <= array[right] ? left : right;
	}

	// Time complexity is O(log(n)).
	// Space complexity is O(1).
}
