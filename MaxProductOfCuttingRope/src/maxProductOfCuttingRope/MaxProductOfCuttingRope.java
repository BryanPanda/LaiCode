package maxProductOfCuttingRope;

// Given a rope with positive integer-length n, how to cut the rope into m
// integer-length parts with length p[0], p[1], ...,p[m-1], in order to get
// the maximal product of p[0]*p[1]* ... *p[m-1]?
// m is determined by you and it must be greater than 0 (at least one cut must be made).
// Return the max product you can have.

//Assumption: n >= 2

public class MaxProductOfCuttingRope {

	// recursive solution
	public int maxProduct(int length) {
		if (length <= 1) {
			return 0;
		}
		int max = 0;
		for (int i = 0; i < length; i++) {
			int best = Math.max(length - i, maxProduct(length - i));
			max = Math.max(max, i * best);
		}
		return max;
	}

	// Time complexity is O(n*n!).
	// Space complexity is O(n).

	// DP solution 1
	// M[i]: maximum product of cutting rope, with length i
	// M[i] = max( max(i - j, M[i - j]), max(j, M[j])), for j = 1, ..., i / 2
	public int maxProduct2(int length) {
		// base case
		if (length <= 1) {
			return 0;
		}
		if (length == 2) {
			return 1;
		}
		int[] array = new int[length + 1];
		array[1] = 0;
		array[2] = 1;
		for (int i = 3; i < length + 1; i++) {
			for (int j = 1; j <= i / 2; j++) {
				array[i] = Math.max(array[i], j * Math.max(i - j, array[i - j]));
			}

		}
		return array[length];
	}

	// Time complexity is O(n^2).
	// Space complexity is O(n).
}
