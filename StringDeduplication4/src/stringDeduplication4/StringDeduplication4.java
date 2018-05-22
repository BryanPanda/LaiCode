package stringDeduplication4;

import java.util.Arrays;

// Repeatedly remove all adjacent, repeated characters in a given string from left to right.
// No adjacent characters should be identified in the final string.

public class StringDeduplication4 {

	public String deDup(String input) {
		if (input == null || input.length() <= 1) {
			return input;
		}
		char[] array = input.toCharArray();
		int end = -1, fast = 0; // including end
		while (fast < array.length) {
			if (end == -1 || array[fast] != array[end]) {
				array[++end] = array[fast++];
			} 
			else {
				while (fast < array.length - 1 && array[fast + 1] == array[fast]) {
					fast++;
				}
				end--;
				fast++;
			}
		}
		return new String(Arrays.copyOf(array, end + 1));
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
