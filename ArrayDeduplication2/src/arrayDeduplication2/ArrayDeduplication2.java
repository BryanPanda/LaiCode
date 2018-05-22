package arrayDeduplication2;

import java.util.Arrays;

// LeetCode #80 (Remove Duplicates from Sorted Array II).

// Given a sorted integer array, remove duplicate elements. 
// For each group of elements with the same value keep at most two of them. 
// Do this in-place, using the left side of the original array and maintain the relative order of the elements of the array. 

// Return the array after deduplication.

public class ArrayDeduplication2 {

	public int[] dedup(int[] array) {
		if (array == null || array.length <= 2) {
			return array;
		}
		int slow = 2; // not including slow
		for (int fast = 2; fast < array.length; fast++) {
			if (array[fast] != array[slow - 2]) {
				array[slow++] = array[fast];
			}
		}
		return Arrays.copyOf(array, slow);
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
