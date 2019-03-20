package edu.ben.labs.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author ryanhassoun
 * @version 1.0
 */
public class AlphaPhonebook implements AlphaPhonebookInterface {
	
	
	

	/**
	 * Creates an array of linkedlists where each location in the array
	 * represents a letter in the alphabet
	 */
	private MyLinkedList<Record>[] phonebook;

	/**
	 * Constructor for the phonebook. Initailizes the phonebook to a size of 26.
	 */
	@SuppressWarnings("unchecked")
	public AlphaPhonebook() {
		phonebook = (MyLinkedList<Record>[]) Array
				.newInstance(MyLinkedList.class, 26);
	}

	
//	public static void main(String[] args) {
//		
//	}
	/**
	 * Adds a record to the phone book placing it in correct order
	 * 
	 * @param record
	 *            the record
	 * @throws InvalidInputType
	 *             Exception
	 */
	@Override
	public void addRecord(Record record) throws InvalidInputType {

		/*
		 * Parsing the phoneNumber of the record to eliminate all invalid
		 * characters
		 */
		String editedPhoneNumber = "";

		for (int i = 0; i < record.getPhoneNumber().length(); i++) {

			if (Character.isDigit(record.getPhoneNumber().charAt(i))) {

				editedPhoneNumber += record.getPhoneNumber().charAt(i);
			}
		}

		record.setPhoneNumber(editedPhoneNumber);

		/*
		 * If the phone number is not 10 digits long throw and invalid input
		 * exception.
		 */
		if (record.getPhoneNumber().length() < 10) {

			throw new InvalidInputType("Invalid Phone Number");
		}

		/*
		 * Create a new Node that needs to be added in the correct order.
		 */
		Node<Record> toAdd = new Node<Record>(record);

		/*
		 * Get the correct location in the array corresponding to the first
		 * letter in the lastName
		 */
		int letter = getLocation(record.getLastName().charAt(0));

		/*
		 * If there are no entries currently in that section of the phonebook,
		 * create a new linkedList with the record in it
		 */
		if (phonebook[letter] == null || phonebook[letter].isEmpty()) {

			MyLinkedList<Record> temp = new MyLinkedList<Record>();
			temp.add(record);
			phonebook[letter] = temp;
		} else {

			/*
			 * Otherwise, if there are other entries in that section, find the
			 * correct location for the record to be placed
			 */

			/*
			 * Create a current and previous pointer to loop through the section
			 * of the phonebook. Also, create a boolean that lets me know
			 * whether the record was correctly placed
			 */
			Node<Record> current = phonebook[letter].getHead();
			Node<Record> previous = null;
			boolean placed = false;

			/*
			 * Compare already inputted entries with the record to be added
			 * until the record is correctly placed
			 */
			while (!placed) {

				if (current != null) {

					if (record.compareTo(current.getValue()) == 0) {

						throw new InvalidInputType(
								"Duplicate Entry - Same Phone Numbers");

					} else if (previous != null
							&& record.compareTo(current.getValue()) < 0
							&& record.compareTo(previous.getValue()) > 0) {

						toAdd.setNext(current);
						previous.setNext(toAdd);
						placed = true;
					} else if (previous == null
							&& record.compareTo(current.getValue()) < 0) {

						phonebook[letter].addFirst(record);
						placed = true;
					} else if (current.getNext() == null
							&& record.compareTo(current.getValue()) > 0) {

						phonebook[letter].addLast(record);
						placed = true;
					}

					previous = current;
					current = current.getNext();
				} else {

					phonebook[letter].addFirst(record);
					placed = true;
				}
			}
		}
	}

