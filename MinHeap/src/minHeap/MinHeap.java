package minHeap;

import java.util.NoSuchElementException;

public class MinHeap {

	// array starts from index 0,
	// indices of the two children are 2*i+1, and 2*i+2
	// index of parent is (i-1)/2
	private int[] array;
	private int size;

	public MinHeap(int[] array) {
		if (array == null || array.length == 0) {
			throw new IllegalArgumentException("Input array can not be null or empty.");
		}
		this.array = array;
		this.size = array.length;
		heapify();
	}

	public MinHeap(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException("Capacity can not be negative.");
		}
		this.array = new int[capacity];
		this.size = 0;
	}

	private void heapify() {
		for (int i = size / 2 - 1; i >= 0; i--) {
			percolateDown(i);
		}
	}

	private void percolateUp(int index) {
		while (index > 0) {
			if (array[index] < array[(index - 1) / 2]) {
				swap(array, index, (index - 1) / 2);
			} else {
				break;
			}
			index = (index - 1) / 2;
		}
	}

	private void percolateDown(int index) {
		while (index < size / 2) {
			// has at least one child, might not have the right child
			int left = 2 * index + 1; // left child index
			int right = 2 * index + 2; // right child index
			int swap = left; // index to be swapped
			if (right < size && array[right] < array[left]) {
				// if right child exists, and is smaller than right child
				swap = right;
			}
			if (array[index] > array[swap]) {
				swap(array, index, swap);
			} else {
				break;
			}
			index = swap;
		}
	}

	public int peek() {
		if (size == 0) {
			throw new NoSuchElementException("Heap is empty.");
		}
		return array[0];
	}

	public int poll() {
		if (size == 0) {
			throw new NoSuchElementException("Heap is empty.");
		}
		int result = array[0];
		array[0] = array[size - 1];
		size--;
		percolateDown(0);
		return result;
	}

	public void offer(int value) {
		if (isFull()) {
			int[] newArray = new int[array.length * 2];
			System.arraycopy(array, 0, newArray, 0, array.length);
			array = newArray;
		}
		array[size] = value;
		size++;
		percolateUp(size - 1);
	}

	public int update(int index, int value) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("Index is not valid.");
		}
		int result = array[index];
		array[index] = value;
		if (value < result) {
			percolateUp(index);
		} else {
			percolateDown(index);
		}
		return result;
	}

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public boolean isFull() {
		return this.size == array.length;
	}

}
