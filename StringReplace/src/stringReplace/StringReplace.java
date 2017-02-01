package stringReplace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Given an original string input, and two strings S and T, replace all occurrences of S in input with T.

// Assumption: input, S and T are not null, S is not empty string

public class StringReplace {

	public String replace(String input, String s, String t) {
		if (input == null || input.length() == 0) {
			return input;
		}
		char[] array = input.toCharArray();
		if (s.length() >= t.length()) {
			return replaceLongWithShort(array, s, t);
		} else {
			return replaceShortWithLong(array, s, t);
		}
	}

	private String replaceLongWithShort(char[] array, String s, String t) {
		int slow = 0, fast = 0;
		while (fast < array.length) {
			if (fast <= array.length - s.length() && equals(array, fast, s)) {
				replace(array, slow, t);
				slow += t.length();
				fast += s.length();
			} else {
				array[slow++] = array[fast++];
			}
		}
		return new String(array, 0, slow);
	}

	private boolean equals(char[] array, int fast, String s) {
		for (int i = 0; i < s.length(); i++) {
			if (array[fast + i] != s.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	private void replace(char[] array, int slow, String t) {
		for (int i = 0; i < t.length(); i++) {
			array[slow++] = t.charAt(i);
		}
	}

	private String replaceShortWithLong(char[] array, String s, String t) {
		List<Integer> matches = new ArrayList<>();
		int i = 0;
		while (i <= array.length - s.length()) {
			if (equals(array, i, s)) {
				matches.add(i + s.length() - 1);
				i += s.length();
			} else {
				i++;
			}
		}
		char[] newArray = Arrays.copyOf(array, array.length + matches.size() * (t.length() - s.length()));
		int slow = array.length - 1, fast = newArray.length - 1, lastIndex = matches.size() - 1;
		while (slow >= 0) {
			if (lastIndex >= 0 && slow == matches.get(lastIndex)) {
				replace(newArray, fast - t.length() + 1, t);
				slow -= s.length();
				fast -= t.length();
				lastIndex--;
			} else {
				newArray[fast--] = array[slow--];
			}
		}
		return new String(newArray);
	}

	// Time complexity is ?
	// Space complexity is ?

	// solution 2: use StringBuilder
	public String replace2(String input, String s, String t) {
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

	// Time complexity is ?
	// Space complexity is ?

	public static void main(String[] args) {
		StringReplace stringReplace = new StringReplace();
		System.out.println(stringReplace.replace("appledogapple", "apple", "cat"));
		System.out.println(stringReplace.replace("dodododo", "dod", "a"));
	}
}
