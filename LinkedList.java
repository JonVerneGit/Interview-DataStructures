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
	
}
