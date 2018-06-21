package compressString;

// LeetCode #443 (String Compression).

// Given a string, replace adjacent repeated characters with the character followed
// by the number of repeated occurrences.

// If the character does not has any adjacent repeated occurrences, it is not changed.

// Assumptions:
// 1. The string is not null.
// 2. The characters used in the original string are guaranteed to be 'a' - 'z'.
// 3. There are no adjacent repeated characters with length > 9.

public class CompressString {

	public String compress(String input) {
		if (input == null || input.length() <= 1) {
			return input;
		}
		char[] array = input.toCharArray();
		int slow = 0, fast = 0;
		while (fast < input.length()) {
			int cur = fast;
			while (fast < input.length() && array[fast] == array[cur]) {
				fast++;
			}
			array[slow++] = array[cur];
			if (fast - cur > 1) {
				array[slow++] = Integer.toString(fast - cur).charAt(0);
			}
		}
		return new String(array, 0, slow);
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
