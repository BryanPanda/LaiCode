package spiralOrderGenerate2;

// Generate an M * N 2D array in spiral order clock-wise starting from the top left corner, 
// using the numbers of 1, 2, 3, …, M * N in increasing order.

public class SpiralOrderGenerate2 {

	// iterative solution
	public int[][] spiralGenerate(int m, int n) {
		int[][] result = new int[m][n];
		if (m == 0 || n == 0) {
			return result;
		}
		// up to this point, m != 0 && n != 0
		int count = 1;
		int left = 0, right = n - 1, up = 0, down = m - 1;
		while (left < right && up < down) {
			for (int i = left; i < right; i++) {
				result[up][i] = count++;
			}
			for (int i = up; i < down; i++) {
				result[i][right] = count++;
			}
			for (int i = right; i > left; i--) {
				result[down][i] = count++;
			}
			for (int i = down; i > up; i--) {
				result[i][left] = count++;
			}
			left++;
			right--;
			up++;
			down--;
		}
		// up to this point, left >= right || up >= down
		if (left > right || up > down) {
			return result;
		}
		// up to this point, (left >= right || up >= down)
		// && (left <= right && up <= down)
		if (left == right) {
			for (int i = up; i <= down; i++) {
				result[i][left] = count++;
			}
		} else {
			for (int i = left; i <= right; i++) {
				result[up][i] = count++;
			}
		}
		return result;
	}

	// Time Complexity is O(m*n).
	// Space Complexity is O(1).
}
