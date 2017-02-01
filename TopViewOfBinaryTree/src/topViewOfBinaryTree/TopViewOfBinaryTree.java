package topViewOfBinaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// Given a binary tree, get the top view of it. The nodes in the output list
// should be from left to right. A node x belongs to the output if x is the 
// topmost node at its column.

public class TopViewOfBinaryTree {

	static class Combo {
		TreeNode node;
		int distance;

		public Combo(TreeNode node, int distance) {
			this.node = node;
			this.distance = distance;
		}
	}

	public List<Integer> topView(TreeNode root) {
		LinkedList<Integer> result = new LinkedList<>();
		if (root == null) {
			return result;
		}
		// root != null
		result.add(root.key);
		int leftDis = 0;
		int rightDis = 0;
		LinkedList<Combo> queue = new LinkedList<>(); // offerLast, pollFirst
		if (root.left != null) {
			queue.offerLast(new Combo(root.left, -1));
		}
		if (root.right != null) {
			queue.offerLast(new Combo(root.right, 1));
		}
		while (!queue.isEmpty()) {
			Combo combo = queue.pollFirst();
			// add to result?
			if (combo.distance < leftDis) {
				result.offerFirst(combo.node.key);
				leftDis = combo.distance;
			}
			if (combo.distance > rightDis) {
				result.offerLast(combo.node.key);
				rightDis = combo.distance;
			}
			// add to queue?
			if (combo.node.left != null) {
				queue.add(new Combo(combo.node.left, combo.distance - 1));
			}
			if (combo.node.right != null) {
				queue.add(new Combo(combo.node.right, combo.distance + 1));
			}
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).

	public static void main(String[] args) {
		TopViewOfBinaryTree topViewOfBinaryTree = new TopViewOfBinaryTree();
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(9);
		System.out.println(Arrays.toString(topViewOfBinaryTree.topView(root).toArray()));
	}

}
