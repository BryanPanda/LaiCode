package findAllBinarySearchTrees;

import java.util.ArrayList;
import java.util.List;

// LeetCode #95 (Unique Binary Search Trees II).

// Given a number n, generate all possible BSTs from 1, ..., n.

public class FindAllBinarySearchTrees {

	public List<TreeNode> generateBSTs(int n) {
		return generateBSTs(1, n);
	}

	private List<TreeNode> generateBSTs(int start, int end) {
		List<TreeNode> result = new ArrayList<>();
		if (start > end) {
			result.add(null);
			return result;
		}
		for (int i = start; i <= end; i++) {
			List<TreeNode> left = generateBSTs(start, i - 1);
			List<TreeNode> right = generateBSTs(i + 1, end);
			for (TreeNode l : left) {
				for (TreeNode r : right) {
					TreeNode root = new TreeNode(i);
					root.left = l;
					root.right = r;
					result.add(root);
				}
			}
		}
		return result;
	}
	
	// Time complexity is O(catalan(n)). See https://en.wikipedia.org/wiki/Catalan_number.
	// Space complexity is O(n).
	
	// DP
}
