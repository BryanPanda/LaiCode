package cousinsInBinaryTree;

import java.util.LinkedList;

// Given a binary Tree and the two keys, determine whether the two nodes are cousins
// of each other or not. Two nodes are cousins of each other if they are at the same
// level and have different parents.

// Assumptions:
// 1. It is not guaranteed the two keys are all in the binary tree.
// 2. There are no duplicate keys in the binary tree.

public class CousinsInBinaryTree {

	// solution 1: BFS level order
	public boolean isCousin(TreeNode root, int a, int b) {
		if (root == null) {
			return false;
		}
		// offer last, poll first
		LinkedList<TreeNode> queue = new LinkedList<>();
		TreeNode temp1 = null;
		TreeNode temp2 = null;
		queue.offerLast(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.pollFirst();
				if (cur.left != null) {
					if (cur.left.key == a) {
						temp1 = cur;
					} else if (cur.left.key == b) {
						temp2 = cur;
					}
					queue.offerLast(cur.left);
				}
				if (cur.right != null) {
					if (cur.right.key == a) {
						temp1 = cur;
					} else if (cur.right.key == b) {
						temp2 = cur;
					}
					queue.offerLast(cur.right);
				}
			}
			if (temp1 != null && temp2 != null && temp1 != temp2) {
				return true;
			} else { // temp1 == null || temp2 == null || temp1 == temp2
				// to the level level
				temp1 = null;
				temp2 = null;
			}
		}
		return false;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).

	// solution 2
	public boolean isCousin2(TreeNode root, int a, int b) {
		int aLevel = level(root, a, 1);
		int bLevel = level(root, b, 1);
		// it is not guaranteed that a and b are in the tree
		return (aLevel != 0 && bLevel != 0 && aLevel == bLevel) && !isSibling(root, a, b);
	}

	// find the level of a node in a binary tree
	private int level(TreeNode root, int val, int level) {
		// base case
		if (root == null) {
			return 0;
		}
		if (root.key == val) {
			return level;
		}
		int l = level(root.left, val, level + 1);
		if (l != 0) {
			return l;
		}
		return level(root.right, val, level + 1);
	}

	private boolean isSibling(TreeNode root, int a, int b) {
		// base case
		if (root == null) {
			return false;
		}
		if (root.left != null && root.right != null) {
			if ((root.left.key == a && root.right.key == b) || (root.left.key == b && root.right.key == a)) {
				return true;
			}
		}
		// root.left = null || root.right == null
		if (root.left != null) {
			if (isSibling(root.left, a, b)) {
				return true;
			}
		}
		if (root.right != null) {
			if (isSibling(root.right, a, b)) {
				return true;
			}
		}
		return false;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).

	public static void main(String[] args) {
		CousinsInBinaryTree cousinsInBinaryTree = new CousinsInBinaryTree();
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.left.right.right = new TreeNode(8);
		root.left.right.right.left = new TreeNode(7);
		System.out.println(cousinsInBinaryTree.isCousin2(root, 1, 3));
	}
}
