package perfectShuffle;

// LeetCode #384 (Shuffle an Array).

// Given an array of integers (without any duplicates), shuffle the array such that 
// all permutations are equally likely to be generated.

// Assumption: The given array is not null

public class PerfectShuffle {

	public void shuffle(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}
		for (int i = array.length - 1; i >= 0; i--) {
			int random = (int) (Math.random() * (i + 1));
			swap(array, random, i);
		}
	}

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
