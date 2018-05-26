package buyStock4;

import java.util.Arrays;

//LeetCode #188 (Best Time to Buy and Sell Stock IV).

// Given an array of integers representing a stock’s price on each day. 
// On each day you can only make one operation: either buy or sell one unit of stock, 
// and at any time you can only hold at most one unit of stock, and you can make at most K transactions in total. 
// Determine the maximum profit you can make.

// Assumption: The give array is not null and is length of at least 2

public class BuyStock4 {

	// generalize solution from BuyStock3
	public int maxProfit(int[] array, int k) {
        k = Math.min(k, array.length / 2); // optimization
        if (k == 0) {
            return 0;
        }
		int[] buy = new int[k];
		Arrays.fill(buy, Integer.MIN_VALUE);
		int[] sell = new int[k];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < k; j++) {
				buy[j] = Math.max(buy[j], (j == 0 ? 0 : sell[j - 1]) - array[i]);
				sell[j] = Math.max(sell[j], buy[j] + array[i]);
			}
		}
		return sell[k - 1];
	}

	// Time complexity is O(n*k).
	// Space complexity is O(k).
}
