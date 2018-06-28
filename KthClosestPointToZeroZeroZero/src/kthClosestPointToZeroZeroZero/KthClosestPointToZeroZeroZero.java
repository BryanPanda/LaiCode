package kthClosestPointToZeroZeroZero;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

// Given three arrays sorted in ascending order. 

// Pull one number from each array to form a coordinate <x, y, z> in a 3D space.

// Find the coordinates of the points that is k-th closest to <0, 0, 0>. We are using euclidean distance
// here.

// Assumption:
// 1. The three given arrays are not null or empty.
// 2. K >= 1 and K <= a.length * b.length * c.length.

public class KthClosestPointToZeroZeroZero {

	public List<Integer> closest(final int[] a, final int[] b, final int[] c, int k) {
		// Integers in the list have to be indices in array a, b and c, otherwise
		// duplicate list of values will not be inserted into the heap.
		Set<List<Integer>> visited = new HashSet<>();
		PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(k, new Comparator<List<Integer>>() {
			@Override
			public int compare(List<Integer> p1, List<Integer> p2) {
				long d1 = distance(p1, a, b, c);
				long d2 = distance(p2, a, b, c);
				if (d1 == d2) {
					return 0;
				}
				return d1 < d2 ? -1 : 1;
			}
		});
		List<Integer> cur = Arrays.asList(0, 0, 0);
		visited.add(cur);
		minHeap.offer(cur);
		for (int i = 0; i < k - 1; i++) {
			cur = minHeap.poll();
			List<Integer> next = Arrays.asList(cur.get(0) + 1, cur.get(1), cur.get(2));
			if (cur.get(0) + 1 < a.length && visited.add(next)) {
				minHeap.offer(next);
			}
			next = Arrays.asList(cur.get(0), cur.get(1) + 1, cur.get(2));
			if (cur.get(1) + 1 < b.length && visited.add(next)) {
				minHeap.offer(next);
			}
			next = Arrays.asList(cur.get(0), cur.get(1), cur.get(2) + 1);
			if (cur.get(2) + 1 < c.length && visited.add(next)) {
				minHeap.offer(next);
			}
		}
		cur = minHeap.poll();
		return Arrays.asList(new Integer[] { a[cur.get(0)], b[cur.get(1)], c[cur.get(2)] });
	}

	private Long distance(List<Integer> point, int[] a, int[] b, int[] c) {
		long distance = 0;
		distance += a[point.get(0)] * a[point.get(0)];
		distance += b[point.get(1)] * b[point.get(1)];
		distance += c[point.get(2)] * c[point.get(2)];
		return distance;
	}

	// Time complexity is O(k).
	// Space complexity is O(k).
}
