package spiralOrderTraverse;

import java.util.ArrayList;
import java.util.List;

// Traverse an N * N 2D array in spiral order clock-wise starting from the top left corner. 
// Return the list of traversal sequence.

// Assumption: The 2D array is not null and has size of N * N where N >= 0

public class SpiralOrderTraverse {

	// iterative solution
	public List<Integer> spiral(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		int start = 0, end = matrix.length - 1;
		while (start < end) {
			for (int i = start; i < end; i++) {
				result.add(matrix[start][i]);
			}
			for (int i = start; i < end; i++) {
				result.add(matrix[i][end]);
			}
			for (int i = end; i > start; i--) {
				result.add(matrix[end][i]);
			}
			for (int i = end; i > start; i--) {
				result.add(matrix[i][start]);
			}
			start++;
			end--;
		}
		if (start == end) {
			result.add(matrix[start][end]);
		}
		return result;
	}

	// Time complexity is O(n^2).
	// Space complexity is O(1).

	// recursive solution
	public List<Integer> spiral2(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		if (matrix.length == 0) {
			return result;
		}
		helper(matrix, 0, matrix.length, result);
		return result;
	}

	private void helper(int[][] matrix, int offset, int size, List<Integer> result) {
		// base case
		if (size == 0) {
			return;
		} else if (size == 1) {
			result.add(matrix[offset][offset]);
			return;
		}
		for (int i = 0; i < size - 1; i++) {
			result.add(matrix[offset][offset + i]);
		}
		for (int i = 0; i < size - 1; i++) {
			result.add(matrix[offset + i][offset + size - 1]);
		}
		for (int i = 0; i < size - 1; i++) {
			result.add(matrix[offset + size - 1][offset + size - 1 - i]);
		}
		for (int i = 0; i < size - 1; i++) {
			result.add(matrix[offset + size - 1 - i][offset]);
		}
		helper(matrix, offset + 1, size - 2, result);
	}

	// Time complexity is O(n^2).
	// Space complexity is O(n), because of call-stack.
}
