package removeDuplicatesFromSortedList;

// LeetCode #83 (Remove Duplicates from Sorted List).

// Given a sorted linked list, delete all duplicates such that each element appear only once.

public class RemoveDuplicatesFromSortedList {

	public ListNode removeDup(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode cur = head;
		while (cur.next != null) {
			if (cur.value == cur.next.value) {
				ListNode next = cur.next;
				cur.next = next.next;
				next.next = null;
			} else {
				cur = cur.next;
			}
		}
		return head;
	}
	
	// Time complexity is O(n).
	// Space complexity is O(1).
}
