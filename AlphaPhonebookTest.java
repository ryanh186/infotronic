package edu.ben.labs.lab6;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

public class AlphaPhonebookTest {

	@Test
	public void test() {
		AlphaPhonebook a = new AlphaPhonebook();
		
		Record b = new Record("Garrett", "Noel", "2231611652");
		Record c = new Record("Thomas", "Ives", "6305556789");
		Record d = new Record("Roland" , "Iceman", "6305559870");
		try {
			a.importDataFromCSV("/Applications/College/CMSC205/CMSC205/src/edu/ben/labs/lab6/AlphaPhonebookSampleFile.csv");
			
			a.deleteRecord(b);
			a.addRecord(d);
			a.deleteRecord(c);

			
			
		} catch (FileNotFoundException e) {
			fail("Wrong file");
			
		} catch (InvalidInputType e) {
			fail("Invalid");
		}
		
		try {
			a.outputToFile("testing");
		} catch (IOException e) {
			fail("could not write");
		}
		
		try {
			a.addRecord(c);
			a.outputToFile("testing");
		} catch (InvalidInputType e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@Test
//	public void test2() {
//		AlphaPhonebook a = new AlphaPhonebook();
//		try {
//			a.importDataFromCSV("MyTest");
//		} catch (FileNotFoundException e) {
//			fail("Wrong file");
//			
//		} catch (InvalidInputType e) {
//			fail("Invalid");
//		}
//		
//		try {
//			a.outputToFile("mytesting");
//		} catch (IOException e) {
//			fail("could not write");
//		}
//	}
	
	@Test
	public void testDelete1() {	
		
		AlphaPhonebook a = new AlphaPhonebook();
		
		Record x = new Record("Lebron", "James", "6305551234");
		Record y = new Record("Michael", "James", "6305551235");
		Record z = new Record("Donovan", "James", "6305551236");
		Record o = new Record("Benjamin", "Cumberbatch", "6305551237");
		
		try {
			a.addRecord(o);
			a.addRecord(x);
			a.addRecord(y);
			a.addRecord(z);
			assertEquals(4, a.getSize());
		} catch (InvalidInputType e) {
			
			fail("Invalid");
		}
		
		a.deleteRecord(y);
		a.deleteRecord(x);
		a.deleteRecord(x);
		
		assertEquals(2, a.getSize());
		a.deleteRecord(z);
		a.deleteRecord(o);
		
		assertEquals(0, a.getSize());
		
		
		try {
			a.addRecord(x);
			assertEquals(1, a.getSize());
		} catch (InvalidInputType e1) {
			
			fail("Invalid");
		}
		
		
		
		try {
			a.outputToFile("mytesting2");
		} catch (IOException e) {
			fail("Could not delete");
		}
	}
	
	@Test
	public void testDelete2() {	
		
		AlphaPhonebook a = new AlphaPhonebook();
		
		Record x = new Record("Lebron", "James", "6305551234");
		Record y = new Record("Michael", "James", "6305551235");
		Record z = new Record("Donovan", "James", "6305551236");
		Record o = new Record("Benjamin", "Cumberbatch", "6305551237");
		
		try {
			a.addRecord(o);
			a.addRecord(x);
			a.addRecord(y);
			a.addRecord(z);
		} catch (InvalidInputType e) {
			
			fail("Invalid");
		}
		
		a.deleteRecord(z);
		
		try {
			a.outputToFile("mytesting3");
		} catch (IOException e) {
			fail("Could not delete");
		}
	}
	
	@Test
	public void testDelete3() {	
		
		AlphaPhonebook a = new AlphaPhonebook();
		
		Record x = new Record("Lebron", "James", "6305551234");
		Record y = new Record("Michael", "James", "6305551235");
		Record z = new Record("Michael", "James", "6305551235");
		Record o = new Record("Benjamin", "Cumberbatch", "6305551237");
		
		try {
			a.addRecord(o);
			a.addRecord(x);
			a.addRecord(y);
		} catch (InvalidInputType e) {
			
			fail("Invalid");
		}
		
		a.deleteRecord(z);
		
		try {
			a.outputToFile("mytesting4");
		} catch (IOException e) {
			fail("Could not delete");
		}
	}
	
	
	@Test
	public void testSearchByLastName1() {
		AlphaPhonebook a = new AlphaPhonebook();
		
		Record x = new Record("Lebron", "James", "6305551234");
		Record y = new Record("Michael", "James", "6305551235");
		Record z = new Record("Donovan", "James", "6305551236");
		Record o = new Record("Benjamin", "Cumberbatch", "6305551237");
		
		try {
			a.addRecord(o);
			a.addRecord(x);
			a.addRecord(y);
			a.addRecord(z);
		} catch (InvalidInputType e) {
			
			fail("Invalid");
		}
		
	
		ArrayList<Record> expected = new ArrayList<Record>();
		expected.add(z);
		expected.add(x);
		expected.add(y);
		assertEquals(expected, a.searchByLastName("James"));
	}
	
	@Test
	public void testSearchByLastName2() {
		AlphaPhonebook a = new AlphaPhonebook();
		
		Record x = new Record("Lebron", "James", "6305551234");
		Record y = new Record("Michael", "James", "6305551235");
		Record z = new Record("Donovan", "James", "6305551236");
		Record o = new Record("Benjamin", "Cumberbatch", "6305551237");
		
		try {
			a.addRecord(o);
			a.addRecord(x);
			a.addRecord(y);
			a.addRecord(z);
		} catch (InvalidInputType e) {
			
			fail("Invalid");
		}
		
	
		ArrayList<Record> expected = new ArrayList<Record>();
		assertEquals(expected, a.searchByLastName("Doggo"));
	}
	
	@Test
	public void testSearchByFirstName1() {
		AlphaPhonebook a = new AlphaPhonebook();
		
		Record x = new Record("Lebron", "James", "6305551234");
		Record y = new Record("Michael", "James", "6305551235");
		Record z = new Record("Donovan", "James", "6305551236");
		Record o = new Record("Benjamin", "Cumberbatch", "6305551237");
		Record p = new Record("Michael", "Jordan", "6305552345");
		
		try {
			a.addRecord(o);
			a.addRecord(x);
			a.addRecord(y);
			a.addRecord(z);
			a.addRecord(p);
		} catch (InvalidInputType e) {
			
			fail("Invalid");
		}
		
	
		ArrayList<Record> expected = new ArrayList<Record>();
		
		expected.add(y);
		expected.add(p);
		
		assertEquals(expected, a.searchByFirstName("Michael"));
	}
	
	@Test
	public void testSearchByFirstName2() {
		
		AlphaPhonebook a = new AlphaPhonebook();
		
		Record x = new Record("Lebron", "James", "6305551234");
		//Record y = new Record("Michael", "James", "6305551235");
		Record z = new Record("Donovan", "James", "6305551236");
		Record o = new Record("Benjamin", "Cumberbatch", "6305551237");
		//Record p = new Record("Michael", "Jordan", "6305552345");
		
		try {
			a.addRecord(o);
			a.addRecord(x);

			a.addRecord(z);
			
		} catch (InvalidInputType e) {
			
			fail("Invalid");
		}
		
	
		ArrayList<Record> expected = new ArrayList<Record>();

		assertEquals(expected, a.searchByFirstName("Michael"));
	}
	
	@Test
	public void testSearchByFirstName3() {
		
		AlphaPhonebook a = new AlphaPhonebook();
	
		ArrayList<Record> expected = new ArrayList<Record>();

		assertEquals(expected, a.searchByFirstName("Michael"));
	}


	@Test
	public void testSearchByPhoneNumber1() {
		
		AlphaPhonebook a = new AlphaPhonebook();
		
		Record x = new Record("Lebron", "James", "6305551234");
		Record y = new Record("Michael", "James", "6305551235");
		Record z = new Record("Donovan", "James", "6305551236");
		Record o = new Record("Benjamin", "Cumberbatch", "6305551237");
		Record p = new Record("Michael", "Jordan", "6305552345");
		
		try {
			a.addRecord(o);
			a.addRecord(x);
			a.addRecord(y);
			a.addRecord(z);
			a.addRecord(p);
			
		} catch (InvalidInputType e) {
			
			fail("Invalid");
		}

		assertEquals(x, a.searchByPhoneNumber("6305551234"));
	}
	
	@Test
	public void testSearchByPhoneNumber2() {
		
		AlphaPhonebook a = new AlphaPhonebook();
		
		Record x = new Record("Lebron", "James", "6305551234");
		Record y = new Record("Michael", "James", "6305551235");
		Record z = new Record("Donovan", "James", "6305551236");
		Record o = new Record("Benjamin", "Cumberbatch", "6305551237");
		Record p = new Record("Michael", "Jordan", "6305552345");
		
		try {
			a.addRecord(o);
			a.addRecord(x);
			a.addRecord(y);
			a.addRecord(z);
			a.addRecord(p);
			
		} catch (InvalidInputType e) {
			
			fail("Invalid");
		}

		assertEquals(z, a.searchByPhoneNumber("6305551236"));
	}
	
	@Test
	public void testSearchByPhoneNumber3() {
		
		AlphaPhonebook a = new AlphaPhonebook();
		
		Record x = new Record("Lebron", "James", "6305551234");
		Record y = new Record("Michael", "James", "6305551235");
		Record z = new Record("Donovan", "James", "6305551236");
		Record o = new Record("Benjamin", "Cumberbatch", "6305551237");
		Record p = new Record("Michael", "Jordan", "6305552345");
		
		try {
			a.addRecord(o);
			a.addRecord(x);
			a.addRecord(y);
			a.addRecord(z);
			a.addRecord(p);
			
		} catch (InvalidInputType e) {
			
			fail("Invalid");
		}

		assertEquals(5, a.getSize());
		assertEquals(null, a.searchByPhoneNumber("2305551236"));
	}
}

