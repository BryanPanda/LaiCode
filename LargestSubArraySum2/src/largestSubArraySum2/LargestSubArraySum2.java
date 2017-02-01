package largestSubArraySum2;

// Given an unsorted integer array, find the start and end indices of the sub-array
// that has the greatest sum. 
// Return the start and end indices.

// Assumption: The given array is not null and has length of at least 1.

public class LargestSubArraySum2 {

	public int[] largestSum(int[] array) {
		int cur = array[0], max = array[0];
		int curLeft = 0, curRight = 0, resultLeft = 0, resultRight = 0;
		for (int i = 1; i < array.length; i++) {
			if (cur < 0) {
				curLeft = curRight = i;
				cur = array[i];
			} else {
				curRight = i;
				cur += array[i];
			}
			if (max < cur) {
				resultLeft = curLeft;
				resultRight = curRight;
				max = cur;
			}
		}
		return new int[] { resultLeft, resultRight };
	}

	// Time Complexity is O(n).
	// Space Complexity is O(1).
}
