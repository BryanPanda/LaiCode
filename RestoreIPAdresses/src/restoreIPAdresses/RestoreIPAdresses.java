package restoreIPAdresses;

import java.util.ArrayList;
import java.util.List;

// LeetCode #93 (Restore IP Addresses).

// Given a string containing only digits, restore it by returning all possible valid IP address combinations.

public class RestoreIPAdresses {

	private static final int NUM = 4;
	private static final int MAX = 255;

	public List<String> restoreIpAddresses(String s) {
		List<String> cur = new ArrayList<>();
		List<String> result = new ArrayList<>();
		DFS(s, 0, cur, result);
		return result;
	}

	private void DFS(String s, int start, List<String> cur, List<String> result) {
		if (cur.size() > NUM) {
			return;
		}
		if (cur.size() == NUM) {
			if (start == s.length()) {
				result.add(String.join(".", cur));
			}
			return;
		}
		for (int end = start; end < s.length() && end <= start + 2; end++) {
			String subStr = s.substring(start, end + 1);
			int value = Integer.parseInt(subStr);
			if (value <= MAX && String.valueOf(value).length() == end - start + 1) { // avoid values like 01, 010, 011, ...
				cur.add(subStr);
				DFS(s, end + 1, cur, result);
				cur.remove(cur.size() - 1);
			}
		}
	}
	
	// Time complexity is O(3^n).
	// Space complexity is O(n).
}
