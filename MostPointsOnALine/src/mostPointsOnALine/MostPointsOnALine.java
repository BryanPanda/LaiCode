package mostPointsOnALine;

import java.util.HashMap;
import java.util.Map;

// Given an array of 2D coordinates of points (all the coordinates are integers), 
// find the largest number of points that can be crossed by a single line in 2D space. 

// Assumption: The given array is not null and it has at least 2 points

public class MostPointsOnALine {

	public int most(Point[] points) {
		int result = 0;
		for (int i = 0; i < points.length; i++) {
			Point seed = points[i];
			int same = 1;
			int sameX = 0;
			int most = 0;
			Map<Double, Integer> count = new HashMap<>();
			for (int j = 0; j < points.length; j++) {
				if (i == j) {
					continue;
				}
				Point temp = points[j];
				if (temp.x == seed.x && temp.y == seed.y) {
					same++;
				} else if (temp.x == seed.x) {
					sameX++;
				} else {
					double slope = ((temp.y - seed.y) + 0.0) / (temp.x - seed.x);
					if (!count.containsKey(slope)) {
						count.put(slope, 1);
					} else {
						count.put(slope, count.get(slope) + 1);
					}
					most = Math.max(most, count.get(slope));
				}
			}
			most = Math.max(most, sameX) + same;
			result = Math.max(result, most);
		}
		return result;
	}

	// Time complexity is O(n^2).
	// Space complexity is O(n^2).
}
