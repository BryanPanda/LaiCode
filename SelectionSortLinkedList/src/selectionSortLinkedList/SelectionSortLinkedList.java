package selectionSortLinkedList;

// Given a singly-linked list, where each node contains an integer value, sort it in ascending order. 
// The selection sort algorithm should be used to solve this problem.

public class SelectionSortLinkedList {

	public ListNode sort(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
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

	public static void main(String[] args) {
		SelectionSortLinkedList selectionSortLinkedList = new SelectionSortLinkedList();

		ListNode head = null;
		ListNode result = selectionSortLinkedList.sort(head);
		System.out.println(result);

		head = new ListNode(1);
		result = selectionSortLinkedList.sort(head);
		System.out.println(result);

		head = new ListNode(new int[] { 1, 2, 3 });
		result = selectionSortLinkedList.sort(head);
		System.out.println(result);

		head = new ListNode(new int[] { 4, 2, 6, 3, 5 });
		result = selectionSortLinkedList.sort(head);
		System.out.println(result);
	}
}
