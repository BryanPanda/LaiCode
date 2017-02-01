package longestCommonSubsequence;

// Find the length of longest common subsequence of two given strings.

// Assumption: The two given strings are not null

public class LongestCommonSubsequence {

	// M[i][j] represents length of the longest common subsequence of first i
	// letters of the first string, and first j letters of the second string.
	public int longest(String s, String t) {
		int[][] common = new int[s.length() + 1][t.length() + 1];
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= t.length(); j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					common[i][j] = common[i - 1][j - 1] + 1;
				} else {
					common[i][j] = Math.max(common[i - 1][j], common[i][j - 1]);
				}
			}
		}
		return common[s.length()][t.length()];
	}

	// Time complexity is O(m * n).
	// Space complexity is O(m * n).
}
