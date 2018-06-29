package maxWaterTrapped2;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// LeetCode #407 (Trapping Rain Water II).

// Given a non-negative integer 2D array representing the heights of bars in a matrix. 
// Suppose each bar has length and width of 1. 
// Find the largest amount of water that can be trapped in the matrix. 

// The water can flow into a neighboring bar if the neighboring bar's height is smaller 
// than the water's height. Each bar has 4 neighboring bars to the left, right, up and 
// down side.

// Assumption:
// The given matrix is not null and has size of M * N, where M > 0 and N > 0, all the values
// are non-negative integers in the matrix.

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
		int result = 0;
		int m = matrix.length, n = matrix[0].length;
		boolean[][] visited = new boolean[m][n];
		PriorityQueue<Pair> minHeap = new PriorityQueue<>();
		addBorder(matrix, visited, minHeap, m, n);
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

	private void addBorder(int[][] matrix, boolean[][] visited, PriorityQueue<Pair> minHeap, int m, int n) {
		// add left and right
		for (int i = 0; i < m; i++) {
			minHeap.offer(new Pair(i, 0, matrix[i][0]));
			minHeap.offer(new Pair(i, n - 1, matrix[i][n - 1]));
			visited[i][0] = true;
			visited[i][n - 1] = true;
		}
		// add top and bottom
		for (int i = 1; i <= n - 2; i++) {
			minHeap.offer(new Pair(0, i, matrix[0][i]));
			minHeap.offer(new Pair(m - 1, i, matrix[m - 1][i]));
			visited[0][i] = true;
			visited[m - 1][i] = true;
		}
	}

	private List<Pair> getNeighbors(Pair cur, int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		List<Pair> neighbors = new ArrayList<>();
		if (cur.x + 1 < m) {
			neighbors.add(new Pair(cur.x + 1, cur.y, matrix[cur.x + 1][cur.y]));
		}
		if (cur.x - 1 >= 0) {
			neighbors.add(new Pair(cur.x - 1, cur.y, matrix[cur.x - 1][cur.y]));
		}
		if (cur.y + 1 < n) {
			neighbors.add(new Pair(cur.x, cur.y + 1, matrix[cur.x][cur.y + 1]));
		}
		if (cur.y - 1 >= 0) {
			neighbors.add(new Pair(cur.x, cur.y - 1, matrix[cur.x][cur.y - 1]));
		}
		return neighbors;
	}

	// Time complexity is O(m*n * log(m*n)).
	// Space complexity is O(m*n).
}
