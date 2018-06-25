package twoSum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// LeetCode #1 (Two Sum).

// Determine if there exist two elements in a given array, the sum of which
// is the given target number.

public class TwoSum {

	public boolean existSum(int[] array, int target) {
		Arrays.sort(array);
		int left = 0, right = array.length - 1;
		while (left < right) {
			if (array[left] + array[right] == target) {
				return true;
			} else if (array[left] + array[right] < target) {
				left++;
			} else {
				right--;
			}
		}
		return false;
	}

	// Time complexity is O(n * log(n)) because of quick sort (for primitive types).
	// Space complexity is O(log(n)).

	public boolean existSum2(int[] array, int target) {
		Set<Integer> set = new HashSet<>();
		for (int num : array) {
			if (set.contains(target - num)) {
				return true;
			} else {
				set.add(num);
			}
		}
		return false;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).

	// Follow up: return the pair of indices (LeetCode #1)?
}
