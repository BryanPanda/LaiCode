package encodeSpace;

// In URL encoding, whenever we see an space " ", we need to replace it with "20%". 
// Provide a method that performs this encoding for a given string.

// Example: "google/q?flo wer market" → "google/q?flo20%wer20%market"

public class EncodeSpace {

	public String encode(String input) {
		StringBuilder sb = new StringBuilder();
		for (char c : input.toCharArray()) {
			sb.append(c == ' ' ? "20%" : c);
		}
		return sb.toString();
	}
	
	// Time complexity is O(n).
	// Space complexity is O(1).
}
