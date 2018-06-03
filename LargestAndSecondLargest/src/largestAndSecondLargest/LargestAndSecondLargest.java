package largestAndSecondLargest;

import java.util.ArrayList;
import java.util.List;

// Use the least number of comparisons to get the largest and 2nd largest number in the given integer array. 
// Return the largest number and 2nd largest number.

public class LargestAndSecondLargest {

	static class Element {
		int value;
		List<Integer> comparedValues;

		Element(int value) {
			this.value = value;
			this.comparedValues = new ArrayList<>();
		}
	}

	public int[] largestAndSecond(int[] array) {
		Element[] helper = convert(array);
		int largerLength = array.length;
		while (largerLength > 1) {
			compareAndSwap(helper, largerLength);
			largerLength = (largerLength + 1) / 2;
		}
		return new int[] { helper[0].value, largest(helper[0].comparedValues) };
	}

	private Element[] convert(int[] array) {
		Element[] helper = new Element[array.length];
		for (int i = 0; i < array.length; i++) {
			helper[i] = new Element(array[i]);
		}
		return helper;
	}

	private void compareAndSwap(Element[] helper, int largerLength) {
		for (int i = 0; i < largerLength / 2; i++) {
			if (helper[i].value < helper[largerLength - 1 - i].value) {
				swap(helper, i, largerLength - 1 - i);
			}
			helper[i].comparedValues.add(helper[largerLength - 1 - i].value);
		}
	}

	private void swap(Element[] helper, int left, int right) {
		Element temp = helper[left];
		helper[left] = helper[right];
		helper[right] = temp;
	}

	private int largest(List<Integer> list) {
		int max = Integer.MIN_VALUE;
		for (int num : list) {
			max = Math.max(max, num);
		}
		return max;
	}

	// The number of comparison is O(n).
	
	// Time complexity is O(log(n)).
	// Space complexity is O(n).
}
