package binaryTreeToDoublyLinkedList;

// Given a binary tree, convert it to a doubly linked list with its in-order sequence.

public class BinaryTreeToDoublyLinkedList {

	static Node prev = null;

	public Node convert(Node root) {
		Node[] head = new Node[] { null };
		helper(root, head);
		return head[0];
	}

	private void helper(Node root, Node[] head) {
		// base case
		if (root == null) {
			return;
		}
		helper(root.left, head);
		if (prev == null) { // initially
			head[0] = root;
		} else {
			root.left = prev;
			prev.right = root;
		}
		prev = root;
		helper(root.right, head);
	}

	public static void main(String[] args) {
		BinaryTreeToDoublyLinkedList binaryTreeToDoublyLinkedList = new BinaryTreeToDoublyLinkedList();
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(15);
		root.left.left = new Node(2);
		root.left.right = new Node(7);
		root.right.left = new Node(12);
		root.right.right = new Node(20);
		System.out.println(root);
		System.out.println(binaryTreeToDoublyLinkedList.convert(root));
	}

}
