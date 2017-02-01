package majorityNumber2;

import java.util.ArrayList;
import java.util.List;

// Given an integer array of length L, find all numbers that occur more than 1/3 * L times if any exist.

// Assumption: The given array is not null

public class MajorityNumber2 {

	// Solution 1: sort the array
	// O(n * log(n)) time, O(1) space.

	// Solution 2: hash map
	// O(n) time, O(n) space.

	public List<Integer> majority(int[] array) {
		List<Integer> result = new ArrayList<>();
		if (array.length == 0) {
			return result;
		}
		if (array.length == 1) {
			result.add(array[0]);
			return result;
		}
		if (array.length == 2) {
			result.add(array[0]);
			if (array[1] != array[0]) {
				result.add(array[1]);
			}
			return result;
		}
		Integer element1 = null, count1 = 0;
		Integer element2 = null, count2 = 0;
		for (int i = 0; i < array.length; i++) {
			if (count1 == 0) {
				element1 = array[i];
				count1++;
			} else if (array[i] == element1) {
				count1++;
			} else if (count2 == 0) {
				element2 = array[i];
				count2++;
			} else if (array[i] == element2) {
				count2++;
			} else {
				count1--;
				count2--;
			}
		}
		count1 = count2 = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == element1) {
				count1++;
			} else if (array[i] == element2) {
				count2++;
			}
		}
		if (count1 > array.length / 3) {
			result.add(element1);
		}
		if (count2 > array.length / 3) {
			result.add(element2);
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
