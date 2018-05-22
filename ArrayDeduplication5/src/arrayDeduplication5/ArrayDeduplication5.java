package arrayDeduplication5;

import java.util.Arrays;

// Given an integer array(not guaranteed to be sorted), remove adjacent repeated elements. 
// For each group of elements with the same value keep at most two of them. Do this in-place, 
// using the left side of the original array and maintain the relative order of the elements 
// of the array. 

// Return the final array.

public class ArrayDeduplication5 {

	public int[] dedup(int[] array) {
		int slow = 0, fast = 0; // not including slow
		while (fast < array.length) {
			int start = fast, end = fast;
			if (fast == array.length - 1 || array[fast] != array[fast + 1]) { // copy one value
				end = ++fast;
			} 
			else { // copy two values
				fast += 2;
				end = fast;
				if (fast < array.length && array[fast] == array[start]) { // ignore repetitive values from the third and on
					while (fast < array.length && array[fast] == array[start]) {
						fast++;
					}
				}
			}
			for (int i = start; i < end; i++) {
				array[slow++] = array[i];
			}
		}
		return Arrays.copyOf(array, slow);
	}
	
	// Time complexity is O(n).
	// Space complexity is O(1).
}
