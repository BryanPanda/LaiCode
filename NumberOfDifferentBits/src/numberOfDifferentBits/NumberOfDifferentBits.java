package numberOfDifferentBits;

// Determine the number of bits that are different for two given integers.

public class NumberOfDifferentBits {

	public int diffBits(int a, int b) {
		int c = a ^ b;
		int count = 0;
		while (c != 0) {
			count += c & 1;
			c >>>= 1;
		}
		return count;
	}
	
}
