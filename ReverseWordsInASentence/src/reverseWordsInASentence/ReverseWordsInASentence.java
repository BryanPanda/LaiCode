package reverseWordsInASentence;

// Reverse the words in a sentence.

// Assumptions:
// 1. Words are separated by single space
// 2. There are no heading or tailing white spaces

public class ReverseWordsInASentence {

	public String reverseWords(String input) {
		char[] array = input.toCharArray();
		reverse(array, 0, array.length - 1);
		int index = 0;
		while (index < array.length) {
			int start = index;
			while (index < array.length - 1 && array[index + 1] != ' ') {
				index++;
			}
			reverse(array, start, index);
			index += 2;
		}
		return new String(array);
	}

	// Time complexity is O(n).
	// Space complexity is O(n).

	// another solution: use for loop to control iterations
	public String reverseWords2(String input) {
		char[] array = input.toCharArray();
		reverse(array, 0, array.length - 1);
		int start = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != ' ' && (i == 0 || array[i - 1] == ' ')) {
				start = i;
			}
			if (array[i] != ' ' && (i == array.length - 1 || array[i + 1] == ' ')) {
				reverse(array, start, i);
			}
		}
		return new String(array);
	}

	// Time complexity is O(n).
	// Space complexity is O(n).

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
}
