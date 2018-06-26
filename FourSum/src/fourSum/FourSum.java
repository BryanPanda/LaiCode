package fourSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Determine if there exists a set of four elements in a given array that sum to the 
// given target number.

// Assumption: The given array is not null and has length of at least 4.

// Solutions:
// 0. Sort + Three Sum: Time complexity is O(n^3), space complexity is O(n * log(n)), 
//    because of quick sort (for primitive types).
// 1. Construct all pairs + Two Sum (sort + two pointers): Time complexity is 
//    O(n^2 * log(n^2)) = O(n^2 * log(n)), space complexity is O(n^2), because of merge
//    sort (for non-primitive types).
// 2. Construct all pairs + Two Sum (with hash map): Time complexity is O(n^2), space 
//    complexity is O(n^2).

public class FourSum {

	// Solution 1
	static class Element implements Comparable<Element> {
		int left;
		int right;
		int sum;

		Element(int left, int right, int sum) {
			this.left = left;
			this.right = right;
			this.sum = sum;
		}

		// Order Element first by sum, then by right, then by left.
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
	}

	public boolean exist(int[] array, int target) {
		Arrays.sort(array); // important (?)
		Element[] pairs = constructAllPairs(array);
		Arrays.sort(pairs);
		int left = 0, right = pairs.length - 1;
		while (left < right) {
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

	private Element[] constructAllPairs(int[] array) {
		Element[] pairs = new Element[array.length * (array.length - 1) / 2];
		int cur = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				pairs[cur++] = new Element(i, j, array[i] + array[j]);
			}
		}
		return pairs;
	}

	// Time complexity is O(n^2 * log(n)).
	// Space complexity is O(n^2).

	// Solution 2
	public boolean exist2(int[] array, int target) {
		Map<Integer, Element> map = new HashMap<>();
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				int sum = array[j] + array[i];
				if (map.containsKey(target - sum) && map.get(target - sum).right < j) {
					return true;
				}
				// If sum does not exist in map, put it into map, otherwise keep the current
				// one since it has the smaller right index. (?)
				if (!map.containsKey(sum)) {
					map.put(sum, new Element(j, i, sum));
				}
			}
		}
		return false;
	}

	// Time complexity is O(n^2).
	// Space complexity is O(n^2).
}
