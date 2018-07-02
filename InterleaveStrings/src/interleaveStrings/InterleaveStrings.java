package interleaveStrings;

// LeetCode #97 (Interleaving String).

// Given three strings A, B and C. Determine if C can be created by merging A and B
// in a way that maintains the relative order of the characters in A and B.

public class InterleaveStrings {

	// M[i][j] represents whether letters of string a in [0, i - 1] and letters of
	// string b in [0, j - 1] can merge to letter of string c in [0, i + j - 1].
	public boolean canMerge(String a, String b, String c) {
		int m = a.length(), n = b.length();
		if (m + n != c.length()) {
			return false;
		}
		boolean[][] matrix = new boolean[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
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
		return matrix[m][n];
	}

	// Time complexity is O(m*n).
	// Space complexity is O(m*n).
}
