package buyStock3;

// Given an array of positive integers representing a stock’s price on each day. 
// On each day you can only make one operation: either buy or sell one unit of stock, 
// at any time you can only hold at most one unit of stock, and you can make at most 2 transactions in total. 
// Determine the maximum profit you can make.

//Assumption: The give array is not null and is length of at least 2

public class BuyStock3 {

	public int maxProfit(int[] array) {
		int buyOne = Integer.MIN_VALUE, buyTwo = Integer.MIN_VALUE;
		int sellOne = 0, sellTwo = 0;
		for (int i = 0; i < array.length; i++) {
			// if this is the first stock I buy, and if I buy on day i,
			// do I save money than if I buy in any day between 0, ..., i - 1?
			// if yes, then I buy on day i; if not, then I buy in some previous
			// day, whichever is the cheapest
			buyOne = Math.max(buyOne, -array[i]);
			// if this is the first stock I sell, and if I sell on day i,
			// do I make more money than if I sell in any day between 0, ..., i
			// - 1?
			// if yes, then I sell on day i; if not, then I sell in some
			// previous day, whichever gives me the most profit
			sellOne = Math.max(sellOne, buyOne + array[i]);
			// now that I have bought and sold the first stock, I have sellOne
			// money at hand, instead of 0
			buyTwo = Math.max(buyTwo, sellOne - array[i]);
			sellTwo = Math.max(sellTwo, buyTwo + array[i]);
		}
		return sellTwo;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
