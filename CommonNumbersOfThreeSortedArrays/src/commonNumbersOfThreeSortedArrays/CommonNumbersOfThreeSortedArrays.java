package commonNumbersOfThreeSortedArrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Find all common elements in 3 sorted arrays.

public class CommonNumbersOfThreeSortedArrays {

	// Solution 1
	public List<Integer> common(int[] a, int[] b, int[] c) {
		List<Integer> result = new ArrayList<>();
		Map<Integer, Integer> map1 = new HashMap<>();
		Map<Integer, Integer> map2 = new HashMap<>();
		for (Integer i : a) {
			Integer count = map1.get(i);
			count = count == null ? 1 : count + 1;
			map1.put(i, count);
		}
		for (Integer i : b) {
			Integer count = map2.get(i);
			count = count == null ? 1 : count + 1;
			map2.put(i, count);
		}
		for (Integer i : c) {
			Integer count1 = map1.get(i);
			Integer count2 = map2.get(i);
			if (count1 != null && count1 > 0 && count2 != null && count2 > 0) {
				result.add(i);
				map1.put(i, count1 - 1);
				map2.put(i, count2 - 1);
			}
		}
		return result;
	}

	// Time complexity is O(l+m+n).
	// Space complexity is O(l+m), could be O(min(l+m, m+n, l+n)).

	// Solution 2
	public List<Integer> common2(int[] a, int[] b, int[] c) {
		List<Integer> list = new ArrayList<>();
		int i = 0, j = 0, k = 0;
		while (i < a.length && j < b.length && k < c.length) {
			if (a[i] == b[j] && b[j] == c[k]) {
				list.add(a[i]);
				i++;
				j++;
				k++;
			} else {
				if (a[i] <= b[j] && a[i] <= c[k]) {
					i++;
				} else if (b[j] <= c[k]) {
					j++;
				} else {
					k++;
				}
			}
		}
		return list;
	}

	// Time complexity is O(l+m+n).
	// Space complexity is O(1).

	// If, for example, l << m, and l << n, another solution could be: for each
	// element in A, run Binary Search in B, run Binary Search in C.
	// Time complexity is O(l * (log(m) + log(n))).
	// But how to handle duplicate elements? For example,
	// A = [5000, 5000, 5000], B = C = [1, 2, 3 , ..., 9999], need to keep two
	// sets of indices, one for B, the other for C, so Space Complexity is O(l).

	// Generalize to common numbers of k sorted arrays?
	// Solution 1: Binary Reduction, let n be length of array, Time Complexity
	// is O(n*k*log(k)), Space Complexity is O(n*k).
	// Solution 2: Use Hash Map.
	// Solution 3: Use Binary Search.
}
