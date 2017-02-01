package recoverBinarySearchTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Given a Binary Search Tree with only two nodes swapped. 
// Try to find them and recover the binary search tree.

public class RecoverBinarySearchTree {

	private TreeNode one;
	private TreeNode two;
	private TreeNode temp;

	// use the inorder Morris traversal
	public TreeNode recover(TreeNode root) {
		TreeNode cur = root, node = null;
		while (cur != null) {
			if (cur.left == null) {
				if (cur.right != null && cur.key > cur.right.key && one == null) {
					one = cur;
					temp = cur.right;
				} else if (cur.right != null && cur.key > cur.right.key && two == null) {
					two = cur.right;
				}
				cur = cur.right;
			} else {
				node = cur.left;
				while (node.right != null && node.right != cur) {
					node = node.right;
				}
				if (node.right == null) {
					node.right = cur;
					cur = cur.left;
				} else {
					node.right = null;
					if (cur.right != null && cur.key > cur.right.key && one == null) {
						one = cur;
						temp = cur.right;
					} else if (cur.right != null && cur.key > cur.right.key && two == null) {
						two = cur.right;
					}
					cur = cur.right;
				}
			}
		}
		// but notice that the relationship between root node and the left most
		// node in the right subtree is not checked
		cur = root;
		node = cur.right;
		if (node != null) {
			while (node.left != null) {
				node = node.left;
			}
			if (cur.key > node.key && one == null) {
				one = cur;
				temp = node;
			} else if (cur.key > node.key && two == null) {
				two = node;
			}
		}
		if (two == null) {
			// swap one and temp
			int i = one.key;
			one.key = temp.key;
			temp.key = i;
		} else {
			// swap one and two
			int i = one.key;
			one.key = two.key;
			two.key = i;
		}
		return root;
	}

	private List<Integer> inOrder(TreeNode root) {
		// base case
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		result.addAll(inOrder(root.left));
		result.add(root.key);
		result.addAll(inOrder(root.right));
		return result;
	}

	// okay, but is Morris really needed?
	private TreeNode first;
	private TreeNode second;
	private TreeNode prev = new TreeNode(Integer.MIN_VALUE);

	public TreeNode recover2(TreeNode root) {
		helper(root);
		// swap first and second
		int temp = first.key;
		first.key = second.key;
		second.key = temp;
		return root;
	}

	private void helper(TreeNode root) {
		if (root == null) {
			return;
		}
		helper(root.left);
		if (prev.key >= root.key && first == null) {
			first = prev;
		}
		if (prev.key >= root.key && first != null) {
			second = root;
		}
		prev = root;
		helper(root.right);
	}

	// Time complexity is O(n).
	// Space complexity is O(n), when BST is unbalanced.

	public static void main(String[] args) {
		RecoverBinarySearchTree recoverBinarySearchTree = new RecoverBinarySearchTree();
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(7);
		root = recoverBinarySearchTree.recover2(root);
		System.out.println(Arrays.toString(recoverBinarySearchTree.inOrder(root).toArray()));
	}

}
