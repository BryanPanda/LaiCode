package twoSumClosest;

import java.util.Arrays;
import java.util.List;

// Find the pair of elements in a given array that sum to a value that is closest to the given target number. 
// Return the values of the two numbers.

public class TwoSumClosest {

	public List<Integer> closest(int[] array, int target) {
		int minDiff = Integer.MAX_VALUE, one = 0, two = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (Math.abs(array[i] + array[j] - target) < minDiff) {
					minDiff = Math.abs(array[i] + array[j] - target);
					one = array[i];
					two = array[j];
				}
			}
		}
		return Arrays.asList(one, two);
	}

	// Time complexity is O(n^2).
	// Space complexity is O(1).

	public List<Integer> closest2(int[] array, int target) {
		Arrays.sort(array);
		int minDiff = Integer.MAX_VALUE, left = 0, right = array.length - 1;
		int one = 0, two = 0;
		while (left < right) {
			if (Math.abs(array[left] + array[right] - target) < minDiff) {
				minDiff = Math.abs(array[left] + array[right] - target);
				one = array[left];
				two = array[right];
			}
			if (array[left] + array[right] == target) {
				return Arrays.asList(one, two);
			} else if (array[left] + array[right] < target) {
				left++;
			} else {
				right--;
			}
		}
		return Arrays.asList(one, two);
	}

	// Time complexity is O(n^2) in the worst case, because Arrays.sort() uses
	// Quick Sort for primitive types.
	// Space complexity is O(n) in the worst case, because of call-stack.

	public static void main(String[] args) {
		TwoSumClosest twoSumClosest = new TwoSumClosest();
		int[] array = new int[] { 1, 4, 7, 13 };
		System.out.println(twoSumClosest.closest2(array, 3));
		System.out.println(twoSumClosest.closest2(array, 8));
		System.out.println(twoSumClosest.closest2(array, 12));
	}

}
