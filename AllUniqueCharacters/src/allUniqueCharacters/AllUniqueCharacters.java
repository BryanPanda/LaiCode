package allUniqueCharacters;

// Determine if the characters of a given string are all unique.

// Assumptions:
// The only set of possible characters used in the string are 'a' - 'z', the 26 lower case letters.
// The given string is not null.

public class AllUniqueCharacters {

	public boolean allUnique(String word) {
		int vec = 0;
		for (int i = 0; i < word.length(); i++) {
			int a = word.charAt(i);
			int w = 1 << (a % 32);
			if ((vec & w) != 0) {
				return false;
			}
			vec |= w;
		}
		return true;
	}
}
