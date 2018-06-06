package largestNumberSmallerInBinarySearchTree;

// In a binary search tree, find the node containing the largest number smaller than the given target number.
// If there is no such number, return INT_MIN.

// Assumption:
// 1. The given root is not null.
// 2. There are no duplicate keys in the binary search tree.

public class LargestNumberSmallerInBinarySearchTree {

	public int largestSmaller(TreeNode root, int target) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		if (root.key >= target) {
			return largestSmaller(root.left, target);
		} else {
			int right = largestSmaller(root.right, target);
			return right == Integer.MIN_VALUE ? root.key : right;
		}
	}

	// Time complexity is O(n).
	// Space complexity is O(n).

	// iterative solution
	public int largestSmaller2(TreeNode root, int target) {
		int result = Integer.MIN_VALUE;
		while (root != null) {
			if (root.key >= target) {
				root = root.left;
			} else {
				result = root.key;
				root = root.right;
			}
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}