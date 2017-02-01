package numberOfDifferentBits;

// Determine the number of bits that are different for two given integers.

public class NumberOfDifferentBits {

	public int diffBits(int a, int b) {
		a ^= b;
		int count = 0;
		while (a != 0) {
			count += a & 1;
			a >>>= 1;
		}
		return count;
	}
}
