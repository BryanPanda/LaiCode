package binaryTreeTraversal;

import java.util.*;

public class InOrder {

	public List<Integer> inOrder(TreeNode root) {
		// base case
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		result.addAll(inOrder(root.left));
		result.add(root.key);
		result.addAll(inOrder(root.right));
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(n), when binary tree is highly unbalanced.
	// Stack might overflow.

	public List<Integer> inOrder2(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		LinkedList<TreeNode> stack = new LinkedList<>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				stack.offerFirst(cur);
				cur = cur.left;
			} else {
				cur = stack.pollFirst();
				result.add(cur.key);
				cur = cur.right;
			}
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
	// No stack overflow.

	public List<Integer> inOrder3(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		TreeNode cur = root, node = null;
		while (cur != null) {
			if (cur.left == null) {
				result.add(cur.key);
				cur = cur.right;
			} else {
				node = cur.left;
				while (node.right != null && node.right != cur) {
					node = node.right;
				}
				// node.right == null || node.right == cur
				if (node.right == null) {
					node.right = cur;
					cur = cur.left;
				} else {
					node.right = null;
					result.add(cur.key);
					cur = cur.right;
				}
			}
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
	// No stack overflow.

}
