package data_structures;

import java.util.Iterator;

/**
 * The Hash data structure has O(1) time complexity (best case) for add, remove, and find
 * for an object in the data structure. The methods in the Hash data structure are defined
 * by the HashI interface. The Hash consists of an array of Linked Lists,
 * the Linked Lists are defined by the HashListI interface.
 * 
 * @author Jonathan Verne
 *
 * @param <K> The key for entries in the hash
 * @param <V> The value for entries in the hash
 */

public class Hash<K, V> implements HashI<K, V> {

	int tableSize;
	int numElements;
	LinkedList<HashElement<K,V>> [] hash_array;
	double maxLoadFactor;
  
	/**
	 * Constructor for the hash table.
	 * @param tableSize
	 */
	public Hash(int tableSize){
		this.tableSize = tableSize;
		hash_array = (LinkedList<HashElement<K,V>>[]) new LinkedList[tableSize];
		for(int i = 0; i < tableSize; i++){
			hash_array[i] = new LinkedList<HashElement<K,V>>();
		}
		maxLoadFactor = 0.75;
		numElements = 0;
	}
	
	/**
	 * Returns the number of key/value pairs currently stored in the dictionary 
	 * @return int number of elements
	 */
	@Override
	public int size() {
		
		return numElements;
	}

	/**
	 * Returns true if the dictionary is empty
	 *  
	 * @return whether the dictionary is empty
	 */
	@Override
	public boolean isEmpty() {
		if(numElements == 0)
			return true;
		return false;
	}

	/**
	 * Makes the hash table empty
	 */
	@Override
	public void makeEmpty() {
		for(int i =0 ; i < tableSize; i++){
			hash_array[i].makeEmpty();
		}
		numElements=0;
	}

	/**
	 * returns the load factor for the hash table
	 */
	@Override
	public double loadFactor() {
		
		return numElements/tableSize;
	}

	/**
	 * returns the maximum load factor
	 */
	@Override
	public double getMaxLoadFactor() {
		
		return maxLoadFactor;
	}

	/**
	 * sets the max load factor for the table
	 * 
	 * @param new load factor
	 */
	@Override
	public void setMaxLoadFActor(double loadfactor) {
		
		maxLoadFactor = loadfactor;
		
	}

	
	 /**  
	 * Adds the given key/value pair to the dictionary.  Returns 
	 * false if the dictionary is full, or if the key is a duplicate. 
	 * Returns true if addition succeeded. 
	 *  
	 * @param key the key to add
	 * @param value the value associated with the key
	 * @return true if the key/value are added to the hash.
	 */
	@Override
	public boolean add(K key, V value) {
		if(loadFactor() > maxLoadFactor)
			resize(tableSize*2);
		HashElement<K,V> he = new HashElement<>(key,value);
		int hashVal = key.hashCode();
		hashVal = hashVal & 0x7fffffff;
		hashVal = hashVal % tableSize;
		hash_array[hashVal].add(he);
		numElements++;
		return true;
	}
	
	/**
	 * Deletes the key/value pair identified by the key parameter. 
	 * Returns true if the key/value pair was found and removed, 
	 * otherwise returns false.
	 *  
	 * @param key
	 * @return boolean
	 */
	@Override
	public boolean remove(K key) {
		
		int hashVal = key.hashCode();
		hashVal = hashVal & 0x7fffffff;
		hashVal = hashVal % tableSize;
		for(HashElement<K,V> he : hash_array[hashVal]){
			if(((Comparable<K>)he.key).compareTo(key) == 0){
				hash_array[hashVal].remove(he);
				numElements--;
				return true;
			}	
		}	
			return false;	
	}
	
