package genericBinarySearchTree;

import java.util.*;

public class GenericBinarySearchTree<Key extends Comparable<Key>, Value> {

	private Node root;

	// Node class
	private class Node {

		private Key key;
		private Value val;
		private Node left, right;
		private int size;

		// constructor
		public Node(Key key, Value val, int size) {
			this.key = key;
			this.val = val;
			this.size = size;
		}
	}

	public GenericBinarySearchTree() {

	}

	public boolean isEmpty() {
		return size() == 0;
	}

	private int size() {
		return size(root);
	}

	private int size(Node x) {
		if (x == null) {
			return 0;
		} else {
			return x.size;
		}
	}

	public boolean contains(Key key) {
		if (key == null) {
			throw new NullPointerException("argument to contains() is null");
		}
		return get(key) != null;
	}

	// get or search method
	public Value get(Key key) {
		return get(root, key);
	}

	private Value get(Node x, Key key) {
		if (x == null) {
			return null;
		}
		int cmp = key.compareTo(x.key);
		if (cmp == 0) {
			return x.val;
		} else if (cmp < 0) { // key < x.key
			return get(x.left, key);
		} else {
			return get(x.right, key);
		}
	}

	// put or insert method
	public void put(Key key, Value val) {
		if (key == null) {
			throw new NullPointerException("first argument to put() is null");
		}
		if (val == null) {
			delete(key);
			return;
		}
		root = put(root, key, val);
	}

	private Node put(Node x, Key key, Value val) {
		if (x == null) {
			return new Node(key, val, 1);
		}
		int cmp = key.compareTo(x.key);
		if (cmp == 0) {
			x.val = val;
		} else if (cmp < 0) { // key < x.key, insert to the left subtree
			x.left = put(x.left, key, val);
		} else {
			x.right = put(x.right, key, val);
		}
		x.size = 1 + size(x.left) + size(x.right);
		return x;
	}

	// delete method
	public void delete(Key key) {
		if (key == null)
			throw new NullPointerException("argument to delete() is null");
		root = delete(root, key);
	}

	private Node delete(Node x, Key key) {
		if (x == null) {
			return null;
		}

		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			x.left = delete(x.left, key);
		} else if (cmp > 0) {
			x.right = delete(x.right, key);
		} else {
			if (x.right == null) {
				return x.left;
			}
			if (x.left == null) {
				return x.right;
			}
			// up to this point, x != null && x.key == key
			// && x.left != null && x.right != null
			Node t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		x.size = size(x.left) + size(x.right) + 1;
		return x;
	}

	public void deleteMin() {
		if (isEmpty()) {
			throw new NoSuchElementException("BST is currently empty");
		}
		root = deleteMin(root);
	}

	private Node deleteMin(Node x) {
		if (x.left == null) {
			return x.right;
		}
		// otherwise
		x.left = deleteMin(x.left);
		x.size = size(x.left) + size(x.right) + 1;
		return x;
	}

	public void deleteMax() {
		if (isEmpty()) {
			throw new NoSuchElementException("BST is currently empty");
		}
		root = deleteMax(root);
	}

	private Node deleteMax(Node x) {
		if (x.right == null) {
			return x.left;
		}
		// otherwise
		x.right = deleteMax(x.right);
		x.size = size(x.left) + size(x.right) + 1;
		return x;
	}

	public Key min() {
		if (isEmpty()) {
			throw new NoSuchElementException("BST is currently empty");
		}
		return min(root).key;
	}

	public Node min(Node x) {
		if (x.left == null) {
			return x;
		} else {
			return min(x.left);
		}
	}

	public Key max() {
		if (isEmpty()) {
			throw new NoSuchElementException("BST is currently empty");
		}
		return max(root).key;
	}

	public Node max(Node x) {
		if (x.right == null) {
			return x;
		} else {
			return max(x.right);
		}
	}

	// Return the largest key in the BST that is less
	// than or equal to key
	public Key floor(Key key) {
		if (key == null) {
			throw new NullPointerException("argument to floor() in invalid");
		}
		if (isEmpty()) {
			throw new NoSuchElementException("BST is currently empty");
		}
		Node x = floor(root, key);
		return x == null ? null : x.key;
	}

	private Node floor(Node x, Key key) {
		if (x == null) {
			return null;
		}
		int cmp = key.compareTo(x.key);
		if (cmp == 0) {
			return x;
		}
		if (cmp < 0) {
			return floor(x.left, key);
		}
		// it is easy to make the mistake of returning
		// floor(x.right, key) when cmp > 0
		Node t = floor(x.right, key);
		return t == null ? x : t;
	}

	// Return the smallest key in the BST that is greater
	// than or equal to key
	public Key ceiling(Key key) {
		if (key == null) {
			throw new NullPointerException("argument to ceiling() in invalid");
		}
		if (isEmpty()) {
			throw new NoSuchElementException("BST is currently empty");
		}
		Node x = ceiling(root, key);
		return x == null ? null : x.key;
	}

	private Node ceiling(Node x, Key key) {
		if (x == null) {
			return null;
		}
		int cmp = key.compareTo(x.key);
		if (cmp == 0) {
			return x;
		}
		if (cmp < 0) {
			Node t = ceiling(x.left, key);
			return t == null ? x : t;
		}
		return ceiling(x.right, key);
	}

	// Return the kth smallest key in the BST
	public Key select(int k) {
		if (k < 0 || k >= size()) {
			throw new IllegalArgumentException();
		}
		Node x = select(root, k);
		return x.key;
	}

	private Node select(Node x, int k) {
		if (x == null) {
			return null;
		}
		int t = size(x.left);
		if (t == k) {
			return x;
		} else if (t < k) {
			return select(x.right, k - t - 1);
		} else {
			return select(x.left, k);
		}
	}

	// Return the number of keys in BST that are less than key
	public int rank(Key key) {
		if (key == null) {
			throw new NullPointerException("argument to rank() is invalid");
		}
		return rank(root, key);
	}

	private int rank(Node x, Key key) {
		if (x == null) {
			return 0;
		}
		int cmp = key.compareTo(x.key);
		if (cmp == 0) {
			return size(x.left);
		} else if (cmp < 0) {
			return rank(x.left, key);
		} else {
			return 1 + size(x.left) + rank(x.right, key);
		}
	}

	// Return all keys in the BST in the given range
	// [lo, hi)
	public Iterable<Key> keys(Key lo, Key hi) {
		if (lo == null) {
			throw new NullPointerException("first argument to keys() is null");
		}
		if (hi == null) {
			throw new NullPointerException("first argument to keys() is null");
		}
		Queue<Key> queue = new LinkedList<Key>();
		keys(root, queue, lo, hi);
		return queue;
	}

	private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
		if (x == null) {
			return;
		}
		int cmplo = lo.compareTo(x.key);
		int cmphi = hi.compareTo(x.key);
		if (cmplo < 0) { // lo < x.key
			keys(x.left, queue, lo, hi);
		}
		if (cmplo <= 0 && cmphi >= 0) {
			queue.offer(x.key);
		}
		if (cmphi > 0) {
			keys(x.right, queue, lo, hi);
		}
	}

	// Return the number of keys in the BST in the given range
	// [lo, hi)
	public int size(Key lo, Key hi) {
		if (lo == null) {
			throw new NullPointerException("first argument to size() is null");
		}
		if (hi == null) {
			throw new NullPointerException("second argument to size() is null");
		}
		if (lo.compareTo(hi) > 0) {
			return 0;
		}
		if (contains(hi)) {
			return rank(hi) - rank(lo) + 1;
		} else {
			return rank(hi) - rank(lo);
		}
	}

}
