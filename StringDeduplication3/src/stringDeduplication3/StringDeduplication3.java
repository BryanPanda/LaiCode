package stringDeduplication3;

// Remove adjacent, repeated characters in a given string, leaving no character for each group of such characters. 
// The characters in the string are sorted in ascending order.

public class StringDeduplication3 {

	public String deDup(String input) {
		int slow = 0; // not including slow
		char[] array = input.toCharArray();
		for (int fast = 0; fast < array.length; fast++) {
			if ((fast == 0 || array[fast] != array[fast - 1]) && (fast == array.length - 1 || array[fast] != array[fast + 1])) {
				array[slow++] = array[fast];
			}
		}
		return new String(array, 0, slow);
	}
	
	// Time complexity is O(n).
	// Space complexity is O(1).
}
