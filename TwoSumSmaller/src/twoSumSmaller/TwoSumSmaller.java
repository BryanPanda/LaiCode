package twoSumSmaller;

import java.util.Arrays;

// Determine the number of pairs of elements in a given array that sum to a value 
// smaller than the given target number.

public class TwoSumSmaller {

	public int smallerPairs(int[] array, int target) {
		int result = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] + array[j] < target) {
					result++;
				}
			}
		}
		return result;
	}

	// Time complexity is O(n^2).
	// Space complexity is O(1).

	public int smallerPairs2(int[] array, int target) {
		// Assume array != null && array.length >= 2
		Arrays.sort(array);
		int result = 0, left = 0, right = array.length - 1;
		while (right > 0 && array[0] + array[right] >= target) {
			right--;
		}
		// up to this point, right <= 0 || array[0] + array[right] < target
		if (right <= 0) {
			return result;
		}
		// right > 0 && array[0] + array[right] < target
		while (left < right) {
			if (array[left] + array[right] < target) {
				result += right - left;
				left++;
			} else {
				right--;
			}
		}
		return result;
	}

	// Time complexity is O(n^2) in the worst case, because Arrays.sort() uses
	// Quick Sort for primitive types.
	// Space complexity is O(n) in the worst case, because of call-stack.

	public static void main(String[] agrs) {
		TwoSumSmaller twoSumSmaller = new TwoSumSmaller();
		int[] array = new int[] { -1, 0, 1 };
		System.out.println(twoSumSmaller.smallerPairs2(array, 2));
		array = new int[] { 1, 2, 2, 4, 7 };
		System.out.println(twoSumSmaller.smallerPairs2(array, 7));
	}

}
