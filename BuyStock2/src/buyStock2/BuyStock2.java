package buyStock2;

// Given an array of positive integers representing a stock’s price on each day. 
// On each day you can only make one operation: either buy or sell one unit of stock, 
// you can make as many transactions you want, but at any time you can only hold at most one unit of stock. 
// Determine the maximum profit you can make.

// Assumption: The given array is not null and has length of at least 2.

public class BuyStock2 {

	public int maxProfit(int[] array) {
		int max = 0;
		for (int i = 1; i < array.length; i++) {
			max += (array[i] - array[i - 1] > 0) ? array[i] - array[i - 1] : 0;
		}
		return max;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
