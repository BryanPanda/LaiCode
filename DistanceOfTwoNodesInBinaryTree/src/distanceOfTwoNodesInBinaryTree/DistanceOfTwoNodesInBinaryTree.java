package distanceOfTwoNodesInBinaryTree;

// Find distance between two given keys of a Binary Tree, no parent pointers
// are given. Distance between two nodes is the minimum number of edges to be
// traversed to reach one node from other.

// Assumption:
// 1. There are no duplicate keys in the binary tree.
// 2. The given two keys are guaranteed to be in the binary tree.

public class DistanceOfTwoNodesInBinaryTree {

	public int distance(TreeNode root, int k1, int k2) {
		TreeNode lca = LCA(root, k1, k2);
		return numEdges(lca, k1, 0) + numEdges(lca, k2, 0);
	}

	private TreeNode LCA(TreeNode root, int a, int b) {
		// base case
		if (root == null || root.key == a || root.key == b) {
			return root;
		}
		TreeNode left = LCA(root.left, a, b);
		TreeNode right = LCA(root.right, a, b);
		if (left != null && right != null) {
			return root;
		}
		return left == null ? right : left;
	}

	private int numEdges(TreeNode root, int val, int num) {
		// base case
		if (root == null) {
			return 0;
		}
		if (root.key == val) {
			return num;
		}
		int left = numEdges(root.left, val, num + 1);
		if (left != 0) {
			return left;
		}
		return numEdges(root.right, val, num + 1);
	}

	// Time complexity is O(n).
	// Space complexity is O(n).

	public static void main(String[] args) {
		DistanceOfTwoNodesInBinaryTree distanceOfTwoNodesInBinaryTree = new DistanceOfTwoNodesInBinaryTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.left.right.right = new TreeNode(8);
		System.out.println(distanceOfTwoNodesInBinaryTree.distance(root, 4, 6));
	}
}
