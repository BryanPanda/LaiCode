package kthClosestPointToZeroZeroZero;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

// Given three arrays sorted in ascending order. 
// Pull one number from each array to form a coordinate <x,y,z> in a 3D space. 
// Find the coordinates of the points that is k-th closest to <0,0,0>.
// We are using euclidean distance here.

// Assumption:
// 1. The three given arrays are not null or empty
// 2. K >= 1 and K <= a.length * b.length * c.length

public class KthClosestPointToZeroZeroZero {

	public List<Integer> closest(final int[] a, final int[] b, final int[] c, int k) {
		// KthSmallestWithFactorsThreeFiveSeven asks for the k-th smallest
		// number only, so PriorityQueue<Long> is enough.
		// KthClosestPointToZeroZeroZero asks for the point with x, y, z
		// coordinates.
		PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(k, new Comparator<List<Integer>>() {
			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				long d1 = distance(o1, a, b, c);
				long d2 = distance(o2, a, b, c);
				if (d1 == d2) {
					return 0;
				}
				return d1 < d2 ? -1 : 1;
			}
		});
		Set<List<Integer>> visited = new HashSet<>();
		// need to store indices in list, because a. this is what needs to be
		// returned; b. list of indices is unique, but list of coordinates might
		// not be
		List<Integer> cur = Arrays.asList(0, 0, 0);
		minHeap.offer(cur);
		visited.add(cur);
		for (int i = 0; i < k - 1; i++) {
			cur = minHeap.poll();
			List<Integer> next = Arrays.asList(cur.get(0) + 1, cur.get(1), cur.get(2));
			if (next.get(0) < a.length && visited.add(next)) {
				minHeap.offer(next);
			}
			next = Arrays.asList(cur.get(0), cur.get(1) + 1, cur.get(2));
			if (next.get(1) < b.length && visited.add(next)) {
				minHeap.offer(next);
			}
			next = Arrays.asList(cur.get(0), cur.get(1), cur.get(2) + 1);
			if (next.get(2) < c.length && visited.add(next)) {
				minHeap.offer(next);
			}
		}
		cur.set(0, a[minHeap.peek().get(0)]);
		cur.set(1, b[minHeap.peek().get(1)]);
		cur.set(2, c[minHeap.peek().get(2)]);
		return cur;
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
