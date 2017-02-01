package searchInBitonicArray;

// Search for a target number in a bitonic array, return the index of the target number if found in the array,
// otherwise return -1.
// A bitonic array is a combination of two sequence: the first sequence is a monotonically increasing one and the second sequence is a monotonically decreasing one.

// Assumptions: The array is not null.

public class SearchInBitonicArray {

	public int search(int[] array, int target) {
		if (array == null || array.length == 0) {
			return -1;
		}
		if (array.length == 1) {
			return array[0] == target ? 0 : -1;
		}
		return search(array, target, 0, array.length - 1);
	}

	private int search(int[] array, int target, int left, int right) {
		// base case
		if (left == right - 1) {
			if (array[left] == target) {
				return left;
			} else if (array[right] == target) {
				return right;
			} else {
				return -1;
			}
		}
		// recursive rule
		int mid = left + (right - left) / 2;
		boolean midIsSmallerThanTarget = array[mid] < target;
		boolean maxIsOnTheLeft = mid > 0 && array[mid] < array[mid - 1];
		if (midIsSmallerThanTarget && maxIsOnTheLeft) {
			return search(array, target, left, mid);
		} else if (midIsSmallerThanTarget && !maxIsOnTheLeft) {
			return search(array, target, mid, right);
		} else {
			int index = binarySearchAscending(array, target, left, mid);
			return index == -1 ? binarySearchDescending(array, target, mid, right) : index;
		}
	}

	private int binarySearchAscending(int[] array, int target, int left, int right) {
		// array != null && array.length > 1
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

	private int binarySearchDescending(int[] array, int target, int left, int right) {
		// array != null && array.length > 1
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (array[mid] == target) {
				return mid;
			} else if (array[mid] > target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}

	// Time complexity is O(log(n)).
	// Space complexity is O(log(n)).
}
