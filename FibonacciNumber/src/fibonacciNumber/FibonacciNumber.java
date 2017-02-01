package fibonacciNumber;

// Get the Kth number in the Fibonacci Sequence. (K is 0-indexed, the 0th Fibonacci number
// is 0 and the 1st Fibonacci number is 1).

public class FibonacciNumber {

	// DP
	public long fibo(int k) {
		if (k <= 0) {
			return 0;
		}
		if (k == 1) {
			return 1;
		}
		// k >= 2
		long prev = 0, cur = 1, next = 1;
		for (int i = 2; i <= k; i++) {
			next = prev + cur;
			prev = cur;
			cur = next;
		}
		return next;
	}
	// Time complexity is O(k).

	// Recursion
	public long fibo2(int k) {
		if (k <= 0) {
			return 0;
		}
		if (k == 1) {
			return 1;
		}
		return fibo2(k - 2) + fibo2(k - 1);
	}
	// Time complexity is O(2^k).

	// Matrix multiplication
	// M = { {1, 1}, {1, 0} } = { {f(2), f(1)}, {f(1), f(0)} }
	public static final long[][] SEED = { { 1L, 1L }, { 1L, 0L } };

	public long fibo3(int k) {
		if (k <= 0) {
			return 0;
		}
		if (k == 1) {
			return 1;
		}
		long[][] matrix = { { 1L, 1L }, { 1L, 0L } };
		pow(matrix, k - 1);
		return matrix[0][0];
	}

	private void pow(long[][] matrix, int pow) {
		if (pow == 1) {
			return;
		}
		pow(matrix, pow / 2);
		multiply(matrix, matrix);
		if (pow % 2 != 0) {
			multiply(matrix, SEED);
		}
	}

	private void multiply(long[][] matrix, long[][] multiplier) {
		long topLeft = matrix[0][0] * multiplier[0][0] + matrix[0][1] * multiplier[1][0];
		long topRight = matrix[0][0] * multiplier[0][1] + matrix[0][1] * multiplier[1][1];
		long bottomLeft = matrix[1][0] * multiplier[0][0] + matrix[1][1] * multiplier[1][0];
		long bottomRight = matrix[1][0] * multiplier[0][1] + matrix[1][1] * multiplier[1][1];
		matrix[0][0] = topLeft;
		matrix[0][1] = topRight;
		matrix[1][0] = bottomLeft;
		matrix[1][1] = bottomRight;
	}
	// Time complexity is O(log(k)).
	// Space complexity is O(1).

	public static void main(String[] args) {
		FibonacciNumber fibonacciNumber = new FibonacciNumber();
		System.out.println(fibonacciNumber.fibo3(0));
		System.out.println(fibonacciNumber.fibo3(1));
		System.out.println(fibonacciNumber.fibo3(2));
		System.out.println(fibonacciNumber.fibo3(3));
		System.out.println(fibonacciNumber.fibo3(4));
		System.out.println(fibonacciNumber.fibo3(5));
		System.out.println(fibonacciNumber.fibo3(6));
		System.out.println(fibonacciNumber.fibo3(50));
	}
}
