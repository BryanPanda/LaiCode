package sortArrayWithTwoStacks;

import java.util.*;

// Sort an array with two stacks.

// Assumption: with duplicate elements, without duplicate elements?

public class SortArrayWithTwoStacks {

	private LinkedList<Integer> stack1;
	private LinkedList<Integer> stack2;

	public SortArrayWithTwoStacks() {
		stack1 = new LinkedList<Integer>();
		stack2 = new LinkedList<Integer>();
	}

	public int[] sort(int[] array) {
		if (array == null || array.length <= 1) {
			return array;
		}
		for (int i = 0; i < array.length; i++) {
			stack1.offerFirst(array[i]);
		}
		int count = 0;
		for (int i = array.length; i > 0; i -= count) {
			int min = stack1.peekFirst();
			for (int j = i; j > 0; j--) {
				if (stack1.peekFirst() < min) {
					min = stack1.peekFirst();
				}
				stack2.offerFirst(stack1.pollFirst());
			}
			count = 0;
			for (int j = i; j > 0; j--) {
				if (stack2.peekFirst() != min) {
					stack1.offerFirst(stack2.pollFirst());
				} else {
					stack2.pollFirst();
					count++;
				}
			}
			for (int k = 0; k < count; k++) {
				stack2.offerFirst(min);
			}
		}
		for (int i = array.length - 1; i >= 0; i--) {
			array[i] = stack2.pollFirst();
		}
		return array;
	}

	// Time complexity is O(n^2).
	// Space complexity is O(n).

	public static void main(String[] args) {
		SortArrayWithTwoStacks sortArrayWithTwoStacks = new SortArrayWithTwoStacks();
		int[] array = null;
		System.out.println(Arrays.toString(sortArrayWithTwoStacks.sort(array)));
		array = new int[] { 1 };
		System.out.println(Arrays.toString(sortArrayWithTwoStacks.sort(array)));
		array = new int[] { 3, 1 };
		System.out.println(Arrays.toString(sortArrayWithTwoStacks.sort(array)));
		array = new int[] { 2, 1, 3 };
		System.out.println(Arrays.toString(sortArrayWithTwoStacks.sort(array)));
		array = new int[] { 1, 4, 3, 2 };
		System.out.println(Arrays.toString(sortArrayWithTwoStacks.sort(array)));
		array = new int[] { 1, 5, 2, 4, 3 };
		System.out.println(Arrays.toString(sortArrayWithTwoStacks.sort(array)));
		array = new int[] { 3, 5, 2, 4, 1, 6 };
		System.out.println(Arrays.toString(sortArrayWithTwoStacks.sort(array)));
		array = new int[] { 3, 2, 1, 2, 3, 3, 4 };
		System.out.println(Arrays.toString(sortArrayWithTwoStacks.sort(array)));
		array = new int[] { 1, 1, 1, 5, 4, 3, 6, 2 };
		System.out.println(Arrays.toString(sortArrayWithTwoStacks.sort(array)));
		array = new int[] { 1, 3, 4, 4, 5, 5, 3, 1, 2 };
		System.out.println(Arrays.toString(sortArrayWithTwoStacks.sort(array)));
	}

}
