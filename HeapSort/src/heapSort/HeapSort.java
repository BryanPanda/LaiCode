package heapSort;

import java.util.Arrays;

// Given a matrix of size N x M. For each row the elements are sorted in ascending order, and for each column the elements are also sorted in ascending order. 
// Find the k-th smallest number in it.

public class HeapSort {

	public int[] sort(int[] array) {
		if (array == null || array.length == 0) {
			return array;
		}
		// heapify
		int n = array.length;
		for (int i = n / 2 - 1; i >= 0; i--) {
			percolateDown(i, n, array);
		}
		while (n > 0) {
			swap(array, 0, n - 1);
			percolateDown(0, --n, array);
		}

		return array;
	}

	private void percolateDown(int index, int size, int[] array) {
		while (index < size / 2) {
			// has at least one child, might not have the right child
			int left = 2 * index + 1; // left child index
			int right = 2 * index + 2; // right child index
			int swap = left; // index to be swapped
			if (right < size && array[right] > array[left]) {
				// if right child exists, and is smaller than right child
				swap = right;
			}
			if (array[index] < array[swap]) {
				swap(array, index, swap);
			} else {
				break;
			}
			index = swap;
		}
	}

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	// Time complexity is O(n*log(n)) in the worst case.
	// Space complexity is O(1).
	// Unstable.

	public static void main(String[] args) {
		HeapSort heapSort = new HeapSort();
		int[] array = null;
		System.out.println(Arrays.toString(heapSort.sort(array)));
		array = new int[] {};
		System.out.println(Arrays.toString(heapSort.sort(array)));
		array = new int[] { 2, 1, 3 };
		System.out.println(Arrays.toString(heapSort.sort(array)));
		array = new int[] { 3, 1, 2, 4, 6, 5 };
		System.out.println(Arrays.toString(heapSort.sort(array)));
	}
}
