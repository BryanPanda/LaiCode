package largestRectangleInHistogram;

import java.util.*;

// Given a non-negative integer array representing the heights of a list of adjacent bars.
// Suppose each bar has a width of 1. Find the largest rectangular area that can be formed
// in the histogram.

public class LargestRectangleInHistogram {

	public int largest(int[] array) {
		LinkedList<Integer> stack = new LinkedList<>();
		int area = 0;
		for (int i = 0; i <= array.length; i++) {
			int cur = (i == array.length) ? 0 : array[i];
			while (!stack.isEmpty() && array[stack.peekFirst()] >= cur) {
				int height = array[stack.pollFirst()];
				int left = (stack.size() == 0) ? 0 : stack.peekFirst() + 1;
				area = Math.max(area, height * (i - left));
			}
			stack.offerFirst(i);
		}
		return area;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
