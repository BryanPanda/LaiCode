package moveZero2;

// Given an array of integers, move all the 0s to the right end of the array.
// The relative order of the elements in the original array need to be maintained.

public class MoveZero2 {

	public int[] moveZero(int[] array) {
		if (array == null || array.length <= 1) {
			return array;
		}
		int slow = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != 0) {
				array[slow++] = array[i];
			}
		}
		for (int i = slow; i < array.length; i++) {
			array[i] = 0;
		}
		return array;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
