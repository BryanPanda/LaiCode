package maximumValuesOfSizeKSlidingWindows;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// LeetCode #239 (Sliding Window Maximum).

// Given an integer array A and a sliding window of size K, 
// find the maximum value of each window as it slides from left to right.

// Assumptions:
// 1. The given array is not null and is not empty.
// 2. K >= 1, K <= A.length.

public class MaximumValuesOfSizeKSlidingWindows {

	public List<Integer> maxWindows(int[] array, int k) {
		List<Integer> result = new ArrayList<Integer>();
		// a descending deque, but stores indices instead of actual values
		Deque<Integer> deque = new LinkedList<>();
		for (int i = 0; i < array.length; i++) {
			// discard indices with value smaller than array[i]
			while (!deque.isEmpty() && array[deque.peekLast()] <= array[i]) {
				deque.pollLast();
			}
			if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
				deque.pollFirst();
			}
			deque.offerLast(i);
			if (i >= k - 1) {
				result.add(array[deque.peekFirst()]);
			}
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(k).

	// Note: Using priority queue, time complexity is O(n*k), because remove(...)
	// take O(k) time.
}
