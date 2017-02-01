package ninetyFivePercentile;

import java.util.List;

// Given a list of integers representing the lengths of urls, 
// find the 95 percentile of all lengths (95% of the urls have lengths <= returned length).

// Assumptions:
// 1. The maximum length of valid url is 4096
// 2. The list is not null, is not empty, and does not contain null

public class NinetyFivePercentile {

	public int percentile95(List<Integer> lengths) {
		int maxLength = 4096;
		int[] count = new int[maxLength + 1];
		for (int length : lengths) {
			count[length]++;
		}
		int sum = 0, result = maxLength + 1;
		while (sum <= lengths.size() * 0.05) {
			sum += count[--result];
		}
		return result;
	}
}
