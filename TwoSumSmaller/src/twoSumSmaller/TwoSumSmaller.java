package twoSumSmaller;

import java.util.Arrays;

// Determine the number of pairs of elements in a given array that sum to a value 
// smaller than the given target number.

public class TwoSumSmaller {

	public int smallerPairs(int[] array, int target) {
		Arrays.sort(array);
		int result = 0, left = 0, right = array.length - 1;
		while (right > 0 && array[0] + array[right] >= target) {
			right--;
		}
		while (left < right) {
			if (array[left] + array[right] < target) {
				result += right - left;
				left++;
			} else {
				right--;
			}
		}
		return result;
	}

	// Time complexity is O(n * log(n)) because of quick sort (for primitive types).
	// Space complexity is O(log(n)).
}
