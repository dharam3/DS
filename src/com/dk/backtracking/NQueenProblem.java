/**
 * 
 */
package com.dk.backtracking;

/**
 * @author d35kumar
 *
 */
public class NQueenProblem {

	private static final int NUMBER = 5;
	/**
	 * If any index of this array is having non-negative value, it means queen
	 * is placed at that position
	 */
	int[] board = new int[NUMBER];

	NQueenProblem() {
		for (int i = 0; i < NUMBER; i++) {
			board[i] = -1;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NQueenProblem problem = new NQueenProblem();
		// means try to put the queen in first row
		problem.putQueen(0);
	}

	/**
	 * Try to put the queen at kth position
	 * 
	 * @param k
	 * @param n
	 */
	public void putQueen(int k) {
		for (int i = 0; i < NUMBER; i++) {
			if (canPlace(k, i)) {
				board[k] = i;// this means we are marking on board that a queen
								// has been placed at kth row
								// and ith column
				if (k == NUMBER - 1) {
					// it means we have placed all NUMBER of queens on
					// NUMBERXNUMBER board
					// and so let's print the result
					printBoard();
				} else {
					// System.out.println("Calling for k "+k);
					putQueen(k + 1);
				}
			}
		}
	}

	/**
	 * 11 12 13 14<br>
	 * 21 22 23 24<br>
	 * 31 32 33 34<br>
	 * 41 42 43 44<br>
	 * 
	 * Returns true if queen can be placed at kth row and ith column
	 * 
	 * @param k
	 * @param i
	 * @return
	 */
	public boolean canPlace(int k, int i) {
		// till k only because, only till here queen has been placed
		for (int j = 0; j < k; j++) {
			// first condition is for if there is already any queen placed in
			// same column
			// we should also check if there is already any queen placed in same
			// row but since we are already running loop before k so no need to
			// do that
			// 2nd condition is to check if the absolute diff between row and
			// coloumn is same or not
			// if that is case it means, at any diagonal positon, there is
			// already a queen
			if (board[j] == i || Math.abs(j - k) == Math.abs(board[j] - i))
				return false;
		}
		return true;
	}

	/************************* UTILITY function to print the array ***********************************/
	static int count = 1;

	void printBoard() {
		System.out
				.println("Following are positions where queen can be placed solution#"
						+ count++);
		for (int i = 0; i < NUMBER; i++) {
			for (int j = 0; j < NUMBER; j++) {
				if (board[i] == j)
					System.out.print(1);
				else
					System.out.print(0);
				System.out.print("  ");
			}
			System.out.println();
		}
	}
}
