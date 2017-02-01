package genericMaxHeap;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class GenericMaxHeap<Key> implements Iterable<Key> {
	private Key[] pq; // store items at indices 1 to N
	private int N; // number of items on priority queue
	private Comparator<Key> comparator; // optional Comparator

	public GenericMaxHeap(int initCapacity) {
		pq = (Key[]) new Object[initCapacity + 1];
		N = 0;
	}

	public GenericMaxHeap() {
		this(1);
	}

	public GenericMaxHeap(int initCapacity, Comparator<Key> comparator) {
		this.comparator = comparator;
		pq = (Key[]) new Object[initCapacity + 1];
		N = 0;
	}

	public GenericMaxHeap(Comparator<Key> comparator) {
		this(1, comparator);
	}

	public GenericMaxHeap(Key[] keys) {
		N = keys.length;
		pq = (Key[]) new Object[keys.length + 1];
		for (int i = 0; i < N; i++)
			pq[i + 1] = keys[i];
		for (int k = N / 2; k >= 1; k--)
			sink(k);
		assert isMaxHeap();
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public Key max() {
		if (isEmpty())
			throw new NoSuchElementException("Priority queue underflow");
		return pq[1];
	}

	// helper function to double the size of the heap array
	private void resize(int capacity) {
		assert capacity > N;
		Key[] temp = (Key[]) new Object[capacity];
		for (int i = 1; i <= N; i++) {
			temp[i] = pq[i];
		}
		pq = temp;
	}

	public void insert(Key x) {
		// double size of array if necessary
		if (N >= pq.length - 1)
			resize(2 * pq.length);
		// add x, and percolate it up to maintain heap invariant
		pq[++N] = x;
		swim(N);
		assert isMaxHeap();
	}

	public Key delMax() {
		if (isEmpty())
			throw new NoSuchElementException("Priority queue underflow");
		Key max = pq[1];
		exch(1, N--);
		sink(1);
		pq[N + 1] = null; // to avoid loiterig and help with garbage collection
		if ((N > 0) && (N == (pq.length - 1) / 4))
			resize(pq.length / 2);
		assert isMaxHeap();
		return max;
	}

	private void swim(int k) {
		while (k > 1 && less(k / 2, k)) {
			exch(k, k / 2);
			k = k / 2;
		}
	}

	private void sink(int k) {
		while (2 * k <= N) {
			int j = 2 * k;
			if (j < N && less(j, j + 1))
				j++;
			if (!less(k, j))
				break;
			exch(k, j);
			k = j;
		}
	}

	private boolean less(int i, int j) {
		if (comparator == null) {
			return ((Comparable<Key>) pq[i]).compareTo(pq[j]) < 0;
		} else {
			return comparator.compare(pq[i], pq[j]) < 0;
		}
	}

	private void exch(int i, int j) {
		Key swap = pq[i];
		pq[i] = pq[j];
		pq[j] = swap;
	}

	private boolean isMaxHeap() {
		return isMaxHeap(1);
	}

	private boolean isMaxHeap(int k) {
		if (k > N)
			return true;
		int left = 2 * k, right = 2 * k + 1;
		if (left <= N && less(k, left))
			return false;
		if (right <= N && less(k, right))
			return false;
		return isMaxHeap(left) && isMaxHeap(right);
	}

	public Iterator<Key> iterator() {
		return new HeapIterator();
	}

	private class HeapIterator implements Iterator<Key> {
		// create a new pq
		private GenericMaxHeap<Key> copy;

		// add all items to copy of heap
		// takes linear time since already in heap order so no keys move
		public HeapIterator() {
			if (comparator == null)
				copy = new GenericMaxHeap<Key>(size());
			else
				copy = new GenericMaxHeap<Key>(size(), comparator);
			for (int i = 1; i <= N; i++)
				copy.insert(pq[i]);
		}

		public boolean hasNext() {
			return !copy.isEmpty();
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

		public Key next() {
			if (!hasNext())
				throw new NoSuchElementException();
			return copy.delMax();
		}
	}

	public static void main(String[] args) {
		GenericMaxHeap<String> pq = new GenericMaxHeap<String>();
	}

}