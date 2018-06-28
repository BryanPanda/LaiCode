package kthSmallestWithFactorsTwoThree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;

// Find the K-th smallest number s such that s = (2^x) * (3^y), x >= 0 and y >= 0, 
// x and y are both integers.

// Assumptions: K >= 1

public class KthSmallestWithFactorsTwoThree {

	// Solution 1: BFS + heap (with hash set)
	public int kth(int k) {
		Set<Integer> set = new HashSet<>();
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		set.add(1);
		minHeap.add(1);
		for (int i = 0; i < k - 1; i++) {
			int cur = minHeap.poll();
			if (set.add(2 * cur)) {
				minHeap.add(2 * cur);
			}
			if (set.add(3 * cur)) {
				minHeap.add(3 * cur);
			}
		}
		return minHeap.peek();
	}

	// Time complexity is O(k * log(k)).
	// Space complexity is O(k).

	// Solution 2: BFS (no need to use heap nor hash set)
	public int kth2(int k) {
		int result = 1;
		LinkedList<Integer> two = new LinkedList<>();
		LinkedList<Integer> three = new LinkedList<>();
		two.offerLast(2 * result);
		three.offerLast(3 * result);
		for (int i = 0; i < k - 1; i++) {
			if (two.peekFirst() < three.peekFirst()) {
				result = two.pollFirst();
				two.offerLast(2 * result);
				three.offerLast(3 * result);
			} else {
				result = three.pollFirst();
				three.offerLast(3 * result);
			}
		}
		return result;
	}

	// Time complexity is O(k).
	// Space complexity is O(k).
}
