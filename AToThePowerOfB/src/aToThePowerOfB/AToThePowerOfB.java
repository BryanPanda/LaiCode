package aToThePowerOfB;

// Evaluate a to the power of b, assuming both a and b are integers and b is non-negative. 

public class AToThePowerOfB {

	public long power(int a, int b) {
		if (b == 0) {
			return 1;
		}
		if (a == 0) {
			return 0;
		}
		long half = power(a, b / 2);
		return b % 2 == 0 ? half * half : half * half * a;
	}

	// Time complexity is O(log(b)).
	// Space complexity is O(log(b)).
}
