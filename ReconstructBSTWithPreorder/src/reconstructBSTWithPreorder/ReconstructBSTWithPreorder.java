package reconstructBSTWithPreorder;

// Given the preorder traversal sequence of a binary search tree, reconstruct the original tree.

// Assumption:
// 1. The given sequence is not null
// 2. There are no duplicate keys in the binary search tree

public class ReconstructBSTWithPreorder {

	public TreeNode reconstruct(int[] pre) {
		int[] index = new int[] { 0 };
		return helper(pre, index, Integer.MAX_VALUE);
	}

	private TreeNode helper(int[] pre, int[] index, int max) {
		if (index[0] >= pre.length || pre[index[0]] > max) {
			return null;
		}
		TreeNode root = new TreeNode(pre[index[0]++]);
		root.left = helper(pre, index, root.key);
		root.right = helper(pre, index, max);
		return root;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
