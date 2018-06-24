package decompressString2;

// Given a string in compressed form, decompress it to the original string.

// The adjacent repeated characters in the original string are compressed to 
// have the character followed by the number of repeated occurrences.

// Assumptions:
// 1. The string is not null.
// 2. The characters used in the original string are guaranteed to be 'a' - 'z'.
// 3.There are no adjacent repeated characters with length > 9.

public class DecompressString2 {

	public String decompress(String input) {
		if (input == null || input.length() <= 1) {
			return input;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); i += 2) {
			for (int j = 0; j < Character.getNumericValue(input.charAt(i + 1)); j++) {
				sb.append(input.charAt(i));
			}
		}
		return new String(sb);
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
