package allSubsets;

import java.util.ArrayList;
import java.util.List;

// LeetCode #78 (Subsets).

// Given a set of characters represented by a String, return a list containing all subsets of the characters.

// Assumption: There are no duplicate characters in the original set.

public class AllSubsets {

	public List<String> subSets(String set) {
		List<String> result = new ArrayList<>();
		if (set == null) {
			return result;
		}
		if (set.length() == 0) {
			result.add("");
			return result;
		}
		StringBuilder sb = new StringBuilder();
		DFS(set, sb, result, 0);
		return result;
	}

	private void DFS(String set, StringBuilder sb, List<String> result, int level) {
		if (level == set.length()) {
			result.add(sb.toString());
			return;
		}
		sb.append(set.charAt(level));
		DFS(set, sb, result, level + 1);
		sb.deleteCharAt(sb.length() - 1);
		DFS(set, sb, result, level + 1);
	}

	// Time complexity is O(2^n).
	// Space complexity is O(n), because of call-stack.

	// Notice: If DFS uses a for loop (as in permutations), then
	// append-DFS-remove. If no for loop, then append-DFS-remove-DFS.
}
