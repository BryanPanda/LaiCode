package isPalindromeLinkedList;

// Given a linked list, check whether it is a palindrome.

public class IsPalindromeLinkedList {

	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		boolean odd = hasOddNumberOfNodes(head);
		ListNode middle = middle(head);
		ListNode left = null, right = null;
		if (odd) {
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
		// up to this point, left == null || right == null
		return (left == null && right == null) ? true : false;
	}

	private boolean hasOddNumberOfNodes(ListNode head) {
		int count = 0;
		while (head != null) {
			count += 1;
			head = head.next;
		}
		return count % 2 == 1;
	}

	private ListNode middle(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next; // no NullPointException guaranteed
		}
		return slow;
	}

	// iterative solution
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

	public static void main(String[] args) {
		IsPalindromeLinkedList isPalindromeLinkedList = new IsPalindromeLinkedList();
		ListNode head = null;
		System.out.println(isPalindromeLinkedList.isPalindrome(head));
		head = new ListNode(1);
		System.out.println(isPalindromeLinkedList.isPalindrome(head));
		head = new ListNode(new int[] { 1, 2 });
		System.out.println(isPalindromeLinkedList.isPalindrome(head));
		head = new ListNode(new int[] { 1, 1 });
		System.out.println(isPalindromeLinkedList.isPalindrome(head));
		head = new ListNode(new int[] { 1, 2, 3 });
		System.out.println(isPalindromeLinkedList.isPalindrome(head));
		head = new ListNode(new int[] { 1, 2, 1 });
		System.out.println(isPalindromeLinkedList.isPalindrome(head));
		head = new ListNode(new int[] { 1, 2, 3, 2, 1 });
		System.out.println(isPalindromeLinkedList.isPalindrome(head));
	}

}
