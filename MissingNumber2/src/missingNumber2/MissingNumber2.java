package missingNumber2;

// Given an integer array of size N - 1 sorted by ascending order, 
// containing all the numbers from 1 to N except one, find the missing number.

// Assumption: The given array is not null, and N >= 1

public class MissingNumber2 {

	// binary search to find the first number whose value and index differ by 2
	public int missing(int[] array) {
		if (array.length == 0) {
			return 1;
		}
		int left = 0, right = array.length - 1;
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (array[mid] - mid == 2) {
				right = mid;
			} else {
				left = mid;
			}
		}
		// post-processing
		if (array[left] - left == 2) {
			return array[left] - 1;
		} else if (array[right] - right == 2) {
			return array[right] - 1;
		} else {
			return array[right] + 1;
		}
	}

	// Time complexity is O(log(n)).
	// Space complexity is O(1).
}

