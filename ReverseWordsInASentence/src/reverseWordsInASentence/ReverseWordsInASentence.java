package reverseWordsInASentence;

// LeetCode #186 (Reverse Words in a String II), #557 (Reverse Words in a String III).

// Reverse the words in a sentence.

// Assumptions:
// 1. Words are separated by single space
// 2. There are no heading or tailing white spaces

public class ReverseWordsInASentence {

	public String reverseWords(String input) {
		if (input == null) {
			return input;
		}
		char[] array = input.toCharArray();
        int slow = 0;
        for (int fast = 0; fast < array.length; fast++) {
            if (array[fast] != ' ' && (fast == 0 || array[fast - 1] == ' ')) {
                slow = fast;
            }
            if (array[fast] != ' ' && (fast == array.length - 1 || array[fast + 1] == ' ')) {
                reverse(array, slow, fast);
            }
        }
        reverse(array, 0, array.length - 1); // remove for #557
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
