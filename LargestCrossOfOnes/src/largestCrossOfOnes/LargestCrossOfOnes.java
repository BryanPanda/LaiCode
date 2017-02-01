package largestCrossOfOnes;

// Given a matrix that contains only 1s and 0s, find the largest
// cross which contains only 1s, with the same arm lengths and the
// four arms joining at the central point.
// Return the arm length of the largest cross.

// Assumption: The given matrix is not null, has size of N * M, N >= 0 and M >= 0.

public class LargestCrossOfOnes {

	public int largest(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int max = 0;
		int row = matrix.length, col = matrix[0].length;
		int[][] leftRight = leftRight(matrix, row, col);
		int[][] upDown = upDown(matrix, row, col);
		int[][] rightLeft = rightLeft(matrix, row, col);
		int[][] bottomUp = bottomUp(matrix, row, col);
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				max = Math.max(max, min(leftRight[i][j], upDown[i][j], rightLeft[i][j], bottomUp[i][j]));
			}
		}
		return max;
	}

	private int min(int a, int b, int c, int d) {
		return Math.min(a, Math.min(b, Math.min(c, d)));
	}

	private int[][] leftRight(int[][] matrix, int row, int col) {
		int[][] leftRight = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 1) {
					leftRight[i][j] = j == 0 ? 1 : leftRight[i][j - 1] + 1;
				}
			}
		}
		return leftRight;
	}

	private int[][] upDown(int[][] matrix, int row, int col) {
		int[][] upDown = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 1) {
					upDown[i][j] = i == 0 ? 1 : upDown[i - 1][j] + 1;
				}
			}
		}
		return upDown;
	}

	private int[][] rightLeft(int[][] matrix, int row, int col) {
		int[][] rightLeft = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = col - 1; j >= 0; j--) {
				if (matrix[i][j] == 1) {
					rightLeft[i][j] = j == col - 1 ? 1 : rightLeft[i][j + 1] + 1;
				}
			}
		}
		return rightLeft;
	}

	private int[][] bottomUp(int[][] matrix, int row, int col) {
		int[][] bottomUp = new int[row][col];
		for (int i = row - 1; i >= 0; i--) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 1) {
					bottomUp[i][j] = i == row - 1 ? 1 : bottomUp[i + 1][j] + 1;
				}
			}
		}
		return bottomUp;
	}

	// Time complexity is O(n*m).
	// Space complexity is O(n*m).
}
