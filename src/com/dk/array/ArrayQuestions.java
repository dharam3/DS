/**
 * 
 */
package com.dk.array;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author d35kumar
 *
 */
public class ArrayQuestions {
	static Logger l = Logger.getLogger("com.dk.string");

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// Logger l = Logger.getGlobal().getLevel();
		// assert level!=null : level;
		// Logger.getGlobal().setLevel(Level.INFO);
		// Level l = Logger.getGlobal().getLevel();
		// assert l != null : l;
		// List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		// ()-> s

		// int a[][] = { { 1, 2, 3, 4 }, { 0, 5, 2, 6 }, { 4, 7, 3, 0 } };
		// System.out.println("Before");
		// printMatrix(a);
		// System.out.println("\n\n After ");
		// makeZero(a);
		// printMatrix(a);
		// l.log(Level.INFO, "By default Log level was " + l);
		findElementInMatrixTest();

	}

	public static void findElementInMatrixTest() {
		int a[][] = { 	{ 10, 20, 30, 40 }, 
						{ 15, 25, 35, 45 },
						{ 27, 29, 37, 48 }, 
						{ 32, 33, 39, 50 } };

		// for (int i = 0; i < a.length; i++) {
		// for (int j = 0; j < a[0].length; j++) {
		// System.out.print("	" + findElementInMatrix(a, a[i][j]));
		// }
		// System.out.println();
		// }

		System.out.println(findElementInMatrix(a, 35));
	}

	/**
	 * Return position of the element in matrix, if found otherwise -1. Matrix
	 * element are sorted from left to right and top to bottom
	 * 
	 * @param a
	 * @return
	 */
	static int findElementInMatrix(int a[][], int ele) {
		int pos = -1;
		int dimension = a.length;
		int row = 0, column = dimension - 1;
		int iterration = 0;
		while (row < dimension && column >= 0) {
			iterration++;
			int currentEle = a[row][column];
			if (ele == currentEle) {
				pos = row * 10 + column;
				System.out.println("Number of iteration " + iterration);
				break;
			} else {
				// This condition optimize the loop iteration
				// if the element is at bottom left, it will reduce the
				// iteration to half
				if (column > 0 && row < dimension - 1
						&& ele > a[row][column - 1] && ele < a[row + 1][column]) {
					row++;
					column--;
				} else if (ele > currentEle) {
					row++;// move down
				} else {
					column--;// move left
				}
			}
		}
		return pos;
	}

	/**
	 * Write an algorithm such that if an element in an MxN matrix is 0, its
	 * entire row and column is set to 0.
	 */
	public static void makeZero(int a[][]) {
		boolean rowHavingZero[] = new boolean[a.length];
		boolean columnHavingZero[] = new boolean[a[0].length];

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] == 0) {
					rowHavingZero[i] = true;
					columnHavingZero[j] = true;
				}
			}
		}
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (rowHavingZero[i] || columnHavingZero[j]) {
					a[i][j] = 0;
				}
				// else leave the array element as it is
			}
		}
	}

	private static void printMatrix(int a[][]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + "	");
			}
			System.out.println();
		}
	}
}
