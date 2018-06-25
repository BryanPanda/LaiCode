package twoSumClosest;

import java.util.Arrays;
import java.util.List;

// Find the pair of elements in a given array that sum to a value that is closest 
// to the given target number.

// Return the values of the two numbers.

public class TwoSumClosest {

	public List<Integer> closest(int[] array, int target) {
		int min = Integer.MAX_VALUE, one = 0, two = 0;
		Arrays.sort(array);
		int left = 0, right = array.length - 1;
		while (left < right) {
			if (Math.abs(array[left] + array[right] - target) < min) {
				min = Math.abs(array[left] + array[right] - target);
				one = array[left];
				two = array[right];
			}
			if (min == 0) {
				return Arrays.asList(one, two);
			} else if (array[left] + array[right] < target) {
				left++;
			} else {
				right--;
			}
		}
		return Arrays.asList(one, two);
	}

	// Time complexity is O(n * log(n)) because of quick sort (for primitive types).
	// Space complexity is O(log(n)).
}
