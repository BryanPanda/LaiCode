package allIfBlocks;

import java.util.ArrayList;
import java.util.List;

// Given an integer n, return a list of Strings, each representing 
// one possibility of if blocks.

public class AllIfBlocks {

	public List<String> allIfBlocks(int n) {
		char[] array = new char[n * 2];
		List<String> result = new ArrayList<String>();
		helper(array, n, n, 0, result);
		return result;
	}

	private void helper(char[] array, int left, int right, int position, List<String> result) {
		if (position == array.length && left == 0 && right == 0) {
			addToResult(array, 0, result);
			return;
		}
		if (left > 0) {
			array[position] = '{';
			helper(array, left - 1, right, position + 1, result);
		}
		if (right > left) {
			array[position] = '}';
			helper(array, left, right - 1, position + 1, result);
		}
	}

	private void addToResult(char[] array, int space, List<String> result) {
		String s = "";
		for (int i = 0; i < array.length; i++) {
			if (array[i] == '{') {
				for (int j = 0; j < space; j++) {
					s += " ";
				}
				s += "if {\n";
				space += 2;
			} else {
				space -= 2;
				for (int j = 0; j < space; j++) {
					s += " ";
				}
				s += "}\n";
			}
		}
		result.add(s);
	}

	// Time complexity is O(2^(2*n)) * O(n^3), because string concatenation
	// takes linear time in string's length, this is a not so tight upper bound.
	// Space complexity is O(n).

	public List<String> allIfBlocks2(int n) {
		if (n <= 0) {
			return new ArrayList<String>();
		}
		List<String> blocks = new ArrayList<>();
		List<String> result = new ArrayList<>();
		helper2(blocks, n, n, result);
		return result;
	}

	private void helper2(List<String> blocks, int left, int right, List<String> result) {
		if (left == 0 && right == 0) {
			addToResult(blocks, result);
			return;
		}
		StringBuilder sb = new StringBuilder();
		if (left > 0) {
			for (int i = 0; i < right - left; i++) {
				sb.append("  ");
			}
			blocks.add(sb.append("if {").toString());
			helper2(blocks, left - 1, right, result);
			blocks.remove(blocks.size() - 1);
		}
		sb.setLength(0);
		if (right > left) {
			for (int i = 0; i < right - left - 1; i++) {
				sb.append("  ");
			}
			blocks.add(sb.append("}").toString());
			helper2(blocks, left, right - 1, result);
			blocks.remove(blocks.size() - 1);
		}
	}

	private void addToResult(List<String> blocks, List<String> result) {
		String str = "";
		for (String s : blocks) {
			str += s + "\n";
		}
		result.add(str);
	}

	// Time complexity is O(2^(2*n)) * O(n^2).
	// Space complexity is O(n).

	public static void main(String[] args) {
		AllIfBlocks allIfBlocks = new AllIfBlocks();
		List<String> result = allIfBlocks.allIfBlocks2(3);
		for (String s : result) {
			System.out.println(s);
		}
	}

	// If array is used, usually needs position/level to keep track of current
	// level of tree, and don't need to remove.
	// If List/StringBuilder is used, position/level is not needed (use size of
	// List/StringBuilder), but need to remove.
}
