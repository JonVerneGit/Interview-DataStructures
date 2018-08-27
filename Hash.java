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
  }
