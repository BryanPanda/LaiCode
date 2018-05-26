package allPermutations2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// LeetCode #47 (Permutations II).

// Given a string with possible duplicate characters, return a list with all permutations
// of the characters.

public class AllPermutations2 {

	public List<String> permutations(String set) {
		List<String> result = new ArrayList<>();
		if (set == null) {
			return result;
		}
		if (set.length() == 0) {
			result.add("");
			return result;
		}
		char[] array = set.toCharArray();
		DFS(array, result, 0);
		return result;
	}

	private void DFS(char[] array, List<String> result, int level) {
		if (level == array.length) {
			result.add(new String(array));
			return;
		}
		Set<Character> set = new HashSet<>();
		for (int i = level; i < array.length; i++) {
			if (set.add(array[i])) {
				swap(array, i, level);
				DFS(array, result, level + 1);
				swap(array, i, level);
			}
		}
	}

	private void swap(char[] array, int i, int j) {
		char temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	// Time complexity is O(n + n*(n-1) + n*(n-1)*(n-2) + ... + n!) = O(n!)
	// Space complexity is O(n) because of call-stack.
}
