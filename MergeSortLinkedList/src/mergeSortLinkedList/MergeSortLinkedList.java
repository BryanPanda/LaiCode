package mergeSortLinkedList;

// Given a singly-linked list, where each node contains an integer value, sort it in ascending order. 
// The merge sort algorithm should be used to solve this problem.

public class MergeSortLinkedList {

	public ListNode sort(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode cur = head, left = null, right = null;
		ListNode[] pack = split(cur, left, right);
		left = pack[0];
		right = pack[1];
		left = sort(left);
		right = sort(right);
		head = merge(left, right);
		return head;
	}

	private ListNode[] split(ListNode cur, ListNode left, ListNode right) {
		// guaranteed cur != null && cur.next != null
		ListNode slow = cur, fast = cur.next;
		while (fast != null) {
			fast = fast.next;
			if (fast != null) {
				slow = slow.next;
				fast = fast.next;
			}
		}
		// up to this point, fast == null
		left = cur;
		// if the total number of nodes is odd, left has one more node
		// if the total number of nodes is even, left and right have the same
		// number of nodes
		right = slow.next;
		slow.next = null;
		return new ListNode[] {left, right};
	}

	private ListNode merge(ListNode left, ListNode right) {
		if (left == null) {
			return right;
		} else if (right == null) {
			return left;
		}
		ListNode result = new ListNode(0), temp = result, l = left, r = right;
		while (l != null && r != null) {
			if (l.value < r.value) {
				temp.next = l;
				temp = temp.next;
				l = l.next;
			} else {
				temp.next = r;
				temp = temp.next;
				r = r.next;
			}
		}
		// up to this point, l == null || r == null
		if (l != null) {
			temp.next = l;
		} else {
			temp.next = r;
		}
		return result.next;
	}

	// Time complexity is O(n*log(n)).
	// Space complexity is O(1).
	
	public static void main(String[] args) {
		MergeSortLinkedList mergeSortLinkedList = new MergeSortLinkedList();

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
