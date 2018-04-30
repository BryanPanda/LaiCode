package reorderLinkedList;

// LeetCode #143 (Reorder List).

// Reorder the given singly-linked list N1 -> N2 -> N3 -> N4 -> … -> Nn -> null 
// to be N1- > Nn -> N2 -> Nn-1 -> N3 -> Nn-2 -> … -> null

public class ReorderLinkedList {

	public ListNode reorder(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode middle = middle(head);
		ListNode left = head, right = middle.next;
		middle.next = null;
		right = reverse(right);
		ListNode result = merge(left, right);
		return result;
	}

	private ListNode middle(ListNode head) {
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

	private ListNode reverse(ListNode head) {
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

	private ListNode merge(ListNode one, ListNode two) {
		ListNode dummy = new ListNode(0), cur = dummy;
		while (one != null && two != null) {
			cur.next = one;
			one = one.next;
			cur = cur.next;
			cur.next = two;
			two = two.next;
			cur = cur.next;
		}
		cur.next = (one == null) ? null : one;
		return dummy.next;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
