package binaryTreePathSumToTarget3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Given a binary tree in which each node contains an integer number.

// Determine if there exists a path (the path can only be from one node to itself or to any of its 
// descendants), the sum of the numbers on the path is the given target number.

public class BinaryTreePathSumToTarget3 {

	// solution 1
	public boolean exist(TreeNode root, int target) {
		if (root == null) {
			return false;
		}
		List<TreeNode> path = new ArrayList<>();
		return helper(root, target, path);
	}

	private boolean helper(TreeNode root, int target, List<TreeNode> path) {
		path.add(root);
		if (root.left != null && helper(root.left, target, path)) {
			return true;
		}
		if (root.right != null && helper(root.right, target, path)) {
			return true;
		}
		int temp = 0;
		for (int i = path.size() - 1; i >= 0; i--) {
			temp += path.get(i).key;
			if (temp == target) {
				return true;
			}
		}
		path.remove(path.size() - 1);
		return false;
	}

	// Time complexity is O(n^2).
	// Space complexity is O(n), because of call-stack, if the binary tree is
	// highly unbalanced.

	// solution 2: hash map
	public boolean exist2(TreeNode root, int target) {
		if (root == null) {
			return false;
		}
		Set<Integer> prefixSums = new HashSet<>();
		prefixSums.add(0);
		return helper2(root, prefixSums, 0, target);
	}

	private boolean helper2(TreeNode root, Set<Integer> prefixSums, int prevSum, int target) {
		prevSum += root.key;
		boolean needRemove = prefixSums.add(prevSum);
		// push down as deep as we can
		if (root.left != null && helper2(root.left, prefixSums, prevSum, target)) {
			return true;
		}
		if (root.right != null && helper2(root.right, prefixSums, prevSum, target)) {
			return true;
		}
		if (prefixSums.contains(prevSum - target)) {
			return true;
		}
		// up to this point, the current root node cannot be in the path
		// therefore, if prevSum doesn't exist before, it has to be removed
		if (needRemove) {
			prefixSums.remove(prevSum);
		}
		return false;
	}

	// Time complexity is O(n).
	// Space complexity is O(n), if binary tree is highly unbalanced,
	// which turns this problem to: Determine, in an integer array, whether
	// there exists a sub-array that sums up to a target value.
}
