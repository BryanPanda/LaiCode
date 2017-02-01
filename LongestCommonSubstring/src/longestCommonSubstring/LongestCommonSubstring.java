package longestCommonSubstring;

// Find the longest common substring of two given strings.

// Assumption: The two given strings are not null

public class LongestCommonSubstring {

	// M[i][j] represents length of the longest common substring of first i
	// letters of the first string, including the i-th letter, and first j
	// letters of the second string, including the j-th letter.
	public String longestCommon(String s, String t) {
		char[] sa = s.toCharArray();
		char[] ta = t.toCharArray();
		int start = 0;
		int length = 0;
		int[][] common = new int[sa.length][ta.length];
		for (int i = 0; i < sa.length; i++) {
			for (int j = 0; j < ta.length; j++) {
				if (sa[i] == ta[j]) {
					if (i == 0 || j == 0) {
						common[i][j] = 1;
					} else {
						common[i][j] = common[i - 1][j - 1] + 1;
					}
				}
				if (common[i][j] > length) {
					length = common[i][j];
					start = i - length + 1;
				}
			}
		}
		return s.substring(start, start + length);
	}

	// Time complexity is O(m * n).
	// Space complexity is O(m * n).

	public static void main(String[] args) {
		LongestCommonSubstring longestCommonSubstring = new LongestCommonSubstring();
		String s = "sweden", t = "student";
		System.out.println(longestCommonSubstring.longestCommon(s, t));
	}
}
