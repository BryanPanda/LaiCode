package removeCertainCharactersInString;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Remove given characters in input string, the relative order of other characters should be remained. 
// Return the new string after deletion.

// Assumptions:
// 1. The given input string is not null.
// 2. The characters to be removed is given by another string, it is guranteed to be not null.

public class RemoveCertainCharactersInString {

	public String remove(String input, String t) {
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < t.length(); i++) {
			set.add(t.charAt(i));
		}
		char[] array = input.toCharArray();
		int slow = 0; // not including slow
		for (int fast = 0; fast < array.length; fast++) {
			if (!set.contains(array[fast])) {
				array[slow++] = array[fast];
			}
		}
		return new String(Arrays.copyOf(array, slow));
	}

	// Time complexity is O(m + n).
	// Space complexitty is O(m + n).

}
