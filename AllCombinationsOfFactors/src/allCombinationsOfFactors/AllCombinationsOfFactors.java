package allCombinationsOfFactors;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Given an integer target, return a list of all combinations of its factors.
// Assumption: 
// 1. target >= 4
// 2. not including factors 1 or target

public class AllCombinationsOfFactors {

	public List<List<Integer>> combinations(int target) {
		// step 1: get all possible factors of target
		int[] factors = allFactors(target);
		return helper(target, factors);
	}

	private int[] allFactors(int target) {
		// target >= 4
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
		List<Integer> list = new ArrayList<>();
		DFS(list, 0, target, factors, result);
		return result;
	}

	private void DFS(List<Integer> list, int level, int target, int[] factors, List<List<Integer>> result) {
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
				DFS(list, level + 1, target / (int) Math.pow(factors[level], i), factors, result);
			}
			list.remove(list.size() - 1);
		}
	}

	private List<Integer> convert(List<Integer> list, int[] factors) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) != 0) {
				for (int j = 0; j < list.get(i); j++) {
					result.add(factors[i]);
				}
			}
		}
		return result;
	}

	// Time complexity: O(target) to find all factors
	// Suppose target has k factors, there are at most k layers, each node has
	// at most log(target) child nodes, O(log(target)^k).
	// Space complexity is O(k).

	public static void main(String[] args) {
		AllCombinationsOfFactors allCombinationsOfFactors = new AllCombinationsOfFactors();
		List<List<Integer>> result = allCombinationsOfFactors.combinations(24);
		for (List<Integer> list : result) {
			System.out.println(list.toString());
		}
	}
}
