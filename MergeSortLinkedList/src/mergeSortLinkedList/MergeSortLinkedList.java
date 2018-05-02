package mergeSortLinkedList;

// LeetCode #148 (Sort List).

// Given a singly-linked list, where each node contains an integer value, sort it in ascending order. 
// The merge sort algorithm should be used to solve this problem.

public class MergeSortLinkedList {

	public ListNode mergeSort(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode cur = head;
		ListNode[] leftAndRight = split(cur);
		ListNode left = leftAndRight[0], right = leftAndRight[1];
		left = mergeSort(left);
		right = mergeSort(right);
		head = merge(left, right);
		return head;
	}

	// Find the middle node of the given linked list, and split the linked list in halves.
	private ListNode[] split(ListNode cur) {
		ListNode slow = cur, fast = cur;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode left = cur, right = slow.next;
		slow.next = null;
		return new ListNode[] {left, right};
	}

	// Merge two sorted linked lists into one large sorted linked list.
	private ListNode merge(ListNode left, ListNode right) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		while (left != null && right != null) {
			if (left.value <= right.value) {
				cur.next = left;
				left = left.next;
			}
			else {
				cur.next = right;
				right = right.next;
			}
			cur = cur.next;
		}
		cur.next = (left == null) ? right : left;
		return dummy.next;
	}

	// Time complexity is O(n*log(n)).
	// Space complexity is O(log(n)), because of call-stack.
}
