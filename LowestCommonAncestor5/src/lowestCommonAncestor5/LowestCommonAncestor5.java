package lowestCommonAncestor5;

// Given two nodes in a k-ary tree, find their lowest common ancestor.

// Assumptions: 
// 1. There is no parent pointer for the nodes in the binary tree
// 2. The given two nodes are guaranteed to be in the binary tree

public class LowestCommonAncestor5 {

	public TreeNodeK lowestCommonAncestor(TreeNodeK root, TreeNodeK one, TreeNodeK two) {
		if (root == null || root == one || root == two) {
			return root;
		}
		int count = 0;
		TreeNodeK temp = null;
		for (TreeNodeK child : root.children) {
			TreeNodeK node = lowestCommonAncestor(child, one, two);
			if (node != null) {
				count++;
				if (count == 2) {
					return root;
				}
				temp = node;
			}
		}
		return temp;
	}

	// Time complexity is O(n).
	// Space complexity is O(n) because of call-stack, if the binary tree is
	// highly unbalanced.
}

