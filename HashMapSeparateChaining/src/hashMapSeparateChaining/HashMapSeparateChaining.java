package hashMapSeparateChaining;

import java.util.Arrays;

public class HashMapSeparateChaining<K, V> {

	// entry class
	public static class Node<K, V> {
		final K key;
		V value;
		Node<K, V> next;

		Node(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public K getKey() {
			return this.key;
		}

		public void setValue(V value) {
			this.value = value;
		}
	}

	private static final int DEFAULT_CAPACITY = 16;
	private static final float DEFAULT_LOAD_FACTOR = 0.75f;

	private Node<K, V>[] array;
	private int size;
	private float loadFactor;

	public HashMapSeparateChaining() {
		this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
	}

	public HashMapSeparateChaining(int capacity, float loadFactor) {
		if (capacity <= 0) {
			throw new IllegalArgumentException("Capacity can not be less than or equal to 0");
		}
		this.array = (Node<K, V>[]) new Node[capacity];
		this.size = 0;
		this.loadFactor = loadFactor;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void clear() {
		Arrays.fill(this.array, null);
		size = 0;
	}

	// non-negative hash value
	private int hash(K key) {
		if (key == null) {
			return 0;
		}
		return key.hashCode() & 0X7FFFFFFF;
		// 1. int code = key.hashCode();
		// return code >= 0 ? code : -code;
		// might result in overflow if code equals Integer.MIN_VALUE
		// 2. in Java, % returns remainder, instead of modulus,
		// and remainder could be negative
	}

	private int getIndex(K key) {
		return hash(key) % array.length;
	}

	private boolean equalsValue(V v1, V v2) {
		return (v1 == v2) || (v1 != null && v1.equals(v2));
	}

	// time complexity is O(n)
	public boolean containsValue(V value) {
		if (isEmpty()) {
			return false;
		}
		for (Node<K, V> node : array) {
			while (node != null) {
				if (equalsValue(node.value, value)) {
					return true;
				}
				node = node.next;
			}
		}
		return false;
	}

	private boolean equalsKey(K k1, K k2) {
		return (k1 == k2) || (k1 != null && k1.equals(k2));
	}

	public boolean containsKey(K key) {
		int index = getIndex(key);
		Node<K, V> node = array[index];
		while (node != null) {
			if (equalsKey(node.key, key)) {
				return true;
			}
			node = node.next;
		}
		return false;
	}

	// if key does NOT exist in the HashMap, return null
	public V get(K key) {
		int index = getIndex(key);
		Node<K, V> node = array[index];
		while (node != null) {
			if (equalsKey(node.key, key)) {
				return node.value;
			}
			node = node.next;
		}
		return null;
	}

	// here we allow value to be null
	// in some text books, they delete the key-value pair, when value is null
	public V put(K key, V value) {
		int index = getIndex(key);
		Node<K, V> head = array[index];
		Node<K, V> node = head;
		while (node != null) {
			if (equalsKey(node.key, key)) {
				V result = node.value;
				node.value = value;
				return result;
			}
			node = node.next;
		}
		// up to this point, key does NOT exist in the HashMap
		// insert to the head of this bucket, and update the head
		Node<K, V> newNode = new Node(key, value);
		newNode.next = head;
		array[index] = newNode;
		size++;
		if (needRehash()) {
			rehash();
		}
		return null;
	}

	private boolean needRehash() {
		float ratio = (size + 0.0f) / array.length;
		return ratio >= loadFactor;
	}

	private void rehash() {
		HashMapSeparateChaining<K, V> temp = new HashMapSeparateChaining<K, V>(array.length * 2, loadFactor);
		for (Node<K, V> node : array) {
			while (node != null) {
				temp.put(node.key, node.value);
				node = node.next;
			}
		}
		this.array = temp.array;
		// this.size does NOT change, this.loadFactor does NOT change
		// this.size = temp.size;
		// this.loadFactor = temp.loadFactor;
	}

	public V remove(K key) {
		int index = getIndex(key);
		Node<K, V> node = array[index];
		// delete operation on a linked-list
		if (node == null) { // key does NOT exist in this HashMap
			return null;
		}
		if (equalsKey(node.key, key)) {
			array[index] = node.next;
			node.next = null; // to be garbage collected
			size--;
			return node.value;
		}
		Node<K, V> prev = node;
		node = node.next;
		while (node != null) {
			if (equalsKey(node.key, key)) {
				prev.next = node.next;
				node.next = null; // to be garbage collected
				size--;
				return node.value;
			}
			prev = node;
			node = node.next;
		}
		// key does NOT exist in this HashMap
		return null;
	}
}
