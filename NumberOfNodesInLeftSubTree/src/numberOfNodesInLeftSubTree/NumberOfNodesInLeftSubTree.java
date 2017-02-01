package numberOfNodesInLeftSubTree;

// Store, in each node, the number of nodes in its left sub-tree.

public class NumberOfNodesInLeftSubTree {

	static class TreeNode {
		int key;
		TreeNode left;
		TreeNode right;
		int numNodesLeft;

		// constructor
		public TreeNode(int key) {
			this.key = key;
		}
	}

	public void numNodesLeft(TreeNode root) {
		helper(root);
	}

	private int helper(TreeNode root) {
		// base case
		if (root == null) {
			return 0;
		}
		int left = helper(root.left);
		int right = helper(root.right);
		root.numNodesLeft = left;
		return left + right + 1;
	}

	// Time complexity is O(n).
	// Space complexity is O(n), if the binary tree is highly unbalanced.
}
