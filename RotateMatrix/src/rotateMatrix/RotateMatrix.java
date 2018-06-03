package rotateMatrix;

// LeetCode #48 (Rotate Image).

// Rotate an N * N matrix clockwise 90 degrees.

// Assumption: The matrix is not null and N >= 0.

public class RotateMatrix {
	
	// First flip against x = 0, then flip against y = x.
	public void rotate(int[][] matrix) {
		int n = matrix.length;
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
			for (int j = 0; i + j < n - 1; j++) {
				swap(matrix, i, j, n - 1 - j, n - 1 - i);
			}
		}
	}

	private void swap(int[][] matrix, int aRow, int aCol, int bRow, int bCol) {
		int temp = matrix[aRow][aCol];
		matrix[aRow][aCol] = matrix[bRow][bCol];
		matrix[bRow][bCol] = temp;
	}

	// Time complexity is O(n^2).
	// Space complexity is O(1).
}
