package recoverBinarySearchTree;

import java.util.LinkedList;

// LeetCode #99 (Recover Binary Search Tree).

// Given a Binary Search Tree with only two nodes swapped. 
// Try to find them and recover the binary search tree.

public class RecoverBinarySearchTree {

	// Solution 1: recursive in-order traversal
	private TreeNode first;
	private TreeNode second;
	private TreeNode prev = new TreeNode(Integer.MIN_VALUE);

	public TreeNode recover(TreeNode root) {
		helper(root);
		swap(first, second);
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
	
	private void swap(TreeNode one, TreeNode two) {
		int temp = one.key;
		one.key = two.key;
		two.key = temp;
	}

	// Time complexity is O(n).
	// Space complexity is O(n), if the BST is highly unbalanced.
	
	// Solution 2: iterative in-order traversal with stack
	public TreeNode recover2(TreeNode root) {
		TreeNode first = null, second = null;
		TreeNode cur = root, prev = new TreeNode(Integer.MIN_VALUE);
		LinkedList<TreeNode> stack = new LinkedList<>();
		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				stack.offerLast(cur);
				cur = cur.left;
			} else {
				cur = stack.pollLast();
				if (prev.key >= cur.key && first == null) {
					first = prev;
				}
				if (prev.key >= cur.key && first != null) {
					second = cur;
				}
				prev = cur;
				cur = cur.right;
			}
		}
		// swap first and second
		swap(first, second);
		return root;
	}
	
	// Time complexity is O(n).
	// Space complexity is O(n).

	// Solution 3: iterative in-order traversal (Morris)
	public TreeNode recover3(TreeNode root) {
		TreeNode first = null, second = null;
		TreeNode cur = root, prev = null, node = null;
		while (cur != null) {
			// compare
			if (prev != null && prev.key >= cur.key && first == null) {
				first = prev;
			}
			if (prev != null && prev.key >= cur.key && first != null) {
				second = cur;
			}
			// Morris
			if (cur.left == null) {
				prev = cur;
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
					prev = cur;
					cur = cur.right;
				}
			}
		}
		swap(first, second);
		return root;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
