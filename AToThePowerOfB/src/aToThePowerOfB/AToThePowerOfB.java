package aToThePowerOfB;

public class AToThePowerOfB {

	public long power(int a, int b) {
		// Assumption: b >= 0
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
