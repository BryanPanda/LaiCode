package missingNumber;

import java.util.HashSet;
import java.util.Set;

// LeetCode #268 (Missing Number).

// Given an integer array of size N - 1, containing all the numbers from 1 to N except one, find the missing number.

// Assumption: The given array is not null, and N >= 1

public class MissingNumber {

	// solution 1: sum all integers 1, ..., n up
	// sum up all integers in array
	// the difference of the two is the missing number
	// potential problem: overflow
	public int missing1(int[] array) {
		long result = 0L;
		for (int i = 1; i <= array.length + 1; i++) {
			result += i;
		}
		for (int i = 0; i < array.length; i++) {
			result -= array[i];
		}
		return (int) (result);
	}

	// Time Complexity is O(n).
	// Space Complexity is O(1).

	// solution 2: exclusive-or
	public int missing2(int[] array) {
		int result = 0;
		for (int i = 1; i <= array.length + 1; i++) {
			result = result ^ i;
		}
		for (int i = 0; i < array.length; i++) {
			result = result ^ array[i];
		}
		return result;
	}

	// Time Complexity is O(n).
	// Space Complexity is O(1).

	// solution 3: hash set
	public int missing3(int[] array) {
		int result = 0;
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < array.length; i++) {
			set.add(array[i]);
		}
		for (int i = 1; i <= array.length + 1; i++) {
			if (!set.contains(i)) {
				result = i;
				break;
			}
		}
		return result;
	}

	// Time Complexity is O(n).
	// Space Complexity is O(n).

	// solution 4: swap
	public int missing4(int[] array) {
		for (int i = 0; i < array.length; i++) {
			// number (i + 1) should be at position i, except for n,
			// because array.length = n - 1, index of last number is n - 2
			// if not at the correct position, swap it to the correct position,
			// and keep doing
			while (array[i] != i + 1 && array[i] != array.length + 1) {
				swap(array, i, array[i] - 1);
			}
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i] != i + 1) {
				return i + 1;
			}
		}
		return array.length + 1;
	}

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	// Time Complexity is O(n).
	// Space Complexity is O(1).
}
