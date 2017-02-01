package minStack;

import java.util.*;

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
		if (min.isEmpty()) {
			min.offerFirst(element);
		} else {
			min.offerFirst(Math.min(min.peekFirst(), element));
		}
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
