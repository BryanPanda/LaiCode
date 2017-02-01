package maximumPathSumBinaryTree;

// Given a binary tree in which each node contains an integer number. 
// Find the maximum possible sum from one leaf node to another leaf node. 
// If there is no such path available, return Integer.MIN_VALUE (Java).

public class MaximumPathSumBinaryTree {

	public int maxPathSum(TreeNode root) {
		int[] max = new int[] { Integer.MIN_VALUE };
		helper(root, max);
		return max[0];
	}

	// helper method returns the max path sum from a leaf node to root
	private int helper(TreeNode root, int[] max) {
		if (root == null) {
			return 0;
		}
		int left = helper(root.left, max);
		int right = helper(root.right, max);
		if (root.left != null && root.right != null) {
			max[0] = Math.max(max[0], left + right + root.key);
			return Math.max(left, right) + root.key;
		}
		// root.left == null || root.right == null
		// no need to update max[0]
		return root.left == null ? right + root.key : left + root.key;
	}

	// How neat recursion is!
	// Time complexity is O(n).
	// Space complexity is O(n), because of call-stack, if the binary tree is
	// highly unbalanced.

	// Notice the reason why we use int[] max:
	// Because Java is always passing by value, if primitive type is passed, a
	// copy with that value will be used throughout the method, therefore the
	// value of the original variable doesn't change.

	public static void main(String[] agrs) {
		MaximumPathSumBinaryTree maximumPathSumBinaryTree = new MaximumPathSumBinaryTree();
		TreeNode root = new TreeNode(-15);
		root.left = new TreeNode(2);
		root.right = new TreeNode(11);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(14);
		System.out.println(maximumPathSumBinaryTree.maxPathSum(root));
	}
}
