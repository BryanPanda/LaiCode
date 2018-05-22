package arrayDeduplication4;

import java.util.Arrays;

// Given an unsorted integer array, remove adjacent duplicate elements repeatedly, from left to right. 
// For each group of elements with the same value do not keep any of them.
// Do this in-place, using the left side of the original array. 

// Return the array after deduplication.

public class ArrayDeduplication4 {

	public int[] dedup(int[] array) {
		if (array == null || array.length <= 1) {
			return array;
		}
		int end = -1, fast = 0; // including end
		while (fast < array.length) {
			if (end == -1 || array[fast] != array[end]) {
				array[++end] = array[fast++];
			} 
			else {
				while (fast < array.length - 1 && array[fast + 1] == array[end]) {
					fast++;
				}
				end--;
				fast++;
			}
		}
		return Arrays.copyOf(array, end + 1);
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
