package reconstructCompleteBinaryTreeWithLevelorder;

import java.util.ArrayList;
import java.util.List;

// How to re construct a complete binary tree from its level-order traversal sequence only.

// Assumption:
// 1. The given level-order is not null.

public class ReconstructCompleteBinaryTreeWithLevelorder {

	public TreeNode construct(int[] level) {
		List<Integer> list = new ArrayList<>();
		for (int i : level) {
			list.add(i);
		}
		return helper(list, 0);
	}

	private TreeNode helper(List<Integer> list, int index) {
		// base case
		if (index >= list.size()) {
			return null;
		}
		TreeNode root = new TreeNode(list.get(index));
		root.left = helper(list, 2 * index + 1);
		root.right = helper(list, 2 * index + 2);
		return root;
	}

	// Time complexity is O(n).
	// Space complexity is O(log(n)).

	public static void main(String[] args) {
		ReconstructCompleteBinaryTreeWithLevelorder reconstructCompleteBinaryTreeWithLevelorder = new ReconstructCompleteBinaryTreeWithLevelorder();
		int[] level = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		TreeNode root = reconstructCompleteBinaryTreeWithLevelorder.construct(level);
		System.out.println(root.key);
		System.out.println(root.left.key);
		System.out.println(root.right.key);
		System.out.println(root.left.left.key);
		System.out.println(root.left.right.key);
		System.out.println(root.right.left.key);
		System.out.println(root.right.right.key);
	}

}
