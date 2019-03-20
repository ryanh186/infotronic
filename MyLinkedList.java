package edu.ben.labs.lab6;

import java.util.ArrayList;

/**
 * Implements the methods in the MyListLinkedInterface
 * 
 * @author ryanhassoun
 * @version 1.0
 * 
 * @param <E>
 *            the type of the data
 */
public class MyLinkedList<E> implements MyLinkedListInterface<E> {

	/**
	 * The head of the list initialized to null
	 */
	private Node<E> head = new Node<E>(null);

	/**
	 * A pointer pointing to the previous node
	 */
	private Node<E> previous;

	/**
	 * A pointer pointing to the current value initialized to the head
	 */
	private Node<E> current = head;

	/**
	 * Holds the size of the linkedlist
	 */
	private int size = 0;

	/**
	 * Returns the head value
	 * 
	 * @return head
	 */
	@Override
	public Node<E> getHead() {
		return head;
	}

	/**
	 * Adds a node to the linkedlist
	 * 
	 * @param value
	 *            the value of the node
	 */
	@Override
	public void add(E value) {

		if (head.getValue() == null) {

			head.setValue(value);
		} else {

			current.setNext(new Node<E>(value));
			previous = current;
			current = current.getNext();
		}

		size++;
	}

	/**
	 * Adds an array of values to the end of a linkedlist as nodes
	 * 
	 * @param values
	 *            the array of values
	 */
	@Override
	public void addAll(E[] values) {

		for (int i = 0; i < values.length; i++) {

			if (head.getValue() == null) {
				head.setValue(values[i]);
			} else {

				current.setNext(new Node<E>(values[i]));
				previous = current;
				current = current.getNext();
			}
		}

		size += values.length;

	}

	/**
	 * Adds a node to the beginning of the linkedlist
	 * 
	 * @param value
	 *            the value of the node
	 */
	@Override
	public void addFirst(E value) {

		Node<E> temp = new Node<E>(value);
		temp.setNext(head);
		head = temp;
		size++;
	}

	/**
	 * Adds a node to the end of the linkedlist
	 * 
	 * @param value
	 *            the value of the node
	 */
	@Override
	public void addLast(E value) {

		if (head.getValue() == null) {
			head.setValue(value);
		} else {
			Node<E> temp = new Node<E>(value);
			current.setNext(temp);
			previous = current;
			current = current.getNext();
		}
		size++;
	}

	/**
	 * Checks if the LinkedList is empty
	 * 
	 * @return true if the list is empty, false if it is not
	 */
	@Override
	public boolean isEmpty() {

		return size == 0;
	}

	/**
	 * Returns the value of the head
	 * 
	 * @return the value of the head
	 */
	@Override
	public E peek() {

		return head.getValue();
	}

	/**
	 * Clears the linkedlist erasing any nodes
	 */
	@Override
	public void clear() {

		head.setNext(null);
		head.setValue(null);
		previous = null;
		current = head;
		size = 0;
	}

	/**
	 * Gets the first value of the first node
	 * 
	 * @return the value of the first node
	 */
	@Override
	public E getFirst() {

		return head.getValue();
	}

	/**
	 * Get the last value of the last node
	 * 
	 * @return the last value of the last node
	 */
	@Override
	public E getLast() {

		return current.getValue();
	}

	/**
	 * Removes the first node in the list
	 * 
	 * @return the first node
	 */
	@Override
	public E remove() {

		if (head.getValue() != null) {
			size--;
		}

		E temp = head.getValue();

		if (head.getNext() == null) {
			head.setValue(null);
		} else {
			head = head.getNext();
		}

		return temp;
	}

	/**
	 * Removes a certain node of the remove
	 * 
	 * @param value
	 *            the value of the node to be removed
	 * @return true if the value was found and node was removed, false if not
	 */
	@Override
	public boolean remove(E value) {

		boolean found = false;

		if (getFirst() != null && getFirst().equals(value)) {

			remove();
			found = true;

		} else if (getLast() != null && getLast().equals(value)) {

			removeLast();
			found = true;

		} else {

			current = head;
			previous = null;
			while (current.getNext() != null) {

				if (current.getValue().equals(value)) {

					previous.setNext(current.getNext());
					found = true;
					size--;
				}

				previous = current;
				current = current.getNext();
			}

		}
		return found;
	}

	/**
	 * Removes the last node in the linkedlist
	 * 
	 * @return the node that was rmoved
	 */
	@Override
	public E removeLast() {

		Node<E> temp = current;

		if (size == 1) {

			temp.setValue(remove());
			size--;
		} else {

			previous.setNext(null);
			current = previous;

			Node<E> point = head;

			while (point != null && point.getNext() != previous) {

				point = point.getNext();
			}

			previous = point;

			size--;

		}
		return temp.getValue();
	}

	/**
	 * Gets the size of the of the linkedlist
	 * 
	 * @return the size of the linkedlist
	 */
	@Override
	public int getSize() {

		return size;
	}

	/**
	 * Converts the linkedlist to an array representation
	 * 
	 * @return the linkedlist in array form
	 */
	@Override
	public ArrayList<E> toArray() {
		ArrayList<E> o = new ArrayList<E>(getSize());

		previous = null;
		current = head;

		for (int i = 0; i < getSize(); i++) {

			o.add(current.getValue());

			if (current.getNext() != null) {
				previous = current;
				current = current.getNext();
			}
		}

		//Object[] a = o.toArray();

		return toArray();
	}


	/**
	 * Gets a string representation of the linkedlist
	 * 
	 * @return a string representing the linkedlist
	 */
	public String toString() {

		String toString = "List = [";

		previous = null;
		current = head;

		for (int i = 0; i < getSize(); i++) {

			toString += current.getValue();

			if (current.getNext() != null) {
				previous = current;
				current = current.getNext();
				toString += ", ";
			}

		}

		toString += "]";

		return toString;
	}

}
