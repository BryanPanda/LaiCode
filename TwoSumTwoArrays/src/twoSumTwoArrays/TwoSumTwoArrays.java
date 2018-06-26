package twoSumTwoArrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Given two arrays A and B, determine whether or not there exists a pair of elements, 
// one drawn from each array, that sums to the given target number.

// Assumption: The two given arrays are not null and have length of at least 1.

public class TwoSumTwoArrays {

	public boolean existSum(int[] a, int[] b, int target) {
		Arrays.sort(a);
		Arrays.sort(b);
		int left = 0, right = b.length - 1;
		while (left < a.length && right >= 0) {
			if (a[left] + b[right] == target) {
				return true;
			} else if (a[left] + b[right] < target) {
				left++;
			} else {
				right--;
			}
		}
		return false;
	}

	// Time complexity is O(m * log(m) + n * log(n)).
	// Space complexity is O(log(m) + log(n)), because of quick sort (for primitive
	// types).

	public boolean existSum2(int[] a, int[] b, int target) {
		Set<Integer> set = new HashSet<>();
		for (int i : a) {
			set.add(i);
		}
		for (int i : b) {
			if (set.contains(target - i)) {
				return true;
			}
		}
		return false;
	}

	// Time complexity is O(m + n).
	// Space complexity is O(m).
}
