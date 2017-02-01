package maximumPathSumBinaryTree3;

// Given a binary tree in which each node contains an integer number. 
// Find the maximum possible sub-path sum (both the starting and ending node
// of the sub-path should be on the same path from root to one of the leaf nodes, 
// and the sub-path is allowed to contain only one node).

public class MaximumPathSumBinaryTree3 {

	public int maxPathSum(TreeNode root) {
		int[] max = new int[] { Integer.MIN_VALUE };
		helper(root, max);
		return max[0];
	}

	private int helper(TreeNode root, int[] max) {
		if (root == null) {
			return 0;
		}
		int left = helper(root.left, max);
		int right = helper(root.right, max);
		if (root.left != null && root.right != null) {
			max[0] = Math.max(max[0], largest(left + root.key, root.key, right + root.key));
			return largest(left + root.key, root.key, right + root.key);
		}
		if (root.left == null) {
			max[0] = Math.max(max[0], Math.max(root.key, root.key + right));
			return Math.max(root.key, root.key + right);
		} else {
			max[0] = Math.max(max[0], Math.max(left + root.key, root.key));
			return Math.max(left + root.key, root.key);
		}
	}

	// helper can be simplified
	private int helper2(TreeNode root, int[] max) {
		if (root == null) {
			return 0;
		}
		int left = helper(root.left, max);
		int right = helper(root.right, max);
		left = left < 0 ? 0 : left;
		right = right < 0 ? 0 : right;
		max[0] = Math.max(max[0], root.key + Math.max(left, right));
		return root.key + Math.max(left, right);
	}

	private int largest(int a, int b, int c) {
		return Math.max(Math.max(a, b), c);
	}

	// Time complexity is O(n).
	// Space complexity is O(n), because of call-stack, if the binary tree is
	// highly unbalanced.

	public static void main(String[] args) {
		MaximumPathSumBinaryTree3 maximumPathSumBinaryTree3 = new MaximumPathSumBinaryTree3();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(11);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(14);
		root.right.right.left = new TreeNode(-3);
		System.out.println(maximumPathSumBinaryTree3.maxPathSum(root));
	}

}
