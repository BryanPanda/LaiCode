package lowestCommonAncestor;

// Given two nodes in a binary tree, find their lowest common ancestor.

// Assumptions: 
// 1. There is no parent pointer for the nodes in the binary tree
// 2. The given two nodes are guaranteed to be in the binary tree

public class LowestCommonAncestor {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
		if (root == null || root == one || root == two) {
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, one, two);
		TreeNode right = lowestCommonAncestor(root.right, one, two);
		if (left != null && right != null) {
			return root;
		}
		return left == null ? right : left;
	}

	// Time complexity is O(n).
	// Space complexity is O(n), when the binary tree is highly unbalanced.

	// Follow up from Facebook: What if the binary tree contains billions of
	// nodes?
	// Answer: Map Reduce, with the following situations:
	// 1. both a and b are very shallow;
	// 2. one of them is very shallow: BFS to determine which one, and map
	// reduce to find which machine contains the other, then LCA;
	// 3. both of them are very deep: map reduce LCA.
}
