package reverseAlternateNodes;

// Given a linked list, reverse alternate nodes and append at the end.

public class ReverseAlternateNodes {

	public ListNode reverseAlternate(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		// head != null && head.next != null
		ListNode left = head, right = head.next, leftCur = head;
		ListNode[] results = partition(head, left, right, leftCur);
		left = results[0];
		right = results[1];
		leftCur = results[2];
		right = reverse(right);
		leftCur.next = right;
		return left;
	}

	private ListNode[] partition(ListNode head, ListNode left, ListNode right, ListNode leftCur) {
		// guaranteed head != null && head.next != null
		ListNode rightCur = right, cur = right.next;
		int count = 0;
		while (cur != null) {
			if (count == 0) {
				leftCur.next = cur;
				leftCur = leftCur.next;
			} else {
				rightCur.next = cur;
				rightCur = rightCur.next;
			}
			count = 1 - count;
			cur = cur.next;
		}
		leftCur.next = null;
		rightCur.next = null;
		return new ListNode[] { left, right, leftCur };
	}

	private ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode cur = head, prev = null;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).

	public static void main(String[] agrs) {
		ReverseAlternateNodes reverseAlternateNodes = new ReverseAlternateNodes();
		ListNode head = null;
		System.out.println(reverseAlternateNodes.reverseAlternate(head));
		head = new ListNode(0);
		System.out.println(reverseAlternateNodes.reverseAlternate(head));
		head = new ListNode(new int[] { 1, 2 });
		System.out.println(reverseAlternateNodes.reverseAlternate(head));
		head = new ListNode(new int[] { 1, 2, 3 });
		System.out.println(reverseAlternateNodes.reverseAlternate(head));
		head = new ListNode(new int[] { 1, 2, 3, 4 });
		System.out.println(reverseAlternateNodes.reverseAlternate(head));
		head = new ListNode(new int[] { 1, 2, 3, 4, 5 });
		System.out.println(reverseAlternateNodes.reverseAlternate(head));
		head = new ListNode(new int[] { 1, 2, 3, 4, 5, 6 });
		System.out.println(reverseAlternateNodes.reverseAlternate(head));
	}

}
