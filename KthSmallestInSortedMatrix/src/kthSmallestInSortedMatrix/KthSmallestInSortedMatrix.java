package kthSmallestInSortedMatrix;

import java.util.Comparator;
import java.util.PriorityQueue;

// LeetCode #378 (Kth Smallest Element in a Sorted Matrix).

// Given a matrix of size N x M. For each row the elements are sorted in ascending order, 
// and for each column the elements are also sorted in ascending order. 
// Find the k-th smallest number in it.

// Assumption:
// 1. the matrix is not null, N > 0 and M > 0
// 2. K > 0 and K <= N * M

public class KthSmallestInSortedMatrix {

	static class Cell {
		// Option 1: if class Cell doesn't implements Comparable<Cell>,
		// then below PriorityQueue<Cell>() needs a Comparator in it.
		// Option 2: class Cell implements Comparable<Cell>, then below
		// PriorityQueue<Cell> doesn't need any Comparator.
		int row;
		int col;
		int value;

		Cell(int row, int col, int value) {
			this.row = row;
			this.col = col;
			this.value = value;
		}
	}

	public int kthSmallest(int[][] matrix, int k) {
		PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(k, new Comparator<Cell>() {
			@Override
			public int compare(Cell c1, Cell c2) {
				if (c1.value == c2.value) {
					return 0;
				}
				return c1.value < c2.value ? -1 : 1;
			}
		});
		int row = matrix.length, col = matrix[0].length;
		boolean[][] marked = new boolean[row][col];
		minHeap.offer(new Cell(0, 0, matrix[0][0]));
		marked[0][0] = true;
		for (int i = 0; i < k - 1; i++) {
			Cell cell = minHeap.poll();
			if (cell.row < row - 1 && !marked[cell.row + 1][cell.col]) {
				// the cell below
				minHeap.offer(new Cell(cell.row + 1, cell.col, matrix[cell.row + 1][cell.col]));
				marked[cell.row + 1][cell.col] = true;
			}
			if (cell.col < col - 1 && !marked[cell.row][cell.col + 1]) {
				// the cell on the right
				minHeap.offer(new Cell(cell.row, cell.col + 1, matrix[cell.row][cell.col + 1]));
				marked[cell.row][cell.col + 1] = true;
			}
		}
		return minHeap.poll().value;
	}

	// Time complexity is O(k*log(k)).
	// Space complexity is O(k + m*n) = O(m*n).
}
