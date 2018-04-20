package firstOccurrence;

// LeetCode #278 (First Bad Version), #34 (Search for a Range).

// Given a target integer T and an integer array A sorted in ascending order, 
// find the index of the first occurrence of T in A or return -1 if there is no such index.

public class FirstOccurrence {

	public int firstOccur(int[] array, int target) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int left = 0, right = array.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (array[mid] >= target) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return array[left] == target ? left : -1;
	}

	// Time complexity is O(log(n)).
	// Space complexity is O(1).
}

