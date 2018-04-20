package searchInShiftedSortedArray;

// LeetCode #33 (Search in Rotated Sorted Array).

// Given a target integer T and an integer array A, A is sorted in ascending order first, 
// then shifted by an arbitrary number of positions.

// For Example, A = {3, 4, 5, 1, 2} (shifted left by 2 positions). 
// Find the index i such that A[i] == T or return -1 if there is no such index.

// There is no duplicate number.

public class SearchInShiftedSortedArray {

	public int search(int[] array, int target) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int pos = getIndexOfMaxNumber(array);
		int result = binarySearch(array, 0, pos, target);
		if (result == -1) {
			result = binarySearch(array, pos + 1, array.length - 1, target);
		}
		return result;
	}

	public int getIndexOfMaxNumber(int[] array) {
		// guaranteed that array != null && array.length > 0
		int left = 0, right = array.length - 1;
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (mid < right && array[mid] > array[mid + 1]) {
				return mid;
			}
			if (mid > left && array[mid - 1] > array[mid]) {
				return mid - 1;
			}
			// up to this point,
			// mid == right || array[mid] < array[mid + 1] ||
			// mid == left || array[mid - 1] < array[mid]
			if (array[left] >= array[mid]) {
				right = mid;
			} else {
				left = mid;
			}
		}
		// up to this point, left == right - 1;
		return array[left] >= array[right] ? left : right;
	}

	private int binarySearch(int[] array, int left, int right, int target) {
		// guaranteed array != null && array.length > 0
		if (left > right) {
			return -1;
		}
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (array[mid] == target) {
				return mid;
			} else if (array[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}

	// Time complexity is O(log(n)).
	// Space complexity is O(1).
}
