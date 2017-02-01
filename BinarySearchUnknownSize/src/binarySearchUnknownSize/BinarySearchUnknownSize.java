package binarySearchUnknownSize;

// Given a integer dictionary A of unknown size, where the numbers in the dictionary are sorted in ascending order, 
// determine if a given target integer T is in the dictionary. 
// Return the index of T in A, return -1 if T is not in A.

// dictionary A is not null
// dictionary.get(i) will return null if index i is out of bounds

public class BinarySearchUnknownSize {
	public int search(Dictionary dict, int target) {
		if (dict == null)
			return -1;
		int i = 1;
		while (dict.get(i) != null && dict.get(i) < target) {
			i *= 2;
		}
		int low = i / 2, high = i;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (dict.get(mid) == null || dict.get(mid) > target) {
				high = mid - 1;
			} else if (dict.get(mid) < target) {
				low = mid + 1;
			} else if (dict.get(mid) == target) {
				return mid;
			}
		}
		return -1;
	}
}
