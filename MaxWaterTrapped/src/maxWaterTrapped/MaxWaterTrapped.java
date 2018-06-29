package maxWaterTrapped;

// LeetCode #42 (Trapping Rain Water).

// Given a non-negative integer array representing the heights of a list of adjacent bars. 
// Suppose each bar has a width of 1. Find the largest amount of water that can be trapped in the histogram.

// Assumption: The given array is not null

public class MaxWaterTrapped {

	// Brute force
	public int maxTrapped(int[] array) {
		int result = 0;
		for (int i = 0; i < array.length; i++) {
			int maxLeft = 0, maxRight = 0;
			for (int j = i - 1; j >= 0; j--) {
				maxLeft = Math.max(maxLeft, array[j]);
			}
			for (int k = i + 1; k < array.length; k++) {
				maxRight = Math.max(maxRight, array[k]);
			}
			result += Math.max(Math.min(maxLeft, maxRight) - array[i], 0);
		}
		return result;
	}

	// Time complexity is O(n^2).
	// Space complexity is O(1).

	// DP
	// M1[i]: largest value in [0, i]
	// M2[i]: largest value in [i, n - 1]
	public int maxTrapped2(int[] array) {
		int result = 0;
		int[] left = new int[array.length];
		int[] right = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			left[i] = (i == 0 || array[i] > left[i - 1]) ? array[i] : left[i - 1];
		}
		for (int j = array.length - 1; j >= 0; j--) {
			right[j] = (j == array.length - 1 || array[j] > right[j + 1]) ? array[j] : right[j + 1];
		}
		for (int i = 0; i < array.length; i++) {
			result += Math.max(Math.min(left[i], right[i]) - array[i], 0);
		}
		return result;
	}

	// Time Complexity is O(n).
	// Space complexity is O(n)

	// Two pointers
	public int maxTrapped3(int[] array) {
		if (array.length == 0) {
			return 0;
		}
		int result = 0;
		int left = 0, right = array.length - 1;
		int leftMax = array[left], rightMax = array[right];
		while (left < right) {
			if (array[left] <= array[right]) {
				result += Math.max(0, leftMax - array[left]);
				leftMax = Math.max(leftMax, array[left]);
				left++;
			} else {
				result += Math.max(0, rightMax - array[right]);
				rightMax = Math.max(rightMax, array[right]);
				right--;
			}
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
