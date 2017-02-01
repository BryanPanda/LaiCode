package maxWaterTrapped2;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// Given a non-negative integer 2D array representing the heights of bars in a matrix. 
// Suppose each bar has length and width of 1. 
// Find the largest amount of water that can be trapped in the matrix. 

// The water can flow into a neighboring bar if the neighboring bar's height is smaller 
// than the water's height. Each bar has 4 neighboring bars to the left, right, up and down side.

// Assumption:
// The given matrix is not null and has size of M * N, where M > 0 and N > 0, 
// all the values are non-negative integers in the matrix.

public class MaxWaterTrapped2 {

	static class Pair implements Comparable<Pair> {
		int x;
		int y;
		int height;

		Pair(int x, int y, int height) {
			this.x = x;
			this.y = y;
			this.height = height;
		}

		@Override
		public int compareTo(Pair another) {
			if (this.height == another.height) {
				return 0;
			}
			return this.height < another.height ? -1 : 1;
		}
	}

	public int maxTrapped(int[][] matrix) {
		if (matrix == null || matrix.length < 3 || matrix[0].length < 3) {
			return 0;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		PriorityQueue<Pair> minHeap = new PriorityQueue<>();
		boolean[][] visited = new boolean[rows][cols];
		addBorder(matrix, visited, minHeap, rows, cols);
		int result = 0;
		while (!minHeap.isEmpty()) {
			Pair cur = minHeap.poll();
			List<Pair> neighbors = getNeighbors(cur, matrix);
			for (Pair neighbor : neighbors) {
				if (!visited[neighbor.x][neighbor.y]) {
					visited[neighbor.x][neighbor.y] = true;
					result += Math.max(cur.height - neighbor.height, 0);
					neighbor.height = Math.max(cur.height, neighbor.height);
					minHeap.offer(neighbor);
				}
			}
		}
		return result;
	}

	private void addBorder(int[][] matrix, boolean[][] visited, PriorityQueue<Pair> minHeap, int rows, int cols) {
		// add top and bottom
		for (int j = 0; j < cols; j++) {
			minHeap.offer(new Pair(0, j, matrix[0][j]));
			minHeap.offer(new Pair(rows - 1, j, matrix[rows - 1][j]));
			visited[0][j] = true;
			visited[rows - 1][j] = true;
		}
		// add left and right
		for (int i = 1; i < rows - 1; i++) {
			minHeap.offer(new Pair(i, 0, matrix[i][0]));
			minHeap.offer(new Pair(i, cols - 1, matrix[i][cols - 1]));
			visited[i][0] = true;
			visited[i][cols - 1] = true;
		}
	}

	private List<Pair> getNeighbors(Pair cur, int[][] matrix) {
		List<Pair> neighbors = new ArrayList<>();
		if (cur.x + 1 < matrix.length) {
			neighbors.add(new Pair(cur.x + 1, cur.y, matrix[cur.x + 1][cur.y]));
		}
		if (cur.x - 1 >= 0) {
			neighbors.add(new Pair(cur.x - 1, cur.y, matrix[cur.x - 1][cur.y]));
		}
		if (cur.y + 1 < matrix[0].length) {
			neighbors.add(new Pair(cur.x, cur.y + 1, matrix[cur.x][cur.y + 1]));
		}
		if (cur.y - 1 >= 0) {
			neighbors.add(new Pair(cur.x, cur.y - 1, matrix[cur.x][cur.y - 1]));
		}
		return neighbors;
	}

	// Time complexity is O(n^2).
	// Space complexity is O(n^2).
}
