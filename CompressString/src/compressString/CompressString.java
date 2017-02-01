package compressString;

// Given a string, replace adjacent, repeated characters with the character followed by the number of repeated occurrences.
// If the character does not has any adjacent, repeated occurrences, it is not changed.

// Assumptions:
// 1. The string is not null
// 2. The characters used in the original string are guaranteed to be ‘a’ - ‘z’
// 3. There are no adjacent repeated characters with length > 9

public class CompressString {

	public String compress(String input) {
		if (input == null || input.length() <= 1) {
			return input;
		}
		char[] array = input.toCharArray();
		int slow = 0;
		for (int fast = 0; fast < array.length; fast++) {
			int begin = fast;
			while (fast + 1 < array.length && array[fast + 1] == array[begin]) {
				fast++;
			}
			array[slow++] = array[begin];
			if (fast - begin > 0) {
				array[slow++] = Integer.toString(fast - begin + 1).charAt(0);
			}
		}
		return new String(array, 0, slow);
	}

	// Time complexity is O(n).
	// Space complexity is O(n).

	// Notice the difference, if while loop, instead of for loop is used.
	public String compress2(String input) {
		if (input == null || input.length() <= 1) {
			return input;
		}
		char[] array = input.toCharArray();
		int slow = 0, fast = 0;
		while (fast < input.length()) {
			int begin = fast;
			while (fast < input.length() && array[fast] == array[begin]) {
				fast++;
			}
			if (fast - begin == 1) {
				array[slow++] = array[begin];
			} else {
				array[slow++] = array[begin];
				array[slow++] = Integer.toString(fast - begin).charAt(0);
			}
		}
		return new String(array, 0, slow);
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
