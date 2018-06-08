package maximumPathSumBinaryTree4;

// Given a binary tree in which each node contains an integer number. 
// Find the maximum possible sub-path sum from root node to leaf node.

// Assumption: root != null

public class MaximumPathSumBinaryTree4 {

	public int maxPathSum(TreeNode root) {
		if (root.left == null && root.right == null) {
			return root.key;
		}
		int left = (root.left == null) ? 0 : maxPathSum(root.left);
		int right = (root.right == null) ? 0 : maxPathSum(root.right);
		return root.key + Math.max(left, right);
	}

	// Time complexity is O(n).
	// Space complexity is O(n), if the binary tree is highly unbalanced.
}
