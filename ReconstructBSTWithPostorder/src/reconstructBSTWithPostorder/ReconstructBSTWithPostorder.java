package reconstructBSTWithPostorder;

// Given the postorder traversal sequence of a binary search tree, reconstruct the original tree.

// Assumption:
// 1. The given sequence is not null
// 2. There are no duplicate keys in the binary search tree

public class ReconstructBSTWithPostorder {

	public TreeNode reconstruct(int[] post) {
		int[] index = new int[] { post.length - 1 };
		return helper(post, index, Integer.MIN_VALUE);
	}

	private TreeNode helper(int[] post, int[] index, int min) {
		if (index[0] < 0 || post[index[0]] < min) {
			return null;
		}
		TreeNode root = new TreeNode(post[index[0]--]);
		root.right = helper(post, index, root.key);
		root.left = helper(post, index, min);
		return root;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
	// Understand the reason of passing in int[] index, instead of int index

	public static void main(String[] args) {
		ReconstructBSTWithPostorder reconstructBSTWithPostorder = new ReconstructBSTWithPostorder();
		reconstructBSTWithPostorder.reconstruct(new int[] { 1, 4, 3, 11, 8, 5 });
	}
}
