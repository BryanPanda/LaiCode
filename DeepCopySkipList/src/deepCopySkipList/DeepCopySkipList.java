package deepCopySkipList;

import java.util.HashMap;
import java.util.Map;

// A Skip List is a special type of linked list, where each of the nodes has a forward pointer
// to another node in the front and forward pointers are guaranteed to be in non-descending order.
// Make a deep copy of the original skip list.

public class DeepCopySkipList {

	public SkipListNode copy(SkipListNode head) {
		if (head == null) {
			return null;
		}
		Map<SkipListNode, SkipListNode> lookUp = new HashMap<>();
		SkipListNode newHead = new SkipListNode(head.value);
		SkipListNode cur = newHead;
		lookUp.put(head, newHead);
		while (head != null) {
			if (head.next != null) {
				if (!lookUp.containsKey(head.next)) {
					SkipListNode node = new SkipListNode(head.next.value);
					lookUp.put(head.next, node);
				}
				cur.next = lookUp.get(head.next);
			}
			if (head.forward != null) {
				if (!lookUp.containsKey(head.forward)) {
					SkipListNode node = new SkipListNode(head.forward.value);
					lookUp.put(head.forward, node);
				}
				cur.forward = lookUp.get(head.forward);
			}
			head = head.next;
			cur = cur.next;
		}
		return newHead;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}

