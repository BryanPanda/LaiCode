package allCombinationsOfFactors;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Given an integer target, return a list of all combinations of its factors.

// Assumption: The given number is guaranteed to be >= 2.

public class AllCombinationsOfFactors {

	public List<List<Integer>> factors(int target) {
		int[] factors = allFactors(target);
		return helper(target, factors);
	}

	// get all possible factors of target (>= 2)
	private int[] allFactors(int target) {
		Set<Integer> set = new HashSet<>();
		for (int i = 2; i <= Math.sqrt(target); i++) {
			if (target % i == 0) {
				set.add(i);
				set.add(target / i);
			}
		}
		int[] factors = new int[set.size()];
		int i = 0;
		for (int factor : set) {
			factors[i++] = factor;
		}
		return factors;
	}

	private List<List<Integer>> helper(int target, int[] factors) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result.add(Arrays.asList(target)); // add target itself
		
		List<Integer> list = new ArrayList<>();
		DFS(target, factors, list, result, 0);
		return result;
	}

	private void DFS(int target, int[] factors, List<Integer> list, List<List<Integer>> result, int level) {
		if (level == factors.length) {
			if (target == 1) {
				List<Integer> mult = convert(list, factors);
				result.add(mult);
			}
			return;
		}
		for (int i = 0; i <= Math.log(target) / Math.log(factors[level]); i++) {
			list.add(i);
			if (target % Math.pow(factors[level], i) == 0) {
				DFS(target / (int) Math.pow(factors[level], i), factors, list, result, level + 1);
			}
			list.remove(list.size() - 1);
		}
	}

	private List<Integer> convert(List<Integer> list, int[] factors) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i); j++) {
				result.add(factors[i]);
			}
		}
		return result;
	}

	// Time complexity: O(target) to find all factors + ?
	// Suppose target has k factors, there are at most k layers, each node has
	// at most log(target) child nodes, O(log(target)^k).
	
	// Space complexity is O(k).
}
