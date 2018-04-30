package checkCycleLinkedList;

// LeetCode #141 (Linked List Cycle).

// Check if a given linked list has a cycle. Return true if it does, otherwise return false.

public class CheckCycleLinkedList {

	public boolean hasCycle(ListNode head) {
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}
	
	// Time complexity is O(n).
	// Space complexity is O(1).
}
