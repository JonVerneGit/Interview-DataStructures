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
	
	/**
	 * Adds an object to the end of the list.
	 * @param obj the object to be added to the list.
	 */
	@Override
	public void addLast(E obj) {
		
		if (head == null){
			head = tail = new Node<E>(obj);
			currentSize++;
			return;
		}
		
		Node<E> tmpNode = new Node<E>(obj);
		tail.setNext(tmpNode);
		tail = tmpNode;
		currentSize++;
	}
	
	/**
	 * Removes the first Object in the list and returns it.
	 * Returns null if the list is empty.
	 * @return the object removed.
	 */
	@Override
	public E removeFirst() {
		
		E objectData; 	
		
		if(head == null){
			return null;
		}
		
		if(head == tail){
			objectData = head.data;
			head = tail = null;
			currentSize--;
			return objectData;
		}
		
		objectData = head.data;
		head = head.next;
		currentSize--;
		return objectData;
	}

	/**
	 * Removes the last Object in the list and returns it.
	 * Returns null if the list is empty.
	 * @return the object removed.
	 */
	@Override
	public E removeLast() {
		
		Node<E> current = head;
		Node<E> previous = null;
		
		if(isEmpty()){
			return null;
		}
		
		if(head == tail){
			return removeFirst();
		}
		
		while(current != tail){
			previous = current;
			current = current.next;
		}
		
		previous.next = null;
		tail = previous;
		currentSize--;
		return current.data;
	}
	
	/**
	 * Returns the first Object in the list, but does not remove it.
	 * Returns null if the list is empty.
	 * @return the object at the beginning of the list.
	 */
	@Override
	public E peekFirst() {
		
		while(head != null)
			return head.data;
		
		return null;
		
	}
	
	/**
	 * Returns the last Object in the list, but does not remove it. 
	 * Returns null if the list is empty.
	 * @return the object at the end of the list.
	 */
	@Override
	public E peekLast() {
		
		while(tail != null)
			return tail.data;
		
		return null;
	}

	/**
	 * Return the list to an empty state.
	 * This should generally be a constant time operation.
	 */
	@Override
	public void makeEmpty() {
		
		head = tail = null;
		currentSize = 0;
		
	}

	/**
	 * Test whether the list is empty.
	 * @return true if the list is empty, otherwise false
	 */
	@Override
	public boolean isEmpty() {
		
		return head == null;
	}

	/**
	 * Test whether the list is full.
	 * @return true if the list is full, otherwise false
	 */
	@Override
	public boolean isFull() {
		
		return false;
	}

	/**
	 * Returns the number of Objects currently in the list.
	 * @return the number of Objects currently in the list.
	 */
	@Override
	public int size() {
		
		return currentSize;
	}
	
	/**
	 * Test whether the list contains an object. This will use the object's
	 * compareTo method to determine whether two objects are the same.
	 * @param obj The object to look for in the list
	 * @return true if the object is found in the list, false if it is not found
	 */
	@Override
	public boolean contains(E obj) {
		
		Node<E> current = head;
		
		while(current != null){
			if(((Comparable<E>) obj) .compareTo(current.data) == 0)
				return true;
			
			current = current.next;
		}
		
		return false;
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
