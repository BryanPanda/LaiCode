package numberOfNodesLinkedList;

// Return the number of nodes in the linked list.

public class NumberOfNodesLinkedList {

	public int numberOfNodes(ListNode head) {
		if (head == null) {
			return 0;
		}
		int result = 0;
		while (head != null) {
			result += 1;
			head = head.next;
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
