package longestAscendingSubArray;

// LeetCode #674 (Longest Continuous Increasing Subsequence).

// Given an unsorted array, find the length of the longest subarray in which the numbers are in ascending order.

// Assumption: The given array is not null

public class LongestAscendingSubArray {

	// M[i]: length of the longest ascending subarray, from index 0 to i,
	// including i
	// M[i] = M[i - 1] + 1, if array[i] > array[i - 1]
	// M[i] = 1, otherwise
	public int longest(int[] array) { // optimized solution
		if (array == null || array.length == 0) {
			return 0;
		}
		int max = 1, cur = 1;
		for (int i = 1; i < array.length; i++) {
			if (array[i] > array[i - 1]) {
				cur++;
				max = Math.max(max, cur);
			} else {
				cur = 1;
			}
		}
		return max;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
