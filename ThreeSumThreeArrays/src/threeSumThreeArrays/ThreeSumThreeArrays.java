package threeSumThreeArrays;

import java.util.HashSet;
import java.util.Set;

// Given three arrays, determine if a set can be made by picking one element 
// from each array that sums to the given target number.

// Assumption: The three given arrays are not null and have length of at least 1.

public class ThreeSumThreeArrays {

	public boolean exist(int[] a, int[] b, int[] c, int target) {
		Set<Integer> set = new HashSet<>();
		for (int i : b) {
			set.add(i);
		}
		for (int i : a) {
			if (existTwoSum(set, c, target - i)) {
				return true;
			}
		}

		return false;
	}

	public boolean existTwoSum(Set<Integer> b, int[] c, int target) {
		for (int i : c) {
			if (b.contains(target - i)) {
				return true;
			}
		}
		return false;
	}

	// Time complexity is O(m + l * n).
	// Space complexity is O(m).
}
