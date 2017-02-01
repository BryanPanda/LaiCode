package largestRectangleOfOnes;

import java.util.LinkedList;

// Determine the largest rectangle of 1s in a binary matrix 
// (a binary matrix only contains 0 and 1), return the area.

// Assumption: The given matrix is not null and has size of M * N, M >= 0 and N >= 0

public class LargestRectangleOfOnes {

	public int largest(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int M = matrix.length;
		int N = matrix[0].length;
		int area = largest(matrix[0]);
		for (int i = 1; i < M; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = matrix[i][j] == 1 ? matrix[i - 1][j] + 1 : 0;
			}
			area = Math.max(area, largest(matrix[i]));
		}
		return area;
	}

	// O(n) time, O(n) space
	private int largest(int[] array) {
		LinkedList<Integer> stack = new LinkedList<>();
		int area = 0;
		for (int i = 0; i <= array.length; i++) {
			int cur = (i == array.length) ? 0 : array[i];
			while (!stack.isEmpty() && array[stack.peekFirst()] >= cur) {
				int height = array[stack.pollFirst()];
				int left = (stack.size() == 0) ? 0 : stack.peekFirst() + 1;
				area = Math.max(area, height * (i - left));
			}
			stack.offerFirst(i);
		}
		return area;
	}

	// Time complexity is O(m*n).
	// Space complexity is O(n).

	public static void main(String[] args) {
		LargestRectangleOfOnes largestRectangleOfOnes = new LargestRectangleOfOnes();
		int[][] matrix = new int[][] { { 0, 1, 1, 1 }, { 1, 1, 0, 1 }, { 0, 1, 0, 1 }, { 1, 1, 1, 1 } };
		System.out.println(largestRectangleOfOnes.largest(matrix));
	}
}
