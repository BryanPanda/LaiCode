package subarraySumToTarget;

import java.util.HashSet;
import java.util.Set;

// Given an array of integers, determine whether there exists a contiguous sub-array in the array, which sums to a target number.

// Assumption: The given array is not null and its length is > 0.

public class SubarraySumToTarget {

	public boolean sumToTarget(int[] array, int target) {
		if (array == null || array.length == 0) {
			return false;
		}
		Set<Integer> prefixSums = new HashSet<>();
		prefixSums.add(0);
		return DFS(array, target, 0, 0, prefixSums);
	}

	private boolean DFS(int[] array, int target, int index, int prefixSum, Set<Integer> prefixSums) {
		prefixSum += array[index];
		if (prefixSums.contains(prefixSum - target)) {
			return true;
		}
		boolean needRemove = prefixSums.add(prefixSum);
		if (index < array.length - 1 && DFS(array, target, index + 1, prefixSum, prefixSums)) {
			return true;
		}
		if (needRemove) {
			prefixSums.remove(prefixSum);
		}
		return false;
	}
	
	// Time complexity is O(n).
	// Space complexity is O(n).
	
	// Follow up: return the total number of sub-arrays that sum to target (LeetCode #560 Subarray Sum Equals K).
}
