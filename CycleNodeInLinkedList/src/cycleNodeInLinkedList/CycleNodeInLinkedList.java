package cycleNodeInLinkedList;

// Check if a given linked list has a cycle. Return the node where the cycle starts. 
// Return null if there is no cycle.

public class CycleNodeInLinkedList {

	public ListNode cycleNode(ListNode head) {
		if (!hasCycle(head)) {
			return null;
		}
		// has cycle
		ListNode fast = meetingPoint(head);
		ListNode slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

	private boolean hasCycle(ListNode head) {
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

	private ListNode meetingPoint(ListNode head) {
		// guaranteed head != null, and has cycle
		ListNode slow = head, fast = head;
		slow = slow.next;
		fast = fast.next.next; // so no NullPointerException
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return fast;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).

	public static void main(String[] args) {
		CycleNodeInLinkedList cycleNodeInLinkedList = new CycleNodeInLinkedList();
		ListNode head = null;
		System.out.println(cycleNodeInLinkedList.cycleNode(head));
		head = new ListNode(1);
		head.next = head;
		System.out.println(cycleNodeInLinkedList.cycleNode(head).value);
		head = new ListNode(new int[] { 1, 2 });
		head.next.next = head.next;
		System.out.println(cycleNodeInLinkedList.cycleNode(head).value);
		head = new ListNode(new int[] { 1, 2 });
		head.next.next = head;
		System.out.println(cycleNodeInLinkedList.cycleNode(head).value);
	}

}
