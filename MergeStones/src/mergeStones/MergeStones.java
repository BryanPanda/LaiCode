package mergeStones;

// We have a list of piles of stones, each pile of stones has a certain weight, 
// represented by an array of integers. In each move, we can merge two adjacent
// piles into one larger pile, the cost is the sum of the weights of the two piles. 
// We merge the piles of stones until we have only one pile left. 
// Determine the minimum total cost.

// Assumptions: 
// 1. stone is not null, stones.length >= 1

public class MergeStones {

	public int minCost(int[] stones) {
		int length = stones.length;
		int[][] minCost = new int[length][length];
		int[][] subSum = new int[length][length];
		for (int i = 0; i < length; i++) {
			for (int j = i; j >= 0; j--) {
				if (i == j) {
					subSum[j][i] = stones[i];
					minCost[j][i] = 0;
				} else {
					subSum[j][i] = subSum[j][i - 1] + stones[i];
					minCost[j][i] = Integer.MAX_VALUE;
					for (int k = j; k < i; k++) {
						minCost[j][i] = Math.min(minCost[j][i], minCost[j][k] + minCost[k + 1][i] + subSum[j][i]);
					}
				}
			}
		}
		return minCost[0][length - 1];
	}

	// Time complexity is O(n^3).
	// Space complexity is O(n^2).
}
