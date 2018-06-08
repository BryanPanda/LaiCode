package subarraySumToTarget;

import java.util.HashSet;
import java.util.Set;

// Given an array of integers, determine whether there exists a contiguous sub-array in the array, which sums to a target number.

// Assumption: The given array is not null and its length is > 0.

public class SubarraySumToTarget {

	public boolean sumToTarget(int[] array, int target) {
		int prefixSum = 0;
		Set<Integer> prefixSums = new HashSet<>();
		prefixSums.add(0);
		for (int i = 0; i < array.length; i++) {
			prefixSum += array[i];
			if (prefixSums.contains(prefixSum - target)) {
				return true;
			}
			prefixSums.add(prefixSum);
		}
		return false;
	}
	
	// Time complexity is O(n).
	// Space complexity is O(n).
	
	// Note: It might be tempting to use DFS, as in LeetCode #437 (Path Sum III).
	// However, that turns out to be a tail recursion, and thus can be turned into an iterative solution.
	
	// Follow up: return the total number of sub-arrays that sum to target (LeetCode #560 Subarray Sum Equals K).
}
