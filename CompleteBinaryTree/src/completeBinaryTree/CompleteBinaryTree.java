package completeBinaryTree;

import java.util.LinkedList;

// Check if a given binary tree is completed. A complete binary tree is one in which every
// level of the binary tree is completely filled except possibly the last level. Furthermore,
// all nodes are as far left as possible.

public class CompleteBinaryTree {

	public boolean isComplete(TreeNode root) {
		if (root == null) {
			return true;
		}
		boolean flag = false;
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offerLast(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.pollFirst();
			// left node
			if (node.left == null) {
				flag = true;
			} else if (flag) {
				return false;
			} else {
				queue.offerLast(node.left);
			}
			// right node
			if (node.right == null) {
				flag = true;
			} else if (flag) {
				return false;
			} else {
				queue.offerLast(node.right);
			}
		}
		return true;
	}

	// Time complexity is O(n).
	// Space complexity is O(n), since the last layer of a binary tree contains 
	// half the total number of nodes.
}
