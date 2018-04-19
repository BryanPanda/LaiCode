package mergeSort;

public class MergeSort {
	public int[] sort(int[] array) {
		if (array == null || array.length <= 1) {
			return array;
		}
		// up to this point, array != null && array.length > 1
		int[] helper = new int[array.length];
		helper(array, helper, 0, array.length - 1);
		return array;
	}
	
	private void helper(int[] array, int[] helper, int left, int right) {
		if (left >= right) {
			return ;
		}
		int mid = left + (right - left) / 2;
		helper(array, helper, left, mid);
		helper(array, helper, mid + 1, right);
		merge(array, helper, left, mid, right);
	}
	
	private void merge(int[] array, int[] helper, int left, int mid, int right) {
		for (int i = left; i <= right; i++) {
			helper[i] = array[i];
		}
		int leftIndex = left, rightIndex = mid + 1;
		while (leftIndex <= mid && rightIndex <= right) {
			if (helper[leftIndex] <= helper[rightIndex]) {
				array[left++] = helper[leftIndex++];
			} else {
				array[left++] = helper[rightIndex++];
			}
		}
		while (leftIndex <= mid) {
			array[left++] = helper[leftIndex++];
		}
	}
	
	// Time complexity is O(n*log(n)).
	// Space complexity is O(n).
}
