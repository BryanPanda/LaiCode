package fourSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Determine if there exists a set of four elements in a given array that sum to the given target number.

// Assumption: The given array is not null and has length of at least 4

public class FourSum {

	// Solution 1: Sort + ThreeSum, O(n^3)
	public boolean exist(int[] array, int target) {
		Arrays.sort(array);
		for (int i = 0; i < array.length - 3; i++) {
			for (int j = i + 1; j < array.length - 2; j++) {
				int left = j + 1, right = array.length - 1;
				int curTarget = target - array[i] - array[j];
				while (left < right) {
					int sum = array[left] + array[right];
					if (sum == curTarget) {
						return true;
					} else if (sum < curTarget) {
						left++;
					} else {
						right--;
					}
				}
			}
		}
		return false;
	}

	// Time complexity is O(n^3).
	// Space complexity is O(1).

	// Solution 2:contruct all possible pairs, and run TwoSum
	static class Element implements Comparable<Element> {
		int left;
		int right;
		int sum;

		Element(int left, int right, int sum) {
			this.left = left;
			this.right = right;
			this.sum = sum;
		}

		// order of Element is first by sum, then by right, the by left
		@Override
		public int compareTo(Element another) {
			if (this.sum != another.sum) {
				return this.sum < another.sum ? -1 : 1;
			} else if (this.right != another.right) {
				return this.right < another.right ? -1 : 1;
			} else if (this.left != another.left) {
				return this.left < another.left ? -1 : 1;
			}
			return 0;
		}

		@Override
		public String toString() {
			return "l: " + this.left + ", r: " + this.right + ", sum: " + this.sum;
		}
	}

	public boolean exist2(int[] array, int target) {
		Arrays.sort(array);
		Element[] pairs = getAllPairs(array);
		Arrays.sort(pairs);
		int left = 0, right = pairs.length - 1;
		// run TwoSum
		while (left < right) {
			// need to guarantee that no elements appears more than once
			if (pairs[left].sum + pairs[right].sum == target && pairs[left].right < pairs[right].left) {
				return true;
			} else if (pairs[left].sum + pairs[right].sum < target) {
				left++;
			} else {
				right--;
			}
		}
		return false;
	}

	private Element[] getAllPairs(int[] array) {
		Element[] pairs = new Element[array.length * (array.length - 1) / 2];
		int cur = 0;
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				pairs[cur++] = new Element(j, i, array[j] + array[i]);
			}
		}
		return pairs;
	}

	// Time complexity is O(n^2 * log(n^2)) = O(n^2 * log(n)), because
	// Arrays.sort() uses Merge Sort for non-primitive types
	// Space complexity is O(n^2).

	static class Pair {
		int left;
		int right;

		Pair(int left, int right) {
			this.left = left;
			this.right = right;
		}
	}

	// Solution 3:
	public boolean exist3(int[] array, int target) {
		Map<Integer, Pair> map = new HashMap<>();
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				int sum = array[j] + array[i];
				if (map.containsKey(target - sum) && map.get(target - sum).right < j) {
					return true;
				}
				// otherwise, we need to insert, but for the same sum, only the
				// pair with the smallest right index is needed
				if (!map.containsKey(sum)) {
					map.put(sum, new Pair(j, i));
				}
			}
		}
		return false;
	}

	// Time complexity is O(n^2).
	// Space complexity is O(n^2).

	public static void main(String[] args) {
		FourSum fourSum = new FourSum();
		int[] array = new int[] { 3, 1, 6, 2, 5, 9, 4 };
		System.out.println(fourSum.exist2(array, 9));
	}

}
