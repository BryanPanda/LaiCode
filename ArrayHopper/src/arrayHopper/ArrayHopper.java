package arrayHopper;

// LeetCode #55 (Jump Game).

// Given an array A of non-negative integers, you are initially positioned at index 0 of the array. 
// A[i] means the maximum jump distance from that position (you can only jump towards the end of the array). 
// Determine if you are able to reach the last index.

// Assumption: The given array is not null and has length of at least 1.

public class ArrayHopper {

	// DP
	// M[i]: from index 0, can jump to index i
	public boolean canJump(int[] array) {
		boolean[] canJump = new boolean[array.length];
		canJump[0] = true;
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				if (canJump[j] && j + array[j] >= i) {
					canJump[i] = true;
					break;
				}
			}
		}
		return canJump[canJump.length - 1];
	}

	// Time complexity is O(n^2).
	// Space complexity is O(n).

	// greedy
	public boolean canJump2(int[] nums) {
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			max = max < i ? max : Math.max(max, i + nums[i]);
		}
		return max >= nums.length - 1;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
