package deepCopyLinkedListWithRandomPointer;

import java.util.HashMap;
import java.util.Map;

// LeetCode #138 (Copy List with Random Pointer).

// Each of the nodes in the linked list has another pointer pointing to a random node in the list or null. 
// Make a deep copy of the original list.

public class DeepCopyLinkedListWithRandomPointer {

	public RandomListNode copy(RandomListNode head) {
		if (head == null) {
			return null;
		}
		Map<RandomListNode, RandomListNode> lookUp = new HashMap<>();
		RandomListNode newHead = new RandomListNode(head.value);
		RandomListNode cur = newHead;
		lookUp.put(head, newHead);
		while (head != null) {
			if (head.next != null) {
				if (!lookUp.containsKey(head.next)) {
					RandomListNode node = new RandomListNode(head.next.value);
					lookUp.put(head.next, node);
				}
				cur.next = lookUp.get(head.next);
			}
			if (head.random != null) {
				if (!lookUp.containsKey(head.random)) {
					RandomListNode node = new RandomListNode(head.random.value);
					lookUp.put(head.random, node);
				}
				cur.random = lookUp.get(head.random);
			}
			head = head.next;
			cur = cur.next;
		}
		return newHead;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).

	// Follow up: Use O(1) space?
	public RandomListNode copy2(RandomListNode head) {
		if (head == null) {
			return null;
		}
		RandomListNode cur = head;
		while (cur != null) {
			RandomListNode node = cur.next;
			RandomListNode newNext = new RandomListNode(cur.value);
			cur.next = newNext;
			newNext.next = node;
			cur = cur.next.next;
		}
		cur = head;
		while (cur != null) {
			cur.next.random = (cur.random == null) ? null : cur.random.next;
			cur = cur.next.next;
		}
		cur = head;
		RandomListNode newHead = head.next;
		while (cur != null) {
			RandomListNode prev = cur.next.next; // possibly null
			cur.next.next = (prev == null) ? null : prev.next;
			cur.next = prev;
			cur = cur.next;
		}
		return newHead;
	}
	
	// Time complexity is O(n).
	// Space complexity is O(1).
}
