package partitionLinkedList;

// Given a linked list and a target value T, partition it such that 
// all nodes less than T are listed before the nodes larger than or 
// equal to target value T. The original relative order of the nodes 
// in each of the two partitions should be preserved.

public class PartitionLinkedList {

	public ListNode partition(ListNode head, int target) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode small = new ListNode(0), smallCur = small;
		ListNode large = new ListNode(0), largeCur = large;
		while (head != null) {
			if (head.value < target) {
				smallCur.next = head;
				smallCur = smallCur.next;
			} else {
				largeCur.next = head;
				largeCur = largeCur.next;
			}
			head = head.next;
		}
		smallCur.next = large.next;
		large.next = null;
		largeCur.next = null;
		return small.next;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
