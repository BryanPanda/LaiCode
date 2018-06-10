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
	// M[i]: all possible BSTs from 1, ..., i.
	public List<TreeNode> generateBSTs2(int n) {
		List<TreeNode>[] M = new List[n + 1];
		M[0] = new ArrayList<TreeNode>();
		M[0].add(null);
		if (n == 0) {
			return M[0];
		}
		for (int i = 1; i <= n; i++) {
			M[i] = new ArrayList<TreeNode>();
			for (int j = 1; j <= i; j++) { // let j be root
				List<TreeNode> left = M[j - 1];
				List<TreeNode> right = M[i - j];
				for (TreeNode l : left) {
					for (TreeNode r : right) {
						TreeNode root = new TreeNode(j);
						root.left = l;
						root.right = increment(r, j);
						M[i].add(root);
					}
				}
			}
		}
		return M[n];
	}
	
	// increment the subtree by offset
	private TreeNode increment(TreeNode root, int offset) {
		if (root == null) {
			return null;
		}
		TreeNode newRoot = new TreeNode(root.key + offset); // base case
		newRoot.left = increment(root.left, offset);
		newRoot.right = increment(root.right, offset);
		return newRoot;
	}
	
	// Time complexity is ...
	// Space complexity is O(catalan(n)).
}
