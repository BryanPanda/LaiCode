package reorderArray;

// Given an array of elements, reorder it as follows:

// { N1, N2, N3, ..., N2k } -> { N1, Nk+1, N2, Nk+2, N3, Nk+3, ..., Nk, N2k }
// { N1, N2, N3, ..., N2k+1 } -> { N1, Nk+1, N2, Nk+2, N3, Nk+3, ..., Nk, N2k, N2k+1 }

// Assumption: The given array is not null.

public class ReorderArray {

	public int[] reorder(int[] array) {
		reorder(array, 0, array.length - (array.length % 2));
		return array;
	}

	private void reorder(int[] array, int first, int last) {
		int size = last - first;
		if (size <= 2) {
			return;
		}
		int middle = rotate(array, first + size / 4, first + size / 2, first + 3 * size / 4);
		reorder(array, first, middle);
		reorder(array, middle, last);
	}

	private int rotate(int[] array, int first, int middle, int last) {
		int next = middle, result = last + first - middle;
		while (first != next) {
			swap(array, first++, next++);
			if (next == last) {
				next = middle;
			} else if (first == middle) {
				middle = next;
			}
		}
		return result;
	}

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	// Time complexity is O(n*log(n)).
	// Space complexity is O(log(n)).
}
