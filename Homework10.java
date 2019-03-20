package edu.ben.homeworks.homework10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 
 * @author ryanhassoun
 * @version 1.0
 *
 */
public class Homework10 {
	


	/**
	 * Iteration coin pile program
	 * 
	 * @param args
	 *            args
	 */
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String answer = scan.nextLine();
		int piles = Integer.parseInt(answer);

		while (piles > 0) {

			ArrayList<Integer> cpiles = new ArrayList<Integer>(piles);

			
			String[] coinS = scan.nextLine().split(" ");

			int totalCoins = 0;

			for (int i = 0; i < piles; i++) {

				if (Integer.parseInt(coinS[i]) != 0) {

					cpiles.add(Integer.parseInt(coinS[i]));
				}
			}

			for (int i = 0; i < cpiles.size(); i++) {

				totalCoins += cpiles.get(i);
			}
			if (isTriangleNumber(totalCoins)) {

				int iterations = 0;

				
				while (!isInOrder(cpiles)) {

				
					int newPile = 0;

					for (int i = 0; i < cpiles.size(); i++) {

						if (cpiles.get(i) > 0) {

							newPile++;
						}

					
						cpiles.set(i, cpiles.get(i) - 1);

						
						if (cpiles.get(i) == 0) {

							cpiles.remove(i);
							i--;
						}
					}

				
					cpiles.add(newPile);
					iterations++;

				
					Collections.sort(cpiles);
				}


				System.out.println(iterations + " iterations");
			} else {

				System.out.println(totalCoins + " is not a triangular number");
			}


			String input = scan.nextLine();
			piles = Integer.parseInt(input);
		}

		scan.close();
	}

	/**
	 * the quadratic method to solve.
	 * 
	 * @param num
	 *            the number
	 * @return true/false
	 */
	public static boolean isTriangleNumber(int num) {

		// Use positive quadratic formula

		if (num >= 1) {

			double answer = num;

			answer *= 2;

			answer = (-1 + Math.sqrt(1 + (4 * answer))) / 2;

			return Math.floor(answer) == answer;
		} else {

			return false;
		}
	}

	/**
	 * Determines if an ArrayList of integers isInOrder and begins with 1. 
	 * @param array
	 *            the list
	 * @return boolean
	 */
	public static boolean isInOrder(ArrayList<Integer> array) {

		boolean inOrder = false;

		if (array.size() == 1 && array.get(0) == 1) {

			return true;
		}

		for (int i = 0; i < array.size(); i++) {

			if (i != array.size() - 1) {

				if (array.get(i + 1) == array.get(i) + 1) {

					inOrder = true;
				} else {

					return false;
				}
			}
		}

		if (!array.isEmpty() && array.get(0) == 1) {

			return inOrder;
		} else {

			return false;
		}
	}

}
