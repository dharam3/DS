/**
 * 
 */
package com.dk.array;

/**
 * @author d35kumar
 *
 */
public class PrintSpiralMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int a[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		// print(a);
		printThreadProperty();

	}

	private static void printThreadProperty() {

		Thread thread = Thread.currentThread();
		long id = thread.getId();
		int priority = thread.getPriority();
		String name = thread.getName();
		String groupName = thread.getThreadGroup().getName();
		String state = thread.getState().name();

		System.out.println("\nid: " + id + " \nPriority " + priority
				+ " \nName : " + name + "\nGroupName: " + groupName
				+ "\nState: " + state);
	}

	/**
	 * 1 2 3 4 <br>
	 * 5 6 7 8<br>
	 * 9 10 11 12<br>
	 * 
	 * 13 14 15 16
	 * 
	 * @param a
	 */
	public static void print(int a[][]) {
		int startRowIndex = 0, startColumnIndex = 0;
		int endRwoIndex = a.length, endColumnIndex = a[0].length;
		int index;

		while (startRowIndex < endRwoIndex && startColumnIndex < endColumnIndex) {
			// Print top row, row-Constant and column varying
			// This prints all element of remaining top row
			for (index = startColumnIndex; index < endColumnIndex; ++index) {
				System.out.print("  " + a[startRowIndex][index]);
			}
			startRowIndex++;
			// print last column, row varying, column Constant
			// this prints all element of remaining last column, except first
			// element which is already printed in above loop
			for (index = startRowIndex; index < endRwoIndex; ++index) {
				System.out.print("  " + a[index][endColumnIndex - 1]);
			}
			// we are done with last column so decrement the column index
			endColumnIndex--;
			// print the last remaining row
			// row-constant and column should vary
			if (startRowIndex < endRwoIndex) {
				for (index = endColumnIndex - 1; index >= startColumnIndex; --index) {
					System.out.print("  " + a[endRwoIndex - 1][index]);
				}
				endRwoIndex--;
			}
			// print the started remaining columns
			// row vary, column Constant
			if (startColumnIndex < endColumnIndex) {
				for (index = endRwoIndex - 1; index >= startRowIndex; --index) {
					System.out.print("  " + a[index][startColumnIndex]);
				}
				startColumnIndex++;
			}

		}

	}
}
