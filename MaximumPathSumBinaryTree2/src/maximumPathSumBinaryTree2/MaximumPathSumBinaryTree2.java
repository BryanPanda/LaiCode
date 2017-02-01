package maximumPathSumBinaryTree2;

// Given a binary tree in which each node contains an integer number. 
// Find the maximum possible sum from any node to any node (the start
// node and the end node can be the same). 

// Assumption: The root of the given binary tree is not null.

public class MaximumPathSumBinaryTree2 {

	public int maxPathSum(TreeNode root) {
		int[] max = new int[] { Integer.MIN_VALUE };
		helper(root, max);
		return max[0];
	}

	// returns the largest path sum from any node to root
	private int helper(TreeNode root, int[] max) {
		if (root == null) {
			return 0;
		}
		int left = helper(root.left, max);
		int right = helper(root.right, max);
		if (root.left != null && root.right != null) {
			// update max[0]
			// 4 options: m, lm, lmr, mr
			max[0] = Math.max(max[0], largest(root.key, left + root.key, root.key + right, left + root.key + right));
			return Math.max(Math.max(left + root.key, root.key), root.key + right);
		}
		// difference between this and MaximumPathSumBinaryTree
		// might need to update max[0]
		if (root.left == null) {
			max[0] = Math.max(max[0], root.key + right);
			return Math.max(root.key, root.key + right);
		} else {
			max[0] = Math.max(max[0], root.key + left);
			return Math.max(root.key, left + root.key);
		}
	}

	private int largest(int a, int b, int c, int d) {
		return Math.max(Math.max(Math.max(a, b), c), d);
	}

	// Time complexity is O(n).
	// Space complexity is O(n), because of call-stack, if the binary tree is
	// highly unbalanced.

	// a neater solution... amazing...
	public int maxPathSum2(TreeNode root) {
		int[] max = new int[] { Integer.MIN_VALUE };
		helper2(root, max);
		return max[0];
	}

	private int helper2(TreeNode root, int[] max) {
		if (root == null) {
			return 0;
		}
		int left = helper2(root.left, max);
		int right = helper2(root.right, max);
		left = left < 0 ? 0 : left;
		right = right < 0 ? 0 : right;
		max[0] = Math.max(max[0], root.key + left + right);
		return root.key + Math.max(left, right);
	}

	// The idea is if left < 0, or right < 0, they don't contribute to the path
	// sum

	public static void main(String[] args) {
		MaximumPathSumBinaryTree2 maximumPathSumBinaryTree2 = new MaximumPathSumBinaryTree2();
		TreeNode root = new TreeNode(-1);
		root.left = new TreeNode(-2);
		root.right = new TreeNode(-4);
		root.left.left = new TreeNode(-3);
		root.right.left = new TreeNode(-5);
		System.out.println(maximumPathSumBinaryTree2.maxPathSum2(root));
	}

}
