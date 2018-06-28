package largestProductOfLength;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

// LeetCode #318 (Maximum Product of Word Lengths).

// Given a dictionary containing many words, find the largest product of two words’ lengths,
// such that the two words do not share any common characters.

// Assumption:
// 1. The words only contains characters of 'a' to 'z'
// 2. The dictionary is not null and does not contains null string, and has at least two strings
// 3. If there is no such pair of words, just return 0

public class LargestProductOfLength {

	public int largestProduct(String[] dict) {
		HashMap<String, Integer> bitMasks = getBitMasks(dict);

		Arrays.sort(dict, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if (s1.length() == s2.length()) {
					return 0;
				}
				return s1.length() < s2.length() ? 1 : -1;
			}
		});

		int largest = 0;
		for (int i = 1; i < dict.length; i++) {
			for (int j = 0; j < i; j++) {
				int product = dict[i].length() * dict[j].length();
				if (product < largest) {
					break; // break inner for loop
				}
				if ((bitMasks.get(dict[i]) & bitMasks.get(dict[j])) == 0) {
					largest = product;
				}
			}
		}

		return largest;
	}

	private HashMap<String, Integer> getBitMasks(String[] dict) {
		HashMap<String, Integer> result = new HashMap<>();
		for (String s : dict) {
			int bitMask = 0;
			for (int i = 0; i < s.length(); i++) {
				bitMask |= 1 << (s.charAt(i) - 'a');
			}
			result.put(s, bitMask);
		}
		return result;
	}

	// Time complexity is O(n*k + n*log(n) + n^2).
	// Space complexity is O(n).

	// Take-away: When there is only a limited number of possible chars in each
	// word, bit mask can save time on checking whether two words have the same
	// chars in common.
}
