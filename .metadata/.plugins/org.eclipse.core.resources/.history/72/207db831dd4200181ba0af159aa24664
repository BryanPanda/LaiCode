package longestAscendingSubSequence;

import java.util.Arrays;

// LeetCode 300.

// Given an array A[0]...A[n-1] of integers, find out the length of the longest ascending subsequence.

// Assumption: A is not null.

public class LongestAscendingSubSequence {

	// M[i]: the length of longest ascending subsequence, ending at array[i]
	public int longest(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int max = 1;
		int[] result = new int[array.length];
		Arrays.fill(result, 1);
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				if (array[j] < array[i]) {
					result[i] = Math.max(result[i], result[j] + 1);
					max = Math.max(result[i], max);
				}
			}
		}
		return max;
	}

	// Time complexity is O(n^2).
	// Space complexity is O(n).

	public int longest2(int[] array) {
		if (array.length == 0) {
			return 0;
		}
		// tbl[i]: the smallest ending value of all the ascending subsequences
		// with length i
		int[] tbl = new int[array.length + 1];
		int result = 1;
		tbl[1] = array[0];
		for (int i = 1; i < array.length; i++) {
			// tbl is guaranteed to be in ascending order
			int index = find(tbl, 1, result, array[i]);
			if (index == result) { // tbl[result] < array[i]
				tbl[++result] = array[i];
			} else {
				tbl[index + 1] = array[i];
			}
		}
		return result;
	}

	// find the largest value that is smaller than target
	private int find(int[] tbl, int left, int right, int target) {
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (tbl[mid] >= target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return right;
	}

	// Time complexity is O(n * log(n)).
	// Space complexity is O(n).
}
