package dictionaryWord;

import java.util.HashSet;
import java.util.Set;

// Given a word and a dictionary, determine if it can be composed by 
// concatenating words from the given dictionary.

// The given word is not null and is not empty
// The given dictionary is not null and is not empty and all the words in the dictionary are not null or empty

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
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				if (array[j] && set.contains(input.substring(j, i))) {
					array[i] = true;
					break;
				}
			}
		}
		return array[array.length - 1];
	}

	// Time complexity is O(n^3), because substring method takes O(n) time.
	// Space complexity is O(n).

	// another solution with different meaning of M[i]
	// M[i]: whether index 0 to i, inclusive, in input string can be composed by
	// concatenating words from the dictionary
	public boolean canBreak2(String input, String[] dict) {
		Set<String> set = new HashSet<>();
		for (String s : dict) {
			set.add(s);
		}
		boolean[] array = new boolean[input.length()];
		array[0] = set.contains(input.charAt(0));
		for (int i = 1; i < array.length; i++) {
			if (set.contains(input.substring(0, i + 1))) {
				array[i] = true;
				continue;
			}
			for (int j = 0; j < i; j++) {
				if (array[j] && set.contains(input.substring(j + 1, i + 1))) {
					array[i] = true;
					break;
				}
			}
		}
		return array[array.length - 1];
	}

	// Time complexity is O(n^3), because substring method takes O(n) time.
	// Space complexity is O(n).
}