package largestSubArrayProduct;

// LeetCode #152 (Maximum Product Subarray).

// Given an unsorted array of doubles, find the sub-array that has the greatest
// product. Return the product.

// Assumption: The given array is not null and has length of at least 1.

public class LargestSubArrayProduct {

	public double largestProduct(double[] array) {
		double prevMax = array[0], prevMin = array[0], curMax = array[0], curMin = array[0], max = array[0];
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
			max = Math.max(max, curMax);
		}
		return max;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
