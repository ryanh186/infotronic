package edu.ben.labs.lab5;



import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;

import student.TestCase;

public class CargoLoaderTest extends TestCase {

	@Test
	public void testAirplane() {

		Airplane a = new Airplane(5, 276, 506, 800);
		Cargo c = new Cargo(2548, 100, 1205, 150);

		int actual = a.getRemainingSpace();
		int expected = 506;
		assertEquals(expected, actual);
		a.storage.push(c);

	}

	@Test
	public void testFile() throws FileNotFoundException {

		File f = new File("/Applications/College/CMSC205/CMSC205/src/edu/ben/labs/lab5/files/aircraft.log");
		File This = new File("/Applications/College/CMSC205/CMSC205/src/edu/ben/labs/lab5/files/cargo.log");

		CargoLoader.loadCargo(f, This);

		String expected = "********** CARGO MANIFEST **********\n" + "Flight #276 Cargo: 472/506 cu/ft. 475/800 lbs.\n"
				+ "CARGO DETAILS:\n" + "\t#754415, 152 cu/ft., 125 lbs. $521\n"
				+ "\t#2548, 100 cu/ft., 150 lbs. $1205\n" + "\t#415253, 220 cu/ft., 200 lbs. $5236\n" + "\n"
				+ "Flight #731 Cargo: 320/325 cu/ft. 400/600 lbs.\n" + "CARGO DETAILS:\n"
				+ "\t#45215, 320 cu/ft., 400 lbs. $4521\n" + "\n" + "Flight #152 Cargo: 452/1250 cu/ft. 652/1000 lbs.\n"
				+ "CARGO DETAILS:\n" + "\t#964513, 452 cu/ft., 652 lbs. $2536\n" + "\n"
				+ "Flight #512 Cargo: 0/852 cu/ft. 0/700 lbs.\n" + "CARGO DETAILS:\n" + "\tNO CARGO\n" + "\n"
				+ "Unable to load the following cargo on any available aircraft: \n"
				+ "\t#1234, 11111 cu/ft., 8522 lbs. $1234\n\n";

		String actual = systemOut().getHistory();

		assertEquals(expected, actual);
	}

}
