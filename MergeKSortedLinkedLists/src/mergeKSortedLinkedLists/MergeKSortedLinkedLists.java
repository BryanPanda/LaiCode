package mergeKSortedLinkedLists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// Merge K sorted lists into one big sorted list in ascending order.

// Assumption: ListOfLists is not null, and none of the lists is null.

public class MergeKSortedLinkedLists {

	public ListNode merge(List<ListNode> listOfLists) {
		if (listOfLists == null) {
			return null;
		}
		int k = listOfLists.size();
		PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(k, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode n1, ListNode n2) {
				if (n1.value == n2.value) {
					return 0;
				}
				return n1.value < n2.value ? -1 : 1;
			}
		});
		for (ListNode head : listOfLists) {
			if (head != null) {
				minHeap.offer(head);
			}
		}
		ListNode result = new ListNode(0);
		ListNode cur = result;
		while (!minHeap.isEmpty()) {
			ListNode node = minHeap.poll();
			cur.next = node;
			cur = cur.next;
			if (node.next != null) {
				minHeap.offer(node.next);
			}
		}
		return result.next;
	}

	// Time complexity is O(n*k*log(k)).
	// Space complexity is O(k).

	// solution 2: binary reduction
	// Time complexity is O(n*k*log(k)).
	// Space complexity is O(k*n).

	// When array sizes are big, solution 1 reads and writes each element once,
	// solution 2 reads and writes reach element log(k) times.

	public static void main(String[] args) {
		MergeKSortedLinkedLists mergeKSortedLinkedLists = new MergeKSortedLinkedLists();
		List<ListNode> listOfLists = new ArrayList<>();
		ListNode head = new ListNode(new int[] { 1, 5, 7 });
		listOfLists.add(head);
		head = new ListNode(new int[] { 4 });
		listOfLists.add(head);
		head = new ListNode(new int[] { 2, 3, 5, 11 });
		listOfLists.add(head);
		head = new ListNode(new int[] { 2, 4, 4, 6, 8 });
		listOfLists.add(head);
		System.out.println(mergeKSortedLinkedLists.merge(listOfLists));
	}
}
