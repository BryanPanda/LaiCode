package commonNumbersOfTwoSortedArrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Find all numbers that appear in both of two sorted arrays (the two arrays are all sorted in ascending order).

// Assumption:
// 1. In each of the two sorted arrays, there could be duplicate numbers.
// 2. Both two arrays are not null.

public class CommonNumbersOfTwoSortedArrays {

	public List<Integer> common(List<Integer> A, List<Integer> B) {
		List<Integer> result = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (Integer i : A) {
			Integer count = map.get(i);
			count = count == null ? 1 : count + 1;
			map.put(i, count);
		}
		for (Integer i : B) {
			Integer count = map.get(i);
			if (count != null && count > 0) {
				result.add(i);
				map.put(i, count - 1);
			}
		}
		return result;
	}

	// Time complexity is O(m + n).
	// Space complexity is O(max(m, n)).

	public List<Integer> common2(List<Integer> A, List<Integer> B) {
		List<Integer> result = new ArrayList<>();
		int i = 0, j = 0;
		while (i < A.size() && j < B.size()) {
			if (A.get(i) == B.get(j)) {
				result.add(A.get(i));
				i++;
				j++;
			} else if (A.get(i) < B.get(j)) {
				i++;
			} else {
				j++;
			}
		}
		return result;
	}

	// Time complexity is O(m + n).
	// Space complexity is O(1).

	// If m << n, another solution could be: for each element in A, run binary search in B.
	// Time complexity is O(m * log(n)).
	// But how to handle duplicate elements? For example, A = [5000, 5000, 5000], B = [1, 2, 3, ..., 9999].
	// Need to keep a set of indices, so space complexity is O(m).
}