	/**
	 * Returns the correct number corresponding with the letter in the alphabet
	 * Ex: A = 1, B = 2, C = 3, ..., Z = 26.
	 * 
	 * @param a
	 *            the letter of the alphabet
	 * @return the corresponding number
	 */
	private int getLocation(char a) {

		int letter = 0;

		switch (a) {

		case 'A':
			letter = 0;
			break;
		case 'B':
			letter = 1;
			break;
		case 'C':
			letter = 2;
			break;
		case 'D':
			letter = 3;
			break;
		case 'E':
			letter = 4;
			break;
		case 'F':
			letter = 5;
			break;
		case 'G':
			letter = 6;
			break;
		case 'H':
			letter = 7;
			break;
		case 'I':
			letter = 8;
			break;
		case 'J':
			letter = 9;
			break;
		case 'K':
			letter = 10;
			break;
		case 'L':
			letter = 11;
			break;
		case 'M':
			letter = 12;
			break;
		case 'N':
			letter = 13;
			break;
		case 'O':
			letter = 14;
			break;
		case 'P':
			letter = 15;
			break;
		case 'Q':
			letter = 16;
			break;
		case 'R':
			letter = 17;
			break;
		case 'S':
			letter = 18;
			break;
		case 'T':
			letter = 19;
			break;
		case 'U':
			letter = 20;
			break;
		case 'V':
			letter = 21;
			break;
		case 'W':
			letter = 22;
			break;
		case 'X':
			letter = 23;
			break;
		case 'Y':
			letter = 24;
			break;
		case 'Z':
			letter = 25;
			break;
		default:
			letter = -1;
			break;
		}

		return letter;
	}

	/**
	 * Deletes a record in the phone book
	 * 
	 * @param record
	 *            the record to be deleted
	 */
	@Override
	public void deleteRecord(Record record) {

		// Gets the starting letter of the last name and gets its appropriate
		// section
		int letter = getLocation(record.getLastName().charAt(0));

		// Using the LinkedLists remove method to delete the record

		if (phonebook[letter] != null) {

			phonebook[letter].remove(record);
		}

	}

	/**
	 * Gets a list of records from a file and adds them to the phone book
	 * 
	 * @param filepath
	 *            the name of the file
	 * @throws InvalidInputType
	 */
	@Override
	public void importDataFromCSV(String filepath)
			throws InvalidInputType, FileNotFoundException {

		File f = new File(filepath);
		Scanner scan = new Scanner(f);
		scan.nextLine();

		while (scan.hasNext()) {
			String[] info = scan.nextLine().split(",");
			Record currentPerson = new Record(info[0], info[1], info[2]);

			addRecord(currentPerson);
		}

		scan.close();
	}

	/**
	 * Writes the correctly formatted phone book in a file
	 * 
	 * @param filename
	 *            the file the output should be written in
	 * @throws IOException
	 *             If the file could not be found
	 */
	@Override
	public void outputToFile(String filename) throws IOException {

		/*
		 * Initialize the writer
		 */
		File file = new File(filename);
		FileWriter writer = new FileWriter(file);

		/*
		 * Create an array of the alphabet
		 */
		String[] alphabet = { "A:", "B:", "C:", "D:", "E:", "F:", "G:", "H:",
				"I:", "J:", "K:", "L:", "M:", "N:", "O:", "P:", "Q:", "R:",
				"S:", "T:", "U:", "V:", "W:", "X:", "Y:", "Z:" };

		/*
		 * For all sections in the phone book
		 */
		for (int i = 0; i < phonebook.length; i++) {

			/*
			 * If a section is not empty
			 */
			if (phonebook[i] != null && !phonebook[i].isEmpty()) {

				// write the alphabet letter
				writer.write(alphabet[i]);

				Node<Record> temp = phonebook[i].getHead();

				// then write all the entries in order
				while (temp != null) {

					Record current = temp.getValue();
					writer.write("\t" + current.toString() + "\n");

					temp = temp.getNext();
				}

				/*
				 * Otherwise simply write the letter with a tab and go on to the
				 * next letter
				 */
			} else {

				writer.write(alphabet[i] + "\t\n");
			}
		}

		writer.write("\n");

		writer.close();
	}

