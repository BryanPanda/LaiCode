package lowestCommonAncestorBST;

// LeetCode #235 (Lowest Common Ancestor of a Binary Search Tree).

// Given two keys in a binary search tree, find their lowest common ancestor.

// Assumptions:
// 1. There is no parent pointer for the nodes in the binary search tree
// 2. There are no duplicate keys in the binary search tree
// 3. The given two nodes are guaranteed to be in the binary search tree

public class LowestCommonAncestorBST {

	public TreeNode lca(TreeNode root, int p, int q) {
		while ((root.key - p) * (root.key - q) > 0) {
			root = root.key > p ? root.left : root.right;
		}
		return root;
	}

	// Time complexity is O(n), when the BST is highly unbalanced.
	// Space complexity is O(1).
}
