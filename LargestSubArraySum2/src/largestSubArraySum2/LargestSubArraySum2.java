package largestSubArraySum2;

// Given an unsorted integer array, find the subarray that has the greatest sum. 

// Return the sum and the indices of the left and right boundaries of the subarray.
// If there are multiple solutions, return the leftmost subarray.

// Assumptions:
// 1. The given array is not null and has length of at least 1.

public class LargestSubArraySum2 {

	public int[] largestSum(int[] array) {
		int cur = array[0], max = array[0];
		int tempStart = 0, start = 0, end = 0;
		for (int i = 1; i < array.length; i++) {
			if (cur >= 0) {
				cur += array[i];
			}
			else {
				cur = array[i];
				tempStart = i;
			}
			if (cur > max) {
				max = cur;
				start = tempStart;
				end = i;
			}
		}
		return new int[] { max, start, end };
	}

	// Time Complexity is O(n).
	// Space Complexity is O(1).
}
