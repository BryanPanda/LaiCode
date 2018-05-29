package spiralOrderGenerate;

// LeetCode #59 (Spiral Matrix II).

// Generate an N * N 2D array in spiral order clock-wise starting from the top left corner,
// using the numbers of 1, 2, 3, ..., N * N in increasing order.

// Assumptions: N >= 0

public class SpiralOrderGenerate {

	// iterative
	public int[][] spiralGenerate(int n) {
		int[][] result = new int[n][n];
		if (n == 0) {
			return result;
		}
		int count = 1;
		int start = 0, end = n;
		while (start < end) {
			for (int i = start; i < end; i++) {
				result[start][i] = count++;
			}
			for (int i = start; i < end; i++) {
				result[i][end] = count++;
			}
			for (int i = end; i > start; i--) {
				result[end][i] = count++;
			}
			for (int i = end; i > start; i--) {
				result[i][start] = count++;
			}
			start++;
			end--;
		}
		// up to this point, start >= end
		if (start == end) {
			result[start][end] = count++;
		}
		return result;
	}

	// Time Complexity is O(n^2).
	// Space Complexity is O(1).

	// recursive
	public int[][] spiralGenerate2(int n) {
		int[][] result = new int[n][n];
		if (n == 0) {
			return result;
		}
		int offset = 0, size = n, count = 1;
		helper(result, offset, size, count);
		return result;
	}

	private void helper(int[][] result, int offset, int size, int count) {
		// base case
		if (size == 0) {
			return;
		} else if (size == 1) {
			result[offset][offset] = count;
			return;
		}
		for (int i = 0; i < size - 1; i++) {
			result[offset][offset + i] = count++;
		}
		for (int i = 0; i < size - 1; i++) {
			result[offset + i][offset + size - 1] = count++;
		}
		for (int i = size - 1; i >= 1; i--) {
			result[offset + size - 1][offset + i] = count++;
		}
		for (int i = size - 1; i >= 1; i--) {
			result[offset + i][offset] = count++;
		}
		helper(result, offset + 1, size - 2, count);
	}

	// Time Complexity is O(n^2).
	// Space Complexity is O(n), because of call-stack.
}
