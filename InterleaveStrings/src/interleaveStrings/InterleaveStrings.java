package interleaveStrings;

// Given three strings A, B and C. Determine if C can be created by merging A and B
// in a way that maintains the relative order of the characters in A and B.

public class InterleaveStrings {

	// M[i][j] represents whether letters of string a, indexed from 0 to i - 1,
	// inclusively, and letters of string b, indexed from 0 to j - 1,
	// inclusively, can merge to letter of string c, indexed from 0 to i + j - 1
	public boolean canMerge(String a, String b, String c) {
		int aLength = a.length();
		int bLength = b.length();
		int cLength = c.length();
		if (aLength + bLength != cLength) {
			return false;
		}
		boolean[][] matrix = new boolean[aLength + 1][bLength + 1];
		for (int i = 0; i <= aLength; i++) {
			for (int j = 0; j <= bLength; j++) {
				if (i == 0 && j == 0) {
					matrix[i][j] = true;
				}
				if (i > 0 && a.charAt(i - 1) == c.charAt(i + j - 1)) {
					matrix[i][j] |= matrix[i - 1][j];
				}
				if (j > 0 && b.charAt(j - 1) == c.charAt(i + j - 1)) {
					matrix[i][j] |= matrix[i][j - 1];
				}
			}
		}
		return matrix[aLength][bLength];
	}

	// Time complexity is O(m*n).
	// Space complexity is O(m*n).
}
