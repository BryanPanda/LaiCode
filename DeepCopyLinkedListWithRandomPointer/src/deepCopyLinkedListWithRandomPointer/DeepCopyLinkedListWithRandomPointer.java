package deepCopyLinkedListWithRandomPointer;

import java.util.HashMap;
import java.util.Map;

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
}
