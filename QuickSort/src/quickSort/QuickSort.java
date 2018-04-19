package quickSort;

public class QuickSort {

	public int[] sort(int[] array) {
		if (array == null || array.length == 0) {
			return array;
		}
		quickSort(array, 0, array.length - 1);
		return array;
	}

	private void quickSort(int[] array, int left, int right) {
		if (left >= right) {
			return;
		}
		int pivotPosition = partition(array, left, right);
		quickSort(array, left, pivotPosition - 1);
		quickSort(array, pivotPosition + 1, right);
	}

	private int partition(int[] array, int left, int right) {
		// guaranteed left < right
		int pivotIndex = pivotIndex(left, right);
		int pivot = array[pivotIndex];
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

	private int pivotIndex(int left, int right) {
		return left + (int) Math.random() * (right - left + 1);
	}

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	// Time complexity is O(n^2) in the worst case, and
	// O(n*log(n)) in the best and average cases.
	// Space complexity is O(n) in the worst case, and 
	// O(log(n)) in the best and average cases, because of call-stack.
}
