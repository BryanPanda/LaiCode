package removeExtraDuplicatesFromSortedList;

// LeetCode #82 (Remove Duplicates from Sorted List II).

// Given a sorted linked list, delete all nodes that have duplicate numbers, 
// leaving only distinct numbers from the original list.

public class RemoveExtraDuplicatesFromSortedList {

	public ListNode removeDup(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy, cur = dummy.next;
		while (cur != null && cur.next != null) {
			if (cur.value != cur.next.value) {
				prev = cur;
				cur = cur.next;
			} else {
				ListNode node = cur;
				while (node != null && node.value == cur.value) {
					node = node.next;
				}
				prev.next = node;
				cur = node;
			}
		}
		return dummy.next;
	}
	
	// Time complexity is O(n).
	// Space complexity is O(1).
}
