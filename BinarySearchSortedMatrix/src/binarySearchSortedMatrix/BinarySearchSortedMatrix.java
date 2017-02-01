package binarySearchSortedMatrix;

import java.util.Arrays;

// Given a 2D matrix that contains integers only, which each row is sorted in an ascending order. 
// The first element of next row is larger than (or equal to) the last element of previous row.
// Given a target number, returning the position that the target locates within the matrix. 
// If the target number does not exist in the matrix, return {-1, -1}.

// The given matrix is not null, and has size of N * M, where N >= 0 and M >= 0.

public class BinarySearchSortedMatrix {

	public int[] search(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return new int[] { -1, -1 };
		}
		int rows = matrix.length, cols = matrix[0].length;
		int left = 0, right = rows * cols - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			int row = mid / cols, col = mid % cols;
			if (matrix[row][col] == target) {
				return new int[] { row, col };
			} else if (matrix[row][col] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return new int[] { -1, -1 };
	}

	// Time complexity is O(log(n*m)).
	// Space complexity is O(1).

	public static void main(String[] args) {
		BinarySearchSortedMatrix binarySearchSortedMatrix = new BinarySearchSortedMatrix();
		int[][] matrix = new int[][] { { 1, 2, 3, 4 } };
		System.out.println(Arrays.toString(binarySearchSortedMatrix.search(matrix, 5)));
	}
}
