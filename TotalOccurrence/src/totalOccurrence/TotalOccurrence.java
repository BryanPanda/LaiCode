package totalOccurrence;

// Given a target integer T and an integer array A sorted in ascending order.
// Find the total number of occurrences of T in A.

public class TotalOccurrence {

	public int totalOccur(int[] array, int target) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int first = firstOccur(array, target);
		int last = lastOccur(array, target);
		return (first == -1 || last == -1) ? 0 : (last - first + 1);
	}

	private int firstOccur(int[] array, int target) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int left = 0, right = array.length - 1;
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			// Note: when array[mid] == target, move left or right?
			if (array[mid] >= target) {
				right = mid;
			} else {
				left = mid;
			}
			// Note: in binary search, we have mid +/- 1, so left and right are
			// approaching in each of the iterations; but here, left and right
			// might not be, thus the change in while condition and
			// post-processing below.
		}
		// up to this point, left == right - 1
		if (array[left] == target) {
			return left;
		} else if (array[right] == target) {
			return right;
		}
		return -1;
	}

	private int lastOccur(int[] array, int target) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int left = 0, right = array.length - 1;
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (array[mid] <= target) {
				left = mid;
			} else {
				right = mid;
			}
		}
		if (array[right] == target) {
			return right;
		} else if (array[left] == target) {
			return left;
		}
		return -1;
	}

	// Time complexity is O(log(n)).
	// Space complexity is O(1).
}
