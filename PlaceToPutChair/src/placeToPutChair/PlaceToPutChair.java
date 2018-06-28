package placeToPutChair;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Given a gym with k pieces of equipment and some obstacles. We bought a chair and wanted to put this
// chair in the gym such that the sum of the shortest path cost from the chair to the k pieces of equipment
// is minimal. 

// The gym is represented by a char matrix, 'E' denotes a cell with equipment, 'O' denotes a cell with an 
// obstacle, 'C' denotes a cell without any equipment or obstacle. 

// You can move to neighboring cells (left, right, up, down), only if it is not an obstacle. The cost of moving
// from one cell to its neighbor is 1. You can not put the chair on a cell with equipment or obstacle.

// Assumptions:
// 1. There is at least one equipment in the gym.
// 2. The given gym is represented by a char matrix of size M * N, where M >= 1 and N >= 1, it is guaranteed not
//    to be null.
// 3. It is guaranteed that each 'C' cell is reachable from all 'E' cells.
// 4. If there does not exist such place to put the chair, just return null.

public class PlaceToPutChair {

	private static final char EQUIPMENT = 'E';
	private static final char OBSTACLE = 'O';

	static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public List<Integer> putChair(char[][] gym) {
		int m = gym.length, n = gym[0].length;
		// sum up the path cost from all equipments to each particular cell
		int[][] cost = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (gym[i][j] == EQUIPMENT) {
					if (!addCost(cost, gym, i, j)) {
						return null;
					}
				}
			}
		}
		List<Integer> result = null;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (gym[i][j] != EQUIPMENT && gym[i][j] != OBSTACLE) {
					if (result == null || cost[i][j] < cost[result.get(0)][result.get(1)]) {
						result = Arrays.asList(i, j);
					}
				}
			}
		}
		return result;
	}

	// BFS (with queue)
	// sum up the path cost from the equipment at (row, col) to each particular cell
	private boolean addCost(int[][] cost, char[][] gym, int row, int col) {
		int m = gym.length, n = gym[0].length;
		int pathCost = 1;
		boolean[][] visited = new boolean[m][n];
		Queue<Pair> queue = new LinkedList<>();
		visited[row][col] = true;
		queue.offer(new Pair(row, col));
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int k = 0; k < size; k++) {
				Pair cur = queue.poll();
				List<Pair> neighbors = getNeighbors(cur, gym);
				for (Pair neighbor : neighbors) {
					if (!visited[neighbor.x][neighbor.y]) {
						visited[neighbor.x][neighbor.y] = true;
						cost[neighbor.x][neighbor.y] += pathCost;
						queue.offer(neighbor);
					}
				}
			}
			pathCost++;
		}
		// If some equipment is not reachable from the equipment at (row, col), then
		// it's impossible to reach the equipment from anywhere in the gym.
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && gym[i][j] == EQUIPMENT) {
					return false;
				}
			}
		}
		return true;
	}

	private List<Pair> getNeighbors(Pair cur, char[][] gym) {
		int m = gym.length, n = gym[0].length;
		int x = cur.x, y = cur.y;
		List<Pair> neighbors = new ArrayList<>();
		if (x + 1 < m && gym[x + 1][y] != OBSTACLE) {
			neighbors.add(new Pair(x + 1, y));
		}
		if (y + 1 < n && gym[x][y + 1] != OBSTACLE) {
			neighbors.add(new Pair(x, y + 1));
		}
		if (x - 1 >= 0 && gym[x - 1][y] != OBSTACLE) {
			neighbors.add(new Pair(x - 1, y));
		}
		if (y - 1 >= 0 && gym[x][y - 1] != OBSTACLE) {
			neighbors.add(new Pair(x, y - 1));
		}
		return neighbors;
	}

	// Time complexity is O(k * n^2).
	// Space complexity is O(n^2).
}
