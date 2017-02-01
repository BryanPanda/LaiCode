package quickSortLinkedList;

// Given a singly-linked list, where each node contains an integer value, sort it in ascending order. 
// The quick sort algorithm should be used to solve this problem.

public class QuickSortLinkedList {

	public ListNode sort(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode end = getTail(head);
		head = recur(head, end);
		return head;
	}

	private ListNode getTail(ListNode head) {
		ListNode cur = head;
		if (cur == null || cur.next == null) {
			return cur;
		}
		while (cur.next != null) {
			cur = cur.next;
		}
		// up to this point, cur.next = null
		return cur;
	}

	private ListNode recur(ListNode head, ListNode end) {
		// base case
		if (head == null || head == end) {
			return head;
		}
		ListNode newHead = null, newEnd = null;
		ListNode[] pack = partition(head, end, newHead, newEnd);
		ListNode pivot = pack[0];
		newHead = pack[1];
		newEnd = pack[2];
		// get the left half and the right half, then call recursion
		if (newHead != pivot) {
			ListNode temp = newHead;
			while (temp.next != pivot) {
				temp = temp.next;
			}
			// temp.next == pivot
			temp.next = null;
			newHead = recur(newHead, temp);
			temp = getTail(newHead);
			temp.next = pivot;
		}
		pivot.next = recur(pivot.next, newEnd);
		return newHead;
	}

	private ListNode[] partition(ListNode head, ListNode end, ListNode newHead, ListNode newEnd) {
		ListNode pivot = end;
		ListNode prev = null, cur = head, tail = pivot;
		while (cur != pivot) {
			if (cur.value < pivot.value) {
				if (newHead == null) {
					newHead = cur;
				}
				prev = cur;
				cur = cur.next;
			} else {
				if (prev != null) {
					prev.next = cur.next;
				}
				ListNode temp = cur.next;
				cur.next = null;
				tail.next = cur;
				tail = tail.next;
				cur = temp;
			}
		}
		// up to this point, cur == pivot
		if (newHead == null) {
			newHead = pivot;
		}
		newEnd = tail;
		return new ListNode[] { pivot, newHead, newEnd };
	}

	// Time complexity is O(n^2) in the worst case, and
	// O(n*log(n)) in the best and average cases.
	// Space complexity is O(n) in the worst case, and
	// O(log(n)) in the best and average cases, because of call-stack.

	public static void main(String[] args) {
		QuickSortLinkedList mergeSortLinkedList = new QuickSortLinkedList();

		ListNode head = null;
		ListNode result = mergeSortLinkedList.sort(head);
		System.out.println(result);

		head = new ListNode(1);
		result = mergeSortLinkedList.sort(head);
		System.out.println(result);

		head = new ListNode(new int[] { 1, 2, 3 });
		result = mergeSortLinkedList.sort(head);
		System.out.println(result);

		head = new ListNode(new int[] { 4, 2, 6, 3, 5 });
		result = mergeSortLinkedList.sort(head);
		System.out.println(result);

		head = new ListNode(new int[] { 3, 7, 6, 2 });
		result = mergeSortLinkedList.sort(head);
		System.out.println(result);

		head = new ListNode(new int[] { 2, 3, 20, 5, 10, 15 });
		result = mergeSortLinkedList.sort(head);
		System.out.println(result);
	}

}
