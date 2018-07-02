package kthSmallestInArray;

// LeetCode #215 (Kth Largest Element in Array).

// Given an array of N items, find the k-th smallest element.

public class KthSmallestInArray {

	public int select(int[] array, int k) {
		int low = 0, high = array.length - 1;
		while (low < high) {
			int j = partition(array, low, high);
			if (j < k) {
				low = j + 1;
			} else if (j > k) {
				high = j - 1;
			} else {
				return array[k];
			}
		}
		return array[k];
	}

	private int partition(int[] array, int left, int right) {
		// randomly select a pivot position
		int pivotIndex = left + (int) (Math.random() * (right - left + 1));
		int pivot = array[pivotIndex];
		// swap the pivot element with the right-most element
		swap(array, pivotIndex, right);
		int leftBound = left;
		int rightBound = right - 1;
		while (leftBound <= rightBound) {
			if (array[leftBound] < pivot) {
				leftBound++;
			} else if (array[rightBound] >= pivot) {
				rightBound--;
			} else {
				swap(array, leftBound++, rightBound--);
			}
		}
		swap(array, leftBound, right);
		return leftBound;
	}

	private void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	// Time complexity is O(n), if array is randomly shuffled.
	// Space complexity O(log(n)), if array is randomly shuffled.
}
