package transformBSTToGST;

// Given a BST, change each node’s value, such that its value is equal to the sum of all nodes greater than itself.

public class TransformBSTToGST {

	public TreeNode greaterSum(TreeNode root) {
		helper(root, 0);
		return root;
	}

	private int helper(TreeNode root, int greaterSum) {
		// base case
		if (root == null) {
			return greaterSum;
		}
		int cur = root.key;
		root.key = helper(root.right, greaterSum);
		return helper(root.left, cur + root.key);
	}

	// Time complexity is O(n).
	// Space complexity is O(n), if BST is unbalanced.
}
