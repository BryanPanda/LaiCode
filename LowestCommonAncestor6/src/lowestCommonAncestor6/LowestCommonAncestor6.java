package lowestCommonAncestor6;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Given K nodes in a k-ary tree, find their lowest common ancestor.

// Assumptions:
// 1. K >= 2
// 2. There is no parent pointer for the nodes in the k-ary tree
// 3. The given K nodes are guaranteed to be in the binary tree

public class LowestCommonAncestor6 {

	public TreeNodeK lowestCommonAncestor(TreeNodeK root, List<TreeNodeK> nodes) {
		Set<TreeNodeK> set = new HashSet<>(nodes);
		return helper(root, set);
	}

	private TreeNodeK helper(TreeNodeK root, Set<TreeNodeK> set) {
		// base case
		if (root == null || set.contains(root)) {
			return root;
		}
		int count = 0;
		TreeNodeK temp = null;
		for (TreeNodeK child : root.children) {
			TreeNodeK node = helper(child, set);
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
