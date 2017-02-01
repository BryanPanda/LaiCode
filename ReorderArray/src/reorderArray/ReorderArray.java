package reorderArray;

//Given an array of elements, reorder it as follow:
//{ N1, N2, N3, ..., N2k } -> { N1, Nk+1, N2, Nk+2, N3, Nk+3, ..., Nk, N2k }
//{ N1, N2, N3, ..., N2k+1 } -> { N1, Nk+1, N2, Nk+2, N3, Nk+3, ..., Nk, N2k, N2k+1 }

//Assumption: The given array is not null.

public class ReorderArray {

	public int[] reorder(int[] array) {
		if (array.length % 2 == 0) {
			reorder(array, 0, array.length - 1);
		} else {
			reorder(array, 0, array.length - 2);
		}
		return array;
	}

	private void reorder(int[] array, int left, int right) {
		int length = right - left + 1;
		if (length <= 2) {
			return;
		}
		int mid = left + length / 2;
		int lmid = left + length / 4;
		int rmid = left + length * 3 / 4;
		reverse(array, lmid, mid - 1);
		reverse(array, mid, rmid - 1);
		reverse(array, lmid, rmid - 1);
		reorder(array, left, left + (lmid - left) * 2 - 1);
		reorder(array, left + (lmid - left) * 2, right);
	}

	private void reverse(int[] array, int left, int right) {
		while (left < right) {
			int temp = array[left];
			array[left] = array[right];
			array[right] = temp;
			left++;
			right--;
		}
	}

	// Time complexity is O(n*log(n)).
	// Space complexity is O(log(n)).

	// solution 2
	public int[] reorder2(int[] array) {
		reorder2(array, 0, array.length - (array.length % 2));
		return array;
	}

	private void reorder2(int[] array, int first, int last) {
		int size = last - first;
		if (size <= 2)
			return;
		int middle = rotate(array, first + size / 4, first + size / 2, first + 3 * size / 4);
		reorder2(array, first, middle);
		reorder2(array, middle, last);
	}

	private int rotate(int[] array, int first, int middle, int last) {
		int next = middle, result = last + first - middle;
		while (first != next) {
			swap(array, first++, next++);
			if (next == last)
				next = middle;
			else if (first == middle)
				middle = next;
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

	// solution 3: my solution...
	public int[] reorder3(int[] array) {
		// Write your solution here.
		helper(array, 0, array.length - 1);
		return array;
	}

	private void helper(int[] array, int left, int right) {
		// base case
		if (left >= right) {
			return;
		}
		// recursive rule
		// up to this point, left < right
		helper(array, left + 1, right);
		if ((right - left) % 2 == 1) {
			swapPairs(array, left + 1, right);
		} else {
			rotate(array, left + 1, right - 1);
		}
	}

	private void swapPairs(int[] array, int left, int right) {
		// up to here, (right - left) % 2 == 0
		// there are a odd number of integers
		for (int i = left; i < right; i = i + 2) {
			swap(array, i, i + 1);
		}
	}

	private void rotate(int[] array, int left, int right) {
		reverse(array, left, right - 1);
		reverse(array, left, right);
	}

	// Time complexity is O(n^2).
	// Space complexity is O(n).
}
