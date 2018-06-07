package binaryTreePathSumToTarget3;

import java.util.HashSet;
import java.util.Set;

// Given a binary tree in which each node contains an integer number.

// Determine if there exists a path (the path can only be from one node to itself or to any of its 
// descendants), the sum of the numbers on the path is the given target number.

public class BinaryTreePathSumToTarget3 {
	
	public boolean exist(TreeNode root, int target) {
		if (root == null) {
			return false;
		}
		Set<Integer> prefixSums = new HashSet<>();
		prefixSums.add(0);
		return DFS(root, target, 0, prefixSums);
	}

	private boolean DFS(TreeNode root, int target, int prefixSum, Set<Integer> prefixSums) {
		prefixSum += root.key;
		if (prefixSums.contains(prefixSum - target)) {
			return true;
		}
		// add
		boolean needRemove = prefixSums.add(prefixSum);
		// dfs
		if (root.left != null && DFS(root.left, target, prefixSum, prefixSums)) {
			return true;
		}
		if (root.right != null && DFS(root.right, target, prefixSum, prefixSums)) {
			return true;
		}
		// remove
		if (needRemove) {
			prefixSums.remove(prefixSum);
		}
		return false;
	}

	// Time complexity is O(n).
	// Space complexity is O(n), if binary tree is highly unbalanced (SubarraySumToTarget,
	// LeetCode #523, #560).
	
	// Follow up: return the total number of paths that sum to target (LeetCode #437 Path Sum III).
}