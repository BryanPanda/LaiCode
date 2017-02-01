package arrayDeduplication3;

import java.util.Arrays;

// Given a sorted integer array, remove duplicate elements. 
// For each group of elements with the same value do not keep any of them. 
// Do this in-place, using the left side of the original array and and maintain the relative order of the elements of the array. 
// Return the array after deduplication.

public class ArrayDeduplication3 {

	public int[] dedup(int[] array) {
		if (array == null || array.length <= 1) {
			return array;
		}
		int slow = 0; // not including slow
		int fast = 0;
		while (fast < array.length) {
			int begin = fast;
			while (fast < array.length && array[fast] == array[begin]) {
				fast++;
			}
			if (fast - begin == 1) {
				array[slow++] = array[begin];
			}
		}
		return Arrays.copyOf(array, slow);
	}

	// Time complexity is O(n).
	// Space complexity is O(1).

	// solution 2: use flag
	public int[] dedup2(int[] array) {
		if (array == null || array.length <= 1) {
			return array;
		}
		int slow = 0;
		boolean flag = false; // whether array[slow] is duplicate or not
		for (int fast = 1; fast < array.length; fast++) {
			if (array[fast] == array[slow]) {
				flag = true;
			} else if (flag == true) {
				array[slow] = array[fast];
				flag = false;
			} else {
				array[++slow] = array[fast];
			}
		}
		return Arrays.copyOf(array, flag ? slow : slow + 1);
	}

	// Time complexity is O(n).
	// Space complexity is O(1).

	// solution 3: for each element, check its left and right neighbors to see
	// if it is a duplicate
	public int[] dedup3(int[] array) {
		if (array == null || array.length <= 1) {
			return array;
		}
		int slow = 0; // not including slow
		for (int fast = 0; fast < array.length; fast++) {
			if (fast == 0) {
				if (array[fast] != array[fast + 1]) {
					array[slow++] = array[fast];
				}
			} else if (fast > 0 && fast < array.length - 1) {
				if (array[fast - 1] != array[fast] && array[fast] != array[fast + 1]) {
					array[slow++] = array[fast];
				}
			} else {
				if (array[fast - 1] != array[fast]) {
					array[slow++] = array[fast];
				}
			}
		}
		return Arrays.copyOf(array, slow);
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