	/**
	 * Creates an ArrayList of records that have the same first name
	 * 
	 * @param firstName
	 *            the first name that the records should have in common
	 * @return an ArrayList of records that share that first name
	 */
	@Override
	public ArrayList<Record> searchByFirstName(String firstName) {

		// Initialize the ArrayList to be returned
		ArrayList<Record> firstNameList = new ArrayList<Record>();

		/*
		 * For all sections in the phonebook
		 */
		for (int i = 0; i < phonebook.length; i++) {

			// If the section is not empty
			if (phonebook[i] != null) {

				/*
				 * Loop through the sections and add any records with the same
				 * first name
				 */
				Node<Record> current = phonebook[i].getHead();

				while (current != null) {

					if (current.getValue().getFirstName()
							.equalsIgnoreCase(firstName)) {

						firstNameList.add(current.getValue());
					}

					// move to the next record
					current = current.getNext();
				}
			}

		}

		return firstNameList;
	}

	/**
	 * Creates an ArrayList of records that have the same last name
	 * 
	 * @param lastName
	 *            the last name that the records should have in common
	 * @return an ArrayList of records that share that last name
	 */
	@Override
	public ArrayList<Record> searchByLastName(String lastName) {

		// Initialize an ArrayList to be returned
		ArrayList<Record> lastNameList = new ArrayList<Record>();

		// Get corresponding section of the last name
		int letter = getLocation(lastName.charAt(0));

		/*
		 * If the section is empty return an empty ArrayList
		 */
		if (phonebook[letter] == null) {

			return lastNameList;
		}

		Node<Record> current = phonebook[letter].getHead();

		/*
		 * Otherwise loop through that section adding any records with the same
		 * last name.
		 */
		while (current != null) {

			if (current.getValue().getLastName().equalsIgnoreCase(lastName)) {

				lastNameList.add(current.getValue());
			}

			current = current.getNext();
		}

		return lastNameList;
	}

	/**
	 * Returns a record with a particular phone number or null if none is found
	 * 
	 * @param phoneNumber
	 *            the number the record should have
	 * @return the record with the given phone number
	 */
	@Override
	public Record searchByPhoneNumber(String phoneNumber) {

		// Initialize the record to be returned
		Record r = null;

		// For all sections in the phonebook
		for (int i = 0; i < phonebook.length; i++) {

			// If the section is not empty
			if (phonebook[i] != null) {

				/*
				 * Loop through the section and return the record with same
				 * phone number
				 */
				Node<Record> current = phonebook[i].getHead();

				while (current != null) {

					if (current.getValue().getPhoneNumber()
							.equalsIgnoreCase(phoneNumber)) {

						return current.getValue();

					}

					current = current.getNext();
				}
			}

		}

		return r;
	}

	/**
	 * Gets the size of the phone book;
	 * 
	 * @return the size of the phone book
	 */
	@Override
	public int getSize() {

		int size = 0;

		/*
		 * For all sections that are not empty add to the size value
		 */
		for (int i = 0; i < phonebook.length; i++) {

			if (phonebook[i] != null && !phonebook[i].isEmpty()) {

				Node<Record> current = phonebook[i].getHead();

				while (current != null) {

					size++;
					current = current.getNext();
				}
			}
		}

		return size;
	}

	/**
	 * Returns a formatted string of the phone book
	 * 
	 * @return a formatted string of the phone book
	 */
	public String toString() {

		String alphaPhoneBook = "";

		/*
		 * Create an array of the alphabet
		 */
		String[] alphabet = { "A:", "B:", "C:", "D:", "E:", "F:", "G:", "H:",
				"I:", "J:", "K:", "L:", "M:", "N:", "O:", "P:", "Q:", "R:",
				"S:", "T:", "U:", "V:", "W:", "X:", "Y:", "Z:" };

		/*
		 * For all sections in the phone book
		 */
		for (int i = 0; i < phonebook.length; i++) {

			/*
			 * If a section is not empty
			 */
			if (phonebook[i] != null) {

				// write the alphabet letter
				alphaPhoneBook += alphabet[i];

				// then write all the entries in order
				while (phonebook[i].peek() != null) {

					Record current = phonebook[i].remove();
					alphaPhoneBook += "\t" + current.toString() + "\n";
				}

				/*
				 * Otherwise simply write the letter with a tab and go on to the
				 * next letter
				 */
			} else {

				alphaPhoneBook += alphabet[i] + "\t\n";
			}
		}

		return alphaPhoneBook;
	}

}
