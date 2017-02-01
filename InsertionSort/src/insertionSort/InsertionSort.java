package insertionSort;

import java.util.Arrays;

public class InsertionSort {

	public int[] sort(int[] array) {
		if (array == null || array.length <= 1) {
			return array;
		}
		// up to this point, array != null && array.length > 1
		for (int i = 1; i < array.length; i++) {
			for (int j = i; j > 0; j--) {
				if (array[j] < array[j - 1]) {
					swap(array, j, j - 1);
				}
			}
		}
		return array;
	}

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	// Time complexity is O(n) in best case, O(n^2) in average case and worst case.
	// Space complexity is O(1).

	public static void main(String[] args) {
		InsertionSort selectionSort = new InsertionSort();
		int[] array = null;
		System.out.println(Arrays.toString(selectionSort.sort(array)));
		array = new int[0];
		System.out.println(Arrays.toString(selectionSort.sort(array)));
		array = new int[] { 0 };
		System.out.println(Arrays.toString(selectionSort.sort(array)));
		array = new int[] { -1, -3, 4, 7 };
		System.out.println(Arrays.toString(selectionSort.sort(array)));
		array = new int[] { 1, 2, 3, 4 };
		System.out.println(Arrays.toString(selectionSort.sort(array)));
		array = new int[] { 4, 3, 2, 1 };
		System.out.println(Arrays.toString(selectionSort.sort(array)));
		array = new int[] { 2, 4, 1, 5, 3 };
		System.out.println(Arrays.toString(selectionSort.sort(array)));
	}

}
