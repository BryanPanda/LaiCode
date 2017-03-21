package twoSumAllPairs2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Find all pairs of elements in a given array that sum to the given target number. 
// Return all the distinct pairs of values.

public class TwoSumAllPairs2 {

	public List<List<Integer>> allPairs(int[] array, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(array);
		int left = 0, right = array.length - 1;
		while (left < right) {
			if (array[left] + array[right] == target) {
				int small = array[left], large = array[right];
				List<Integer> pair = new ArrayList<>();
				pair.add(array[left++]);
				pair.add(array[right--]);
				result.add(pair);
				while (left < array.length - 1 && left < right && array[left] == small) {
					left++;
				}
				while (right > 0 && left < right && array[right] == large) {
					right--;
				}
			} else if (array[left] + array[right] < target) {
				left++;
			} else {
				right--;
			}
		}
		return result;
	}

	// neater solution
	public List<List<Integer>> allPairs2(int[] array, int target) {
		Arrays.sort(array);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int left = 0, right = array.length - 1;
		while (left < right) {
			if (left > 0 && array[left] == array[left - 1]) {
				left++;
				continue;
			}
			if (array[left] + array[right] == target) {
				result.add(Arrays.asList(array[left++], array[right--]));
			} else if (array[left] + array[right] < target) {
				left++;
			} else {
				right--;
			}
		}
		return result;
	}

	// Time complexity is O(n^2) in the worst case, because Arrays.sort() uses
	// Quick Sort for primitive types.
	// Space complexity is O(n) in the worst case, because of call-stack.

	public List<List<Integer>> allPairs3(int[] array, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		for (int num : array) {
			if (map.containsKey(target - num)) {
				if (!map.get(target - num)) {
					List<Integer> pair = new ArrayList<>();
					pair.add(num);
					pair.add(target - num);
					result.add(pair);
					map.put(target - num, true);
				}
			} else if (!map.containsKey(num)) {
				map.put(num, false);
			}
		}
		return result;
	}

	// neater solution
	public List<List<Integer>> allPairs4(int[] array, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : array) {
			Integer count = map.get(num);
			if (num * 2 == target && count != null && count == 1) {
				result.add(Arrays.asList(num, num));
			} else if (map.containsKey(target - num) && count == null) {
				result.add(Arrays.asList(num, target - num));
			}
			if (count == null) {
				map.put(num, 1);
			} else {
				map.put(num, count + 1);
			}
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).

	public static void main(String[] args) {
		TwoSumAllPairs2 twoSumAllPair = new TwoSumAllPairs2();
		int[] array = new int[] { 1 };
		System.out.println(twoSumAllPair.allPairs2(array, 1));
		array = new int[] { 2, 3, 1 };
		System.out.println(twoSumAllPair.allPairs2(array, 4));
		System.out.println(twoSumAllPair.allPairs2(array, 7));
		array = new int[] { 2, 1, 3, 2, 4, 3, 4, 2 };
		System.out.println(twoSumAllPair.allPairs2(array, 5));
		System.out.println(twoSumAllPair.allPairs2(array, 6));
		System.out.println(twoSumAllPair.allPairs2(array, 7));
	}

}
