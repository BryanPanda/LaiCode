package rainbowSort3;

import java.util.Arrays;

// Given an array of balls with k different colors denoted by numbers 1 to k, sort the balls.

public class RainbowSort3 {

	public int[] sort(int[] array, int k) {
		if (array == null || array.length <= 1) {
			return array;
		}
		int[] indices = new int[k];
		indices[k - 1] = array.length - 1;
		while (indices[k - 2] <= indices[k - 1]) {
			boolean flag = false; // indicating whether the if statement below evaluates to true
			for (int i = 1; i <= k - 2; i++) {
				if (array[indices[k - 2]] == i) {
					flag = true;
					swap(array, indices[i - 1]++, indices[k - 2]);
					for (int j = i + 1; j <= k - 1; j++) {
						if (indices[j - 1] < indices[i - 1]) {
							indices[j - 1] = indices[i - 1];
						}
					}
					break;
				}
			}
			if (!flag && indices[k - 2] < array.length && array[indices[k - 2]] == k - 1) {
				indices[k - 2]++;
			} else if (!flag && indices[k - 2] < array.length && array[indices[k - 2]] == k) {
				swap(array, indices[k - 2], indices[k - 1]--);
			}
		}
		return array;
	}
	
	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	// Time complexity is O(n*k).
	// Space complexity is O(1).
	
	public static void main(String[] args) {
		RainbowSort3 rainbowSort3 = new RainbowSort3();
		int[] array = new int[] { 1 };
		System.out.println(Arrays.toString(rainbowSort3.sort(array, 1)));

		array = new int[] { 1, 6, 2, 1, 2 };
		System.out.println(Arrays.toString(rainbowSort3.sort(array, 6)));

		array = new int[] { 3, 1, 5, 5, 1, 4, 2 };
		System.out.println(Arrays.toString(rainbowSort3.sort(array, 5)));

		array = new int[] { 3, 3, 4, 2, 1, 4, 2, 2, 1, 3 };
		System.out.println(Arrays.toString(rainbowSort3.sort(array, 4)));
	
		array = new int[] { 2, 4, 4, 4, 3, 3, 2, 2, 2, 1, 1, 2, 3, 4, 2, 1 };
		System.out.println(Arrays.toString(rainbowSort3.sort(array, 4)));
	
		array = new int[] { 3, 1, 1, 2, 2 };
		System.out.println(Arrays.toString(rainbowSort3.sort(array, 3)));
		
		array = new int[] { 1, 3 };
		System.out.println(Arrays.toString(rainbowSort3.sort(array, 5)));
		
		array = new int[] { 5, 2, 2 };
		System.out.println(Arrays.toString(rainbowSort3.sort(array, 5)));
	}
}
