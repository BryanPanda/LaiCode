package removeSpacesInString;

import java.util.Arrays;

// Given a string, remove all leading/trailing/duplicated empty spaces.

// Assumption: The given string is not null.

public class RemoveSpacesInString {

	public String removeSpaces(String input) {
		char[] array = input.toCharArray();
		int slow = 0; // not including slow
		for (int fast = 0; fast < array.length; fast++) {
			if (array[fast] != ' ' || fast > 0 && array[fast - 1] != ' ') {
				array[slow++] = array[fast];
			}
		}
		if (slow - 1 >= 0 && array[slow - 1] == ' ') {
			slow--;
		}
		return new String(Arrays.copyOf(array, slow));
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
