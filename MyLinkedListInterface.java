package edu.ben.labs.lab6;

import java.util.ArrayList;
/**
 * 
 * @author ryanhassoun
 * @version 1.0
 *
 * @param <E>
 */
interface MyLinkedListInterface<E> {

	/**
	 * Returns the head value
	 * 
	 * @return head
	 */
	Node<E> getHead();

	/**
	 * Adds a node to the linkedlist
	 * 
	 * @param value
	 *            the value of the node
	 */
	void add(E value);

	/**
	 * Adds an array of values to the end of a linkedlist as nodes
	 * 
	 * @param values
	 *            the array of values
	 */
	void addAll(E[] values);

	/**
	 * Adds a node to the beginning of the linkedlist
	 * 
	 * @param value
	 *            the value of the node
	 */
	void addFirst(E value);

	/**
	 * Adds a node to the end of the linkedlist
	 * 
	 * @param value
	 *            the value of the node
	 */
	void addLast(E value);

	/**
	 * Checks if the LinkedList is empty
	 * 
	 * @return true if the list is empty, false if it is not
	 */
	boolean isEmpty();

	/**
	 * Returns the value of the head
	 * 
	 * @return the value of the head
	 */
	E peek();

	/**
	 * Clears the linkedlist erasing any nodes
	 */
	void clear();

	/**
	 * Gets the first value of the first node
	 * 
	 * @return the value of the first node
	 */
	E getFirst();

	/**
	 * Get the last value of the last node
	 * 
	 * @return the last value of the last node
	 */
	E getLast();

	/**
	 * Removes the first node in the list
	 * 
	 * @return the first node
	 */
	E remove();

	/**
	 * Removes a certain node of the remove
	 * 
	 * @param value
	 *            the value of the node to be removed
	 * @return true if the value was found and node was removed, false if not
	 */
	boolean remove(E value);

	/**
	 * Removes the last node in the linkedlist
	 * 
	 * @return the node that was rmoved
	 */
	E removeLast();

	/**
	 * Gets the size of the of the linkedlist
	 * 
	 * @return the size of the linkedlist
	 */
	int getSize();

	/**
	 * Converts the linkedlist to an array representation
	 * 
	 * @return the linkedlist in array form
	 */
	ArrayList<E> toArray();

	@Override
	String toString();


}
