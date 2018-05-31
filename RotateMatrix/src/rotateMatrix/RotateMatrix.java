package rotateMatrix;

// Rotate an N * N matrix clockwise 90 degrees.

// Assumption: The matrix is not null and N >= 0.

public class RotateMatrix {

	// solution 1
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		if (n <= 1) {
			return;
		}
		int round = n / 2;
		for (int level = 0; level < round; level++) {
			int left = level;
			int right = n - 2 - level;
			for (int i = left; i <= right; i++) {
				int temp = matrix[left][i];
				matrix[left][i] = matrix[n - 1 - i][left];
				matrix[n - 1 - i][left] = matrix[n - 1 - left][n - 1 - i];
				matrix[n - 1 - left][n - 1 - i] = matrix[i][n - 1 - left];
				matrix[i][n - 1 - left] = temp;
			}
		}
	}

	// Time complexity is O(n^2).
	// Space complexity is O(n^2).

	// solution 2:
	// rotate 90 degrees clock-wise = flip against y-axis, then flip against
	// line y = x
	public void rotate2(int[][] matrix) {
		int n = matrix.length;
		if (n <= 1) {
			return;
		}
		flipAgainstY(matrix, n);
		flipAgainstYEqualsX(matrix, n);
	}

	private void flipAgainstY(int[][] matrix, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n / 2; j++) {
				swap(matrix, i, j, i, n - 1 - j);
			}
		}
	}

	private void flipAgainstYEqualsX(int[][] matrix, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j + i < n - 1; j++) {
				swap(matrix, i, j, n - 1 - j, n - 1 - i);
			}
		}
	}

	private void swap(int[][] matrix, int iRow, int iCol, int jRow, int jCol) {
		int temp = matrix[iRow][iCol];
		matrix[iRow][iCol] = matrix[jRow][jCol];
		matrix[jRow][jCol] = temp;
	}

	// Time complexity is O(n^2).
	// Space complexity is O(1).
}
