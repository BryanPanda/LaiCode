package binaryTreeToDoublyLinkedList;

public class Node {

	public int value;
	public Node left;
	public Node right;

	public Node(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}

	@Override
	public String toString() {
		Node left = this.left;
		Node right = this.right;
		String s = "" + this.value;
		while (left != null) {
			s = left.value + " <-> " + s;
			left = left.left;
		}
		while (right != null) {
			s = s + " <-> " + right.value;
			right = right.right;
		}
		return s;
	}
}
