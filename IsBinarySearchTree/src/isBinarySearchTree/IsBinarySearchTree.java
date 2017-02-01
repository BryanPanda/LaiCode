package isBinarySearchTree;

// Determine if a given binary tree is binary search tree.

public class IsBinarySearchTree {

	public boolean isBST(TreeNode root) {
		return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	// both min and max are inclusive
	private boolean helper(TreeNode root, int min, int max) {
		// base case
		if (root == null) {
			return true;
		}
		if (root.key < min || root.key > max) {
			return false;
		}
		// up to this point, root.key >= min && root.key <= max
		return helper(root.left, min, root.key - 1) && helper(root.right, root.key + 1, max);
	}

	// Time complexity is O(n).
	// Space complexity is O(n), when the BST is highly unbalanced.

}
