package hexadecimalRepresentation;

// LeetCode #405 (Convert a Number to Hexadecimal).

// Generate the hexadecimal representation for a given non-negative integer number as a string. 
// The hex representation should start with "0x".
// There should not be extra zeros on the left side.

public class HexadecimalRepresentation {

	public String hex(int number) {
		String prefix = "0x";
		if (number == 0) {
			return prefix + "0";
		}
		StringBuilder sb = new StringBuilder();
		while (number > 0) {
			int cur = number % 16; // if number could be negative, then int cur = number & 15
			if (cur < 10) {
				sb.append((char) ('0' + cur));
			} else {
				sb.append((char) (cur - 10 + 'A'));
			}
			number >>>= 4;
		}
		return prefix + sb.reverse().toString();
	}
	
}
