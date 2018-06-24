package decompressString;

// Given a string in compressed form, decompress it to the original string. 

// The adjacent repeated characters in the original string are compressed to
// have the character followed by the number of repeated occurrences.

// If the character does not have any adjacent repeated occurrences, it is not compressed.

// Assumptions:
// 1. The string is not null.
// 2. The characters used in the original string are guaranteed to be 'a' - 'z'.
// 3. There are no adjacent repeated characters with length > 9.

public class DecompressString {

	public String decompress(String input) {
		if (input == null || input.length() <= 1) {
			return input;
		}
		int extraSpace = 0;
		for (int i = 0; i < input.length(); i++) {
			if (Character.isDigit(input.charAt(i)) && Character.getNumericValue(input.charAt(i)) > 2) {
				extraSpace += Character.getNumericValue(input.charAt(i)) - 2;
			}
		}
		char[] newArray = new char[input.length() + extraSpace];
		int slow = input.length() - 1, fast = newArray.length - 1;
		while (slow >= 0) {
			if (Character.isDigit(input.charAt(slow))) {
				for (int i = 0; i < Character.getNumericValue(input.charAt(slow)); i++) {
					newArray[fast--] = input.charAt(slow - 1);
				}
				slow -= 2;
			} else {
				newArray[fast--] = input.charAt(slow--);
			}
		}
		return new String(newArray);
	}

	// Time complexity is O(n).
	// Space complexity is O(n).

	// Alternatively, using string builder is easier.
}
