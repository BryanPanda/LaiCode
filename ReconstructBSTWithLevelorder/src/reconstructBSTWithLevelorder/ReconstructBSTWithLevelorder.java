package reconstructBSTWithLevelorder;

import java.util.ArrayList;
import java.util.List;

// Given the levelorder traversal sequence of a binary search tree, reconstruct the original tree.

// Assumption:
// 1. The given sequence is not null
// 2. There are no duplicate keys in the binary search tree

public class ReconstructBSTWithLevelorder {

	public TreeNode reconstruct(int[] level) {
		List<Integer> list = new ArrayList<>();
		for (int i : level) {
			list.add(i);
		}
		return helper(level, list);
	}

	private TreeNode helper(int[] level, List<Integer> list) {
		if (list.isEmpty()) {
			return null;
		}
		TreeNode root = new TreeNode(list.get(0));
		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();
		for (int i : list) {
			if (i < root.key) {
				left.add(i);
			} else if (i > root.key) {
				right.add(i);
			}
		}
		root.left = helper(level, left);
		root.right = helper(level, right);
		return root;
	}

	// Time complexity is O(n^2) in the worst case, but O(n*log(n)) in the
	// average case.
	// Space complexity is O(n) in the worst case, but O(log(n)) in the average
	// case.
}
