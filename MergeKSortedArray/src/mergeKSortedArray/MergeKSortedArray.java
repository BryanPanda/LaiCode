package mergeKSortedArray;

import java.util.Comparator;
import java.util.PriorityQueue;

// Merge K sorted array into one big sorted array in ascending order.

// Assumption: The input arrayOfArrays is not null, none of the arrays is null either.

public class MergeKSortedArray {

	// Solution 1: BFS + Heap
	static class Element {
		int value;
		int indexOfArray;
		int indexInArray;

		Element(int value, int indexOfArray, int indexInArray) {
			this.value = value;
			this.indexOfArray = indexOfArray;
			this.indexInArray = indexInArray;
		}
	}

	public int[] merge(int[][] arrayOfArrays) {
		if (arrayOfArrays.length == 0) {
			return null;
		}
		int k = arrayOfArrays.length;
		PriorityQueue<Element> minHeap = new PriorityQueue<Element>(k, new Comparator<Element>() {
			@Override
			public int compare(Element e1, Element e2) {
				if (e1.value == e2.value) {
					return 0;
				}
				return e1.value < e2.value ? -1 : 1;
			}
		});
		int length = 0;
		for (int i = 0; i < k; i++) {
			if (arrayOfArrays[i].length > 0) {
				length += arrayOfArrays[i].length;
				minHeap.offer(new Element(arrayOfArrays[i][0], i, 0));
			}
		}
		int[] result = new int[length];
		for (int i = 0; i < length; i++) {
			Element e = minHeap.poll();
			result[i] = e.value;
			if (e.indexInArray < arrayOfArrays[e.indexOfArray].length - 1) {
				minHeap.offer(new Element(arrayOfArrays[e.indexOfArray][e.indexInArray + 1], e.indexOfArray,
						e.indexInArray + 1));
			}
		}
		return result;
	}

	// Time complexity is O(n*k*log(k)).
	// Space complexity is O(k).

	// Solution 2: Binary Reduction
	// Time complexity is O(n*k*log(k)).
	// Space complexity is O(k*n).

	// When array sizes are big, solution 1 reads and writes each element once,
	// while solution 2 reads and writes reach element log(k) times.
}
