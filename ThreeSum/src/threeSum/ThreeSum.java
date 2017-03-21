package threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// LeetCode #15

// Determine if there exists three elements in a given array 
// that sum to the given target number. 
// Return all the triple of values that sums to target.

// Assumption:
// 1. The given array is not null and has length of at least 3
// 2. No duplicate triples should be returned, order of the values in the tuple does not matter

// Triple for loops O(n^3).
// for + TwoSum, sort doesn't increase Big-O: 
// 		O(n^2) time, O(n) space with hash table
//		O(n^2) time, O(1) space with two pointers

public class ThreeSum {

	// O(n^2) time, O(1) space
	public List<List<Integer>> allTriples(int[] array, int target) {
		Arrays.sort(array);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 0; i < array.length - 2; i++) {
			// need to guarantee no duplicate is in result
			if (i > 0 && array[i] == array[i - 1]) {
				continue;
			}
			twoSum(array, target - array[i], i, i + 1, array.length - 1, result);
		}
		return result;
	}

	public void twoSum(int[] array, int target, int cur, int left, int right, List<List<Integer>> result) {
		while (left < right) {
			if (array[left] + array[right] == target) {
				result.add(Arrays.asList(array[cur], array[left++], array[right--]));
				// need to guarantee no duplicate is in result
				while (left < right && array[left] == array[left - 1]) {
					left++;
				}
				while (left < right && array[right] == array[right + 1]) {
					right--;
				}
			} else if (array[left] + array[right] < target) {
				left++;
			} else {
				right--;
			}
		}
	}

	// Time complexity is O(n^2).
	// Space complexity is O(1).
}
