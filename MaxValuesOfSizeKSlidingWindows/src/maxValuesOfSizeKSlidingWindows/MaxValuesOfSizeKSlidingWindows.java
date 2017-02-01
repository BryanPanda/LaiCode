package maxValuesOfSizeKSlidingWindows;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// Given an integer array A and a sliding window of size K, 
// find the maximum value of each window as it slides from left to right.

// Assumptions:
// 1. The given array is not null and is not empty
// 2. K >= 1, K <= A.length

public class MaxValuesOfSizeKSlidingWindows {

	public List<Integer> maxWindows(int[] array, int k) {
		List<Integer> result = new ArrayList<Integer>();
		// a descending deque with indices stored in it
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

	public static void main(String[] agrs) {
		MaxValuesOfSizeKSlidingWindows maxValuesOfSizeKSlidingWindows = new MaxValuesOfSizeKSlidingWindows();
		int[] array = new int[] { 1, 2, 3, 2, 4, 2, 1 };
		System.out.println(maxValuesOfSizeKSlidingWindows.maxWindows(array, 3).toString());
	}
}
