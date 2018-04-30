package mergeTwoSortedLinkedList;

// LeetCode #21 (Merge Two Sorted Lists).

// Merge two sorted lists into one large sorted list.

public class MergeTwoSortedLinkedList {

	public ListNode merge(ListNode one, ListNode two) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		while (one != null && two != null) {
			if (one.value <= two.value) {
				cur.next = one;
				one = one.next;
			} else {
				cur.next = two;
				two = two.next;
			}
			cur = cur.next;
		}
		cur.next = (one == null) ? two : one;
		return dummy.next;
	}

	// Time complexity is O(m + n).
	// Space complexity is O(1).
}
