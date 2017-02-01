package stringAbbreviationMatching;

// Word “book” can be abbreviated to 4, b3, b2k, etc. 
// Given a string and an abbreviation, return if the string matches the abbreviation.

// Assumptions:
// 1. The original string only contains alphabetic characters.
// 2. Both input and pattern are not null.

public class StringAbbreviationMatching {

	// iterative solution
	public boolean match(String input, String pattern) {
		int slow = 0, fast = 0;
		while (slow < pattern.length() && fast < input.length()) {
			if (!Character.isDigit(pattern.charAt(slow))) {
				if (pattern.charAt(slow) != input.charAt(fast)) {
					return false;
				}
				slow++;
				fast++;
			} else {
				int count = Character.getNumericValue(pattern.charAt(slow));
				slow++;
				while (slow < pattern.length() && Character.isDigit(pattern.charAt(slow))) {
					count = 10 * count + Character.getNumericValue(pattern.charAt(slow));
					slow++;
				}
				fast += count;
			}
		}
		// slow >= pattern.length() || fast >= input.length()
		return (slow == pattern.length() && fast == input.length()) ? true : false;
	}

	// Time complexity is O(min(m, n)).
	// Space complexity is O(1).

	// recursive solution
	public boolean match2(String input, String pattern) {
		int i = 0, j = 0;
		return helper2(input, pattern, i, j);
	}

	private boolean helper2(String input, String pattern, int i, int j) {
		if (i == input.length() || j == pattern.length()) {
			return input.length() - i == pattern.length() - j;
		}
		if (!Character.isDigit(pattern.charAt(j))) {
			if (input.charAt(i) != pattern.charAt(j)) {
				return false;
			}
			return helper2(input, pattern, i + 1, j + 1);
		} else {
			// first, get the number
			int num = 0;
			while (j < pattern.length() && Character.isDigit(pattern.charAt(j))) {
				num = 10 * num + Character.getNumericValue(pattern.charAt(j++));
			}
			return i + num > input.length() ? false : helper2(input, pattern, i + num, j);
		}
	}

	// Time Complexity is O(min(m, n)).
	// Space Complexity is O(min(m, n)), because of call-stack.
}
