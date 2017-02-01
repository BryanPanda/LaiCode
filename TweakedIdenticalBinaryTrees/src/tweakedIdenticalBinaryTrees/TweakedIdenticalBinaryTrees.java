package tweakedIdenticalBinaryTrees;

// Determine whether two given binary trees are identical assuming any number of ‘tweak’s 
// are allowed. A tweak is defined as a swap of the children of one node in the tree.

public class TweakedIdenticalBinaryTrees {

	public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
		if (one == null || two == null) {
			return one == two;
		}
		if (one.key != two.key) {
			return false;
		}
		return isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right)
				|| isTweakedIdentical(one.left, two.right) && isTweakedIdentical(one.right, two.left);
	}

	// Time complexity is O(n^2).
	// Space complexity is O(n), when the binary tree is highly unbalanced.
}
