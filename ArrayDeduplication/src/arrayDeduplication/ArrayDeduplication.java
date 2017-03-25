package arrayDeduplication;

import java.util.Arrays;

// LeetCode #26

// Given a sorted integer array, remove duplicate elements. 
// For each group of elements with the same value keep only one of them. 
// Do this in-place, using the left side of the original array and maintain
// the relative order of the elements of the array.
// Return the array after deduplication.

public class ArrayDeduplication {

	public int[] dedup(int[] array) {
		if (array == null || array.length <= 1) {
			return array;
		}
		int slow = 0; // including slow
		for (int fast = 1; fast < array.length; fast++) {
			if (array[fast] != array[slow]) {
				array[++slow] = array[fast];
			}
		}
		return Arrays.copyOf(array, slow + 1);
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
