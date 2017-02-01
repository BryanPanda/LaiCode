package binarySearchTree;

public class BinarySearchTree {

	private TreeNode root;

	// get or search method
	public TreeNode search(int key) {
		return search1(root, key);
	}

	// recursive solution
	private TreeNode search1(TreeNode x, int key) {
		if (x == null || x.key == key) {
			return x;
		}
		if (x.key < key) {
			return search1(x.right, key);
		} else {
			return search1(x.left, key);
		}
	}

	// iterative solution
	private TreeNode search2(TreeNode x, int key) {
		TreeNode cur = x;
		while (cur != null && cur.key != key) {
			if (cur.key < key) {
				cur = cur.right;
			} else {
				cur = cur.left;
			}
		}
		// up to this point, cur == null || cur.key == key
		return cur;
	}

	// put or insert method
	public void insert(int key) {
		root = insert1(root, key);
	}

	// recursive solution
	private TreeNode insert1(TreeNode x, int key) {
		if (x == null) {
			return new TreeNode(key);
		}
		// if key is already in the tree, do nothing
		if (x.key < key) {
			x.right = insert1(x.right, key);
		} else if (x.key > key) {
			x.left = insert1(x.left, key);
		}
		return x;
	}

	// iterative solution
	private TreeNode insert2(TreeNode x, int key) {
		TreeNode newNode = new TreeNode(key);
		if (x == null) {
			return newNode;
		}
		TreeNode cur = x;
		// cur.key == key, do nothing
		while (cur.key != key) {
			if (cur.key < key) {
				if (cur.right != null) {
					cur = cur.right;
				} else {
					cur.right = newNode;
					break;
				}
			} else { // cur.key > key
				if (cur.left != null) {
					cur = cur.left;
				} else {
					cur.left = newNode;
					break;
				}
			}
		}
		return x;
	}

	// delete or remove method
	public void delete(int key) {
		root = delete(root, key);
	}

	private TreeNode delete(TreeNode x, int key) {
		if (x == null) {
			return null;
		}

		if (x.key < key) {
			x.right = delete(x.right, key);
			return x;
		} else if (x.key > key) {
			x.left = delete(x.left, key);
			return x;
		}

		// up to this point, x != null && x.key == key
		// case 1: no children, neither on the left, nor on the right
		// case 2: no left child
		// case 3: no right child
		if (x.left == null) {
			return x.right;
		} else if (x.right == null) {
			return x.left;
		}

		// up to this point: x != null && x.key == key
		// && x.left != null && x.right != null
		// case 4: have left child, and have right child
		// let's pick the smallest from the right sub-tree of x
		// case 4.1: x.right has no left child
		if (x.right.left == null) {
			x.right.left = x.left;
			return x.right;
		}

		// case 4.2: x.right has left child
		// need to find and delete the smallest from x.right
		TreeNode smallest = deleteSmallest(x.right);
		smallest.left = x.left;
		smallest.right = x.right;
		return smallest;
	}

	// given a TreeNode cur, find and delete the smallest node
	// from its right sub-tree
	private TreeNode deleteSmallest(TreeNode cur) {
		TreeNode prev = cur;
		cur = cur.left;
		while (cur.left != null) {
			prev = cur;
			cur = cur.left;
		}
		// up to this point cur.left == null
		// which means cur is the smallest node in the right sub-tree
		// and prev is its parent
		prev.left = prev.left.right;
		return cur;
	}

}
