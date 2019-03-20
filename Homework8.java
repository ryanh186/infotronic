package edu.ben.homeworks.homework8;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 
 * @author ryanhassoun
 * @version 1.0
 */
public class Homework8 {
	/**
	 * prevents error
	 */
	private Homework8() {
		// this code is to stop the cat of the web
	}

	/**
	 * This a local linked list
	 */
	private static LinkedList<Integer> llist;

	/**
	 * main method
	 * 
	 * @param args
	 *            required for main method
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		LinkedList<Integer> list = new LinkedList<Integer>();
		int i = 0;
		System.out.print("Enter numbers: ");
		String num = input.nextLine();
		String[] numlist = num.split(" ");
		int[] convert = new int[numlist.length];
		for (int l = 0; l < numlist.length; l++) {
			convert[l] = Integer.parseInt(numlist[l]);
		}
		for (int k = 0; k < convert.length; k++) {
			list.add(convert[k]);
		}
		llist = list;
		menu();
		int temp = input.nextInt();
		while (i == 0) {
			switch (temp) {
			case 1:
				sortListAscending();
				break;
			case 2:
				sortListDescending();
				break;
			case 3:
				String y = displayList();
				System.out.println(y);
				break;
			case 4:
				removeLargestValue();
				break;
			case 5:
				removeSmallestValue();
				break;
			case 6:
				i = 1;
				break;
			default :
            		break;
			}
			
			if (i == 0) {
				menu();

			}
			if (i == 0) {
				temp = input.nextInt();
			}

		}
		input.close();
	}

	/**
	 * sorts linked list in ascending order
	 */
	private static void sortListAscending() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		Object[] y = llist.toArray();
		Arrays.sort(y);
		for (int x = 0; x < y.length; x++) {
			list.add((Integer) y[x]);
		}
		llist = list;
	}

	/**
	 * sorts linked list in descending order
	 */
	private static void sortListDescending() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		Object[] y = llist.toArray();
		Object[] x = new Object[y.length];
		Arrays.sort(y);
		int a = 0;
		for (int z = y.length - 1; z >= 0; z--) {
			x[a] = y[z];
			a++;
		}
		for (int b = 0; b < y.length; b++) {
			list.add((Integer) x[b]);
		}
		llist = list;
	}

	/**
	 * turns linked list into string
	 * 
	 * @return string of linked list
	 */
	public static String displayList() {
		Object[] y = llist.toArray();
		String x = Arrays.toString(y);
		return x;
	}

	/**
	 * removes largest value
	 */
	private static void removeLargestValue() {
		if (llist.size() != 0) {
			Object[] y = llist.toArray();
			Arrays.sort(y);
			llist.remove(y[y.length - 1]);
		}
	}

	/**
	 * removes smallest value
	 */
	private static void removeSmallestValue() {
		if (llist.size() != 0) {
			Object[] y = llist.toArray();
			Arrays.sort(y);
			llist.remove(y[0]);
		}
	}

	/**
	 * Prints a menu
	 */
	public static void menu() {
		System.out.println("1. Sort List Ascending");
		System.out.println("2. Sort List Descending");
		System.out.println("3. Display List");
		System.out.println("4. Remove Largest value");
		System.out.println("5. Remove Smallest value");
		System.out.println("6. Exit");
		System.out.print("");

	}
}
