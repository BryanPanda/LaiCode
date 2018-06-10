package findAllBinarySearchTrees;

import java.util.ArrayList;
import java.util.List;

// Given a number n, generate all possible BST from 1, ..., n.

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
	
	// Time complexity is ...
	// Space complexity is O(n).
	
	// Note: Obviously there are repetitive computations, so DP is a better approach.
}
