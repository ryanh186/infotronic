package edu.ben.homeworks.homework9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author ryanhassoun
 *@version 1.0
 */
public class Homework9 {
	/**
	 * private constructor
	 */
	private Homework9() {
		//savage
	}
		
	/**
	 * Transcript
	 */
	private static File f = new File(
			"/Applications/College/CMSC205/CMSC205/lib/monkey");
/**
 * Main tester
 * @param args
 * 		param
 * @throws FileNotFoundException
 * 		throws
 */
	public static void main(String[] args) throws FileNotFoundException {

		processTranscript(f);
	}

/**
 * Transcript of monkeys
 * @param file
 * 		transcript
 * @throws FileNotFoundException
 * 		if file not found
 */
	public static void processTranscript(File file)
			throws FileNotFoundException {
		int i = 0;
		String[] monkeys = new String[25];
		ArrayList<String> spies = new ArrayList<String>();

		try {
			@SuppressWarnings("resource")
			Scanner data = new Scanner(file);

			while (data.hasNextLine()) {
				String s = data.nextLine();
				String[] splited = s.split(":");
				if (splited[0].equals("OMEGA")) {

					break;
				}

				if (isSentence(splited[1])) {
					monkeys[i++] = splited[0];
				} else {
					

					if (!spies.contains(splited[0])) {
						spies.add(splited[0]);
					}
				}
			}

			for (int p = 0; p < spies.size(); p++) {

				if (!spies.contains(null)) {

					System.out.println(spies.get(p));
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("Can't Find file!");
		}

	}
/**
 * Sentence
 * @param s
 * 		String
 * @return
 * 		boolean
 */
	public static boolean isSentence(String s) {
		String[] allWords = s.split(" ");
		String restWords = "";
		String lastWord = "";

		if (allWords.length == 1) {

			return isWord(s);
		} else {

			lastWord = allWords[allWords.length - 1];

			for (int i = 0; i < allWords.length - 1; i++) {

				restWords += allWords[i] + " ";
			}

		}

		restWords = restWords.trim();
		lastWord = lastWord.trim();
		return isSentence(restWords) && isWord(lastWord);

	}
	/**
	 * Word
	 * @param s
	 * 		String
	 * @return
	 * 		boolean
	 */
	public static boolean isWord(String s) {

		int syllables = 0;
		s = s.trim();

		while (s.length() > 0) {

			if (s.length() <= 4 && s.length() > 1) {

				if (isSyllable(s)) {

					syllables++;
					s = s.substring(s.length());
				} else if (isSyllable(s.substring(0, 2))) {

					syllables++;
					s = s.substring(2);
				} else {

					return false;
				}
			} else if (s.length() >= 5) {

				if (isSyllable(s.substring(0, 4))) {

					syllables++;
					s = s.substring(4);

				} else if (isSyllable(s.substring(0, 3))) {

					syllables++;
					s = s.substring(3);

				} else if (isSyllable(s.substring(0, 2))) {

					syllables++;
					s = s.substring(2);
				}
			} else {

				return false;
			}
		}

		return syllables % 2 != 0;
	}
	/**
	 * Syllable
	 * @param s
	 * 		String
	 * @return
	 * 		boolean
	 */
	public static boolean isSyllable(String s) {
		return s.equals("cbab") || s.equals("cbad") || s.equals("cdad")
				|| s.equals("cdab") || s.equals("acda") || s.equals("acba")
				|| s.equals("ad") || s.equals("ab") || isPlosive(s);

	}
	/**
	 * Plosive
	 * @param s
	 * 		String
	 * @return
	 * 		boolean
	 */
	public static boolean isPlosive(String s) {
		return isStop(s);

	}
	/**
	 * Stop
	 * @param s
	 * 		String
	 * @return
	 * 		boolean
	 */
	public static boolean isStop(String s) {
		return s.equals("cda") || s.equals("cba");

	}


}
