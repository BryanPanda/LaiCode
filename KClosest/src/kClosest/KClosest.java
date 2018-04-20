package kClosest;

// LeetCode #658 (Find K Closest Elements).

// Given a target integer T, a non-negative integer K and an integer array A sorted in ascending order, 
// find the K closest numbers to T in A.

// A is not null
// K is guaranteed to be >= 0 and K is guaranteed to be <= A.length

public class KClosest {

	public int[] kClosest(int[] array, int target, int k) {
		if (array == null || array.length == 0) {
			return array;
		}
		if (k == 0) {
			return new int[0];
		}
		int[] result = new int[k];
		int left = largestSmallerOrEqual(array, target);
		int right = left + 1;
		for (int i = 0; i < k; i++) {
			// when can we pick the left element?
			// 1. right >= array.length;
			// 2. left >= 0 && (the left element is closer)
			if (right >= array.length || left >= 0 && target - array[left] <= array[right] - target) {
				result[i] = array[left--];
			} else {
				result[i] = array[right++];
			}
		}
		return result;
	}

	private int largestSmallerOrEqual(int[] array, int target) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int left = 0, right = array.length - 1;
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (array[mid] <= target) {
				left = mid;
			} else {
				right = mid;
			}
		}
		// up to this point, left == right - 1
		if (array[right] <= target) {
			return right;
		} else if (array[left] <= target) {
			return left;
		}
		return -1;
	}

	// Time complexity is O(log(n) + k).
	// Space complexity is O(1).
	
	// Follow up: The returned integer array is ordered by the closeness to target, could you
	// return them in ascending order?
	// Answer: Use a linked list: Add to first when left element is picked, and add to last 
	// when right element is picked.
}

