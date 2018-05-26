package allSubsets2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// LeetCode #90 (Subsets II).

// Given a set of characters represented by a String, return a list
// containing all subsets of the characters.

// There could be duplicate characters in the original set.

public class AllSubsets2 {

	public List<String> subSets(String set) {
		List<String> result = new ArrayList<>();
		if (set == null) {
			return result;
		}
		if (set.length() == 0) {
			result.add("");
			return result;
		}
		char[] array = set.toCharArray();
		Arrays.sort(array);
		StringBuilder sb = new StringBuilder();
		DFS(array, sb, result, 0);
		return result;
	}

	private void DFS(char[] array, StringBuilder sb, List<String> result, int level) {
		if (level == array.length) {
			result.add(sb.toString());
			return;
		}
		sb.append(array[level]);
		DFS(array, sb, result, level + 1);
		sb.deleteCharAt(sb.length() - 1);
		while (level < array.length - 1 && array[level] == array[level + 1]) {
			level++;
		}
		DFS(array, sb, result, level + 1);
	}

	// Time complexity is O(2^n).
	// Space complexity is O(n), because of call-stack.
}
