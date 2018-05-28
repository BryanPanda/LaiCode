package largestSubMatrixSum;

// Given a matrix that contains integers, find the sub-matrix with the largest sum.
// Return the sum of the sub-matrix.

// Assumption: The given matrix is not null and has size of M * N, where M >= 1 and N >= 1

public class LargestSubMatrixSum {

	// DP 1: pre-compute prefix sum, of each sub-matrix
	// M[i][j]: prefix sum of sub-matrix, with top left corner being
	// matrix[0][0], and bottom right corner being matrix[i][j]
	public int largest(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int result = Integer.MIN_VALUE, m = matrix.length, n = matrix[0].length;
		int[][] sum = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0) {
					sum[i][j] = (j == 0) ? matrix[i][j] : sum[i][j - 1] + matrix[i][j];
				} else if (j == 0) { // 1 <= i <= m - 1
					sum[i][j] = sum[i - 1][j] + matrix[i][j];
				} else { // 1 <= i <= m - 1, 1 <= j <= n - 1
					sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i][j];
				}
			}
		}
		for (int up = 0; up < m; up++) {
			for (int left = 0; left < n; left++) {
				for (int down = up; down < m; down++) {
					for (int right = left; right < n; right++) {
						int cur = 0;
						if (up == 0) {
							cur = (left == 0) ? sum[down][right] : sum[down][right] - sum[down][left - 1];
						} else if (left == 0) { // 1 <= up <= m - 1
							cur = sum[down][right] - sum[up - 1][right];
						} else { // 1 <= up <= m - 1 && 1 <= left <= n - 1
							cur = sum[down][right] - sum[up - 1][right] - sum[down][left - 1] + sum[up - 1][left - 1];
						}
						result = Math.max(result, cur);
					}
				}
			}
		}
		return result;
	}

	// Time complexity is O(m^2 * n^2).
	// Space complexity is O(m*n).

	// DP 2
	public int largest2(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int result = Integer.MIN_VALUE, m = matrix.length, n = matrix[0].length;
		for (int i = 0; i < m; i++) {
			int[] cur = new int[n];
			for (int j = i; j < m; j++) {
				add(matrix[j], cur);
				result = Math.max(result, max(cur));
			}
		}
		return result;
	}

	// add array to cur
	private void add(int[] array, int[] cur) {
		for (int i = 0; i < array.length; i++) {
			cur[i] += array[i];
		}
	}

	// largest sub-array sum
	private int max(int[] cur) {
		int result = cur[0];
		int temp = cur[0];
		for (int i = 1; i < cur.length; i++) {
			temp = Math.max(temp + cur[i], cur[i]);
			result = Math.max(result, temp);
		}
		return result;
	}

	// Time complexity is O(m^2 * n).
	// Space complexity is O(n).
}
