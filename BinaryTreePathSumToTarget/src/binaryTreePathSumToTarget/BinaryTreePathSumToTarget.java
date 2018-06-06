package binaryTreePathSumToTarget;

// LeetCode #112 (Path Sum).


// Given a binary tree and a target sum, determine if the tree has a root-to-leaf path such that 
// adding up all the values along the path equals the given target.

public class BinaryTreePathSumToTarget {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.key == sum) {
            return true;
        }
        return hasPathSum(root.left, sum - root.key) || hasPathSum(root.right, sum - root.key);
    }
    
    // Time complexity is O(n).
    // Space complexity is O(n).
    
    // Follow up: return all paths?
    // LeetCode #113 (Path Sum II).
}
