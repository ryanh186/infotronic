package edu.ben.labs.lab6;

import java.util.Formatter;
/**
 * 
 * @author ryanhassoun
 * @version 1.0
 *
 */
public class Record implements Comparable<Object> {
/**
 * public constructor
 */
	public Record() {
		// TODO Auto-generated constructor stub
	}
/**
 * first name
 */
	public String firstName;
/**
 * last name
 */
	public String lastName;
/**
 * phone number
 */
	public String phoneNumber;
/**
 * 
 * @param firstName
 * 			fn
 * @param lastName
 * 			ln
 * @param phoneNumber
 * 			phone #
 */
	public Record(String firstName, String lastName, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}
/**
 * first name
 * @return
 * 		fn
 */
	@SuppressWarnings("unused")
	public String getFirstName() {
		return firstName;
	}
/**
 * First name
 * @param firstName
 * 			fn
 */
	@SuppressWarnings("unused")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
/**
 * last name
 * @return
 * 		ln
 */
	@SuppressWarnings("unused")
	public String getLastName() {
		return lastName;
	}
/**
 * Last name
 * @param lastName
 * 		ln
 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
/**
 * phone number
 * @return
 * 		phone #
 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
/**
 * phone number
 * @param phoneNumber
 * 		phone #
 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
/**
 * Prints to string
 * @return
 * 		string
 */
	public String toString() {

		Formatter f = new Formatter();

		/*
		 * Putting phone number in standard format
		 */
		String phoneNumberEdit = "";
		phoneNumberEdit += "(" + phoneNumber.substring(0, 3) + ") " + phoneNumber.substring(3, 6) + "-"
				+ phoneNumber.substring(6);

		String name = lastName + ", " + firstName;

		/*
		 * Set column width to 19 and right align the name
		 */

		String record = f.format("%20s", name) + "\t" + phoneNumberEdit;
		f.close();
		return record;
	}
/**
 * Compares obj
 * @param o
 * 		object
 * @return
 * 	record
 */
	public int compareTo(Object o) {

		Record two = (Record) o;

		if (this.lastName.equals(two.lastName)) {

			return this.firstName.compareTo(two.firstName);
		} else {

			return this.lastName.compareTo(two.lastName);
		}

	}
/**
 * equals to obj
 * @param obj
 *     obj
 *     @return
 *     boolean
 */
	public boolean equals(Object obj) {

		Record o = null;

		if (obj instanceof Record) {

			o = (Record) obj;
		}

		return this.firstName.equals(o.firstName) && this.lastName.equals(o.lastName)
				&& this.phoneNumber.equals(o.phoneNumber);
	}

}
