package longestCommonSubsequence;

// Find the length of longest common subsequence of two given strings.

// Assumption: The two given strings are not null.

public class LongestCommonSubsequence {

	// M[i][j] represents length of the longest common subsequence
	// of s in [0, i) and t in [0, j).
	public int longest(String s, String t) {
		int m = s.length(), n = t.length();
		int[][] common = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					common[i][j] = common[i - 1][j - 1] + 1;
				} else {
					common[i][j] = Math.max(common[i - 1][j], common[i][j - 1]);
				}
			}
		}
		return common[m][n];
	}

	// Time complexity is O(m*n).
	// Space complexity is O(m*n).
}
