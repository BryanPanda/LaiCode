package searchInSortedMatrix2;

import java.util.Comparator;
import java.util.PriorityQueue;

// Given a 2D matrix that contains integers only, where each row is sorted in ascending order,
// and each column is also sorted in ascending order.
// Given a target number, return the position where the target locates within the matrix. 
// If the target number does not exist in the matrix, return { -1, -1 }.

// Assumption: The given matrix is not null.

public class SearchInSortedMatrix2 {

	// Solution 1: BFS2
	static class Cell {
		int row;
		int col;
		int value;

		Cell(int row, int col, int value) {
			this.row = row;
			this.col = col;
			this.value = value;
		}
	}

	public int[] search(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return new int[] { -1, -1 };
		}
		PriorityQueue<Cell> minHeap = new PriorityQueue<>(11, new Comparator<Cell>() {
			@Override
			public int compare(Cell c1, Cell c2) {
				if (c1.value == c2.value) {
					return 0;
				}
				return c1.value < c2.value ? -1 : 1;
			}
		});
		minHeap.offer(new Cell(0, 0, matrix[0][0]));
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		visited[0][0] = true;
		while (minHeap.size() != 0) {
			Cell cur = minHeap.poll();
			if (cur.value == target) {
				return new int[] { cur.row, cur.col };
			}
			if (cur.row < matrix.length - 1 && !visited[cur.row + 1][cur.col]) {
				minHeap.offer(new Cell(cur.row + 1, cur.col, matrix[cur.row + 1][cur.col]));
				visited[cur.row + 1][cur.col] = true;
			}
			if (cur.col < matrix[0].length - 1 && !visited[cur.row][cur.col + 1]) {
				minHeap.offer(new Cell(cur.row, cur.col + 1, matrix[cur.row][cur.col + 1]));
				visited[cur.row][cur.col + 1] = true;
			}
		}
		return new int[] { -1, -1 };
	}

	// Time complexity is O(m*n).
	// Space complexity is O(m*n).

	// Solution 2
	public int[] search2(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return new int[] { -1, -1 };
		}
		int row = 0, col = matrix[0].length - 1;
		while (col >= 0 && row <= matrix.length - 1) {
			if (matrix[row][col] == target) {
				return new int[] { row, col };
			} else if (matrix[row][col] < target) {
				row++;
			} else {
				col--;
			}
		}
		return new int[] { -1, -1 };
	}

	// Time complexity is O(m+n).
	// Space complexity is O(1).
}
