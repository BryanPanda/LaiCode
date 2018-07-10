package allAnagrams;

import java.util.ArrayList;
import java.util.List;

// LeetCode #438 (Find All Anagrams in a String).

// Find all occurrence of anagrams of a given string s in a given string l. 
// Return the list of starting indices.

// Assumptions:
// 1. s is not null or empty.
// 2. l is not null.

public class AllAnagrams {

	private static final int NUM_LETTERS = 26;

	public List<Integer> allAnagrams(String s, String l) {
		int[] countMap = new int[NUM_LETTERS];
		for (int i = 0; i < s.length(); i++) {
			countMap[s.charAt(i) - 'a']++;
		}
		int left = 0, right = 0;
		int count = s.length(); // number of chars in s
		List<Integer> result = new ArrayList<>();
		while (right < l.length()) {
			if (right - left == s.length() && countMap[l.charAt(left++) - 'a']++ >= 0) {
				count++;
			}
			if (countMap[l.charAt(right++) - 'a']-- > 0) {
				count--;
			}
			if (count == 0) {
				result.add(left);
			}
		}
		return result;
	}

	// Time complexity is O(m + n).
	// Space complexity is O(1).
}
