package insertInSortedLinkedList;

// Insert a value in a sorted linked list.

public class InsertInSortedLinkedList {

	public ListNode insert(ListNode head, int value) {
		ListNode temp = new ListNode(value);
		if (head == null || head.value >= value) {
			temp.next = head;
			return temp;
		}
		// up to this point, head != null && head.value < value
		ListNode prev = head;
		while (prev.next != null && prev.next.value < value) {
			prev = prev.next;
		}
		// up to this point
		// dummy.next == null || dummy.next.value >= value
		temp.next = prev.next;
		prev.next = temp;
		return head;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
