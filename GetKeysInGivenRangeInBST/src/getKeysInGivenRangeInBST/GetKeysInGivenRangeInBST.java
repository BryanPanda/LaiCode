package getKeysInGivenRangeInBST;

import java.util.*;

// Get the list of keys in a given binary search tree in a given range[min, max] 
// in ascending order, both min and max are inclusive.

public class GetKeysInGivenRangeInBST {

	public List<Integer> getRange(TreeNode root, int min, int max) {
		List<Integer> result = new ArrayList<>();
		helper(root, min, max, result);
		return result;
	}

	public void helper(TreeNode root, int min, int max, List<Integer> result) {
		if (root == null) {
			return;
		}
		if (root.key > min) {
			helper(root.left, min, max, result);
		}
		if (root.key >= min && root.key <= max) {
			result.add(root.key);
		}
		if (root.key < max) {
			helper(root.right, min, max, result);
		}
	}

	// Time complexity is O(n).
	// Space complexity is O(n), when the BST is highly unbalanced.
}
