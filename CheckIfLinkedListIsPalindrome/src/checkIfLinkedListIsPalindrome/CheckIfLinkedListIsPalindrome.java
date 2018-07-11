package checkIfLinkedListIsPalindrome;

// LeetCode #234 (Palindrome Linked List).

// Given a linked list, check whether it is a palindrome.

public class CheckIfLinkedListIsPalindrome {

	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		int length = findNumberOfNodes(head);
		ListNode middle = findMiddle(head);
		ListNode left = null, right = null;
		if (length % 2 == 1) {
			right = new ListNode(middle.value);
			right.next = middle.next;
		} else {
			right = middle.next;
		}
		middle.next = null;
		left = reverse(head);
		while (left != null && right != null) {
			if (left.value != right.value) {
				return false;
			}
			left = left.next;
			right = right.next;
		}
		return (left == null && right == null) ? true : false;
	}

	private int findNumberOfNodes(ListNode head) {
		int count = 0;
		while (head != null) {
			count += 1;
			head = head.next;
		}
		return count;
	}

	private ListNode findMiddle(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	// iterative
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
}
