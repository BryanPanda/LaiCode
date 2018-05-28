package largestXOfOnes;

// Given a matrix that contains only 1s and 0s, find the largest
// X shape which contains only 1s, with the same arm lengths and
// the four arms joining at the central point.
// Return the arm length of the largest X shape.

// Assumption: The given matrix is not null, has size of N * M, N >= 0 and M >= 0.

public class LargestXOfOnes {

	public int largest(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int max = 0;
		int row = matrix.length, col = matrix[0].length;
		int[][] topLeftBottomRight = topLeftBottomRight(matrix, row, col);
		int[][] topRightBottomLeft = topRightBottomLeft(matrix, row, col);
		int[][] bottomLeftTopRight = bottomLeftTopRight(matrix, row, col);
		int[][] bottomRightTopLeft = bottomRightTopLeft(matrix, row, col);
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				max = Math.max(max, min(topLeftBottomRight[i][j], topRightBottomLeft[i][j], bottomRightTopLeft[i][j],
						bottomLeftTopRight[i][j]));
			}
		}
		return max;
	}

	private int[][] topLeftBottomRight(int[][] matrix, int row, int col) {
		int[][] topLeftBottomRight = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 1) {
					topLeftBottomRight[i][j] = (i == 0 || j == 0) ? 1 : topLeftBottomRight[i - 1][j - 1] + 1;
				}
			}
		}
		return topLeftBottomRight;
	}

	private int[][] topRightBottomLeft(int[][] matrix, int row, int col) {
		int[][] topRightBottomLeft = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = col - 1; j >= 0; j--) {
				if (matrix[i][j] == 1) {
					topRightBottomLeft[i][j] = (i == 0 || j == col - 1) ? 1 : topRightBottomLeft[i - 1][j + 1] + 1;
				}
			}
		}
		return topRightBottomLeft;
	}

	private int[][] bottomLeftTopRight(int[][] matrix, int row, int col) {
		int[][] bottomLeftTopRight = new int[row][col];
		for (int i = row - 1; i >= 0; i--) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 1) {
					bottomLeftTopRight[i][j] = (i == row - 1 || j == 0) ? 1 : bottomLeftTopRight[i + 1][j - 1] + 1;
				}
			}
		}
		return bottomLeftTopRight;
	}

	private int[][] bottomRightTopLeft(int[][] matrix, int row, int col) {
		int[][] bottomRightTopLeft = new int[row][col];
		for (int i = row - 1; i >= 0; i--) {
			for (int j = col - 1; j >= 0; j--) {
				if (matrix[i][j] == 1) {
					bottomRightTopLeft[i][j] = (i == row - 1 || j == col - 1) ? 1
							: bottomRightTopLeft[i + 1][j + 1] + 1;
				}
			}
		}
		return bottomRightTopLeft;
	}
	
	private int min(int a, int b, int c, int d) {
		return Math.min(a, Math.min(b, Math.min(c, d)));
	}

	// Time complexity is O(m*m).
	// Space complexity is O(m*m).
}
