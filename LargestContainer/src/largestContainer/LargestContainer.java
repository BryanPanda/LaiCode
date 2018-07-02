package largestContainer;

// LeetCode #11 (Container with Most Water).

// Given an array of non-negative integers, each of them representing the height of a board 
// perpendicular to the horizontal line, the distance between any two adjacent boards is 1. 

// Consider selecting two boards such that together with the horizontal line they form a container. 

// Find the volume of the largest such container.

public class LargestContainer {

	public int largest(int[] array) {
		int maxVolume = 0;
		int leftMax = 0, rightMax = 0;
		int left = 0, right = array.length - 1;
		while (left < right) {
			leftMax = Math.max(leftMax, array[left]);
			rightMax = Math.max(rightMax, array[right]);
			maxVolume = Math.max(maxVolume, Math.min(rightMax, leftMax) * (right - left));
			if (array[left] < array[right]) {
				left++;
			} else {
				right--;
			}
		}
		return maxVolume;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
