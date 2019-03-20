package edu.ben.labs.lab4;

/**
 * 
 * @author ryanhassoun
 * @version 1.0
 *
 */
public class CoffeeHouse {
	// front of the line
	private int frontLine;
	// end of the line
	private int endLine;
	// revenue
	private double revenue;
	// coffee line queue
	private Coffee[] coffeeLine = new Coffee[10000];

	/**
	 * Takes order and enqueues it into array
	 * 
	 * @param c
	 *            Order if not null
	 * @return order
	 */
	public boolean takeOrder(Coffee c) {
		boolean order = false;
		if (c == null) {
			return order;
		} else {
			order = true;
			coffeeLine[endLine] = c;
			endLine++;
			return order;
		}
	}

	/**
	 * Dequeues order
	 * 
	 * @return order that is next
	 */
	public Coffee serveOrder() {
		Coffee currentOrder = coffeeLine[frontLine];
		revenue += coffeeLine[frontLine].getCost();
		frontLine++;
		return currentOrder;
	}

	/**
	 * calculates revenue based off coffee queue
	 * 
	 * @return revenue for queue
	 */
	public double getPotentialRevenue() {
		double tempRevenue = 0;
		for (int i = frontLine; i < endLine; i++) {
			tempRevenue += coffeeLine[i].getCost();
		}
		return tempRevenue;

	}

	/**
	 * time to make coffee orders
	 * 
	 * @return time
	 */
	public int timeToMakeCoffeeOrders() {
		int time = 0;
		for (int i = frontLine; i < endLine; i++) {
			time += coffeeLine[i].getTimeToMake();
		}
		return time;
	}

	/**
	 * number of orders in queue
	 * 
	 * @return order number
	 */
	public int numOfOrders() {
		int orders = 0;
		for (int i = frontLine; i < endLine; i++) {
			if (coffeeLine[i] != null) {
				orders++;
			}
		}
		return orders;

	}

	/**
	 * counts the sizes in the queue
	 * 
	 * @return number of sizes in an array
	 */
	public int[] getSizeCount() {
		int[] numSizes = new int[3];
		int tall = 0;
		int grande = 0;
		int venti = 0;
		for (int i = frontLine; i < endLine; i++) {
			int orderSize = coffeeLine[i].getSize();

			// Check and account for sizes
			if (orderSize == 1) {
				tall++;
			} else if (orderSize == 2) {
				grande++;
			} else if (orderSize == 3) {
				venti++;
			}
		}

		numSizes[0] = tall;
		numSizes[1] = grande;
		numSizes[2] = venti;

		return numSizes;

	}

	/**
	 * peek next order
	 * 
	 * @return next order
	 */
	public Coffee viewNextOrder() {
		return coffeeLine[frontLine];

	}

	/**
	 * number of orders currently
	 * 
	 * @return number of orders
	 */
	public int getNumOrders() {
		return numOfOrders();

	}

	/**
	 * calculates total revenue
	 * 
	 * @return revenue
	 */
	public double getRevenue() {
		return revenue;

	}
	// end

}
