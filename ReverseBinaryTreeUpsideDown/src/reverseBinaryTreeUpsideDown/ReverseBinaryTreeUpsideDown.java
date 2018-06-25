package reverseBinaryTreeUpsideDown;

// LeetCode #156 (Binary Tree Upside Down).

// Given a binary tree where all the right nodes are leaf nodes, 
// flip it upside down and turn it into a tree with left leaf nodes
// as the root.

public class ReverseBinaryTreeUpsideDown {

	// recursive
	public TreeNode reverse(TreeNode root) {
		if (root == null || root.left == null) {
			return root;
		}
		TreeNode newRoot = reverse(root.left);
		root.left.left = root;
		root.left.right = root.right;
		root.left = null;
		root.right = null;
		return newRoot;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).

	// iterative
	public TreeNode reverse2(TreeNode root) {
		TreeNode cur = root;
		TreeNode left = null, prev = null, temp = null, right = null;
		while (cur != null) {
			left = cur.left;
			right = cur.right;
			cur.left = prev;
			cur.right = temp;
			prev = cur;
			cur = left;
			temp = right;
		}
		return prev;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
