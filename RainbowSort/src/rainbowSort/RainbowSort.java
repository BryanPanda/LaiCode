package rainbowSort;

// Given an array of balls, where the color of the balls can only be Red, Green or Blue, 
// sort the balls such that all the Red balls are grouped on the left side, all the Green balls 
// are grouped in the middle and all the Blue balls are grouped on the right side. 
// (Red is denoted by -1, Green is denoted by 0, and Blue is denoted by 1).

public class RainbowSort {

	public int[] rainbowSort(int[] array) {
		if (array == null || array.length <= 1) {
			return array;
		}
		// three bounds: i, j, k
		// [0, i): -1
		// [i, j): 0
		// [j, k]: to be discovered
		// (k, array.length - 1]: 1
		int i = 0, j = 0, k = array.length - 1;
		while (j <= k) {
			if (array[j] == -1) {
				swap(array, i++, j++);
			} else if (array[j] == 0) {
				j++;
			} else {
				swap(array, j, k--);
			}
		}
		return array;
	}

	private void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
	// Attention:
	// 1. definition of three bounds, each of them exclusive/inclusive
	// 2. j++ in swap(array, i++, j++)
}

