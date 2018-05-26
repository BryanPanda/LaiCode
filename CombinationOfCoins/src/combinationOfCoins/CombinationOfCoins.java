package combinationOfCoins;

import java.util.ArrayList;
import java.util.List;

// LeetCode #39 (Combination Sum).

// Given a number of different denominations of coins (e.g., 1 cent, 5 cents, 10 cents, 25 cents), 
// get all the possible ways to pay a target number of cents.

// Assumptions:
// 1. coins is not null and is not empty, all the numbers in coins are positive
// 2. target >= 0
// 3. You have infinite number of coins for each of the denominations, you can pick any number of the coins.

public class CombinationOfCoins {

	public List<List<Integer>> combinations(int target, int[] coins) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<>();
		DFS(list, 0, target, coins, result);
		return result;
	}

	private void DFS(List<Integer> list, int level, int target, int[] coins, List<List<Integer>> result) {
		if (level == coins.length) {
			if (target == 0) {
				// Notice: create a new List<Integer>, otherwise all lists in
				// result are the same
				result.add(new ArrayList<Integer>(list));
			}
			return;
		}
		for (int i = 0; i <= target / coins[level]; i++) {
			list.add(i);
			DFS(list, level + 1, target - i * coins[level], coins, result);
			list.remove(list.size() - 1);
		}
	}

	// Time complexity is O(target^n), where n is the number of coin types.
	// Space complexity is O(n).
}
