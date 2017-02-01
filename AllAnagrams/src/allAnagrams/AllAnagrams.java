package allAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Find all occurrence of anagrams of a given string s in a given string l. 
// Return the list of starting indices.

// Assumptions:
// 1. s is not null or empty.
// 2. l is not null.

public class AllAnagrams {

	public List<Integer> allAnagrams(String s, String l) {
		List<Integer> result = new ArrayList<>();
		if (l.length() < s.length()) {
			return result;
		}
		Map<Character, Integer> countMap = getCountMap(s);
		int match = 0;
		for (int i = 0; i < l.length(); i++) {
			Integer count = countMap.get(l.charAt(i));
			if (count != null) {
				countMap.put(l.charAt(i), count - 1);
				if (count == 1) {
					match++;
				}
			}
			if (i >= s.length()) {
				count = countMap.get(l.charAt(i - s.length()));
				if (count != null) {
					countMap.put(l.charAt(i - s.length()), count + 1);
					if (count == 0) {
						match--;
					}
				}
			}
			if (match == countMap.size()) {
				result.add(i - s.length() + 1);
			}
		}
		return result;
	}

	private Map<Character, Integer> getCountMap(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			Integer count = map.get(s.charAt(i));
			count = count == null ? 1 : count + 1;
			map.put(s.charAt(i), count);
		}
		return map;
	}

	// Time complexity is O(|l|).
	// Space complexity is O(|s|).
}
