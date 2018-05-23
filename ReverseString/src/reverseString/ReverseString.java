package reverseString;

// LeetCode #344 (Reverse String).

// Reverse a given string.

public class ReverseString {

	// iterative solution
	public String reverse(String input) {
		if (input == null || input.length() <= 1) {
			return input;
		}
		char[] array = input.toCharArray();
		int left = 0, right = array.length - 1;
		while (left < right) {
			swap(array, left++, right--);
		}
		return new String(array);
	}

	private void swap(char[] array, int left, int right) {
		char temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).

	// recursive solution
	public String reverse2(String input) {
		if (input == null || input.length() <= 1) {
			return input;
		}
		char[] array = input.toCharArray();
		helper(array, 0, array.length - 1);
		return new String(array);
	}

	private void helper(char[] array, int left, int right) {
		if (left >= right) {
			return;
		}
		swap(array, left, right);
		helper(array, left + 1, right - 1);
	}

	// Time Complexity is O(n).
	// Space Complexity is O(n).
}
