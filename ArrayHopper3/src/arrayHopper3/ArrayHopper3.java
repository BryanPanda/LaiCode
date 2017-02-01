package arrayHopper3;

import java.util.Arrays;

// Given an array of non-negative integers, you are initially positioned at index 0 of the array. 
// A[i] means the maximum jump distance from that position (you can only jump towards the end of the array). 
// Determine the minimum number of jumps you need to jump out of the array.
// By jump out, it means you can not stay at the end of the array. 
// Return -1 if you can not do so.

// Assumption: The given array is not null and has length of at least 1.

public class ArrayHopper3 {

	// DP solution 1
	public int minJump(int[] array) {
		if (array.length == 1) {
			return array[0] == 0 ? -1 : 1;
		}
		int[] minJump = new int[array.length];
		Arrays.fill(minJump, Integer.MAX_VALUE);
		minJump[minJump.length - 1] = array[array.length - 1] == 0 ? Integer.MAX_VALUE : 1;
		for (int i = array.length - 2; i >= 0; i--) {
			if (i + array[i] > array.length - 1) {
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
			return array[0] == 0 ? -1 : 1;
		}
		int[] minJump = new int[array.length + 1];
		for (int i = 1; i < array.length + 1; i++) {
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
			return array[0] == 0 ? -1 : 1;
		}
		int jump = 0; // number of jumps so far
		int cur = 0; // max index that current steps can reach
		int next = 0; // max index that (current + 1) steps can reach
		for (int i = 0; i <= array.length; i++) {
			if (i > cur) {
				// if index i can NOT be reached by current steps
				// jump one more step
				jump++;
				if (cur == next) {
					return -1;
				}
				cur = next;
			}
			next = (i == array.length) ? next : Math.max(next, array[i] + i);
		}
		return jump;
	}

	// Time Complexity is O(n).
	// Space Complexity is O(1).
}
