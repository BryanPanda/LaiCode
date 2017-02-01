package reverseLinkedList;

public class ListNode {
	public int value;
	public ListNode next;

	public ListNode(int value) {
		this.value = value;
		next = null;
	}

	public ListNode(int[] array) {
		// assumption: array != null && array.length > 0
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		for (int i = 0; i < array.length; i++) {
			cur.next = new ListNode(array[i]);
			cur = cur.next;
		}
		this.value = dummy.next.value;
		this.next = dummy.next.next;
	}

	@Override
	public String toString() {
		ListNode head = new ListNode(this.value);
		head.next = this.next;
		String s = "" + head.value;
		while (head.next != null) {
			s += " -> " + head.next.value;
			head = head.next;
		}
		return s;
	}
}
