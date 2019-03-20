package edu.ben.labs.lab5;

/**
 * 
 * @author ryanhassoun
 * @version 1.0
 */

public class Cargo {

	/**
	 * tracking number
	 */
	private int trackingNum;
	/**
	 * size
	 */
	private int size;
	/**
	 * value
	 */
	private int value;
	/**
	 * weight
	 */
	private int weight;

	/**
	 * Cargo class
	 * 
	 * @param trackingNum
	 *            int
	 * @param size
	 *            int
	 * @param value
	 *            int
	 * @param weight
	 *            int
	 */
	public Cargo(int trackingNum, int size, int value, int weight) {
		this.trackingNum = trackingNum;
		this.size = size;
		this.value = value;
		this.weight = weight;

	}

	/**
	 * gets tracking number
	 * 
	 * @return int
	 */
	public int getTrackingNum() {
		return trackingNum;
	}

	/**
	 * sets tracking number
	 * 
	 * @param trackingNum
	 *            int
	 */
	public void setTrackingNum(int trackingNum) {
		this.trackingNum = trackingNum;
	}

	/**
	 * gets size of cargo
	 * 
	 * @return int
	 */
	public int getSize() {
		return size;
	}

	/**
	 * sets size of cargo
	 * 
	 * @param size
	 *            int
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * gets value of cargo
	 * 
	 * @return int
	 */
	public int getValue() {
		return value;
	}

	/**
	 * sets value of cargo
	 * 
	 * @param value
	 *            int
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * gets weight limit
	 * 
	 * @return weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * sets weight limit
	 * 
	 * @param weight
	 *            weight limit
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

}
