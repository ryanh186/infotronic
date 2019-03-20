package edu.ben.labs.lab5;

import java.util.Stack;

/**
 * 
 * @author ryanhassoun
 * @version 1.0
 */
public class Airplane {
	/**
	 * type
	 */
	private int type;
	/**
	 * flight Number
	 */
	private int flightNumber;
	/**
	 * capacity
	 */
	private int capacity;
	/**
	 * weight limit
	 */
	private int weightLimit;
	/**
	 * Cargo stack
	 */
	public Stack<Cargo> storage = new Stack<Cargo>();

	/**
	 * Airplane class
	 * 
	 * @param type
	 *            type
	 * @param flightNumber
	 *            Flight number
	 * @param capacity
	 *            capacity
	 * @param weightLimit
	 *            weight limit
	 */
	public Airplane(int type, int flightNumber, int capacity, int weightLimit) {
		this.type = type;
		this.flightNumber = flightNumber;
		this.capacity = capacity;
		this.weightLimit = weightLimit;
	}

	/**
	 * gets remaining space
	 * 
	 * @return int
	 */
	public int getRemainingSpace() {

		int remainingSpace = this.getCapacity();

		for (int i = 0; i < storage.size(); i++) {

			remainingSpace -= storage.get(i).getSize();
		}

		return remainingSpace;
	}

	/**
	 * gets remaining weight
	 * 
	 * @return int
	 */
	public int getRemainingWeight() {

		int remainingWeight = this.getWeightLimit();

		for (int i = 0; i < storage.size(); i++) {

			remainingWeight -= storage.get(i).getWeight();
		}

		return remainingWeight;
	}

	/**
	 * gets type of plane
	 * 
	 * @return int
	 */
	public int getType() {
		return type;
	}

	/**
	 * sets type
	 * 
	 * @param type
	 *            type of plane
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * gets flight number
	 * 
	 * @return int
	 */
	public int getFlightNumber() {
		return flightNumber;
	}

	/**
	 * sets flight number
	 * 
	 * @param flightNumber
	 *            int
	 */
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	/**
	 * gets capacity
	 * 
	 * @return int
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * sets capacity
	 * 
	 * @param capacity
	 *            int
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * gets weight limit
	 * 
	 * @return int
	 */
	public int getWeightLimit() {
		return weightLimit;
	}

	/**
	 * sets weight limit
	 * 
	 * @param weightLimit
	 *            int
	 */

	public void setWeightLimit(int weightLimit) {
		this.weightLimit = weightLimit;
	}

}
