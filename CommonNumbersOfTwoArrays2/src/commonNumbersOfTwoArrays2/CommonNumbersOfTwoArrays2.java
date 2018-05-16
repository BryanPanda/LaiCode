package commonNumbersOfTwoArrays2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// LeetCode #350 (Intersection of Two Arrays II).

// Find all numbers that appear in both of two unsorted arrays.

// Assumption: In any of the two arrays, there could be duplicate numbers.

public class CommonNumbersOfTwoArrays2 {

	public List<Integer> common(List<Integer> a, List<Integer> b) {
		List<Integer> result = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (Integer i : a) {
			Integer frequency = map.get(i);
			frequency = frequency == null ? 1 : frequency + 1;
			map.put(i, frequency);
		}
		for (int i : b) {
			Integer frequency = map.get(i);
			if (frequency != null && frequency > 0) {
				result.add(i);
				map.put(i, frequency - 1);
			}
		}
		Collections.sort(result);
		return result;
	}
	
	// Time complexity is O(m + n).
	// Space complexity is O(max(m, n)).
	
	// Follow up: What if neither of the two lists can fit into memory?
	//   a. For each of the two arrays, split it into sub-arrays that can fit into 
	//      memory, sort each sub-array, then merge k sorted arrays.
	//   b. Read a pair of values at a time, one from the first array, the other
	//      from the second array. If equal, add to the result, otherwise, throw the 
	//      smaller value away, and read the next value from the same array.
}
