package firstNonRepeatingCharacterInStream;

import java.util.HashMap;
import java.util.HashSet;

// Given an unlimited stream of characters, find the first non-repeating 
// character from the stream in O(1) time at any moment.

public class FirstNonRepeatingCharacterInStream {

	static class Node {
		Character ch;
		Node prev;
		Node next;

		Node(Character ch) {
			this.ch = ch;
		}
	}

	private Node head;
	private Node tail;
	private HashMap<Character, Node> singleChar;
	private HashSet<Character> repetitiveChar;

	public FirstNonRepeatingCharacterInStream() {
		tail = new Node(null);
		tail.next = tail.prev = tail;
		head = tail;
		singleChar = new HashMap<Character, Node>();
		repetitiveChar = new HashSet<Character>();
	}

	public void read(char ch) {
		if (repetitiveChar.contains(ch)) {
			return;
		}
		Node node = singleChar.get(ch);
		if (node == null) {
			node = new Node(ch);
			append(node);
		} else {
			remove(node);
		}
	}

	private void append(Node node) {
		singleChar.put(node.ch, node);
		tail.next = node;
		node.prev = tail;
		node.next = head;
		tail = tail.next;
	}

	private void remove(Node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
		if (node == tail) {
			tail = node.prev;
		}
		node.prev = node.next = null;
		repetitiveChar.add(node.ch);
		singleChar.remove(node.ch);
	}

	public Character firstNonRepeating() {
		if (head == tail) {
			return null;
		}
		return head.next.ch;
	}

}
