package queueByTwoStacks;

import java.util.LinkedList;

// LeetCode #232 (Implement Queue Using Stacks).

// Implement a queue by using two stacks. The queue should provide size(), isEmpty(), offer(), poll()
// and peek() operations. When the queue is empty, poll() and peek() should return null.

public class QueueByTwoStacks {

	private LinkedList<Integer> input;
	private LinkedList<Integer> output;

	public QueueByTwoStacks() {
		input = new LinkedList<>();
		output = new LinkedList<>();
	}

	public Integer poll() {
		if (isEmpty()) {
			return null;
		}
		if (output.isEmpty()) {
			while (!input.isEmpty()) {
				output.offerFirst(input.pollFirst());
			}
		}
		return output.pollFirst();
	}

	// Time complexity is O(n) in the worst case, but is O(1) amortized time.

	public void offer(int element) {
		input.offerFirst(element);
	}

	// Time complexity is O(1).

	public Integer peek() {
		if (isEmpty()) {
			return null;
		}
		if (output.isEmpty()) {
			while (!input.isEmpty()) {
				output.offerFirst(input.pollFirst());
			}
		}
		return output.peekFirst();
	}

	// Time complexity is O(n) in the worst case, but is O(1) amortized time.

	public int size() {
		return input.size() + output.size();
	}

	// Time complexity is O(1).

	public boolean isEmpty() {
		return input.size() == 0 && output.size() == 0;
	}

	// Time complexity is O(1).
}
