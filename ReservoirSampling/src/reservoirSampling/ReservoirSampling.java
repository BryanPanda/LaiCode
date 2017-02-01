package reservoirSampling;

// Consider an unlimited flow of data elements. How do you sample one element from this flow, 
// such that at any point during the processing of the flow, you can return a random element
// from the n elements read so far.

// You will implement two methods for a sampling class:
// 1. read(int value) - read one number from the flow
// 2. sample() - return at any time the sample, if n values have been read, the probability
//    of returning any one of the n values is 1/n, return null(Java)/INT_MIN(C++) if there is
//    no value read so far

public class ReservoirSampling {

	private int count; // number of integers that have been read so far
	private Integer sample;

	public ReservoirSampling() {
		this.count = 0;
		this.sample = null;
	}

	public void read(int value) {
		count++;
		int prob = (int) (Math.random() * count);
		if (prob == 0) {
			sample = value;
		}
	}

	public Integer sample() {
		return sample;
	}
}
