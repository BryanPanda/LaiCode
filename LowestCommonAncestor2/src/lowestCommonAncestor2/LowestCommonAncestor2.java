package lowestCommonAncestor2;

// Given two nodes in a binary tree (with parent pointer available), 
// find their lowest common ancestor.

// Assumptions:
// 1. There is parent pointer for the nodes in the binary tree
// 2. The given two nodes are not guaranteed to be in the binary tree

public class LowestCommonAncestor2 {

	public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
		int l1 = length(one);
		int l2 = length(two);
		if (l1 <= l2) {
			return helper(one, two, l2 - l1);
		} else {
			return helper(two, one, l1 - l2);
		}
	}

	private TreeNodeP helper(TreeNodeP shorter, TreeNodeP longer, int diff) {
		while (diff > 0) {
			longer = longer.parent;
			diff--;
		}
		while (shorter != longer) {
			shorter = shorter.parent;
			longer = longer.parent;
		}
		return shorter;
	}

	private int length(TreeNodeP node) {
		int length = 0;
		while (node != null) {
			node = node.parent;
			length++;
		}
		return length;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
