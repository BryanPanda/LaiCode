package minimumCutsForPalindromes;

import java.util.Arrays;

// Given a string, a partitioning of the string is a palindrome partitioning if 
// every substring of the partition is a palindrome. 
// Determine the fewest cuts needed for a palindrome partitioning of a given string.

// Assumption: The given string is not null

public class MinimumCutsForPalindromes {

	// solution 1
	// minCuts[i]: min cuts needed for palindrome partitioning of substring from
	// index 0 to i
	public int minCuts(String input) {
		if (input.length() == 0) {
			return 0;
		}
		int[] minCuts = new int[input.length()];
		Arrays.fill(minCuts, Integer.MAX_VALUE);
		minCuts[0] = 0;
		for (int i = 1; i < input.length(); i++) {
			if (isPalindrome(input, 0, i)) {
				minCuts[i] = 0;
			}
			for (int j = 0; j < i; j++) {
				if (isPalindrome(input, j + 1, i)) {
					minCuts[i] = Math.min(minCuts[i], minCuts[j] + 1);
				}
			}
		}
		return minCuts[minCuts.length - 1];
	}

	private boolean isPalindrome(String input, int left, int right) {
		while (left < right) {
			if (input.charAt(left) != input.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	// Time complexity is O(n^3).
	// Space complexity is O(n).

	// solution 2
	// minCuts[i]: min cuts needed for palindrome partitioning of substring from
	// index 0 to i, inclusive
	// isPalindrome[i][j]: whether substring from index i to j, inclusive, is a
	// palindrome
	public int minCuts2(String input) {
		if (input.length() == 0) {
			return 0;
		}
		boolean[][] isPalindrome = new boolean[input.length()][input.length()];
		int[] minCuts = new int[input.length()];
		for (int i = 1; i < input.length(); i++) {
			minCuts[i] = i;
			for (int j = 0; j <= i; j++) {
				if (input.charAt(j) == input.charAt(i)) {
					isPalindrome[j][i] = (i - j < 2) || isPalindrome[j + 1][i - 1];
				}
				if (isPalindrome[j][i]) {
					minCuts[i] = j == 0 ? 0 : Math.min(minCuts[i], minCuts[j - 1] + 1);
				}
			}
		}
		return minCuts[minCuts.length - 1];
	}

	// Time complexity is O(n^2).
	// Space complexity is O(n^2).

	public static void main(String[] args) {
		MinimumCutsForPalindromes minimumCutsForPalindromes = new MinimumCutsForPalindromes();
		System.out.println(minimumCutsForPalindromes.minCuts2("aaaaaabbabb"));
	}
}
