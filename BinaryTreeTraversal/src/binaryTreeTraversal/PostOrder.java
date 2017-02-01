package binaryTreeTraversal;

import java.util.*;

public class PostOrder {

	public List<Integer> postOrder(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		// base case
		if (root == null) {
			return result;
		}
		result.addAll(postOrder(root.left));
		result.addAll(postOrder(root.right));
		result.add(root.key);
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
	// Stack might overflow.

	public List<Integer> postOrder2(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		LinkedList<TreeNode> stack = new LinkedList<>();
		stack.offerFirst(root);
		TreeNode prev = null;
		while (!stack.isEmpty()) {
			TreeNode cur = stack.peekFirst();
			// when prev is cur's parent, we are traversing down the tree
			if (prev == null || prev.left == cur || prev.right == cur) {
				// if left child is not null, push it to stack
				if (cur.left != null) {
					stack.offerFirst(cur.left);
				} else if (cur.right != null) {
					// if right child is not null, push it to stack
					stack.offerFirst(cur.right);
				} else {
					stack.pollFirst();
					result.add(cur.key);
				}
			}
			// when prev is cur's left child, we are traversing up the tree from
			// the left
			else if (cur.left == prev) {
				if (cur.right != null) {
					// if right child is not null, push it to stack
					stack.offerFirst(cur.right);
				} else {
					stack.pollFirst();
					result.add(cur.key);
				}
			}
			// when prev is cur's right child, we are traversing up the tree
			// from the right
			else if (cur.right == prev) {
				stack.pollFirst();
				result.add(cur.key);
			}
			prev = cur;
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
	// No stack overflow.

	public List<Integer> postOrder3(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		TreeNode dummy = new TreeNode(0);
		dummy.left = root;
		TreeNode cur = dummy;
		TreeNode pred, first, middle, last;
		while (cur != null) {
			if (cur.left == null) {
				cur = cur.right;
			} else {
				pred = cur.left;
				// find inOrder predecessor
				while (pred.right != null && pred.right != cur) {
					pred = pred.right;
				}
				// if right child of predecessor is null, set it to be cur
				if (pred.right == null) {
					pred.right = cur;
					cur = cur.left;
				}
				// if right child of predecessor is cur, set it to null
				else {
					first = cur;
					middle = cur.left;
					while (middle != cur) {
						last = middle.right;
						middle.right = first;
						first = middle;
						middle = last;
					}
					first = cur;
					middle = pred;
					while (middle != cur) {
						result.add(middle.key);
						last = middle.right;
						middle.right = first;
						first = middle;
						middle = last;
					}
					pred.right = null;
					cur = cur.right;
				}
			}
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
	// No stack overflow.

	public List<Integer> postOrder4(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		LinkedList<TreeNode> stack1 = new LinkedList<>();
		LinkedList<TreeNode> stack2 = new LinkedList<>();
		stack1.offerFirst(root);
		while (!stack1.isEmpty()) {
			TreeNode node = stack1.pollFirst();
			if (node != null) {
				stack2.offerFirst(node);
				if (node.left != null) {
					stack1.offerFirst(node.left);
				}
				if (node.right != null) {
					stack1.offerFirst(node.right);
				}
			}
		}
		while (!stack2.isEmpty()) {
			result.add(stack2.pollFirst().key);
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
	// No stack overflow.
}
