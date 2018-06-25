package longestCommonSubstring;

// Find the longest common substring of two given strings.

// Assumption: The two given strings are not null.

public class LongestCommonSubstring {

	// M[i][j] represents length of the longest common substring of the first i
	// letters of s and the first j letters of t, both inclusive.
	public String longestCommon(String s, String t) {
		int start = 0, length = 0;
		int m = s.length(), n = t.length();
		int[][] M = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (s.charAt(i) == t.charAt(j)) {
					M[i][j] = (i == 0 || j == 0) ? 1 : M[i - 1][j - 1] + 1;
				}
				if (M[i][j] > length) {
					length = M[i][j];
					start = i - length + 1;
				}
			}
		}
		return s.substring(start, start + length);
	}

	// Time complexity is O(m*n).
	// Space complexity is O(m*n).
}
