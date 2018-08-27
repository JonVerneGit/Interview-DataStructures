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
