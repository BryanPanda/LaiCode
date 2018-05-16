package commonNumbersOfTwoArrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


// LeetCode #349 (Intersection of Two Arrays).

// Find all numbers that appear in both of the two unsorted arrays, 
// return the common numbers in increasing order.

// Assumption: There are no duplicate numbers in each of the two arrays respectively.

public class CommonNumbersOfTwoArrays {

	public List<Integer> common(List<Integer> a, List<Integer> b) {
		Set<Integer> set = new HashSet<>();
		set.addAll(a);
		set.retainAll(b);
		return new ArrayList<Integer>(set);
	}
	
	// Time complexity is O(m + n).
	// Space complexity is O(max(m, n)).
}
