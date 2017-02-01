package allValidPermutationsOfParentheses2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Get all valid permutations of l pairs of (), m pairs of [] and n pairs of {}.

// Assumption: l, m, m >= 0

public class AllValidPermutationsOfParentheses2 {

	public List<String> validParentheses(int l, int m, int n) {
		List<String> result = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		LinkedList<String> stack = new LinkedList<>();
		DFS(0, l, m, n, 0, 0, 0, sb, stack, result);
		return result;
	}

	private void DFS(int level, int l, int m, int n, int lLeft, int mLeft, int nLeft, StringBuilder sb,
			LinkedList<String> stack, List<String> result) {
		if (level == 2 * (l + m + n)) {
			result.add(sb.toString());
			return;
		}
		// ()
		if (lLeft < l) {
			sb.append("(");
			stack.offerFirst("(");
			DFS(level + 1, l, m, n, lLeft + 1, mLeft, nLeft, sb, stack, result);
			sb.deleteCharAt(sb.length() - 1);
			stack.pollFirst();
		}
		if (stack.peekFirst() == "(") {
			sb.append(")");
			stack.pollFirst();
			DFS(level + 1, l, m, n, lLeft, mLeft, nLeft, sb, stack, result);
			sb.deleteCharAt(sb.length() - 1);
			stack.offerFirst("(");
		}
		// []
		if (mLeft < m) {
			sb.append("[");
			stack.offerFirst("[");
			DFS(level + 1, l, m, n, lLeft, mLeft + 1, nLeft, sb, stack, result);
			sb.deleteCharAt(sb.length() - 1);
			stack.pollFirst();
		}
		if (stack.peekFirst() == "[") {
			sb.append("]");
			stack.pollFirst();
			DFS(level + 1, l, m, n, lLeft, mLeft, nLeft, sb, stack, result);
			sb.deleteCharAt(sb.length() - 1);
			stack.offerFirst("[");
		}
		// {}
		if (nLeft < n) {
			sb.append("{");
			stack.offerFirst("{");
			DFS(level + 1, l, m, n, lLeft, mLeft, nLeft + 1, sb, stack, result);
			sb.deleteCharAt(sb.length() - 1);
			stack.pollFirst();
		}
		if (stack.peekFirst() == "{") {
			sb.append("}");
			stack.pollFirst();
			DFS(level + 1, l, m, n, lLeft, mLeft, nLeft, sb, stack, result);
			sb.deleteCharAt(sb.length() - 1);
			stack.offerFirst("{");
		}
	}

	// Time complexity is O(6^(l+m+n)), although this is only an upper bound,
	// and is not tight, because some branches are cut off.
	// Space complexity is O(l+m+n).

	// another solution with the same idea, but is neater
	private static final char[] PS = new char[] { '(', ')', '[', ']', '{', '}' };

	public List<String> validParentheses2(int l, int m, int n) {
		List<String> result = new ArrayList<>();
		int[] remain = new int[] { l, l, m, m, n, n };
		StringBuilder sb = new StringBuilder();
		LinkedList<Character> stack = new LinkedList<>();
		DFS2(2 * (l + m + n), remain, sb, stack, result);
		return result;
	}

	private void DFS2(int len, int[] remain, StringBuilder sb, LinkedList<Character> stack, List<String> result) {
		if (sb.length() == len) {
			result.add(sb.toString());
			return;
		}
		for (int i = 0; i < remain.length; i++) {
			// left parentheses
			if (i % 2 == 0) {
				if (remain[i] > 0) {
					sb.append(PS[i]);
					stack.offerFirst(PS[i]);
					remain[i]--;
					DFS2(len, remain, sb, stack, result);
					sb.deleteCharAt(sb.length() - 1);
					stack.pollFirst();
					remain[i]++;
				}
			} else { // right parentheses
				if (!stack.isEmpty() && stack.peekFirst() == PS[i - 1]) {
					sb.append(PS[i]);
					stack.pollFirst();
					remain[i]--; // can be commented out
					DFS2(len, remain, sb, stack, result);
					sb.deleteCharAt(sb.length() - 1);
					stack.offerFirst(PS[i - 1]);
					remain[i]++; // can be commented out
				}
			}
		}
	}

	public static void main(String[] args) {
		AllValidPermutationsOfParentheses2 allValidPermutationsOfParentheses2 = new AllValidPermutationsOfParentheses2();
		System.out.println(allValidPermutationsOfParentheses2.validParentheses2(1, 1, 0).toString());
	}

}
