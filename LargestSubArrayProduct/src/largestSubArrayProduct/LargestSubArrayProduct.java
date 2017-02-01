package largestSubArrayProduct;

// Given an unsorted array of doubles, find the sub-array that has the greatest
// product. Return the product.

// Assumption: The given array is not null and has length of at least 1.

public class LargestSubArrayProduct {

	public double largestProduct(double[] array) {
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

	// Time complexity is O(n).
	// Space complexity is O(1).

	public static void main(String[] args) {
		LargestSubArrayProduct largestSubArrayProduct = new LargestSubArrayProduct();
		double[] array = new double[] { 1.1, -1.0, -3.0 };
		System.out.println(largestSubArrayProduct.largestProduct(array));
	}
}
