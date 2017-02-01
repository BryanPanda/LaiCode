package insertInSortedLinkedList;

// Insert a value in a sorted linked list.

public class InsertInSortedLinkedList {

	public ListNode insert(ListNode head, int value) {
		ListNode temp = new ListNode(value);
		if (head == null || head.value >= value) {
			temp.next = head;
			return temp;
		}
		// up to this point, head != null && head.value < value
		ListNode prev = head;
		while (prev.next != null && prev.next.value < value) {
			prev = prev.next;
		}
		// up to this point
		// dummy.next == null || dummy.next.value >= value
		temp.next = prev.next;
		prev.next = temp;
		return head;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).

	public static void main(String[] args) {
		InsertInSortedLinkedList insertInSortedLinkedList = new InsertInSortedLinkedList();
		ListNode head = null;
		System.out.println(insertInSortedLinkedList.insert(head, 99));
		head = new ListNode(1);
		System.out.println(insertInSortedLinkedList.insert(head, 99));
		head = new ListNode(new int[] { 1, 2 });
		System.out.println(insertInSortedLinkedList.insert(head, 1));
		head = new ListNode(new int[] { 1, 2, 3 });
		System.out.println(insertInSortedLinkedList.insert(head, 2));
		head = new ListNode(new int[] { 1, 1, 1 });
		System.out.println(insertInSortedLinkedList.insert(head, 1));
	}

}
