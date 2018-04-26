package reverseLinkedList;

// LeetCode #206 (Reverse Linked List).

// Reverse a singly-linked list.

public class ReverseLinkedList {

	// iterative solution
	public ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode cur = head, prev = null;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).

	// recursive solution
	public ListNode reverse2(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode next = head.next;
		ListNode newHead = reverse(next);
		next.next = head;
		head.next = null;
		return newHead;
	}

	// Time complexity is O(n).
	// Space complexity is O(n), because of call-stack.

}
