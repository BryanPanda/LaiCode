package rightViewOfBinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// LeetCode #199 (Binary Tree Right Side View).

// Given a Binary Tree, return the right view of it. Right view of a Binary Tree
// is list of nodes visible when tree is visited from right side, the order of the
// nodes in the list should be from top to bottom level of the original tree.

public class RightViewOfBinaryTree {

	// BFS
	public List<Integer> rightView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offerLast(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.pollFirst();
				if (i == size - 1) {
					result.add(node.key);
				}
				if (node.left != null) {
					queue.offerLast(node.left);
				}
				if (node.right != null) {
					queue.offerLast(node.right);
				}
			}
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
