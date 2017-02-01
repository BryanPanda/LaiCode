package kthSmallestSumInTwoSortedArrays;

import java.util.PriorityQueue;
import java.util.Comparator;

// Given two sorted arrays A and B, of sizes m and n respectively. 
// Define s = a + b, where a is one element from A and b is one element from B. 
// Find the k-th smallest s out of all possible s.

// Assumptions:
// 1. A is not null and A is not of zero length, so as B
// 2. K > 0 and K <= m * n

public class KthSmallestSumInTwoSortedArrays {

	static class Cell {
		int a;
		int b;
		int val;

		Cell(int a, int b, int val) {
			this.a = a;
			this.b = b;
			this.val = val;
		}
	}

	public int kthSum(int[] A, int[] B, int k) {
		PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(k, new Comparator<Cell>() {
			@Override
			public int compare(Cell c1, Cell c2) {
				if (c1.val == c2.val) {
					return 0;
				}
				return c1.val < c2.val ? -1 : 1;
			}
		});
		minHeap.add(new Cell(0, 0, A[0] + B[0]));
		boolean[][] visited = new boolean[A.length][B.length];
		visited[0][0] = true;
		for (int i = 0; i < k - 1; i++) {
			Cell cur = minHeap.poll();
			if (cur.a < A.length - 1 && !visited[cur.a + 1][cur.b]) {
				minHeap.offer(new Cell(cur.a + 1, cur.b, A[cur.a + 1] + B[cur.b]));
				visited[cur.a + 1][cur.b] = true;
			}
			if (cur.b < B.length - 1 && !visited[cur.a][cur.b + 1]) {
				minHeap.offer(new Cell(cur.a, cur.b + 1, A[cur.a] + B[cur.b + 1]));
				visited[cur.a][cur.b + 1] = true;
			}
		}
		return minHeap.poll().val;
	}

	// Time complexity is O(m*n).
	// Space complexity is O(m*n).

	public static void main(String[] args) {
		KthSmallestSumInTwoSortedArrays kthSmallestSumInTwoSortedArrays = new KthSmallestSumInTwoSortedArrays();
		int[] A = new int[] { 1, 3, 5, 8, 9 };
		int[] B = new int[] { 2, 3, 4, 7 };
		System.out.println(kthSmallestSumInTwoSortedArrays.kthSum(A, B, 1));
		System.out.println(kthSmallestSumInTwoSortedArrays.kthSum(A, B, 2));
		System.out.println(kthSmallestSumInTwoSortedArrays.kthSum(A, B, 3));
		System.out.println(kthSmallestSumInTwoSortedArrays.kthSum(A, B, 4));
		System.out.println(kthSmallestSumInTwoSortedArrays.kthSum(A, B, 17));
	}

}
