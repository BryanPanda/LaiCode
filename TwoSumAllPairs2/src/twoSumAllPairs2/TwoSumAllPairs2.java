package twoSumAllPairs2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Find all pairs of elements in a given array that sum to the given target number.

// Return all the distinct pairs of values.

public class TwoSumAllPairs2 {

	public List<List<Integer>> allPairs(int[] array, int target) {
		Arrays.sort(array);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int left = 0, right = array.length - 1;
		while (left < right) {
			if (array[left] + array[right] == target && (left == 0 || array[left] != array[left - 1])) {
				result.add(Arrays.asList(array[left++], array[right--]));
			} else if (array[left] + array[right] <= target) {
				left++;
			} else {
				right--;
			}
		}
		return result;
	}

	// Time complexity is O(n * log(n)) because of quick sort (for primitive types).
	// Space complexity is O(log(n)).

	// Solution 2
	public List<List<Integer>> allPairs2(int[] array, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : array) {
			Integer count = map.get(num);
			if (num * 2 == target && count != null && count == 1) {
				result.add(Arrays.asList(num, num));
			} else if (map.containsKey(target - num) && count == null) {
				result.add(Arrays.asList(num, target - num));
			}
			count = count == null ? 1 : count + 1;
			map.put(num, count);
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
