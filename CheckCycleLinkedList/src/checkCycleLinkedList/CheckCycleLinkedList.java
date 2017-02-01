package checkCycleLinkedList;

// Check if a given linked list has a cycle. Return true if it does, otherwise return false.

public class CheckCycleLinkedList {

	public boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}
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

	public static void main(String[] args) {
		CheckCycleLinkedList checkCycleLinkedList = new CheckCycleLinkedList();
		ListNode head = null;
		System.out.println(checkCycleLinkedList.hasCycle(head));
		head = new ListNode(1);
		System.out.println(checkCycleLinkedList.hasCycle(head));
		head = new ListNode(new int[] { 1, 2 });
		System.out.println(checkCycleLinkedList.hasCycle(head));
		head.next.next = head;
		System.out.println(checkCycleLinkedList.hasCycle(head));
		head = new ListNode(new int[] { 1, 2, 3 });
		System.out.println(checkCycleLinkedList.hasCycle(head));
		ListNode temp = head.next;
		head.next.next.next = temp;
		System.out.println(checkCycleLinkedList.hasCycle(head));
	}

}
