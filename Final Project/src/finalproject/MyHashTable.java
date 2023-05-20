package finalproject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;




public class MyHashTable<K,V> implements Iterable<MyPair<K,V>>{
	// num of entries to the table
	private int size;
	// num of buckets
	private int capacity = 16;
	// load factor needed to check for rehashing
	private static final double MAX_LOAD_FACTOR = 0.75;
	// ArrayList of buckets. Each bucket is a LinkedList of HashPair
	private ArrayList<LinkedList<MyPair<K,V>>> buckets;


	// constructors
	public MyHashTable() {

		this.size = 0;
		this.capacity = 16;
		this.buckets = new ArrayList<LinkedList<MyPair<K,V>>>();

		for (int i = 0; i < this.capacity; i++) {
			buckets.add(i, new LinkedList<MyPair<K,V>>());
		}

	}

	public MyHashTable(int initialCapacity) {

		this.size = 0;
		this.capacity = initialCapacity;
		this.buckets = new ArrayList<LinkedList<MyPair<K,V>>>();

		for (int i = 0; i < this.capacity; i++) {
			buckets.add(i, new LinkedList<MyPair<K,V>>());
		}

	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public int numBuckets() {
		return this.capacity;
	}

	/**
	 * Returns the buckets variable. Useful for testing  purposes.
	 */
	public ArrayList<LinkedList< MyPair<K,V> > > getBuckets(){
		return this.buckets;
	}

	/**
	 * Given a key, return the bucket position for the key.
	 */
	public int hashFunction(K key) {
		int hashValue = Math.abs(key.hashCode())%this.capacity;
		return hashValue;
	}

	/**
	 * Takes a key and a value as input and adds the corresponding HashPair
	 * to this HashTable. Expected average run time  O(1)
	 */
	public V put(K key, V value) {
		//  ADD YOUR CODE BELOW HERE
		int hash = hashFunction(key);
		if (!keyExists(key)) {
			MyPair<K,V> pair = new MyPair<>(key, value);
			buckets.get(hash).add(pair);
			size++;
			if (shouldRehash()) rehash();
			return get(key); // Could also return value, but in this way we can do error checking like "if (put(key,value)!=value) thr	I(	"Unexpected result from function");"
		} else {
			for (int i = 0; i < buckets.get(hash).size(); i++) {
				if (buckets.get(hash).get(i) == key) {
					V oldValue = buckets.get(hash).get(i).getValue();
					buckets.get(hash).get(i).setValue(value);
					size++;
					if (shouldRehash()) rehash();
					return oldValue;
				}
			}
		}

		size++;
		if (shouldRehash()) rehash();

		return null;
		//  ADD YOUR CODE ABOVE HERE
	}

	private boolean shouldRehash() {
		return ((double) size)/capacity > MAX_LOAD_FACTOR;
	}

	private boolean keyExists(K key) {
		int hash = hashFunction(key);

		for (int i = 0; i < buckets.get(hash).size(); i++) { // As long as we have a good hash function and max load factor, each bucket can be considered of constant size, so this functions runs in constant time (O(1))
			if (buckets.get(hash).get(i).equals(key)) return true;
		}

		return false;
	}


	/**
	 * Get the value corresponding to key. Expected average runtime O(1)
	 */
	public V get(K key) {

		int hash = hashFunction(key);

		for (int i = 0; i < buckets.get(hash).size(); i++) {
			if (buckets.get(hash).get(i).getKey().equals(key)) return buckets.get(hash).get(i).getValue();
		}

		return null;

	}

	/**
	 * Remove the HashPair corresponding to key . Expected average runtime O(1)
	 */
	public V remove(K key) {

		int hash = hashFunction(key);

		for (int i = 0; i < buckets.get(hash).size(); i++) {
			if (buckets.get(hash).get(i) == key) {
				V oldValue = buckets.get(hash).get(i).getValue();
				buckets.get(hash).remove(i);
				return oldValue;
			}
		}

		return null;

	}


	/**
	 * Method to double the size of the hashtable if load factor increases
	 * beyond MAX_LOAD_FACTOR.
	 * Made public for ease of testing.
	 * Expected average runtime is O(m), where m is the number of buckets
	 */
	public void rehash() {
		ArrayList<LinkedList<MyPair<K,V>>> newBuckets = new ArrayList<>();

		capacity *= 2;

		for (int i = 0; i < capacity; i++) {
			newBuckets.add(i, new LinkedList<>());
		}

		MyPair<K,V> currentPair;
		int currentHash;

		for (int i = 0; i < buckets.size(); i++) {
			for (int j = 0; j < buckets.get(i).size(); j++){
				currentPair = buckets.get(i).get(j);
				currentHash = hashFunction(currentPair.getKey());

				newBuckets.get(currentHash).add(currentPair);

			}
		}

		buckets = newBuckets;
	}


	/**
	 * Return a list of all the keys present in this hashtable.
	 * Expected average runtime is O(m), where m is the number of buckets
	 */
	public ArrayList<K> getKeySet() {

		ArrayList<K> keyList = new ArrayList<K>();

		for (int i = 0; i < buckets.size(); i++) {
			for (int j =  0; j < buckets.get(i).size(); j++) {
				keyList.add(buckets.get(i).get(j).getKey());
			}
		}
		return keyList;
	}


	// TODO make a function that removes duplicates from a list in O(n) = O(m)
	private <T> ArrayList<T> removeDuplicates(ArrayList<T> oldList) { // TODO unsure of creation of type parameter syntax

		ArrayList<T> newList = new ArrayList<T>();
		return null;

	}

	/**
	 * Returns an ArrayList of unique values present in this hashtable.
	 * Expected average runtime is O(m) where m is the number of buckets
	 * //TODO The issue here is with only returning UNIQUEEE values
	 */
	public ArrayList<V> getValueSet() {
		ArrayList<V> output = new ArrayList<>();
		for(LinkedList<MyPair<K,V>> bucket : this.buckets){
			if(bucket.size()!=0){
				for(MyPair<K,V> pair : bucket){
					if(!output.contains(pair.getValue())){
						output.add(pair.getValue());
					}
				}
			}
		}
		return output;
	}


	/**
	 * Returns an ArrayList of all the key-value pairs present in this hashtable.
	 * Expected average runtime is O(m) where m is the number of buckets
	 */
	public ArrayList<MyPair<K, V>> getEntries() {
		ArrayList<MyPair<K,V>> entryList = new ArrayList<MyPair<K,V>>();

		for (int i = 0; i < buckets.size(); i++) {
			for (int j =  0; j < buckets.get(i).size(); i++) {
				entryList.add(buckets.get(i).get(j));
			}
		}
		return entryList;
	}


	@Override
	public MyHashIterator iterator() {
		return new MyHashIterator();
	}


	private class MyHashIterator implements Iterator<MyPair<K,V>> {


		private Iterator <MyPair<K,V>> pair;

		private MyHashIterator() {
			pair = getEntries().iterator();
		}

		@Override
		public boolean hasNext() {
			return(pair.hasNext());
		}

		@Override
		public MyPair<K,V> next() {
			if(hasNext()) return pair.next();
			return null;
		}

	}

}
