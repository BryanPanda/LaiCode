package stringDeduplication2;

import java.util.Arrays;

//LeetCode #80 (Remove Duplicates from Sorted Array II).


// Remove adjacent, repeated characters in a given string, leaving 
// only two characters for each group of such characters. 

// The characters in the string are sorted in ascending order.

public class StringDeduplication2 {

	public String deDup(String input) {
		if (input == null || input.length() <= 2) {
			return input;
		}
		char[] array = input.toCharArray();
		int slow = 2; // not including slow
		for (int fast = 2; fast < array.length; fast++) {
			if (array[fast] != array[slow - 2]) {
				array[slow++] = array[fast];
			}
		}
		return new String(Arrays.copyOf(array, slow));
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
