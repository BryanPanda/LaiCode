package longestConsecutiveOnes;

// Given an array containing only 0s and 1s, find the length of the longest subarray of consecutive 1s.

// Assumption: The given array is not null

public class LongestConsecutiveOnes {

	public int longest(int[] array) {
		if (array.length == 0) {
			return 0;
		}
		int cur = 0, max = 0;
		for (int i = 0; i < array.length; i++) {
			cur = array[i] == 0 ? 0 : cur + 1;
			max = Math.max(cur, max);
		}
		return max;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
