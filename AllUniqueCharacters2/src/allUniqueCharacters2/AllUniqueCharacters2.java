package allUniqueCharacters2;

// Determine if the characters of a given string are all unique.

// Assumptions:
// We are using ASCII char set, the value of valid characters are from 0 to 255
// The given string is not null

public class AllUniqueCharacters2 {

	public boolean allUnique(String word) {
		int[] vec = new int[8];
		for (int i = 0; i < word.length(); i++) {
			int c = word.charAt(i);
			int row = c / 32;
			int w = 1 << (c % 32);
			if ((vec[row] & w) != 0) {
				return false;
			}
			vec[row] |= w;
		}
		return true;
	}
}
