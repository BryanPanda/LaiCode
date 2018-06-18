package minimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;

// LeetCode #76 (Minimum Window Substring).

// Given a string S and a string T, find the minimum window in S which will 
// contain all the characters in T in complexity O(n).

public class MinimumWindowSubstring {

	public String minWindow(String s, String t) {
		Map<Character, Integer> map = generateFrequencyMap(t);
		int start = 0, prev = 0;
		int length = Integer.MAX_VALUE;
		int count = t.length();
		for (int cur = 0; cur < s.length(); cur++) {
			Integer curFrequency = map.get(s.charAt(cur));
			if (curFrequency != null) {
				count = curFrequency > 0 ? count - 1 : count;
				map.put(s.charAt(cur), --curFrequency);
				while (count == 0) {
					if (cur - prev + 1 < length) {
						start = prev;
						length = cur - prev + 1;
					}
					Integer prevFrequency = map.get(s.charAt(prev));
					if (prevFrequency != null) {
						count = prevFrequency == 0 ? count + 1 : count;
						map.put(s.charAt(prev), ++prevFrequency);
					}
					prev++;
				}
			}
		}
		return length == Integer.MAX_VALUE ? "" : s.substring(start, start + length);
	}

	private Map<Character, Integer> generateFrequencyMap(String t) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : t.toCharArray()) {
			Integer frequency = map.get(c);
			frequency = frequency == null ? 1 : frequency + 1;
			map.put(c, frequency);
		}
		return map;
	}

	// Time complexity is O(m+n).
	// Space complexity is O(n).
}
