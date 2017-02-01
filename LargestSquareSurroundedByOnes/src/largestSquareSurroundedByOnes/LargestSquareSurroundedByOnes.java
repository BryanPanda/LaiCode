package largestSquareSurroundedByOnes;

// Determine the largest square surrounded by 1s in a binary matrix 
// (a binary matrix only contains 0 and 1), return the length of the square.

// Assumption: The given matrix is not null and guaranteed to be of size M * N, M >= 0, N >= 0.

public class LargestSquareSurroundedByOnes {

	public int largest(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int max = 0;
		int row = matrix.length, col = matrix[0].length;
		// leftRight[i][j]: longest arm length of consecutive ones from left to
		// right, ending at matrix[i - 1][j - 1]
		int[][] leftRight = new int[row + 1][col + 1];
		// upDown[i][j]: longest arm length of consecutive ones from top to
		// bottom, ending at matrix[i - 1][j - 1]
		int[][] upDown = new int[row + 1][col + 1];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 1) {
					leftRight[i + 1][j + 1] = leftRight[i + 1][j] + 1;
					upDown[i + 1][j + 1] = upDown[i][j + 1] + 1;
					for (int maxLength = Math.min(leftRight[i + 1][j + 1],
							upDown[i + 1][j + 1]); maxLength >= 1; maxLength--) {
						if (leftRight[i + 2 - maxLength][j + 1] >= maxLength
								&& upDown[i + 1][j + 2 - maxLength] >= maxLength) {
							max = Math.max(max, maxLength);
							break;
						}
					}
				}
			}
		}
		return max;
	}

	// Time complexity is O(m*n*max(m,n)).
	// Space complexity is O(m*n).
}
