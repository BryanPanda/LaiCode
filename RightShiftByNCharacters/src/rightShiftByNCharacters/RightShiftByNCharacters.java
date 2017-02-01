package rightShiftByNCharacters;

// Right shift a given string by n characters.

// Assumptions:
// 1. The given string is not null.
// 2. n >= 0.

public class RightShiftByNCharacters {

	public String rightShift(String input, int n) {
		if (input == null || input.length() == 0) {
			return input;
		}
		char[] array = input.toCharArray();
		n %= array.length;
		reverse(array, 0, array.length - 1 - n);
		reverse(array, array.length - n, array.length - 1);
		reverse(array, 0, array.length - 1);
		return new String(array);
	}

	private void reverse(char[] array, int left, int right) {
		if (left >= right) {
			return;
		}
		while (left < right) {
			char temp = array[left];
			array[left] = array[right];
			array[right] = temp;
			left++;
			right--;
		}
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
