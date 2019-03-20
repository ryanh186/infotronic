package edu.ben.labs.lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * 
 * @author ryanhassoun
 * @version 1.0
 */
public class CargoLoader {
	
	/**
	 * Formats the manifest according to description
	 * 
	 * @param airport
	 *            the ArrayList of airplanes
	 * @param unloaded
	 *            the stack of unloaded cargo
	 * @return a single string containing the manifest
	 */
	public static String manifest(ArrayList<Airplane> airport,
			Stack<Cargo> unloaded) {

		String manifest = "********** CARGO MANIFEST **********";

		for (int i = 0; i < airport.size(); i++) {

			manifest += "\nFlight #" + airport.get(i).getFlightNumber()
					+ " Cargo: "
					+ (airport.get(i).getCapacity()
							- airport.get(i).getRemainingSpace())
					+ "/" + airport.get(i).getCapacity() + " cu/ft. "
					+ (airport.get(i).getWeightLimit()
							- airport.get(i).getRemainingWeight() + "/"
							+ airport.get(i).getWeightLimit() + " lbs.\n");
			manifest += "CARGO DETAILS:\n";

			if (airport.get(i).storage.isEmpty()) {

				manifest += "\tNO CARGO\n";
			} else {

				Stack<Cargo> tempStorage = new Stack<Cargo>();

				while (!airport.get(i).storage.isEmpty()) {

					tempStorage.push(airport.get(i).storage.pop());
				}

				while (!tempStorage.isEmpty()) {

					Cargo tempCargo = tempStorage.pop();
					manifest += "\t#" + tempCargo.getTrackingNum() + ", ";
					manifest += tempCargo.getSize() + " cu/ft., ";
					manifest += tempCargo.getWeight() + " lbs. ";
					manifest += "$" + tempCargo.getValue() + "\n";
				}
			}
		}

		manifest += "\nUnable to load the following cargo on any available aircraft: \n";

		Stack<Cargo> orderedUnloaded = new Stack<Cargo>();

		while (!unloaded.isEmpty()) {

			orderedUnloaded.push(unloaded.pop());
		}

		while (!orderedUnloaded.isEmpty()) {

			Cargo tempCargo = orderedUnloaded.pop();

			manifest += "\t#" + tempCargo.getTrackingNum() + ", ";
			manifest += tempCargo.getSize() + " cu/ft., ";
			manifest += tempCargo.getWeight() + " lbs. ";
			manifest += "$" + tempCargo.getValue();

			manifest += "\n";

		}

		return manifest;
	}

	/**
	 * Loads cargo on plane
	 * 
	 * @param aircraftLog
	 *            file
	 * @param cargoLog
	 *            file
	 */
	public static void loadCargo(File aircraftLog, File cargoLog) {
		ArrayList<Airplane> loadingDock = readAircraftLog(aircraftLog);
		MyQueue cargoStorage = readCargoLog(cargoLog);
		Stack<Cargo> unloaded = new Stack<Cargo>();

		while (!cargoStorage.isEmpty()) {

			int count = 0;

			while (count < loadingDock.size()) {

				while (!cargoStorage.isEmpty() && loadingDock.get(count)
						.getRemainingSpace() >= cargoStorage.peek().getSize()
						&& loadingDock.get(count)
								.getRemainingWeight() >= cargoStorage.peek()
										.getWeight()) {

					loadingDock.get(count).storage.push(cargoStorage.dequeue());
					Cargo[] c = new Cargo[loadingDock.get(count).storage
							.size()];

					for (int i = 0; i < c.length; i++) {
						c[i] = loadingDock.get(count).storage.pop();
					}

					Stack<Cargo> ordered = orderCargo(c);
					loadingDock.get(count).storage = ordered;
					count = 0;
				}

				count++;
			}

			if (!cargoStorage.isEmpty()) {

				unloaded.push(cargoStorage.dequeue());
			}
		}

		// Final Print
		System.out.println(manifest(loadingDock, unloaded));
	}

	/**
	 * Orders cargo
	 * 
	 * @param x
	 *            the array of cargo
	 * @return cargo stack
	 */
	public static Stack<Cargo> orderCargo(Cargo[] x) {

		int position;
		Cargo temp;

		for (int i = 0; i < x.length - 1; i++) {

			position = i;

			for (int j = i + 1; j < x.length; j++) {

				if (x[j].getWeight() < x[position].getWeight()) {

					position = j;
				}

			}

			temp = x[i];
			x[i] = x[position];
			x[position] = temp;
		}

		Stack<Cargo> ordered = new Stack<Cargo>();
		for (int i = 0; i < x.length; i++) {
			ordered.push(x[i]);
		}

		return ordered;
	}

	/**
	 * creates an ArrayList of airplanes
	 * 
	 * @param aircraft
	 *            the file containing the airplanes
	 * @return ArrayList of airplanes
	 */
	public static ArrayList<Airplane> readAircraftLog(File aircraft) {

		ArrayList<Airplane> loadingDock = new ArrayList<Airplane>(0);

		try {
			Scanner airplaneInput = new Scanner(aircraft);

			airplaneInput.nextLine();

			while (airplaneInput.hasNextLine()) {

				String[] planeInputString = airplaneInput.nextLine().split(",");

				for (int i = 0; i < planeInputString.length; i++) {

					String parsed = "";

					for (int j = 0; j < planeInputString[i].length(); j++) {

						if (Character.isDigit(planeInputString[i].charAt(j))) {

							parsed += planeInputString[i].charAt(j);
						}
					}

					planeInputString[i] = parsed;
				}

				int[] planeInputInt = new int[planeInputString.length];

				for (int i = 0; i < planeInputInt.length; i++) {

					planeInputInt[i] = Integer.parseInt(planeInputString[i]);
				}

				Airplane currentPlane = new Airplane(planeInputInt[0],
						planeInputInt[1], planeInputInt[2], planeInputInt[3]);

				loadingDock.add(currentPlane);
			}

			airplaneInput.close();
		} catch (FileNotFoundException e) {

			System.out.println("Airplane File Not Found");
		}

		return loadingDock;
	}

	/**
	 * creates a queue of cargo
	 * 
	 * @param cargo
	 *            cargo file
	 * @return a queue of cargo
	 */
	public static MyQueue readCargoLog(File cargo) {
		MyQueue cargoOrder = new MyQueue();
		try {
			Scanner cargoInput = new Scanner(cargo);
			cargoInput.nextLine();

			while (cargoInput.hasNextLine()) {
				String[] cargoInputString = cargoInput.nextLine().split(",");

				for (int i = 0; i < cargoInputString.length; i++) {

					String remove = "";

					for (int j = 0; j < cargoInputString[i].length(); j++) {

						if (Character.isDigit(cargoInputString[i].charAt(j))) {

							remove += cargoInputString[i].charAt(j);
						}
					}

					cargoInputString[i] = remove;
				}

				int[] cargoInputInt = new int[cargoInputString.length];

				for (int i = 0; i < cargoInputInt.length; i++) {

					cargoInputInt[i] = Integer.parseInt(cargoInputString[i]);
				}

				Cargo currentCargo = new Cargo(cargoInputInt[0],
						cargoInputInt[1], cargoInputInt[2], cargoInputInt[3]);

				cargoOrder.enqueue(currentCargo);
			}

			cargoInput.close();

		} catch (FileNotFoundException e) {

			System.out.println("Cargo file not found");
		}

		return cargoOrder;
	}
}