package edu.ben.labs.lab6;

/**
 * 
 * @author ryanhassoun
 * @version 1.0
 *
 * @param <E>
 */
public class Node<E> {

	/**
	 * value
	 */
	private E value;

	/**
	 * pointer to the next node
	 */
	private Node<E> next;

	/**
	 * Node constructor
	 * 
	 * @param value
	 *            node
	 */
	public Node(E value) {

		this.value = value;
	}

	/**
	 * Gets value of the node
	 * 
	 * @return node
	 */
	public E getValue() {
		return value;
	}

	/**
	 * Sets the value of node
	 * 
	 * @param value
	 *            value
	 */
	public void setValue(E value) {
		this.value = value;
	}

	/**
	 * Gets the next node
	 * 
	 * @return the next node
	 */
	public Node<E> getNext() {
		return next;
	}

	/**
	 * Sets the next node
	 * 
	 * @param next
	 *            pointer
	 */
	public void setNext(Node<E> next) {
		this.next = next;
	}

}
