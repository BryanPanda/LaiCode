package generateRandomMaze;

import java.util.Arrays;

// Randomly generate a maze of size N * N (where N = 2K + 1) whose corridor
// and wall’s width are both 1 cell. 
// For each pair of cells on the corridor, there must exist one and only one
// path between them. (Randomly means that the solution is generated randomly, 
// and whenever the program is executed, the solution can be different.). 
// The wall is denoted by 1 in the matrix and corridor is denoted by 0.

// Assumptions:
// 1. N = 2K + 1 and K >= 0
// 2. the top left corner must be corridor
// 3. there should be as many corridor cells as possible
// 4. for each pair of cells on the corridor, there must exist one and only one path between them

public class GenerateRandomMaze {

	enum Direction {
		NORTH(-1, 0), SOUTH(1, 0), EAST(0, -1), WEST(0, 1);

		int deltaX;
		int deltaY;

		Direction(int deltaX, int deltaY) {
			this.deltaX = deltaX;
			this.deltaY = deltaY;
		}

		public int moveX(int x, int times) {
			return x + times * deltaX;
		}

		public int moveY(int y, int times) {
			return y + times * deltaY;
		}
	}

	public int[][] maze(int n) {
		int[][] maze = new int[n][n];
		// initialize the maze to have corridor (0) only on the top left corner
		for (int i = 0; i < n; i++) {
			Arrays.fill(maze[i], 1);
		}
		maze[0][0] = 0;
		generate(maze, 0, 0);
		return maze;
	}

	private void generate(int[][] maze, int x, int y) {
		Direction[] directions = Direction.values();
		shuffle(directions);
		// follow the shuffled order to do DFS & backtrack
		for (Direction direction : directions) {
			// advance by 2 steps
			int nextX = direction.moveX(x, 2);
			int nextY = direction.moveY(y, 2);
			if (isValidWall(maze, nextX, nextY)) {
				maze[direction.moveX(x, 1)][direction.moveY(y, 1)] = 0;
				maze[nextX][nextY] = 0;
				generate(maze, nextX, nextY);
			}
		}
	}

	// generate a random order of directions
	private void shuffle(Direction[] directions) {
		for (int i = 0; i < directions.length; i++) {
			int index = (int) (Math.random() * (directions.length - i));
			Direction temp = directions[i];
			directions[i] = directions[i + index];
			directions[i + index] = temp;
		}
	}

	private boolean isValidWall(int[][] maze, int x, int y) {
		return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 1;
	}

	// Time complexity is O(n^2).
	// Space complexity is O(n).
}
