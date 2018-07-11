package searchInSortedMatrix;

// LeetCode #74 (Search a 2D Matrix).

// Given a 2D matrix that contains integers only, which each row is sorted in an ascending order. 
// The first element of next row is larger than (or equal to) the last element of previous row.

// Given a target number, returning the position that the target locates within the matrix. 
// If the target number does not exist in the matrix, return { -1, -1 }.

public class SearchInSortedMatrix {

	public int[] search(int[][] matrix, int target) {
		int m = matrix.length, n = matrix[0].length;
		int left = 0, right = m * n - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			int row = mid / n, col = mid % n;
			if (matrix[row][col] == target) {
				return new int[] { row, col };
			} else if (matrix[row][col] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return (matrix[left / n][left % n] == target) ? new int[] { left / n, left % n } : new int[] { -1, -1 };
	}

	// Time complexity is O(log(m*n)).
	// Space complexity is O(1).
}
