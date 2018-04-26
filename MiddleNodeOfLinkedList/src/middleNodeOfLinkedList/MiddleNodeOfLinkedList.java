package middleNodeOfLinkedList;

// Find the middle node of a given linked list.

public class MiddleNodeOfLinkedList {

	public ListNode middle(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode slow = dummy, fast = dummy;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next; // no NullPointException guaranteed
		}
		return slow;
	}

	public ListNode middle2(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next; // no NullPointException guaranteed
		}
		return slow;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

