package stringReplace;

// Given an original string input, and two strings S and T, replace all 
// occurrences of S in input with T.

// Assumption: Input S and T are not null, S is not empty.

public class StringReplace {

	public String replace(String input, String s, String t) {
		if (input == null || input.length() == 0) {
			return input;
		}
		StringBuilder sb = new StringBuilder();
		int fromIndex = 0;
		int matchIndex = input.indexOf(s, fromIndex);
		while (matchIndex != -1) {
			sb.append(input, fromIndex, matchIndex).append(t);
			fromIndex = matchIndex + s.length();
			matchIndex = input.indexOf(s, fromIndex);
		}
		sb.append(input, fromIndex, input.length());
		return sb.toString();
	}

	// Time complexity is O(n*t).
	// Space complexity is O(1).
}
