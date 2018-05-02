package selectionSortLinkedList;

// Given a singly-linked list, where each node contains an integer value, sort it in ascending order. 
// The selection sort algorithm should be used to solve this problem.

public class SelectionSortLinkedList {

	public ListNode sort(ListNode head) {
		for (ListNode cur = head; cur != null; cur = cur.next) {
			ListNode min = cur;
			for (ListNode iter = cur; iter != null; iter = iter.next) {
				if (iter.value < min.value) {
					min = iter;
				}
			}
			// swap
			int temp = cur.value;
			cur.value = min.value;
			min.value = temp;
		}
		return head;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
