package arrayHopper4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

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
		Set<Integer> set = new HashSet<>();
		LinkedList<Integer> queue = new LinkedList<>();
		
		int[] minJump = new int[array.length];
		Arrays.fill(minJump, Integer.MAX_VALUE);
		minJump[index] = 0;
		
		set.add(index);
		queue.offerFirst(index);
		while (!queue.isEmpty()) {
			Integer cur = queue.pollLast();
			for (int i = cur - array[cur]; i <= cur + array[cur]; i++) {
				if (i >= 0 && i <= array.length - 1) {
					minJump[i] = Math.min(minJump[i], minJump[cur] + 1);
					if (set.add(i)) {
						queue.offerFirst(i);
					}
				}
			}
		}
		
		return minJump[minJump.length - 1] == Integer.MAX_VALUE ? -1 : minJump[minJump.length - 1];
	}


}
