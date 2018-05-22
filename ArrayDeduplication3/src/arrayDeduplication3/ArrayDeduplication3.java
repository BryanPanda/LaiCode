package arrayDeduplication3;

import java.util.Arrays;

// Given a sorted integer array, remove duplicate elements. 
// For each group of elements with the same value do not keep any of them. 
// Do this in-place, using the left side of the original array and and maintain the relative order of the elements of the array.

// Return the array after deduplication.

public class ArrayDeduplication3 {

	public int[] dedup(int[] array) {
		int slow = 0; // not including slow
		for (int fast = 0; fast < array.length; fast++) {
			if ((fast == 0 || array[fast] != array[fast - 1]) && (fast == array.length - 1 || array[fast] != array[fast + 1])) {
				array[slow++] = array[fast];
			}
		}
		return Arrays.copyOf(array, slow);
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
