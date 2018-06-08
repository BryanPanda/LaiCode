package maximumPathSumBinaryTree;

// Given a binary tree in which each node contains an integer number. 

// Find the maximum possible sum from one leaf node to another leaf node. 
// If there is no such path available, return Integer.MIN_VALUE.

public class MaximumPathSumBinaryTree {

	private int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		helper(root);
		return max;
	}

	private int helper(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = helper(root.left);
		int right = helper(root.right);
		if (root.left != null && root.right != null) {
			max = Math.max(max, root.key + left + right);
			return root.key + Math.max(left, right);
		}
		return root.left == null ? root.key + right : root.key + left;
	}

	// Time complexity is O(n).
	// Space complexity is O(n), because of call-stack, if the binary tree is highly unbalanced.
}
