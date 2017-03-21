package longestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

// LeetCode #3

// Given a string, find the longest substring without any repeating characters and return the length of it. 
// The input string is guaranteed to be not null.
// For example, the longest substring without repeating letters for "bcdfbd" is "bcdf", we should return 4 in this case.

public class LongestSubstringWithoutRepeatingCharacters {

	public int longest(String input) {
		if (input == null || input.length() == 0) {
			return 0;
		}
		int slow = 0, fast = 0, result = 0;
		Set<Character> set = new HashSet<>();
		while (fast < input.length()) {
			if (set.add(input.charAt(fast))) {
				fast++;
				result = Math.max(result, set.size());
			} else {
				set.remove(input.charAt(slow));
				slow++;
			}
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).

}
