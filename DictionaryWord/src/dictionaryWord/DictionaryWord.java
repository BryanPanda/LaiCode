package dictionaryWord;

import java.util.HashSet;
import java.util.Set;

// LeetCode #139 (Word Break).

// Given a word and a dictionary, determine if it can be composed by 
// concatenating words from the given dictionary.

// Assumptions:
// 1. The given word is not null and is not empty
// 2. The given dictionary is not null and is not empty and all the words in the dictionary are not null or empty

public class DictionaryWord {

	// M[i]: whether index 0 to i - 1, inclusive, in input string can be
	// composed by concatenating words from the dictionary
	public boolean canBreak(String input, String[] dict) {
		Set<String> set = new HashSet<>();
		for (String s : dict) {
			set.add(s);
		}
		boolean[] array = new boolean[input.length() + 1];
		array[0] = true;
		for (int i = 1; i <= input.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (array[j] && set.contains(input.substring(j, i))) {
					array[i] = true;
					break;
				}
			}
		}
		return array[input.length()];
	}

	// Time complexity is O(n^3), because substring method takes O(n) time.
	// Space complexity is O(n).
}
