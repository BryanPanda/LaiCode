package kSmallestInArray;

import java.util.*;

// Find the K smallest numbers in an unsorted integer array A. 
// The returned numbers should be in ascending order.

// Assumption: A is not null, 0 <= K <= size of A

public class KSmallestInArray {

	public int[] kSmallest(int[] array, int k) {
		if (k == 0) {
			return new int[0];
		}
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			list.add(array[i]);
		}
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(list);
		int[] result = new int[k];
		for (int i = 0; i < k; i++) {
			result[i] = minHeap.poll();
		}
		return result;
	}

	// Time complexity is O(n + k*log(n)) = O(n*log(n)).
	// Space complexity is O(n).
	
	public int[] kSmallest2(int[] array, int k) {
		if (k == 0) {
			return new int[0];
		}
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
			@Override
			public int compare(Integer one, Integer two) {
				if (one == two) {
					return 0;
				}
				return one > two ? -1 : 1;
			}
		});
		for (int i = 0; i < k; i++) {
			maxHeap.offer(array[i]);
		}
		for (int i = k; i < array.length; i++) {
			if (array[i] < maxHeap.peek()) {
				maxHeap.poll();
				maxHeap.offer(array[i]);
			}
		}
		int[] result = new int[k];
		for (int i = 0; i < k; i++) {
			result[k - 1 - i] = maxHeap.poll();
		}
		return result;
	}

	// Time complexity is O(k*log(k) + (n-k)*log(k) + k*log(k)) = O(n*log(n)).
	// Space complexity is O(k).

	public int[] kSmallest3(int[] array, int k) {
		if (array == null || array.length == 0 || k == 0) {
			return new int[0];
		}
		helper(array, k - 1, 0, array.length - 1);
		int[] result = Arrays.copyOfRange(array, 0, k);
		Arrays.sort(result);
		return result;
	}

	private void helper(int[] array, int k, int left, int right) {
		int pivot = partition(array, left, right);
		if (pivot == k) {
			return;
		} else if (pivot < k) {
			helper(array, k, pivot + 1, right);
		} else {
			helper(array, k, left, pivot - 1);
		}
	}

	private int partition(int[] array, int left, int right) {
		int pivotIndex = left + (int) (Math.random() * (right - left + 1));
		int pivotValue = array[pivotIndex];
		swap(array, pivotIndex, right);
		int i = left, j = right - 1;
		while (i <= j) {
			if (array[i] < pivotValue) {
				i++;
			} else if (array[j] >= pivotValue) {
				j--;
			} else {
				swap(array, i++, j--);
			}
		}
		// i > j
		swap(array, i, right);
		return i;
	}

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	// Time complexity is O(n^2) in the worst case, but O(n) in the average
	// case. Space complexity is O(n) in the worst case, but O(log(n)) in the average
	// case, because of call-stack.
	
	// Quick Sort: Time complexity is O(n^2) in the worst case, but
	// O(n*log(n)) in the average case. Space complexity is O(n) in the worst case,
	// but O(log(n)) in the average case, because of call-stack.
}
