package decodeWays;

// LeetCode #91 (Decode Ways).

// A message containing letters from A-Z is being encoded to numbers using the following ways:
// 'A' = 1, 'B = 2, ..., 'Z' = 26.
// Given an encoded message containing digits, determine the total number of ways to decode it.

public class DecodeWays {
	
	// M[i]: number of ways to decode substring [0, i]
	// M[i] = M[i - 2] + M[i - 1], if substring [i - 1, i] is in [1, 26]
	// M[i] = M[i - 1], otherwise
	public int numDecodeWay(String s) {
		int[] array = new int[s.length()];
		array[0] = s.charAt(0) == '0' ? 0 : 1;
		for (int i = 1; i < s.length(); i++) {
		    array[i] = (s.charAt(i) == '0') ? 0 : array[i - 1];
            int value = Integer.parseInt(s.substring(i - 1, i + 1));
			if (value >= 10 && value <= 26) { 
				array[i] += (i == 1) ? 1 : array[i - 2];
			}
		}
		return array[s.length() - 1];
	}
	
	// Time complexity is O(n).
	// Space complexity is O(n), but can obviously be optimized to O(1).
}
