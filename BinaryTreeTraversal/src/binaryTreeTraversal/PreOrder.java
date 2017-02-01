package binaryTreeTraversal;

import java.util.*;

public class PreOrder {

	public List<Integer> preOrder(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		// base case
		if (root == null) {
			return result;
		}
		result.add(root.key);
		result.addAll(preOrder(root.left));
		result.addAll(preOrder(root.right));
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(n), when binary tree is highly unbalanced.
	// Stack might overflow.

	public List<Integer> preOrder2(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		// root != null
		LinkedList<TreeNode> stack = new LinkedList<>();
		stack.offerFirst(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pollFirst();
			result.add(node.key);
			if (node.right != null) {
				stack.offerFirst(node.right);
			}
			if (node.left != null) {
				stack.offerFirst(node.left);
			}
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
	// No stack overflow.

	public List<Integer> preOrder3(TreeNode root) {
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
					result.add(cur.key);
					cur = cur.left;
				} else {
					node.right = null;
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
