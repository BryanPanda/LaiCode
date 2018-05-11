package getKeysInBinaryTreeZigZag;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// LeetCode #103 (Binary Tree Zigzag Level Order Traversal).

// Get the list of keys in a given binary tree layer by layer in zig-zag order.

public class GetKeysInBinaryTreeZigZag {

	public List<Integer> zigZag(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Deque<TreeNode> deque = new LinkedList<>();
		deque.offerFirst(root);
		int level = 0;
		while (!deque.isEmpty()) {
			int size = deque.size();
			if (level % 2 == 0) {
				for (int i = 0; i < size; i++) {
					TreeNode node = deque.pollLast();
					result.add(node.key);
					if (node.right != null) {
						deque.offerFirst(node.right);
					}
					if (node.left != null) {
						deque.offerFirst(node.left);
					}
				}
			} else {
				for (int i = 0; i < size; i++) {
					TreeNode node = deque.pollFirst();
					result.add(node.key);
					if (node.left != null) {
						deque.offerLast(node.left);
					}
					if (node.right != null) {
						deque.offerLast(node.right);
					}
				}
			}
			level += 1;
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
