package largestSubArraySum;

// LeetCode #53 (Maximum Subarray).

// Given an unsorted integer array, find the subarray that has the greatest sum. 
// Return the sum.

// Assumption: The given array is not null and has length of at least 1.

public class LargestSubArraySum {

	public int largestSum(int[] array) {
		int cur = array[0], max = array[0];
		for (int i = 1; i < array.length; i++) {
			cur = Math.max(array[i], cur + array[i]);
			max = Math.max(max, cur);
		}
		return max;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
	
	// Follow up: return the start and end indices of the largest subarray?
	// Largest Subarray Sum 2.
}
