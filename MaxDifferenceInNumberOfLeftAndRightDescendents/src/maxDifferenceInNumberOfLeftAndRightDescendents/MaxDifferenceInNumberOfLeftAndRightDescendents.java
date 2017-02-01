package maxDifferenceInNumberOfLeftAndRightDescendents;

// Given a binary tree, find the node whose left sub-tree and
// right sub-tree have the maximum difference, in terms of the 
// number of nodes.

public class MaxDifferenceInNumberOfLeftAndRightDescendents {

	public TreeNode maxDiff(TreeNode root) {
		// base case
		if (root == null) {
			return null;
		}
		TreeNode[] node = new TreeNode[] { null };
		int[] max = new int[] { Integer.MIN_VALUE };
		helper(root, node, max);
		return node[0];
	}

	private int helper(TreeNode root, TreeNode[] node, int[] max) {
		// base case
		if (root == null) {
			return 0;
		}
		int left = helper(root.left, node, max);
		int right = helper(root.right, node, max);
		if (Math.abs(left - right) > max[0]) {
			node[0] = root;
			max[0] = Math.abs(left - right);
		}
		return left + right + 1;
	}

	// Time complexity is O(n).
	// Space complexity is O(n), if the binary tree is highly unbalanced.
}
