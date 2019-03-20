package edu.ben.labs.lab4;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @author ryanhassoun
 * @version 1.0
 *
 */
public class CoffeeHouseTest {

	@Test
	public void takeOrderTest() {
		CoffeeHouse c = new CoffeeHouse();
		Coffee one = new Coffee("John Smith", 1, 5.00, 60);
		boolean expected = true;
		boolean actual = c.takeOrder(one);
		assertEquals(expected, actual);
	}

	@Test
	public void serveOrderTest() {
		CoffeeHouse c = new CoffeeHouse();
		Coffee one = new Coffee("John Smith", 1, 5.00, 60);
		c.takeOrder(one);
		Coffee expected = new Coffee("John Smith", 1, 5.00, 60);
		Coffee actual = c.serveOrder();
		assertEquals(expected, actual);
	}

	@Test
	public void getPotentialRevenueTest() {
		CoffeeHouse c = new CoffeeHouse();
		Coffee one = new Coffee("John Smith", 1, 5.00, 60);
		c.takeOrder(one);
		Coffee two = new Coffee("Bob Smith", 2, 10.00, 30);
		c.takeOrder(two);
		double expected = 15.00;
		double actual = c.getPotentialRevenue();
		assertEquals(expected, actual, 0.00);
	}

	@Test
	public void timeToMakeCoffeeOrdersTest() {
		CoffeeHouse c = new CoffeeHouse();
		Coffee one = new Coffee("John Smith", 1, 5.00, 60);
		c.takeOrder(one);
		Coffee two = new Coffee("Bob Smith", 2, 10.00, 30);
		c.takeOrder(two);
		int expected = 90;
		int actual = c.timeToMakeCoffeeOrders();
		assertEquals(expected, actual);
	}

	@Test
	public void getNumOrdersTest() {
		CoffeeHouse c = new CoffeeHouse();
		Coffee one = new Coffee("John Smith", 1, 5.00, 60);
		c.takeOrder(one);
		Coffee two = new Coffee("Bob Smith", 2, 10.00, 30);
		c.takeOrder(two);
		int expected = 2;
		int actual = c.getNumOrders();
		assertEquals(expected, actual);
	}

	@Test
	public void viewNextOrderTest() {
		CoffeeHouse c = new CoffeeHouse();
		Coffee one = new Coffee("John Smith", 1, 5.00, 60);
		c.takeOrder(one);
		Coffee two = new Coffee("Bob Smith", 2, 10.00, 30);
		c.takeOrder(two);
		Coffee expected = one;
		Coffee actual = c.viewNextOrder();
		assertEquals(expected, actual);
	}

	@Test
	public void getRevenueTest() {
		CoffeeHouse Starbucks = new CoffeeHouse();
		Coffee one = new Coffee("John Smith", 1, 5.00, 60);
		Starbucks.takeOrder(one);
		Coffee two = new Coffee("Bob Smith", 2, 10.00, 30);
		Starbucks.takeOrder(two);
		Starbucks.serveOrder();
		double expected = 5.00;
		double actual = Starbucks.getRevenue();
		assertEquals(expected, actual, 0.00);
	}

}
