package identicalBinaryTree;

import java.util.LinkedList;

// LeetCode #100 (Same Tree).

// Check if two given binary trees are identical. Identical means
// the equal valued keys are at the same position in the two binary trees.

public class IdenticalBinaryTree {

	public boolean isIdentical(TreeNode one, TreeNode two) {
		// base case
		if (one == null || two == null) {
			return one == two;
		}
		if (one.key != two.key) {
			return false;
		}
		// one != null && two != null && one.key == two.key
		return isIdentical(one.left, two.left) && isIdentical(one.right, two.right);
	}

	// Time complexity is O(n).
	// Space complexity is O(n), when the binary tree is highly unbalanced.

	// tail recursion, can be converted to an iterative solution
	public boolean isIdentical2(TreeNode one, TreeNode two) {
		LinkedList<TreeNode> stack = new LinkedList<>();
		stack.offerFirst(two);
		stack.offerFirst(one);
		while (!stack.isEmpty()) {
			TreeNode left = stack.pollFirst();
			TreeNode right = stack.pollFirst();
			if (left == null || right == null) {
				if (left != right) {
					return false;
				}
			} else {
				if (left.key != right.key) {
					return false;
				} else {
					stack.offerFirst(right.right);
					stack.offerFirst(left.right);
					stack.offerFirst(right.left);
					stack.offerFirst(left.left);
				}
			}
		}
		return true;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