	/**
	 * Change the value associated with an existing key.
	 * Returns true if the value was successfully changed,
	 * otherwise returns false.
	 * 
	 * @param key The key to change
	 * @param value
	 * @return boolean
	 */
	@Override
	public boolean changeValue(K key, V value) {
		
		int hashVal = key.hashCode();
		hashVal = hashVal & 0x7fffffff;
		hashVal = hashVal % tableSize;
		for(HashElement<K,V> he : hash_array[hashVal]){
			if(((Comparable<K>)he.key).compareTo(key) == 0){
				he.value = value;
				return true;
			}
		}	
		return false;
	}
	
	/**
	 * Test whether the hash has the entry associated with the key. 
	 * True if the key is there and false otherwise.
	 * 
	 * @param key the key to look for
	 * @return boolean
	 */
	@Override
	public boolean contains(K key) {
		int hashVal = key.hashCode();
		hashVal = hashVal & 0x7fffffff;
		hashVal = hashVal % tableSize;
		if(hash_array[hashVal].isEmpty())
			return false;
		return true;
	}
	
	/**
	 * Returns the value associated with the parameter key. 
	 * Returns null if the key is not found or the dictionary is empty. 
	 * 
	 * @param key the key to find the value for
	 * @return the value
	 */
	@Override
	public V getValue(K key) {
		int hashVal = key.hashCode();
		hashVal = hashVal & 0x7fffffff;
		hashVal = hashVal % tableSize;
		for(HashElement<K,V> he : hash_array[hashVal]){
			if(((Comparable<K>)he.key).compareTo(key) == 0)
				return he.value;
		}
			return null;
	}
	
	/**
	 * Resizes the hash table
	 */
	@Override
	public void resize(int newSize) {
		
		LinkedList<HashElement<K,V>> [] new_array = (LinkedList<HashElement<K,V>> []) new LinkedList[newSize];
		
		for(int i=0;i<newSize;i++)
			new_array[i] = new LinkedList<HashElement<K,V>>();
		for(K key : this){
			V val = getValue(key);
			HashElement<K,V> he = new HashElement<>(key,val);
			int hashval = (key.hashCode() & 0x7fffffff) % newSize;
			new_array[hashval].add(he);
		}
		hash_array = new_array;
		tableSize = newSize;
	}
	
	/**
	 * The Hash Element class provides methods to create a new Hash Element
	 * to be added to the Hash Table. It also includes a CompareTo in order
	 * to compare two hash elements.
	 * @author Jonathan Verne
	 *
	 * @param <K> The key for the hash element
	 * @param <V> The value for the hash element
	 */
	class HashElement<K, V> implements Comparable<HashElement<K,V>>{
		K key;
		V value;
		
		/**
		 * Constructor for the Hash Element. Sets the key and value.
		 * @param key
		 * @param value
		 */
		public HashElement(K key,V value){
			this.key = key;
			this.value = value;
		}
		
		/**
		 * Compares two hash elements.
		 */
		public int compareTo(HashElement<K,V> o){
			return (((Comparable<K>)o.key).compareTo(this.key));
		}
	}
	
	/**
	 * Iterates through the hash table
	 */
	@Override
	public Iterator<K> iterator() {
		return new IteratorHelper();
	}
	
	/**
	 * The Iterator Helper class provides methods to iterate through
	 * the hash table and all of the chained Linked Lists.
	 * @author Jonathan Verne
	 *
	 * @param <T>
	 */
	class IteratorHelper<T> implements Iterator<T>{
		T[] keys;
		int position;
		
		/**
		 * Constructor for the Iterator Helper
		 */
		public IteratorHelper(){
			keys = (T[]) new Object[numElements];
			int p = 0;
			for(int i = 0; i < tableSize; i++){
				LinkedList<HashElement<K,V>> list = hash_array[i];
				for(HashElement<K,V> h : list)
					keys[p++] = (T) h.key;
			}
			position = 0;
		}
		
		/**
		 * returns true if there is another element in the table
		 */
		public boolean hasNext(){
			return position < keys.length;
		}
		
		/**
		 * Iterates to the next element in the table
		 */
		public T next(){
			if(!hasNext())
				return null;
			return keys[position++];
		}
	}

  }
