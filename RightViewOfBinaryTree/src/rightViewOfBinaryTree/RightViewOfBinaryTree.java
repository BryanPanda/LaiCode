package rightViewOfBinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// Given a Binary Tree, return the right view of it. Right view of a Binary Tree
// is list of nodes visible when tree is visited from right side, the order of the
// nodes in the list should be from top to bottom level of the original tree.

public class RightViewOfBinaryTree {

	public List<Integer> rightView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		LinkedList<TreeNode> queue = new LinkedList<>(); // offerLast, pollFirst
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

	public static void main(String[] args) {
		RightViewOfBinaryTree rightViewOfBinaryTree = new RightViewOfBinaryTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.left.left.left = new TreeNode(9);
		root.right.left.right = new TreeNode(8);
		root.left.left.left.left = new TreeNode(10);
		root.left.left.left.right = new TreeNode(11);
		System.out.println(Arrays.toString(rightViewOfBinaryTree.rightView(root).toArray()));
	}

}
