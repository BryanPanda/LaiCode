package closestNumberInBinarySearchTree2;

import java.util.LinkedList;
import java.util.List;

// LeetCode #272 (Closest Binary Search Tree Value II).

public class ClosestNumberInBinarySearchTree2 {
	
	// in-order traversal
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		LinkedList<Integer> result = new LinkedList<>();
		TreeNode cur = root;
		while (cur != null) {
			if (cur.left == null) {
				add(target, k, cur.key, result);
				cur = cur.right;
			} else {
				TreeNode node = cur.left;
				while (node.right != null && node.right != cur) {
					node = node.right;
				}
				if (node.right == null) {
					node.right = cur;
					cur = cur.left;
				} else {
					add(target, k, cur.key, result);
					cur = cur.right;
				}
			}
		}
		return result;
	}

	private void add(double target, int k, int val, LinkedList<Integer> result) {
		if (result.size() < k) {
			result.offerLast(val);
		} else if (Math.abs(result.peekFirst() - target) > Math.abs(val - target)) {
			result.pollFirst();
			result.offerLast(val);
		}
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
