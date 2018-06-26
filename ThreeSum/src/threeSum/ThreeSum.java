package threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// LeetCode #15 (3 Sum).

// Determine if there exists three elements in a given array that sum to the given target number. 
// Return all the triple of values that sums to target.

// Assumption:
// 1. The given array is not null and has length of at least 3.
// 2. No duplicate triples should be returned, order of the values in the tuple does not matter.

// Solutions:
// 1. Triple for loops: Time complexity is O(n^3), space complexity is O(1).
// 2. For loop + Two Sum (with hash map): Time complexity is O(n^2), space complexity is O(n).
// 3. For loop + Two Sum (sort + two pointers): Time complexity is O(n^2), space complexity is O(log(n)), 
//    because of quick sort (for primitive types).

public class ThreeSum {

	public List<List<Integer>> allTriples(int[] array, int target) {
		Arrays.sort(array);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 0; i < array.length - 2; i++) {
			if (i > 0 && array[i] == array[i - 1]) {
				continue;
			}
			twoSum(array, target - array[i], i, i + 1, array.length - 1, result);
		}
		return result;
	}

	public void twoSum(int[] array, int target, int cur, int left, int right, List<List<Integer>> result) {
		while (left < right) {
			// avoid duplicate triplet
			if (array[left] + array[right] == target && (left - 1 == cur || array[left] != array[left - 1])) {
				result.add(Arrays.asList(array[cur], array[left++], array[right--]));
			} else if (array[left] + array[right] <= target) {
				left++;
			} else {
				right--;
			}
		}
	}

	// Time complexity is O(n^2).
	// Space complexity is O(log(n)), because of quick sort (for primitive types).
}
