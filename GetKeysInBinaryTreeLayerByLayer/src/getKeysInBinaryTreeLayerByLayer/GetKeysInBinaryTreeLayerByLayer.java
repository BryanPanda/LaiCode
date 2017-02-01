package getKeysInBinaryTreeLayerByLayer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Get the list of list of keys in a given binary tree layer by layer. 
// Each layer is represented by a list of keys and the keys are traversed from left to right.

public class GetKeysInBinaryTreeLayerByLayer {

	public List<List<Integer>> layerByLayer(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offerLast(root);
		while (!queue.isEmpty()) {
			List<Integer> temp = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.pollFirst();
				temp.add(cur.key);
				if (cur.left != null) {
					queue.offerLast(cur.left);
				}
				if (cur.right != null) {
					queue.offerLast(cur.right);
				}
			}
			result.add(temp);
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).

}
