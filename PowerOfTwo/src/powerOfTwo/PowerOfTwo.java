package powerOfTwo;

// Determine if a given integer is power of 2.

public class PowerOfTwo {

	// solution 1
	public boolean isPowerOfTwo(int number) {
		if (number <= 0) {
			return false;
		}
		// ignore all trailing 0's
		while ((number & 1) == 0) {
			number >>>= 1;
		}
		return number == 1;
	}

	// solution 2
	public boolean isPowerOfTwo2(int number) {
		if (number <= 0) {
			return false;
		}
		int count = 0;
		while (number > 0) {
			count += number & 1;
			number >>>= 1;
		}
		return count == 1;
	}

	// solution 3
	public boolean isPowerOfTwo3(int number) {
		return number > 0 && (number & (number - 1)) == 0;
	}

}
