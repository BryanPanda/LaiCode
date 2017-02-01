package kthSmallestInArray;

// Given an array of N items, find the k-th smallest element.

// Assumption: array != null && array.length > 0, 0 <= k <= array.length - 1

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
		// swap the pivot element to the rightmost position
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

	// Time complexity is O(n^2) in the worst case, but O(n) in the average
	// case;
	// Space complexity is O(1).

	public static void main(String[] args) {
		KthSmallestInArray kthSmallestInArray = new KthSmallestInArray();
		int[] array = new int[] { 2, 4, 1, 5, 3 };
		System.out.println(kthSmallestInArray.select(array, 0));
		System.out.println(kthSmallestInArray.select(array, 1));
		System.out.println(kthSmallestInArray.select(array, 2));
		System.out.println(kthSmallestInArray.select(array, 3));
		System.out.println(kthSmallestInArray.select(array, 4));
	}

}
