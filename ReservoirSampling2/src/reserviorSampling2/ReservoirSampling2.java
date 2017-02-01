package reserviorSampling2;

import java.util.ArrayList;
import java.util.List;

// Consider an unlimited flow of data elements. How do you sample k element from this flow, such that at any point during the processing of the flow, 
// you can return a random set of k elements from the n elements read so far. 

// You will implement two methods for a sampling class:
// 1. read(int value) - read one number from the flow
// 2. sample() - return at any time the k samples as a list, return the list of all values read when the number of values read so fas <= k.

// Assumption: k >= 1

public class ReservoirSampling2 {

	private final int k;
	private int count;
	private List<Integer> sample;

	public ReservoirSampling2(int k) {
		if (k <= 0) {
			throw new IllegalArgumentException("k must be greater than 0");
		}
		this.k = k;
		this.count = 0;
		this.sample = new ArrayList<>();
	}

	public void read(int value) {
		count++;
		if (count <= k) {
			sample.add(value);
		} else {
			int random = (int) (Math.random() * count);
			if (random < k) {
				sample.set(random, value);
			}
		}
	}

	public List<Integer> sample() {
		return sample;
	}
}
