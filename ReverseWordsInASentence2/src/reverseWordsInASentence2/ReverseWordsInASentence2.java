package reverseWordsInASentence2;

import java.util.Arrays;

// LeetCode #151 (Reverse Words in a String).

// Reverse the words in a sentence and truncate all heading/trailing/duplicate space characters.

public class ReverseWordsInASentence2 {

	public String reverseWords(String input) {
		return helper(removeSpaces(input));
	}

	private String removeSpaces(String input) {
		char[] array = input.toCharArray();
		int slow = 0; // not including slow
		for (int fast = 0; fast < array.length; fast++) {
			if (array[fast] != ' ' || fast > 0 && array[fast - 1] != ' ') {
				array[slow++] = array[fast];
			}
		}
		if (slow - 1 >= 0 && array[slow - 1] == ' ') {
			slow--;
		}
		return new String(Arrays.copyOf(array, slow));
	}

	public String helper(String input) {
		char[] array = input.toCharArray();
		reverse(array, 0, array.length - 1);
		int start = 0;
		for (int fast = 0; fast < array.length; fast++) {
			if (array[fast] != ' ' && (fast == 0 || array[fast - 1] == ' ')) {
				start = fast;
			}
			if (array[fast] != ' ' && (fast == array.length - 1 || array[fast + 1] == ' ')) {
				reverse(array, start, fast);
			}
		}
		return new String(array);
	}

	private void reverse(char[] array, int left, int right) {
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
