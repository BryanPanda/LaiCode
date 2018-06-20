package commonElementsInThreeSortedArrays;

import java.util.ArrayList;
import java.util.List;

// Find all common elements in 3 sorted arrays.

public class CommonElementsInThreeSortedArrays {

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

	// Time complexity is O(l + m + n).
	// Space complexity is O(1).

	// If, for example, l << m, and l << n, another solution could be: for each
	// element in A, run Binary Search in B, run Binary Search in C.
	// Time complexity is O(l * (log(m) + log(n))).

	// But how to handle duplicate elements? For example,
	// A = [5000, 5000, 5000], B = C = [1, 2, 3 , ..., 9999], need to keep a count
	// of each duplicate element, and once found in B or C, look for the duplicate
	// element in both directions.

	// Generalize to common numbers of k sorted arrays?

	// Solution 1: Binary reduction: let n be length of array, time complexity
	// is O(n*k*log(k)), space complexity is O(n*k).
	// Solution 2: Hash map.
	// Solution 3: Binary search.
}
