package edu.ben.homeworks.homework7;

import java.util.Scanner;
/**
 * 
 * @author ryanhassoun
 * @version 1.0
 */

public class Homework7 {
	/**
	 * Private Constructor
	 */
	private Homework7() {

	}
	/**
	 * Main Method
	 * 
	 * @param args
	 *            args = The Output is the values
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter a list: ");
		int length = input.nextInt();

		int[] list = new int[length];

		for (int i = 0; i < list.length; i++) {
			list[i] = input.nextInt();
			
		}
		partition(list);
		/**
		 * Final output
		 */
		System.out.print("After the partition, the list is ");
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
		input.close();

	}
/**
 * 
 * @param list
 *       List array entered
 * @return
 *      partition 
 */
	public static int partition(int[] list) {
		int pivot = list[0];
		int i = 1;
		int j = list.length - 1;

		while (i < j) {
			if (list[i] > pivot) {
				if (list[j] <= pivot) {
					int part = list[i];
					list[i] = list[j];
					list[j] = part;
					j--;
				} 
				else {
					j--;
					i--;
				}
			}
			i++;
		}
		int part = pivot;
		list[0] = list[i - 1];
		list[i - 1] = part;

		return pivot;
	}

}
