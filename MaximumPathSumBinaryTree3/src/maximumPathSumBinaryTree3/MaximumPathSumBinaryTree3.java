package maximumPathSumBinaryTree3;

// Given a binary tree in which each node contains an integer number. 

// Find the maximum possible sub-path sum (both the starting and ending node
// of the sub-path should be on the same path from root to one of the leaf nodes, 
// and the sub-path is allowed to contain only one node).

public class MaximumPathSumBinaryTree3 {

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
		max = Math.max(max, root.key + Math.max(left, right));
		return root.key + Math.max(left, right);
	}

	// Time complexity is O(n).
	// Space complexity is O(n), because of call-stack, if the binary tree is
	// highly unbalanced.
}
