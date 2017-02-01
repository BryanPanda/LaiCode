package majorityNumber3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Given an integer array of length L, find all numbers that occur more than 1/K * L times if any exist.

// Assumption:
// 1. The given array is not null or empty
// 2. K >= 2

public class MajorityNumber3 {

	// Solution 1: sort the array
	// O(n * log(n)) time, O(1) space.

	// Solution 2: hash map
	// O(n) time, O(n) space.

	public List<Integer> majority(int[] array, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			if (map.containsKey(array[i])) {
				map.put(array[i], map.get(array[i]) + 1);
			} else {
				if (map.size() < k) {
					map.put(array[i], 1);
				} else { // avoid ConcurrentModificationException
					// to iterate, use Iterator, instead of
					// Map.Entry<Integer, Integer> entry : map.entrySet(),
					Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
					while (it.hasNext()) {
						Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>) it.next();
						int count = entry.getValue();
						if (count == 1) {
							// to remove, use it.remove(), instead of
							// map.remove(entry.getKey());
							it.remove();
						} else {
							// to update, use entry.setValue(count - 1), instead
							// of map.put(entry.getKey(), count - 1)
							entry.setValue(count - 1);
						}
					}
				}
			}
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			map.put(entry.getKey(), 0);
		}
		for (int i = 0; i < array.length; i++) {
			Integer count = map.get(array[i]);
			if (count != null) {
				map.put(array[i], count + 1);
			}
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > array.length / k) {
				result.add(entry.getKey());
			}
		}
		return result;
	}

	// Time complexity is O(n * k).
	// Space complexity is O(k);

	public static void main(String[] args) {
		MajorityNumber3 majorityNumber3 = new MajorityNumber3();
		int[] array = new int[] { 1, 2, 2, 3, 1, 3, 2, 2, 1, 2, 2, 2, 2, 2 };
		System.out.println(majorityNumber3.majority(array, 2).toString());
	}

}
