package allSubsets;

import java.util.ArrayList;
import java.util.List;

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
		DFS(set, 0, sb, result);
		return result;
	}

	private void DFS(String set, int level, StringBuilder sb, List<String> result) {
		if (level == set.length()) {
			result.add(sb.toString());
			return;
		}
		sb.append(set.charAt(level));
		DFS(set, level + 1, sb, result);
		sb.deleteCharAt(sb.length() - 1);
		DFS(set, level + 1, sb, result);
	}

	// Time complexity is O(2^n).
	// Space complexity is O(n), because of call-stack.

	// Notice: If DFS uses a for loop (as in permutations), then
	// append-DFS-remove.
	// If no for loop, then append-DFS-remove-DFS.

	public static void main(String[] args) {
		AllSubsets allSubsets = new AllSubsets();
		String set = "abc";
		System.out.println(allSubsets.subSets(set).toString());
	}

}
