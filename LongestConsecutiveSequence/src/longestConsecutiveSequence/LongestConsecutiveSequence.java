package longestConsecutiveSequence;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// LeetCode #128 (Longest Consecutive Sequence).

// Given an unsorted array of integers, find the length of the longest consecutive
// elements sequence.

public class LongestConsecutiveSequence {

	public int longestConsecutive(int[] nums) {
		Arrays.sort(nums);
		int cur = 0, max = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i == 0 || nums[i] - nums[i - 1] == 1) {
				cur = cur + 1;
			} else if (nums[i] == nums[i - 1]) {
				continue;
			} else {
				cur = 1;
			}
			max = Math.max(max, cur);
		}
		return max;
	}
	
	// Arrays.sort() uses quick sort for primitives, and merge sort for objects.
	
	// Time complexity is O(n*log(n)) in the average case.
	// Space complexity is O(log(n)) in the average case.
	
	public int longestConsecutive2(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			set.add(num);
		}
		int max = 0;
		for (int num : nums) {
			int cur = 1;
			// to the left
			int temp = num;
			while (set.contains(--temp)) {
				cur++;
				set.remove(temp);
			}
			// to the right
			temp = num;
			while (set.contains(++temp)) {
				cur++;
				set.remove(temp);
			}
			max = Math.max(max, cur);
		}
		return max;
	}
	
	// Time complexity is O(n).
	// Space complexity is O(n).
}
