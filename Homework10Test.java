package edu.ben.homeworks.homework10;


import java.util.ArrayList;

import org.junit.Test;

import student.TestCase;
/**
 * 
 * @author ryanhassoun
 *
 */
public class Homework10Test extends TestCase {

	@Test
	public void testIsTriangleNumber() {

		assertTrue(Homework10.isTriangleNumber(1));
		assertTrue(Homework10.isTriangleNumber(3));
		assertFalse(Homework10.isTriangleNumber(5));
		assertFalse(Homework10.isTriangleNumber(0));
		assertFalse(Homework10.isTriangleNumber(-1));
		assertTrue(Homework10.isTriangleNumber(28));
	}
	
	@Test
	public void testIsInOrder() {

		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		assertTrue(Homework10.isInOrder(a));
		
		ArrayList<Integer> b = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(5);
		assertFalse(Homework10.isInOrder(b));
		
		ArrayList<Integer> c = new ArrayList<Integer>();
		a.add(4);
		a.add(3);
		a.add(2);
		a.add(1);
		assertFalse(Homework10.isInOrder(c));
		
		ArrayList<Integer> d = new ArrayList<Integer>();
		d.add(-1);
		d.add(0);
		d.add(1);
		d.add(2);
		d.add(3);
		assertFalse(Homework10.isInOrder(d));
		
		ArrayList<Integer> e = new ArrayList<Integer>();
		e.add(1);
		assertTrue(Homework10.isInOrder(e));
	}
	
	@Test
	public void test() {
		String input = "2\n6 4\n5\n2 3 2 3 2\n0\n";

		String expected = "2 iterations\n12 is not a triangular number\n";

		setSystemIn(input);

		Homework10.main(null);

		String actual = systemOut().getHistory();

		assertEquals(expected, actual);
	}
	
	@Test
	public void test2() {
		String input = "3\n4 3 3\n1\n1\n0\n";

		String expected = "9 iterations\n0 iterations\n";

		setSystemIn(input);

		Homework10.main(null);

		String actual = systemOut().getHistory();

		assertEquals(expected, actual);
	}
	
	@Test
	public void test3() {
		String input = "0\n";

		String expected = "";

		setSystemIn(input);

		Homework10.main(null);

		String actual = systemOut().getHistory();

		assertEquals(expected, actual);
	}
	
	@Test
	public void test4() {
		String input = "6\n1 1 1 1 1 1\n4\n5 5 0 0\n0\n";

		String expected = "4 iterations\n6 iterations\n";

		setSystemIn(input);

		Homework10.main(null);

		String actual = systemOut().getHistory();

		assertEquals(expected, actual);
	}
	
	@Test
	public void test5() {
		String input = "-1\n9 2\n0\n";

		String expected = "";

		setSystemIn(input);

		Homework10.main(null);

		String actual = systemOut().getHistory();

		assertEquals(expected, actual);
	}
	
	@Test
	public void test6() {
		String input = "11\n1 0 1 0 1 0 0 1 1 0 1\n0\n";

		String expected = "4 iterations\n";

		setSystemIn(input);

		Homework10.main(null);

		String actual = systemOut().getHistory();

		assertEquals(expected, actual);
	}
}
