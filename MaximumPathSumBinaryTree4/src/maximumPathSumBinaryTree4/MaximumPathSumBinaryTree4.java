package maximumPathSumBinaryTree4;

// Given a binary tree in which each node contains an integer number. 
// Find the maximum possible sub-path sum from root node to leaf node.

// Assumption: root != null

public class MaximumPathSumBinaryTree4 {

	// solution 1
	public int maxPathSum(TreeNode root) {
		if (root.left == null && root.right == null) {
			return root.key;
		}
		// root.left != null || root.right != null
		int left = (root.left == null) ? 0 : maxPathSum(root.left);
		int right = (root.right == null) ? 0 : maxPathSum(root.right);
		return root.key + Math.max(left, right);
	}

	// Time complexity is O(n).
	// Space complexity is O(n), if the binary tree is highly unbalanced.

	// solution 2: bottom up return the max suffix sum
	public int maxPathSum2(TreeNode root) {
		if (root.left == null && root.right == null) {
			return root.key;
		}
		if (root.left == null) {
			return maxPathSum2(root.right) + root.key;
		}
		if (root.right == null) {
			return maxPathSum2(root.left) + root.key;
		}
		return root.key + Math.max(maxPathSum2(root.left), maxPathSum2(root.right));
	}

	// Time complexity is O(n).
	// Space complexity is O(n), if the binary tree is highly unbalanced.

	// solution 3: top down pass the prefix sum
	public int maxPathSum3(TreeNode root) {
		return helper(root, 0);
	}

	public int helper(TreeNode root, int prefixSum) {
		prefixSum += root.key;
		if (root.left == null && root.right == null) {
			return prefixSum;
		} else if (root.left == null) {
			return helper(root.right, prefixSum);
		} else if (root.right == null) {
			return helper(root.left, prefixSum);
		}
		return Math.max(helper(root.left, prefixSum), helper(root.right, prefixSum));
	}

	// Time complexity is O(n).
	// Space complexity is O(n), if the binary tree is highly unbalanced.

	public static void main(String[] args) {
		MaximumPathSumBinaryTree4 maximumPathSumBinaryTree4 = new MaximumPathSumBinaryTree4();
		TreeNode root = new TreeNode(3);
		System.out.println(maximumPathSumBinaryTree4.maxPathSum(root));
		root = new TreeNode(-1);
		System.out.println(maximumPathSumBinaryTree4.maxPathSum(root));
		root.left = new TreeNode(2);
		System.out.println(maximumPathSumBinaryTree4.maxPathSum(root));
		root.right = new TreeNode(4);
		System.out.println(maximumPathSumBinaryTree4.maxPathSum(root));
		root.left.left = new TreeNode(-5);
		System.out.println(maximumPathSumBinaryTree4.maxPathSum(root));
		root.left.left.right = new TreeNode(7);
		System.out.println(maximumPathSumBinaryTree4.maxPathSum(root));
		root.left.left.left = new TreeNode(10);
		System.out.println(maximumPathSumBinaryTree4.maxPathSum(root));
	}
}
