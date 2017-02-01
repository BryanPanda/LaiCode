package maxWaterTrapped;

// Given a non-negative integer array representing the heights of a list of adjacent bars. 
// Suppose each bar has a width of 1. Find the largest amount of water that can be trapped in the histogram.

// Assumption: The given array is not null

public class MaxWaterTrapped {

	// Solution 1
	public int maxTrapped(int[] array) {
		int result = 0;
		for (int i = 0; i < array.length; i++) {
			int maxLeft = 0, maxRight = 0;
			for (int j = i - 1; j >= 0; j--) {
				maxLeft = Math.max(maxLeft, array[j]);
			}
			for (int k = i + 1; k < array.length; k++) {
				maxRight = Math.max(maxRight, array[k]);
			}
			result += (Math.min(maxLeft, maxRight) - array[i] < 0) ? 0 : Math.min(maxLeft, maxRight) - array[i];
		}
		return result;
	}

	// Time complexity is O(n^2).
	// Space complexity is O(1).

	// Solution 2
	// M1[i]: largest value from index 0 to i, inclusive
	// M2[i]: largest value from index n-1 to i, inclusive
	public int maxTrapped2(int[] array) {
		int result = 0;
		int[] left = new int[array.length];
		int[] right = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			left[i] = (i == 0 || array[i] > left[i - 1]) ? array[i] : left[i - 1];
		}
		for (int j = array.length - 1; j >= 0; j--) {
			right[j] = (j == array.length - 1 || array[j] > right[j + 1]) ? array[j] : right[j + 1];
		}
		for (int i = 0; i < array.length; i++) {
			result += (Math.min(left[i], right[i]) - array[i] < 0) ? 0 : Math.min(left[i], right[i]) - array[i];
		}
		return result;
	}

	// Time Complexity is O(n).
	// Space complexity is O(n)

	// Solution 3
	public int maxTrapped3(int[] array) {
		if (array.length == 0) {
			return 0;
		}
		int left = 0;
		int right = array.length - 1;
		int result = 0;
		int leftMax = array[left];
		int rightMax = array[right];
		while (left < right) {
			if (array[left] <= array[right]) {
				result += Math.max(0, leftMax - array[left]);
				leftMax = Math.max(leftMax, array[left]);
				left++;
			} else {
				result += Math.max(0, rightMax - array[right]);
				rightMax = Math.max(rightMax, array[right]);
				right--;
			}
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).

	public static void main(String[] args) {
		MaxWaterTrapped maxWaterTrapped = new MaxWaterTrapped();
		int[] array = new int[] { 1, 3, 2, 4, 1, 3, 2, 4, 3, 2 };
		System.out.println(maxWaterTrapped.maxTrapped3(array));
	}
}
