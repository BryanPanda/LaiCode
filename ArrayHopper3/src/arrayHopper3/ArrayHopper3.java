package arrayHopper3;

import java.util.Arrays;

// Given an array of non-negative integers, you are initially positioned at index 0 of the array. 
// A[i] means the maximum jump distance from that position (you can only jump towards the end of the array). 
// Determine the minimum number of jumps you need to jump out of the array.
// By jump out, it means you can not stay at the end of the array. 
// Return -1 if you can not do so.

// Assumption: The given array is not null and has length of at least 1.

public class ArrayHopper3 {

	// DP
	// M[i]: from index 0, minimum number of jumps to index i
	public int minJump(int[] array) {
		int[] minJump = new int[array.length + 1];
		Arrays.fill(minJump, Integer.MAX_VALUE);
		minJump[0] = 0;
		for (int i = 1; i <= array.length; i++) {
			for (int j = 0; j < i; j++) {
				if (minJump[j] != Integer.MAX_VALUE && j + array[j] >= i) {
					minJump[i] = Math.min(minJump[i], minJump[j] + 1);
				}
			}
		}
		return minJump[minJump.length - 1] == Integer.MAX_VALUE ? -1 : minJump[minJump.length - 1];
	}

	// Time Complexity is O(n^2).
	// Space Complexity is O(n).

	// greedy
	public int minJump2(int[] array) {
		int jump = 0; // number of jumps so far
		int cur = 0; // max index that jump steps can reach
		int next = 0; // max index that (jump + 1) steps can reach
		for (int i = 0; i <= array.length; i++) {
			if (i > cur) { // index i can not be reached by jump steps
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
