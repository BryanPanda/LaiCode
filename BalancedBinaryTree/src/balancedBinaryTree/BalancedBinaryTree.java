package balancedBinaryTree;

// LeetCode #110 (Balanced Binary Tree).

// Check if a given binary tree is balanced. A balanced binary tree is one 
// in which the depths of every node’s left and right subtree differ by at most 1.

public class BalancedBinaryTree {

	public boolean isBalanced(TreeNode root) {
		return height(root) != -1;
	}

	public int height(TreeNode root) {
		// base case
		if (root == null) {
			return 0;
		}
		int leftHeight = height(root.left);
		if (leftHeight == -1) {
			return -1;
		}
		int rightHeight = height(root.right);
		if (rightHeight == -1) {
			return -1;
		}
		if (Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		}
		return Math.max(leftHeight, rightHeight) + 1;
	}

	// Time complexity is O(n).
	// Space complexity is O(n), when the binary tree is highly unbalanced.
}
