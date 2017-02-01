package getPostorderSequenceByPreorderAndInorder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// Given Inorder and Preorder traversals of a binary tree, get the Postorder
// traversal without reconstructing a binary tree.

// Assumption:
// The given Inorder and Preorder traversals are guaranteed to be valid.

public class GetPostorderSequenceByPreorderAndInorder {

	public int[] postOrder(int[] pre, int[] in) {
		Map<Integer, Integer> map = indexMap(in);
		LinkedList<Integer> result = new LinkedList<>();
		helper(pre, 0, pre.length - 1, in, 0, in.length - 1, map, result);
		int[] array = new int[pre.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = result.pollFirst();
		}
		return array;
	}

	private Map<Integer, Integer> indexMap(int[] in) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < in.length; i++) {
			map.put(in[i], i);
		}
		return map;
	}

	private void helper(int[] pre, int preLeft, int preRight, int[] in, int inLeft, int inRight,
			Map<Integer, Integer> map, LinkedList<Integer> result) {
		if (preLeft > preRight || inLeft > inRight) {
			return;
		}
		int index = map.get(pre[preLeft]);
		result.offerFirst(pre[preLeft]);
		// right sub-tree first, then left sub-tree
		helper(pre, preLeft + index - inLeft + 1, preRight, in, index + 1, inRight, map, result);
		helper(pre, preLeft + 1, preLeft + index - inLeft, in, inLeft, index - 1, map, result);
	}

	// Time complexity is O(n).
	// Space complexity is O(n).

	public static void main(String[] args) {
		GetPostorderSequenceByPreorderAndInorder getPostorderSequenceByPreorderAndInorder = new GetPostorderSequenceByPreorderAndInorder();
		System.out.println(Arrays.toString(getPostorderSequenceByPreorderAndInorder
				.postOrder(new int[] { 1, 2, 4, 5, 3, 6 }, new int[] { 4, 2, 5, 1, 3, 6 })));
	}

}
