package twoSumAllPairs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

// Find all pairs of elements in a given array that sum to the given target number. 
// Return all the pairs of indices.

public class TwoSumAllPairs {

	public List<List<Integer>> allPairs(int[] array, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < array.length; i++) {
			if (map.containsKey(target - array[i])) {
				for (int j : map.get(target - array[i])) {
					result.add(Arrays.asList(i, j));
				}
			}
			if (!map.containsKey(array[i])) {
				map.put(array[i], new ArrayList<Integer>());
			}
			map.get(array[i]).add(i);
		}
		return result;
	}

	// Time complexity is O(n^2).
	// Space complexity is O(n).
}
