package edu.ben.labs.lab5;

/**
 * 
 * @author ryanhassoun
 * @version 3.0
 */
public class MyQueue {

	/**
	 * first index
	 */
	private int firstIndex = 0;
	/**
	 * last index
	 */
	private int lastIndex = 0;
	/**
	 * Cargo list
	 */
	private Cargo[] list = new Cargo[100];

	/**
	 * list of integers
	 * 
	 * @return Integer list.
	 */
	public Cargo[] getList() {
		return list;
	}

	/**
	 * Sets the queue's list
	 * 
	 * @param list
	 *            list
	 */
	public void setList(Cargo[] list) {
		this.list = list;
	}

	/**
	 * Returns next value in the queue
	 * 
	 * @return the next value
	 */
	public Cargo peek() {

		Cargo next;

		if (this.isEmpty()) {

			return null;
		}

		next = list[0];

		return next;
	}

	/**
	 * inserts value into queue
	 * 
	 * @param x
	 *            cargo
	 * @return boolean
	 */
	public boolean enqueue(Cargo x) {

		if (this.isFull()) {

			Cargo[] newList = new Cargo[list.length * 2];

			for (int i = firstIndex; i < lastIndex; i++) {

				newList[i] = list[i];
			}

			list = newList;
		}

		list[lastIndex] = x;
		lastIndex++;

		return true;
	}

	/**
	 * Returns size of queue.
	 * 
	 * @return size
	 */
	public int getSize() {

		return lastIndex;
	}

	/**
	 * Checks if queue is full.
	 * 
	 * @return boolean
	 */
	public boolean isFull() {

		boolean result = false;

		if (lastIndex == this.getCapacity()) {

			return true;
		}

		return result;
	}

	/**
	 * Checks if queue is empty.
	 * 
	 * @return boolean
	 */
	public boolean isEmpty() {

		return lastIndex == 0;

	}

	/**
	 * Removes the next int and returns it.
	 * 
	 * @return removed int.
	 */
	public Cargo dequeue() {

		Cargo next;
		if (this.isEmpty()) {

			return null;
		} else {

			next = list[firstIndex];

			for (int i = firstIndex; i < lastIndex; i++) {

				if (i + 1 < list.length) {
					list[i] = list[i + 1];
				}
			}
		}

		lastIndex--;

		return next;
	}

	/**
	 * Capacity of the queue.
	 * 
	 * @return the capacity
	 */
	public int getCapacity() {

		return list.length;
	}

	/**
	 * remaining capacity.
	 * 
	 * @return free space
	 */
	public int getRemainingCapacity() {

		return list.length - this.getSize();
	}
}
