package allValidPermutationsOfParentheses2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Get all valid permutations of l pairs of (), m pairs of [] and n pairs of {}.

// Assumption: l, m, m >= 0

public class AllValidPermutationsOfParentheses2 {

	private static final char[] PS = new char[] { '(', ')', '[', ']', '{', '}' };

	public List<String> validParentheses(int l, int m, int n) {
		List<String> result = new ArrayList<>();
		int[] remain = new int[] { l, l, m, m, n, n };
		StringBuilder sb = new StringBuilder();
		LinkedList<Character> stack = new LinkedList<>();
		DFS(2 * (l + m + n), remain, sb, stack, result);
		return result;
	}

	private void DFS(int len, int[] remain, StringBuilder sb, LinkedList<Character> stack, List<String> result) {
		if (sb.length() == len) {
			result.add(sb.toString());
			return;
		}
		for (int i = 0; i < remain.length / 2; i++) {
			if (remain[2 * i] > 0) { // left parentheses
				sb.append(PS[2 * i]);
				remain[2 * i]--;
				stack.offerFirst(PS[2 * i]);
				DFS(len, remain, sb, stack, result);
				sb.deleteCharAt(sb.length() - 1);
				remain[2 * i]++;
				stack.pollFirst();
			}
			if (!stack.isEmpty() && stack.peekFirst().equals(PS[2 * i])) { // right parentheses
				sb.append(PS[2 * i + 1]);
				stack.pollFirst();
				DFS(len, remain, sb, stack, result);
				sb.deleteCharAt(sb.length() - 1);
				stack.offerFirst(PS[2 * i]);
			}
		}
	}
	
	// Time complexity is O(6^(l+m+n)), although this is only an upper bound, and 
	// is not tight, because some branches are cut off.
	// Space complexity is O(l+m+n), because of call-stack.
}

