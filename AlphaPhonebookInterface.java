package edu.ben.labs.lab6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * @author ryanhassoun
 * @version 1.0
 */
public interface AlphaPhonebookInterface {

	/*
	 * The following constructor has been provided to help get you started,
	 * simply cut from here and add to your AlphaPhonebook Class
	 */
	// public AlphaPhonebook() {
	// phonebook = (MyLinkedList<Record>[])
	// Array.newInstance(MyLinkedList.class, 26);
	// }
	/**
	 * 
	 * @param record
	 * 			record
	 * @throws InvalidInputType
	 */
	void addRecord(Record record) throws InvalidInputType;

	/**
	 * Deletes a record in the phone book
	 * 
	 * @param record
	 *            the record to be deleted
	 */
	void deleteRecord(Record record);

	/**
	 * Gets a list of records from a file and adds them to the phone book
	 * 
	 * @param filepath
	 *            the name of the file
	 * @throws InvalidInputType
	 */
	void importDataFromCSV(String filepath)
			throws InvalidInputType, FileNotFoundException;

	/**
	 * Writes the correctly formatted phone book in a file
	 * 
	 * @param filename
	 *            the file the output should be written in
	 * @throws IOException
	 *             If the file could not be found
	 */
	void outputToFile(String filename) throws IOException;

	/**
	 * Creates an ArrayList of records that have the same first name
	 * 
	 * @param firstName
	 *            the first name that the records should have in common
	 * @return an ArrayList of records that share that first name
	 */
	ArrayList<Record> searchByFirstName(String firstName);

	/**
	 * Creates an ArrayList of records that have the same last name
	 * 
	 * @param lastName
	 *            the last name that the records should have in common
	 * @return an ArrayList of records that share that last name
	 */
	ArrayList<Record> searchByLastName(String lastName);

	/**
	 * Returns a record with a particular phone number or null if none is found
	 * 
	 * @param phoneNumber
	 *            the number the record should have
	 * @return the record with the given phone number
	 */
	Record searchByPhoneNumber(String phoneNumber);

	/**
	 * Gets the size of the phone book;
	 * 
	 * @return the size of the phone book
	 */
	int getSize();

	/**
	 * Returns a formatted string of the phone book
	 * 
	 * @return a formatted string of the phone book
	 */
	String toString();

}