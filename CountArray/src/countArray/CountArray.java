package countArray;

import java.util.Arrays;

// Given an array A with all positive integers, 
// return an array of integer B with the same length, 
// where B[i] represents the total number of integers in A, 
// whose index is greater than i, and value is smaller than A[i].

// For example, A = [ 4, 1, 3, 2 ], B = [ 3, 0, 1, 0 ]

public class CountArray {

	public int[] count(int[] array) {
		int[] indexArray = initialIndexArray(array);
		int[] countArray = new int[array.length];
		int[] helper = new int[array.length];
		mergeSort(array, indexArray, countArray, helper, 0, array.length - 1);
		return countArray;
	}

	private int[] initialIndexArray(int[] array) {
		int[] indices = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			indices[i] = i;
		}
		return indices;
	}

	private void mergeSort(int[] array, int[] indexArray, int[] countArray, int[] helper, int left, int right) {
		if (left >= right) {
			return;
		}
		int mid = left + (right - left) / 2;
		mergeSort(array, indexArray, countArray, helper, left, mid);
		mergeSort(array, indexArray, countArray, helper, mid + 1, right);
		merge(array, indexArray, countArray, helper, left, mid, right);
	}

	private void merge(int[] array, int[] indexArray, int[] countArray, int[] helper, int left, int mid, int right) {
		copyArray(indexArray, helper, left, right);
		int l = left;
		int r = mid + 1;
		int cur = left;
		while (l <= mid) {
			if (r > right || array[helper[l]] <= array[helper[r]]) {
				countArray[helper[l]] += (r - mid - 1);
				indexArray[cur++] = helper[l++];
			} else {
				indexArray[cur++] = helper[r++];
			}
		}
	}

	private void copyArray(int[] indexArray, int[] helper, int left, int right) {
		for (int i = left; i <= right; i++) {
			helper[i] = indexArray[i];
		}
	}

	// Time complexity is O(n * log(n)).
	// Space complexity is O(n).

	public static void main(String[] args) {
		CountArray countArray = new CountArray();
		int[] array = new int[] { 4, 1, 3, 2 };
		System.out.println(Arrays.toString(countArray.count(array)));
	}

}
