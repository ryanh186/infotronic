package edu.ben.labs.lab4;
/**
 * 
 * @author ryanhassoun
 * @version 1.0
 *
 */
public class Coffee {
	/**
	 *  tall size
	 */
	public static final int TALL = 1;
	/**
	 *  grande size
	 */
	public static final int GRANDE = 2; 
	/**
	 *  venti size
	 */
	public static final int VENTI = 3;
	
	// name of person on order
	private String name; 
	// size of order
	private int size;
	// cost of order
	private double cost;
	// time to make order
	private int timeToMake;
	/**
	 * Stored order information
	 * @param name
	 * 		persons name
	 * @param size
	 * 		ORDER size
	 * @param cost
	 * 		order cost
	 * @param timeToMake
	 * 		time to make order
	 */
	public Coffee(String name, int size, double cost, int timeToMake) {
		super();
		this.name = name;
		this.size = size;
		this.cost = cost;
		this.timeToMake = timeToMake;
	}
/**
 * gets name
 * @return
 * 		name
 */
	public String getName() {
		return name;
	}
/**
 * sets name
 * @param name
 * 			name
 */
	public void setName(String name) {
		this.name = name;
	}
/**
 * gets size
 * @return
 * 		size
 */
	public int getSize() {
		return size;
	}
/**
 * sets size
 * @param size
 * 		size
 */
	public void setSize(int size) {
		this.size = size;
	}
/**
 * gets cost
 * @return
 * 		order cost
 */
	public double getCost() {
		return cost;
	}
/**
 * sets cost
 * @param cost
 * 		cost
 */
	public void setCost(double cost) {
		this.cost = cost;
	}
/**
 * gets time to make order
 * @return
 * 		time to make
 */
	public int getTimeToMake() {
		return timeToMake;
	}
/**
 * sets time to make order 
 * @param timeToMake
 * 		sets time to make
 */
	public void setTimeToMake(int timeToMake) {
		this.timeToMake = timeToMake;
	}
	/**
	 * allows string input to be printed
	 */
	@Override
	public String toString() {
		return "Coffee [name=" + name + ", size=" + size + ", cost=" + cost + ", timeToMake=" + timeToMake + "]";
	}
	/**
	 * allows the coffee queue index to be stored correctly
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Coffee other = (Coffee) obj;
		if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (size != other.size) {
			return false;
		}
		if (timeToMake != other.timeToMake) {
			return false;
		}
		return true;
	}
	
	/**
	 * converts to hashcode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + size;
		result = prime * result + timeToMake;
		return result;
	}

	
	

}
