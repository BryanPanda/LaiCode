package rainbowSort2;

import java.util.*;

// Given an array of balls, where the color of the balls can only be Red, Green, Blue or Black, 
// sort the balls such that all balls with same color are grouped together, and from left to right 
// the order is Red->Green->Blue->Black. (Red is denoted by 0, Green is denoted by 1,  Blue is denoted by 2
// and Black is denoted by 3).

public class RainbowSort2 {

	public int[] sort(int[] array) {
		if (array == null || array.length <= 1) {
			return array;
		}
		// [0, a): 0
		// [a, b): 1
		// [b, c): 2
		// [c, d]: to be explored
		// (d, array.length - 1]: 3
		int a = 0, b = 0, c = 0;
		int d = array.length - 1;
		while (c <= d) {
			if (array[c] == 0) {
				swap(array, a++, c);
				if (a == b + 1) {
					b++;
					c++;
				}
			} else if (array[c] == 1) {
				swap(array, b++, c++);
			} else if (array[c] == 2) {
				c++;
			} else {
				swap(array, c, d--);
			}
		}
		return array;
	}
	
	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	// Time complexity is O(n).
	// Space complexity is O(1).
	
	public static void main(String[] args) {
		RainbowSort2 rainbowSort2 = new RainbowSort2();
		int[] array = null;
		System.out.println(Arrays.toString(rainbowSort2.sort(array)));
		
		array = new int[] { 2 };
		System.out.println(Arrays.toString(rainbowSort2.sort(array)));

		array = new int[] { 1, 0 };
		System.out.println(Arrays.toString(rainbowSort2.sort(array)));

		array = new int[] { 0, 3, 1, 2 };
		System.out.println(Arrays.toString(rainbowSort2.sort(array)));

		array = new int[] { 2, 2, 3, 1, 0, 3, 1, 1, 0, 2 };
		System.out.println(Arrays.toString(rainbowSort2.sort(array)));
	
		array = new int[] { 1, 3, 3, 3, 2, 2, 1, 1, 1, 0, 0, 1, 2, 3, 1, 0 };
		System.out.println(Arrays.toString(rainbowSort2.sort(array)));
	
		array = new int[] { 2, 0, 0, 1, 1 };
		System.out.println(Arrays.toString(rainbowSort2.sort(array)));
	}
			
}
