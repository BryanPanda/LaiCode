package stringDeduplication3;

import java.util.Arrays;

// Remove adjacent, repeated characters in a given string, leaving no character for each group of such characters. 
// The characters in the string are sorted in ascending order.

public class StringDeduplication3 {

	public String deDup(String input) {
		if (input == null || input.length() == 0) {
			return input;
		}
		char[] array = input.toCharArray();
		int slow = 0; // not including slow
		int fast = 0;
		while (fast < array.length) {
			int begin = fast;
			while (fast < array.length && array[fast] == array[begin]) {
				fast++;
			}
			if (fast - begin == 1) {
				array[slow++] = array[begin];
			}
		}
		return new String(Arrays.copyOf(array, slow));
	}

	// Time complexity is O(n).
	// Space complexity is O(n).

	// See ArrayDeduplication3 for solution 2 and 3.
}
