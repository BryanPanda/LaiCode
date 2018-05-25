package stringDeduplication;

import java.util.Arrays;

// LeetCode #26 (Remove Duplicates from Sorted Array).

// Remove adjacent, repeated characters in a given string, leaving only one character 
// for each group of such characters.


public class StringDeduplication {

	public String deDup(String input) {
		if (input == null || input.length() <= 1) {
			return input;
		}
		char[] array = input.toCharArray();
		int slow = 0; // including slow
		for (int fast = 1; fast < array.length; fast++) {
			if (array[fast] != array[slow]) {
				array[++slow] = array[fast];
			}
		}
		return new String(Arrays.copyOf(array, slow + 1));
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
