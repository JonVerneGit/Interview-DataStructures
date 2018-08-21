package data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class is designed to provide a functioning implementation 
 * of the ListI interface. The LinkedList class provides all the 
 * capabilities to construct and operate on a linked list data
 * structure.
 * 
 * @author Jonathan Verne
 *
 * @param <E>
 */

public class LinkedList<E> implements ListI<E> {

  	private static int currentSize;
	private Node<E> head;
	private Node<E> tail;
	
	/**
	 * Adds an object to the beginning of the list.
	 * @param obj the object to be added to the list.
	 */
	@Override
	public void addFirst(E obj) {
		
		if (head == null){
			head = tail = new Node<E>(obj);
			currentSize++;
			return;
		}
		
		Node<E> tmpNode = new Node<E>(obj);
		tmpNode.setNext(head);
		head = tmpNode;
		currentSize++;
	}
	
	 /* Class creates Node objects for a Linked List.
	 * Methods include those to store and retrieve successive 
	 * objects along with generic type data.
	 * @author Jonathan Verne
	 *
	 * @param <E>
	 */
	class Node<E>{
		
		E data;
		Node<E> next;
		
		public Node(E obj){
			data = obj;
			next = null;
		}
		
		public Node(E newData, Node<E> newValue){
			next = newValue;
			data = newData;
		}
		
		public Object getData(){
			return data;
		}
		
		public Node<E> getNext(){
			return next;
		}
		
		public void setNext(Node<E> newValue){
			next = newValue;
		}
	}

}
