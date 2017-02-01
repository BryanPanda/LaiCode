package twoSubsetsWithMinDifference;

import java.util.ArrayList;
import java.util.List;

// Given a set of n integers, divide the set in two subsets (a: of size n/2 each, 
// b: not necessarily of size n/2 each) such that the difference of the sum of two
// subsets is as minimum as possible.
// Return the minimum difference (absolute value).

// Assumption: The given integer array is not null and it has length of >= 2.

public class TwoSubsetsWithMinDifference {

	// solution 1: DFS
	public int minDifference(int[] array) {
		int sum = sum(array);
		Integer[] total = new Integer[] { sum };
		Integer[] min = new Integer[] { Integer.MAX_VALUE };
		Integer[] cur = new Integer[] { 0 };
		List<Integer> list = new ArrayList<>();
		DFS2(array, 0, total, min, cur, list);
		return min[0];
	}

	private int sum(int[] array) {
		int sum = 0;
		for (int i : array) {
			sum += i;
		}
		return sum;
	}

	// Assumption: the two subsets don't need to be of about equal size
	private void DFS(int[] array, int level, Integer[] total, Integer[] min, Integer[] cur, List<Integer> list) {
		if (level == array.length) {
			// check if min needs to be updated
			if (Math.abs(total[0] - 2 * cur[0]) < min[0]) {
				min[0] = Math.abs(total[0] - 2 * cur[0]);
			}
			return;
		}
		list.add(array[level]);
		DFS(array, level + 1, total, min, new Integer[] { cur[0] + array[level] }, list);
		list.remove(list.size() - 1);
		DFS(array, level + 1, total, min, cur, list);
	}

	// Assumption: the two subsets are required to be of about equal size
	private void DFS2(int[] array, int level, Integer[] total, Integer[] min, Integer[] cur, List<Integer> list) {
		if (level == array.length) {
			if ((array.length % 2 == 0 && list.size() == array.length / 2) || (array.length % 2 == 1
					&& (list.size() == array.length / 2 || list.size() == array.length / 2 + 1))) {
				if (Math.abs(total[0] - 2 * cur[0]) < min[0]) {
					min[0] = Math.abs(total[0] - 2 * cur[0]);
				}
			}
			return;
		}
		list.add(array[level]);
		DFS2(array, level + 1, total, min, new Integer[] { cur[0] + array[level] }, list);
		list.remove(list.size() - 1);
		DFS2(array, level + 1, total, min, cur, list);
	}

	// Time complexity is O(2^n).
	// Space complexity is O(n).

	// solution 2: DP
	// Assumptions:
	// 1. all elements are non-negative
	// 2. the two subsets don't need to be of about equal size
	// M[i][j]: whether elements in array, from index 0 to index i, inclusive
	// can sum up to j
	public int minDifference2(int[] array) {
		int sum = sum(array);
		boolean[][] matrix = new boolean[array.length][sum + 1];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < sum + 1; j++) {
				if (i == 0) {
					matrix[i][j] = (j == 0) ? true : (array[i] == j);
				} else {
					matrix[i][j] = (j - array[i]) < 0 ? matrix[i - 1][j]
							: matrix[i - 1][j] || matrix[i - 1][j - array[i]];
				}
			}
		}
		// post processing
		int offset = 0, index = sum / 2;
		while (!matrix[array.length - 1][index + offset] && !matrix[array.length - 1][index - offset]) {
			offset++;
		}
		// matrix[array.length - 1][index + offset] || matrix[array.length -
		// 1][index - offset]
		int min = Integer.MAX_VALUE;
		if (matrix[array.length - 1][index + offset]) {
			min = Math.min(min, Math.abs(sum - 2 * (index + offset)));
		}
		if (matrix[array.length - 1][index - offset]) {
			min = Math.min(min, Math.abs(sum - 2 * (index - offset)));
		}
		return min;
	}

	// Time complexity is O(n*n*k), where [0, k] is range of elements
	// Space complexity is O(n*n*k).

	public static void main(String[] args) {
		TwoSubsetsWithMinDifference twoSubsetsWithMinDifference = new TwoSubsetsWithMinDifference();
		int[] array = new int[] { 1, 5, 2, 7 };
		System.out.println(twoSubsetsWithMinDifference.minDifference2(array));
	}
}
