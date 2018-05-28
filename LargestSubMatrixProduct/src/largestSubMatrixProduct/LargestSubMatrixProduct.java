package largestSubMatrixProduct;

import java.util.Arrays;

// Given a matrix that contains doubles, find the sub-matrix 
// with the largest product.
// Return the product of the sub-matrix.

// Assumption: The given double matrix is not null and has size of M * N, where M >= 1 and N >= 1

public class LargestSubMatrixProduct {

	public double largest(double[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		double result = Double.MIN_VALUE;
		int m = matrix.length, n = matrix[0].length;
		for (int i = 0; i < m; i++) {
			double[] cur = new double[n];
			Arrays.fill(cur, 1.0);
			for (int j = i; j < m; j++) {
				multiply(matrix[j], cur);
				result = Math.max(result, largestProduct(cur));
			}
		}
		return result;
	}

	private void multiply(double[] array, double[] cur) {
		for (int i = 0; i < array.length; i++) {
			cur[i] *= array[i];
		}
	}

	// largest sub-array product
	private double largestProduct(double[] array) {
		double prevMax = array[0];
		double curMax = array[0];
		double prevMin = array[0];
		double curMin = array[0];
		double result = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > 0) {
				curMax = Math.max(array[i], prevMax * array[i]);
				curMin = Math.min(array[i], prevMin * array[i]);
			} else {
				curMax = Math.max(array[i], prevMin * array[i]);
				curMin = Math.min(array[i], prevMax * array[i]);
			}
			prevMax = curMax;
			prevMin = curMin;
			result = Math.max(result, curMax);
		}
		return result;
	}

	// Time complexity is O(m^2) * O(n).
	// Space complexity is O(n).
}
