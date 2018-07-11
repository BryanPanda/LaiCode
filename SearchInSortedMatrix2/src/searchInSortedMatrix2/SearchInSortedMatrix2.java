package searchInSortedMatrix2;

// LeetCode #240 (Search a 2D Matrix II).

// Given a 2D matrix that contains integers only, where each row is sorted in ascending order,
// and each column is also sorted in ascending order.

// Given a target number, return the position where the target locates within the matrix. 

// If the target number does not exist in the matrix, return { -1, -1 }.

// Assumption: The given matrix is not null.

public class SearchInSortedMatrix2 {

	// Solution 1: BFS + Heap
	// Time complexity is O(m*n * log(m*n)).
	// Space complexity is O(m*n).

	// Solution 2: Binary search
	public int[] search(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return new int[] { -1, -1 };
		}
		int row = 0, col = matrix[0].length - 1;
		while (row < matrix.length && col >= 0) {
			if (matrix[row][col] == target) {
				return new int[] { row, col };
			} else if (matrix[row][col] < target) {
				row++;
			} else {
				col--;
			}
		}
		return new int[] { -1, -1 };
	}

	// Time complexity is O(m + n).
	// Space complexity is O(1).
}
