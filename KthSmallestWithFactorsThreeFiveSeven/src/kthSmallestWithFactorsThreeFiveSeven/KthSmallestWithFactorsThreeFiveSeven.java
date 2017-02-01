package kthSmallestWithFactorsThreeFiveSeven;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;

// Find the K-th smallest number s such that s = (3^x) * (5^y) * (7^z), 
// x > 0 and y > 0 and z > 0, x, y, z are all integers.

// Assumption: K >= 1

public class KthSmallestWithFactorsThreeFiveSeven {

	// Solution 1: BFS2
	public long kth(int k) {
		Set<Long> visited = new HashSet<>();
		PriorityQueue<Long> minHeap = new PriorityQueue<>(k);
		minHeap.add(3 * 5 * 7L);
		visited.add(3 * 5 * 7L);
		for (int i = 0; i < k - 1; i++) {
			Long cur = minHeap.poll();
			if (visited.add(3 * cur)) {
				minHeap.offer(3 * cur);
			}
			if (visited.add(5 * cur)) {
				minHeap.offer(5 * cur);
			}
			if (visited.add(7 * cur)) {
				minHeap.offer(7 * cur);
			}
		}
		return minHeap.peek();
	}

	// Notice: we could use a 3-D space to keep a record of x, y, z, but it is
	// not necessary, and takes extra space.
	// However, notice that all 3 factors are co-prime with each other,
	// hence every product is unique, only under this condition can we use
	// Set<Long>.

	// What if the given factors are not co-prime with each other?
	// 1. Use List<Integer>() to keep the number of each factor, hash code of
	// List is already taken care of.
	// 2. Use a static class, but need to override int hashcode() ourselves.

	// Time complexity is O(k*log(k)).
	// Space complexity is O(k).

	// Solution 2: linear in time, with 3 deques
	public long kth2(int k) {
		long base = 3 * 5 * 7L;
		long result = base;
		Deque<Long> three = new LinkedList<>();
		Deque<Long> five = new LinkedList<>();
		Deque<Long> seven = new LinkedList<>();
		three.add(base * 3);
		five.add(base * 5);
		seven.add(base * 7);
		for (int i = 0; i < k - 1; i++) {
			if (three.peekFirst() < five.peekFirst() && three.peekFirst() < seven.peekFirst()) {
				result = three.pollFirst();
				three.offerLast(result * 3);
				five.offerLast(result * 5);
				seven.offerLast(result * 7);
			} else if (five.peekFirst() < three.peekFirst() && five.peekFirst() < seven.peekFirst()) {
				result = five.pollFirst();
				// don't need to insert to Deque<Long> three, because result * 3
				// has already been generated, in previous steps
				five.offerLast(result * 5);
				seven.offerLast(result * 7);
			} else {
				result = seven.pollFirst();
				// same here
				seven.offerLast(result * 7);
			}
		}
		return result;
	}

	// Time complexity is O(k).
	// Space complexity is O(k).
}
