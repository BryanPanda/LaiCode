package getKeysInGivenRangeInBST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Get the list of keys in a given binary search tree in a given range [min, max] 
// in ascending order, both min and max are inclusive.

public class GetKeysInGivenRangeInBST {

	// recursive solution
	public List<Integer> getRange1(TreeNode root, int min, int max) {
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
	
	// iterative solution: in-order traversal of a BST is monotonically increasing
	public List<Integer> getRange2(TreeNode root, int min, int max) {
	    List<Integer> result = new ArrayList<>();
	    LinkedList<TreeNode> stack = new LinkedList<>();
	    TreeNode cur = root;
	    while (cur != null || !stack.isEmpty()) {
	    	if (cur != null) {
	    		stack.offerFirst(cur);
	    		cur = cur.left;
	    	}
	    	else {
	    		cur = stack.pollFirst();
	    		if (cur.key > max) {
	    			break;
	    		}
	    		if (cur.key >= min && cur.key <= max) {
	    			result.add(cur.key);
	    		}
	    		cur = cur.right;
	    	}
	    }
	    return result;
	}
	
	// Time complexity is O(n).
	// Space complexity is O(n), but since object is stored on heap, iterative solution 
	// avoids stack overflow.
}
