package selectionSort;

import java.util.Arrays;

public class SelectionSort {

	public int[] sort(int[] array) {
		// Write your solution here.
		if (array == null || array.length <= 1) {
			return array;
		}
		// up to this point, array != null && array.length > 1
		for (int i = 0; i < array.length - 1; i++) {
			int min = array[i];
			int index = i;
			for (int j = i; j < array.length; j++) {
				if (array[j] < min) {
					min = array[j];
					index = j;
				}
			}
			swap(array, i, index);
		}
		return array;
	}

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	// Time complexity is O(n^2) in best case, average case, and worst case.
	// Space complexity is O(1).

	public static void main(String[] args) {
		SelectionSort selectionSort = new SelectionSort();
		int[] array = null;
		System.out.println(Arrays.toString(selectionSort.sort(array)));
		array = new int[0];
		System.out.println(Arrays.toString(selectionSort.sort(array)));
		array = new int[] {0};
		System.out.println(Arrays.toString(selectionSort.sort(array)));
		array = new int[] {-1, -3, 4, 7};
		System.out.println(Arrays.toString(selectionSort.sort(array)));
		array = new int[] {1, 2, 3, 4};
		System.out.println(Arrays.toString(selectionSort.sort(array)));
		array = new int[] {4, 3, 2, 1};
		System.out.println(Arrays.toString(selectionSort.sort(array)));
		array = new int[] {2, 4, 1, 5, 3};
		System.out.println(Arrays.toString(selectionSort.sort(array)));
	}
}
