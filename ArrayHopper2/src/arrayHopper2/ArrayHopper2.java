package arrayHopper2;

import java.util.Arrays;

// Given an array A of non-negative integers, you are initially positioned at index 0 of the array. 
// A[i] means the maximum jump distance from index i (you can only jump towards the end of the array). 
// Determine the minimum number of jumps you need to reach the end of array. 
// If you can not reach the end of the array, return -1.

// Assumption: The given array is not null and has length of at least 1.

public class ArrayHopper2 {

	// DP solution 1
	public int minJump(int[] array) {
		if (array.length == 1) {
			return 0;
		}
		int[] minJump = new int[array.length];
		Arrays.fill(minJump, Integer.MAX_VALUE);
		minJump[minJump.length - 1] = 0;
		for (int i = array.length - 2; i >= 0; i--) {
			if (i + array[i] >= array.length - 1) {
				minJump[i] = 1;
			} else {
				for (int j = 1; j <= array[i]; j++) {
					if (minJump[i + j] < Integer.MAX_VALUE) {
						minJump[i] = Math.min(minJump[i], minJump[i + j] + 1);
					}
				}
			}
		}
		return minJump[0] == Integer.MAX_VALUE ? -1 : minJump[0];
	}

	// Time complexity is O(n^2).
	// Space complexity is O(n).

	// DP solution 2
	public int minJump2(int[] array) {
		if (array.length == 1) {
			return 0;
		}
		int[] minJump = new int[array.length];
		for (int i = 1; i < array.length; i++) {
			minJump[i] = -1;
			for (int j = i - 1; j >= 0; j--) {
				if (j + array[j] >= i && minJump[j] != -1) {
					if (minJump[i] == -1 || minJump[i] > minJump[j] + 1) {
						minJump[i] = minJump[j] + 1;
					}
				}
			}
		}
		return minJump[minJump.length - 1];
	}

	// Time Complexity is O(n^2).
	// Space Complexity is O(n).

	// solution 3: greedy
	public int minJump3(int[] array) {
		if (array.length == 1) {
			return 0;
		}
		int jump = 0; // number of jumps so far
		int cur = 0; // max index that current steps can reach
		int next = 0; // max index that (current + 1) steps can reach
		for (int i = 0; i < array.length; i++) {
			if (i > cur) {
				// if index i can NOT be reached by current steps
				// jump one more step
				jump++;
				if (cur == next) {
					return -1;
				}
				cur = next;
			}
			next = Math.max(next, array[i] + i);
		}
		return jump;
	}

	// Time Complexity is O(n).
	// Space Complexity is O(1).
}
