package topKFrequentWords;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// Given a composition with different kinds of words, return a list
// of the top K most frequent words in the composition.

// Assumption:
// 1. The composition is not null and is not guaranteed to be sorted
// 2. K >= 1 and K could be larger than the number of distinct words in the composition, 
// 	  in this case, just return all the distinct words

public class TopKFrequentWords {

	public String[] topKFrequent(String[] combo, int k) {
		Map<String, Integer> map = buildMap(combo);
		PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k,
				new Comparator<Map.Entry<String, Integer>>() {
					@Override
					public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
						return e1.getValue().compareTo(e2.getValue());
					}
				});
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (minHeap.size() < k) {
				minHeap.offer(entry);
			} else if (entry.getValue() > minHeap.peek().getValue()) {
				minHeap.poll();
				minHeap.offer(entry);
			}
		}
		String[] result = new String[minHeap.size()];
		for (int i = minHeap.size() - 1; i >= 0; i--) {
			result[i] = minHeap.poll().getKey();
		}
		return result;
	}

	private Map<String, Integer> buildMap(String[] combo) {
		Map<String, Integer> map = new HashMap<>();
		for (String s : combo) {
			Integer count = map.get(s);
			count = count == null ? 1 : count + 1;
			map.put(s, count);
		}
		return map;
	}

	// Time complexity is O(n + n*log(k) + k*log(k)).
	// Space complexity is O(n + k);
}
