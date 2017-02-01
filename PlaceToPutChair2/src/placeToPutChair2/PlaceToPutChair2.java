package placeToPutChair2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Given a gym with k pieces of equipment without any obstacles.  
// Let’s say we bought a chair and wanted to put this chair into the gym 
// such that the sum of the shortest path cost from the chair to the k 
// pieces of equipment is minimal. 

// The gym is represented by a char matrix, 'E' denotes a cell with equipment, 
// ' ' denotes a cell without equipment. 

// The cost of moving from one cell to its neighbor(left, right, up, down) is 1. 
// You can put chair on any cell in the gym.

// Assumptions:
// 1. There is at least one equipment in the gym
// 2. The given gym is represented by a char matrix of size M * N, where M >= 1 and N >= 1, it is guaranteed not to be null

public class PlaceToPutChair2 {

	private static final char EQUIPMENT = 'E';

	static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public List<Integer> putChair(char[][] gym) {
		int M = gym.length;
		int N = gym[0].length;
		int[][] cost = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (gym[i][j] == EQUIPMENT) {
					addCost(cost, gym, i, j);
				}
			}
		}
		List<Integer> result = null;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (result == null) {
					result = Arrays.asList(i, j);
				} else if (cost[i][j] < cost[result.get(0)][result.get(1)]) {
					result.set(0, i);
					result.set(1, j);
				}
			}
		}
		return result;
	}

	private void addCost(int[][] cost, char[][] gym, int i, int j) {
		int pathCost = 1;
		boolean[][] visited = new boolean[gym.length][gym[0].length];
		Queue<Pair> queue = new LinkedList<>();
		visited[i][j] = true;
		queue.offer(new Pair(i, j));
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
	}

	private List<Pair> getNeighbors(Pair cur, char[][] gym) {
		int x = cur.x;
		int y = cur.y;
		int M = gym.length;
		int N = gym[0].length;
		List<Pair> neighbors = new ArrayList<>();
		if (x + 1 < M) {
			neighbors.add(new Pair(x + 1, y));
		}
		if (y + 1 < N) {
			neighbors.add(new Pair(x, y + 1));
		}
		if (x - 1 >= 0) {
			neighbors.add(new Pair(x - 1, y));
		}
		if (y - 1 >= 0) {
			neighbors.add(new Pair(x, y - 1));
		}
		return neighbors;
	}

	// Time complexity is O(k * n^2).
	// Space complexity is O(n^2).

	public static void main(String[] args) {
		PlaceToPutChair2 placeToPutChair2 = new PlaceToPutChair2();
		char[][] gym = new char[][] { { ' ', 'E' }, { ' ', ' ' }, { ' ', ' ' } };
		System.out.println(placeToPutChair2.putChair(gym));
	}

}
