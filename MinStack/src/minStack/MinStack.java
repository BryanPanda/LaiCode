package minStack;

import java.util.LinkedList;

// LeetCode #155 (Min Stack).

public class MinStack {

	private LinkedList<Integer> stack;
	private LinkedList<Integer> min;

	public MinStack() {
		stack = new LinkedList<Integer>();
		min = new LinkedList<Integer>();
	}

	public int pop() {
		if (stack.isEmpty()) {
			return -1;
		}
		min.pollFirst();
		return stack.pollFirst();
	}

	// Time complexity is O(1).

	public void push(int element) {
		stack.offerFirst(element);
		min.offerFirst(
			(min.isEmpty() || min.peekFirst() > element) 
			? element 
			: min.peekFirst());
	}

	// Time complexity is O(1).

	public int top() {
		if (stack.isEmpty()) {
			return -1;
		}
		return stack.peekFirst();
	}

	// Time complexity is O(1).

	public int min() {
		if (min.isEmpty()) {
			return -1;
		}
		return min.peekFirst();
	}

	// Time complexity is O(1).
}
