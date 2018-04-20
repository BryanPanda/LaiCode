package searchInShiftedSortedArray2;

// LeetCode #81 (Search in Rotated Sorted Array 2).

// Given a target integer T and an integer array A, A is sorted in ascending order first, 
// then shifted by an arbitrary number of positions.

// For Example, A = {3, 4, 5, 1, 2} (shifted left by 2 positions). 
// Find the index i such that A[i] == T or return -1 if there is no such index.

// Assumption: there could be duplicate numbers.

public class SearchInShiftedSortedArray2 {

	public int search(int[] array, int target) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int left = 0, right = array.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (array[mid] == target) {
				return mid;
			}
			// up to this point, array[mid] != target
			// check which half of the array is monotonic
			if (array[left] < array[mid]) {
				// array drops on the right half, left half is monotonic
				// draw the picture and you will see
				if (array[left] <= target && target < array[mid]) {
					// target is in the left half
					right = mid - 1;
				} else {
					// array[left] > target || array[mid] <= target
					// target is in the right half
					left = mid + 1;
				}
			} else if (array[left] > array[mid]) {
				// array drops on the left half, right half is monotonic
				if (array[mid] < target && target <= array[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			} else {
				// array[left] = array[mid]
				// no way to tell which half is monotonic
				left += 1;
			}
		}
		return -1;
	}

	// Time complexity is O(n) in the worst case, but O(log(n)) in average case
	// Space complexity is O(1).
}
