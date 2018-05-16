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
			}
		}
		Collections.sort(result);
		return result;
	}
	
	// Time complexity is O(m + n).
	// Space complexity is O(max(m, n)).
}
