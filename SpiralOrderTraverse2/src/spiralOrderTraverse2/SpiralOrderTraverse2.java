package spiralOrderTraverse2;

import java.util.ArrayList;
import java.util.List;

// Traverse an M * N 2D array in spiral order clock-wise starting from the top left corner. 
// Return the list of traversal sequence.

// Assumption: The 2D array is not null and has size of M * N where M, N >= 0

public class SpiralOrderTraverse2 {

	// iterative solution
	public List<Integer> spiral(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();
		if (matrix.length == 0) {
			return result;
		}
		if (matrix[0].length == 0) {
			return result;
		}
		int left = 0, right = matrix[0].length - 1, up = 0, down = matrix.length - 1;
		while (left < right && up < down) {
			for (int i = left; i <= right; i++) {
				result.add(matrix[up][i]);
			}
			for (int i = up + 1; i <= down - 1; i++) {
				result.add(matrix[i][right]);
			}
			for (int i = right; i >= left; i--) {
				result.add(matrix[down][i]);
			}
			for (int i = down - 1; i >= up + 1; i--) {
				result.add(matrix[i][left]);
			}
			left++;
			right--;
			up++;
			down--;
		}
		// up to this point, left >= right || up >= down
		if (left > right || up > down) { // nothing left
			return result;
		}
		if (left == right) { // one column left
			for (int i = up; i <= down; i++) {
				result.add(matrix[i][left]);
			}
		} else { // one row left
			for (int i = left; i <= right; i++) {
				result.add(matrix[up][i]);
			}
		}
		return result;
	}

	// Time complexity is O(m*n).
	// Space complexity is O(1).

	// recursive solution
	public List<Integer> spiral2(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		if (matrix.length == 0 || matrix[0].length == 0) {
			return result;
		}
		helper(matrix, 0, matrix.length, matrix[0].length, result);
		return result;
	}

	private void helper(int[][] matrix, int offset, int rowNum, int colNum, List<Integer> result) {
		// base case
		if (rowNum == 0 || colNum == 0) {
			return;
		} else if (rowNum == 1) {
			for (int i = 0; i < colNum; i++) {
				result.add(matrix[offset][offset + i]);
			}
			return;
		} else if (colNum == 1) {
			for (int i = 0; i < rowNum; i++) {
				result.add(matrix[offset + i][offset]);
			}
			return;
		}
		for (int i = 0; i < colNum - 1; i++) {
			result.add(matrix[offset][offset + i]);
		}
		for (int i = 0; i < rowNum - 1; i++) {
			result.add(matrix[offset + i][offset + colNum - 1]);
		}
		for (int i = 0; i < colNum - 1; i++) {
			result.add(matrix[offset + rowNum - 1][offset + colNum - 1 - i]);
		}
		for (int i = 0; i < rowNum - 1; i++) {
			result.add(matrix[offset + rowNum - 1 - i][offset]);
		}
		helper(matrix, offset + 1, rowNum - 2, colNum - 2, result);
	}

	// Time complexity is O(m*n).
	// Space complexity is O(min(m, n)), because of call-stack.
}
