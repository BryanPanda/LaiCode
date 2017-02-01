package binaryTreeDiameter;

// Given a binary tree in which each node contains an integer number. 
// The diameter is defined as the longest distance from one leaf node to another leaf node. 
// The distance is the number of nodes on the path.
// If there does not exist any such paths, return 0.

public class BinaryTreeDiameter {

	public int diameter(TreeNode root) {
		int[] max = new int[] { 0 };
		helper(root, max);
		return max[0];
	}

	private int helper(TreeNode root, int[] max) {
		if (root == null) {
			return 0;
		}
		int left = helper(root.left, max);
		int right = helper(root.right, max);
		// if root.left == null || root.right == null
		// don't update max[0]
		if (root.left != null && root.right != null) {
			max[0] = Math.max(max[0], left + right + 1);
		}
		return Math.max(left, right) + 1;
	}

	// Time complexity is O(n).
	// Space complexity is O(n), because of call-stack, if the binary tree is
	// highly unbalanced.

	public static void main(String[] args) {
		BinaryTreeDiameter binaryTreeDiameter = new BinaryTreeDiameter();
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		System.out.println(binaryTreeDiameter.diameter(root));
	}
}
