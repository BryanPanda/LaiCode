package validPostOrderTraversalOfBST;

// Given an array with integers, determine whether the array contains a valid post-order traversal sequence of a BST.

// Assumption: The given post-order traversal array is not null.

public class ValidPostOrderTraversalOfBST {

	public boolean validPostOrder(int[] post) {
		if (post.length <= 1) {
			return true;
		}
		return validPostOrder(post, 0, post.length - 1);
	}

	private boolean validPostOrder(int[] post, int left, int right) {
		// base case
		if (left >= right) {
			return true;
		}
		// check on the current level
		int index = -1;
		for (int i = left; i <= right - 1; i++) {
			if (post[i] > post[right]) {
				index = i;
				break;
			}
		}
		if (index != -1) {
			for (int i = index; i <= right - 1; i++) {
				if (post[i] < post[right]) {
					return false;
				}
			}
		}
		// so far so good on the current level
		// recursive rule
		return validPostOrder(post, left, Math.max(left, index - 1))
				&& validPostOrder(post, Math.max(left, index), right - 1);
	}

	// Time complexity: O(n * log(n)) if BST is balanced, and O(n^2) if BST is
	// unbalanced.
	// Space complexity is O(log(n)) and O(n) for balanced and unbalanced BST,
	// respectively.

	public static void main(String[] args) {
		ValidPostOrderTraversalOfBST validPostOrderTraversalOfBST = new ValidPostOrderTraversalOfBST();
		int[] post = new int[] { 9, 5, 4, 8, 7, 2 };
		System.out.println(validPostOrderTraversalOfBST.validPostOrder(post));
	}
}
