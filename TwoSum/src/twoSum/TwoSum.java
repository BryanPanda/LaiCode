package twoSum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Determine if there exist two elements in a given array, the sum of which
// is the given target number.

public class TwoSum {

	public boolean existSum(int[] array, int target) {
		Arrays.sort(array);
		int left = 0, right = array.length - 1;
		while (left < right) {
			if (array[left] + array[right] == target) {
				return true;
			} else if (array[left] + array[right] < target) {
				left++;
			} else {
				right--;
			}
		}
		return false;
	}

	// Time complexity is O(n^2) in the worst case, because Arrays.sort() uses
	// Quick Sort for primitive types.
	// Space complexity is O(n) in the worst case, because of call-stack.

	public boolean existSum2(int[] array, int target) {
		Set<Integer> set = new HashSet<>();
		for (int num : array) {
			if (set.contains(target - num)) {
				return true;
			} else {
				set.add(num);
			}
		}
		return false;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).

	public static void main(String[] args) {
		TwoSum twoSum = new TwoSum();
		int[] array = new int[] { 1 };
		System.out.println(twoSum.existSum2(array, 0));
		System.out.println(twoSum.existSum2(array, 1));
		array = new int[] { 2, 3, 1 };
		System.out.println(twoSum.existSum2(array, 5));
		System.out.println(twoSum.existSum2(array, 6));
		System.out.println(twoSum.existSum2(array, 7));
	}

}
