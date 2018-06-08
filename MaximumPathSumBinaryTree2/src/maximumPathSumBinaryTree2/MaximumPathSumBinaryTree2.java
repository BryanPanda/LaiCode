package maximumPathSumBinaryTree2;

// LeetCode #124 (Binary Tree Maximum Path Sum).

// Given a binary tree in which each node contains an integer number.

// Find the maximum possible sum from any node to any node (the start
// node and the end node can be the same). 

// Assumption: The root of the given binary tree is not null.

public class MaximumPathSumBinaryTree2 {

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
		left = left < 0 ? 0 : left;
		right = right < 0 ? 0 : right;
		max = Math.max(max, root.key + left + right);
		return root.key + Math.max(left, right);
	}
	
	// Time complexity is O(n).
	// Space complexity is O(n), because of call-stack, if the binary tree is highly unbalanced.
}
