package largestAndSmallest;

// Use the least number of comparisons to get the largest and smallest number in the given integer array. 
// Return the largest number and the smallest number.

// Assumption: The given array is not null and has length of at least 1

public class LargestAndSmallest {

	// binary reduction
	public int[] largestAndSmallest(int[] array) {
		for (int i = 0; i < array.length / 2; i++) {
			if (array[i] > array[array.length - 1 - i]) {
				swap(array, i, array.length - 1 - i);
			}
		}
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i <= (array.length - 1) / 2; i++) {
			// why (array.length - 1) / 2?
			if (array[i] < min) {
				min = array[i];
			}
		}
		for (int i = array.length / 2; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return new int[] { max, min };
	}

	// The number of comparison is 1.5 * N
	// Time complexity is O(n).
	// Space complexity is O(1).

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
