package labs;


import java.util.Scanner;
/**
 * 
 * @author ryanhassoun
 * @version 1
 */
public class Lab5 {
	
	private Lab5() {
		board = new char[3][3];
		currentPlayerMark = 'X';
		initializeBoard();

	}
	static char[][] board;
	static char currentPlayerMark;
	static boolean temp = true;
/**
 * Main method
 * @param args
 * 		  args is the parameter
 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Lab5 game = new Lab5();

		int test = 0;
		game.printBoard();
		while (test == 0) {

			System.out.print("Enter a row for player " + currentPlayerMark + ": ");
			int row = input.nextInt();
			System.out.print("Enter a column for player " + currentPlayerMark + ": ");
			int col = input.nextInt();
			game.placeMark(row, col);
			if (temp == false) {
				System.out.print("Enter a row for player " + currentPlayerMark + ": ");
				row = input.nextInt();
				System.out.print("Enter a column for player " + currentPlayerMark + ": ");
				col = input.nextInt();
				game.placeMark(row, col);
			}

			game.printBoard();

			if (game.checkWin()) {
				System.out.print(currentPlayerMark + " player won");
				System.exit(0);
			} else if (game.isBoardFull()) {
				System.out.println("Appears we have a draw!");
				System.exit(0);
			}
			if (currentPlayerMark == 'X') {
				currentPlayerMark = 'O';
			} else {
				currentPlayerMark = 'X';
			}

		}
		input.close();

	}
/**
 * Main hub
 */
	
/**
 * Initialized Board
 */
	public static void initializeBoard() {

		// Loop through rows
		for (int i = 0; i < 3; i++) {

			// Loop through columns
			for (int j = 0; j < 3; j++) {
				board[i][j] = ' ';
			}
		}
	}
/**
 * Checks the board for spaces
 * @return
 * 		If the board is full
 */
	public boolean isBoardFull() {
		boolean isFull = true;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == ' ') {
					isFull = false;
				}
			}
		}

		return isFull;
	}
/**
 * Prints the board
 */
	public void printBoard() {
		System.out.println("-------------");

		for (int i = 0; i < 3; i++) {
			System.out.print("| ");
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			System.out.println("-------------");
		}
	}
/**
 * Places the marker
 * @param row
 * 			Per row
 * @param col
 * 			per col
 * @return
 * 			Sets the marker
 */
	public boolean placeMark(int row, int col) {

		if ((row >= 0) && (row < 3)) {
			if ((col >= 0) && (col < 3)) {
				if (board[row][col] == ' ') {
					board[row][col] = currentPlayerMark;
					temp = true;
					return true;
				} else {
					System.out.println("This cell is already occupied. Try a different cell");
					temp = false;
				}

			}
		}
		return false;
	}
/**
 * Checks if won
 * @return
 * 		returns if won or not
 */
	public boolean checkWin() {
		return (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin());
	}
/**
 * Checks row for win
 * @return
 * 		if row won
 */
	public static boolean checkRowsForWin() {
		for (int i = 0; i < 3; i++) {
			if (checkRowCol(board[i][0], board[i][1], board[i][2]) == true) {
				return true;
			}
		}
		return false;
	}
/**
 * checks col for win
 * @return
 * 		if col won
 */
	public static boolean checkColumnsForWin() {
		for (int i = 0; i < 3; i++) {
			if (checkRowCol(board[0][i], board[1][i], board[2][i]) == true) {
				return true;
			}
		}
		return false;

	}
/**
 * Checks diagonal for win
 * @return
 * 		if diagonal won
 */
	public static boolean checkDiagonalsForWin() {
		return ((checkRowCol(board[0][0], board[1][1], board[2][2]) == true)
				|| (checkRowCol(board[0][2], board[1][1], board[2][0]) == true));
	}
/**
 * Checks each row
 * @param c1
 * 		row in col 1
 * @param c2
 * 		row in col 2
 * @param c3
 * 		row in col 3
 * @return
 * 		checked row
 */
	public static boolean checkRowCol(char c1, char c2, char c3) {
		return ((c1 != ' ') && (c1 == c2) && (c2 == c3));
	}
/**
 * end
 */
}