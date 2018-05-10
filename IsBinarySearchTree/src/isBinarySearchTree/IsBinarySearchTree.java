package isBinarySearchTree;

import java.util.LinkedList;

// LeetCode #98 (Validate Binary Search Tree).

// Determine if a given binary tree is binary search tree.

public class IsBinarySearchTree {

	// recursive solution
	public boolean isBST1(TreeNode root) {
		return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	// both min and max are inclusive
	private boolean helper(TreeNode root, int min, int max) {
		// base case
		if (root == null) {
			return true;
		}
		if (root.key < min || root.key > max) {
			return false;
		}
        if ((root.key == Integer.MIN_VALUE && root.left != null) || 
    		(root.key == Integer.MAX_VALUE && root.right != null)) 
		{
        	return false;
        }
        // up to this point, root.key >= min && root.key <= max
		return helper(root.left, min, root.key - 1) && helper(root.right, root.key + 1, max);
	}

	// Time complexity is O(n).
	// Space complexity is O(n), when the BST is highly unbalanced.
	
	// iterative solution: in-order traversal of a BST is monotonically increasing
	public boolean isBST2(TreeNode root) {
		LinkedList<TreeNode> stack = new LinkedList<>();
		TreeNode cur = root, prev = null;
		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				stack.offerFirst(cur);
				cur = cur.left;
			}
			else {
				cur = stack.pollFirst();
				if (prev != null && prev.key >= cur.key) {
					return false;
				}
				prev = cur;
				cur = cur.right;
			}
		}
		return true;
	}
	
	// Time complexity is O(n).
	// Space complexity is O(n), but since object is stored on heap, iterative solution 
	// avoids stack overflow.
}
