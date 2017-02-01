package decompressString2;

// Given a string in compressed form, decompress it to the original string. 
// The adjacent repeated characters in the original string are compressed to 
// have the character followed by the number of repeated occurrences.

// Assumptions:

// 1. The string is not null
// 2. The characters used in the original string are guaranteed to be ‘a’ - ‘z’
// 3.There are no adjacent repeated characters with length > 9

public class DecompressString2 {

	public String decompress(String input) {
		if (input == null || input.length() <= 1) {
			return input;
		}
		char[] array = input.toCharArray();
		int slow = 0;
		for (int fast = 0; fast < array.length; fast += 2) {
			if (Character.getNumericValue(array[fast + 1]) == 0) {
				continue;
			} else if (Character.getNumericValue(array[fast + 1]) == 1) {
				array[slow++] = array[fast];
			} else {
				array[slow++] = array[fast];
				array[slow++] = array[fast + 1];
			}
		}
		return helper(new String(array, 0, slow));
	}

	private String helper(String input) {
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

	// another solution: use StringBuilder
	public String decompress2(String input) {
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
