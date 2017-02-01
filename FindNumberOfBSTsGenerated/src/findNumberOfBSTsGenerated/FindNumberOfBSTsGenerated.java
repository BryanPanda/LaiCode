package findNumberOfBSTsGenerated;

// Find the number of different Binary Search Trees generated from 1-n.

public class FindNumberOfBSTsGenerated {

	public int numOfTrees(int n) {
		if (n == 0) {
			return 1;
		}
		int[] array = new int[n + 1];
		array[1] = 1;
		for (int i = 2; i < n + 1; i++) {
			array[i] = array[i - 1] * 2;
			int left = 1, right = i - 2;
			while (left < right) {
				array[i] += array[left++] * array[right--] * 2;
			}
			if (left == right) {
				array[i] += array[left] * array[right];
			}
		}
		return array[n];
	}

	// Time complexity is O(n^2).
	// Space complexity is O(n).

	// With little research, mathematically this is called Catalan number,
	// Cn = (2n)!/(n+1)!*n!
	public int numOfTrees2(int n) {
		return binomialCoefficient(2 * n, n) / (n + 1);
	}

	private int binomialCoefficient(int n, int k) {
		int result = 1;
		// C(n, k) = C(n, n - k)
		if (k > n - k) {
			k = n - k;
		}
		for (int i = 0; i < k; i++) {
			result *= (n - i);
			result /= (i + 1);
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).

	public static void main(String[] args) {
		FindNumberOfBSTsGenerated findNumberOfBSTsGenerated = new FindNumberOfBSTsGenerated();
		System.out.println(findNumberOfBSTsGenerated.numOfTrees2(5));
	}
}
