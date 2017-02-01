package hashMapLinearProbing;

public class HashMapLinearProbing<K, V> {

	private static final int DEFAULT_CAPACITY = 4;
	private static final float DEFAULT_LOAD_FACTOR = 0.75f;
	private int size;
	private float loadFactor;
	private K[] keys;
	private V[] values;

	public HashMapLinearProbing() {
		this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
	}

	public HashMapLinearProbing(int capacity, float loadFactor) {
		if (capacity <= 0) {
			throw new IllegalArgumentException("Capacity can not be less than or equal to 0");
		}
		this.size = 0;
		this.loadFactor = loadFactor;
		this.keys = (K[]) new Object[capacity];
		this.values = (V[]) new Object[capacity];
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void clear() {
		this.size = 0;
		this.keys = (K[]) new Object[keys.length];
		this.values = (V[]) new Object[values.length];
	}

	// non-negative hash value
	private int hash(K key) {
		// in separate chaining hash table, if K key is null, it is always
		// mapped to bucket 0, but bucket 0 can have other key-value pairs
		// in linear probing, we don't allow key or value to be null
		return key.hashCode() & 0X7FFFFFFF;
		// 1. int code = key.hashCode();
		// return code >= 0 ? code : -code;
		// might result in overflow if code equals Integer.MIN_VALUE
		// 2. in Java, % returns remainder, instead of modulus,
		// and remainder could be negative
	}

	private int getIndex(K key) {
		return hash(key) % keys.length;
	}

	private boolean equalsValue(V v1, V v2) {
		return (v1 == v2) || (v1 != null && v1.equals(v2));
	}

	// have to iterate over all values: time complexity is O(n)
	public boolean containsValue(V value) {
		if (isEmpty() || value == null) {
			return false;
		}
		for (V v : values) {
			if (equalsValue(v, value)) {
				return true;
			}
		}
		return false;
	}

	private boolean equalsKey(K k1, K k2) {
		return (k1 == k2) || (k1 != null && k1.equals(k2));
	}

	public boolean containsKey(K key) {
		if (key == null) {
			return false;
		}
		for (int index = getIndex(key); keys[index] != null; index = (index + 1) % keys.length) {
			if (equalsKey(keys[index], key)) {
				return true;
			}
		}
		return false;
	}

	public V get(K key) {
		if (key == null) {
			return null;
		}
		for (int index = getIndex(key); keys[index] != null; index = (index + 1) % keys.length) {
			if (equalsKey(keys[index], key)) {
				return values[index];
			}
		}
		return null;
	}

	// here we allow value to be null
	// in some text books, they delete the key-value pair, when value is null
	public V put(K key, V value) {
		if (key == null) {
			return null;
		}
		if (value == null) {
			V result = remove(key);
			return result;
		}
		int index;
		for (index = getIndex(key); keys[index] != null; index = (index + 1) % keys.length) {
			if (equalsKey(keys[index], key)) {
				V result = values[index];
				values[index] = value;
				return result;
			}
		}
		// up to this point, keys[index] == null, key doesn't exist in the hash
		// map
		keys[index] = key;
		values[index] = value;
		size++;
		if (needRehash()) {
			rehash();
		}
		return null;
	}

	private boolean needRehash() {
		float ratio = (size + 0.0f) / keys.length;
		return ratio >= loadFactor;
	}

	private void rehash() {
		HashMapLinearProbing<K, V> temp = new HashMapLinearProbing<K, V>(keys.length * 2, loadFactor);
		for (int i = 0; i < keys.length; i++) {
			// put to temp, as long as key and value are not both null
			if (keys[i] != null) {
				// then value != null in this implementation for sure
				temp.put(keys[i], values[i]);
			}
		}
		this.keys = (K[]) temp.keys;
		this.values = (V[]) temp.values;
		// this.size does NOT change, this.loadFactor does NOT change
		// this.size = temp.size;
		// this.loadFactor = temp.loadFactor;
	}

	public V remove(K key) {
		if (key == null) {
			return null;
		}
		for (int index = getIndex(key); keys[index] != null; index = (index + 1) % keys.length) {
			if (equalsKey(keys[index], key)) {
				V result = values[index];
				keys[index] = null;
				values[index] = null;
				size--;
				// NOTE: need to rehash entries after the deleted entry
				for (index = index + 1; keys[index] != null; index = (index + 1) % keys.length) {
					K keyToRehash = keys[index];
					V valueToRehash = values[index];
					keys[index] = null;
					values[index] = null;
					size--;
					put(keyToRehash, valueToRehash);
				}
				return result;
			}
		}
		// key doesn't exist in hash map
		return null;
	}
}
