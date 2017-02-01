package arrayHopper4;

import java.util.Arrays;

// Given an array A of non-negative integers, you are initially positioned at an arbitrary index of the array. 
// A[i] means the maximum jump distance from that position (you can either jump left or jump right). 
// Determine the minimum jumps you need to reach the right end of the array. 
// Return -1 if you can not reach the right end of the array.

// Assumption: 
// 1. The given array is not null and has length of at least 1.
// 2. index is legal, in other words, it is within range [0, array.length - 1].

public class ArrayHopper4 {

	public int minJump(int[] array, int index) {
		if (array.length == 1) {
			return 0;
		}
		int[] minJump = forward(array);
		minJump = bothDirection(array, minJump);
		return minJump[index] == Integer.MAX_VALUE ? -1 : minJump[index];
	}

	private int[] forward(int[] array) {
		// guaranteed array.length > 1
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
		return minJump;
	}

	private int[] bothDirection(int[] array, int[] minJump) {
		for (int i = array.length - 1; i >= 0; i--) {
			for (int j = 1; j <= array[i] && i - j >= 0 && minJump[i - j] < Integer.MAX_VALUE; j++) {
				minJump[i] = Math.min(minJump[i], 1 + minJump[i - j]);
			}
		}
		return minJump;
	}

	public static void main(String[] args) {
		ArrayHopper4 arrayHopper4 = new ArrayHopper4();
		System.out.println(arrayHopper4.minJump(new int[] { 5, 1, 1, 1, 0, 4 }, 2));
	}

}
