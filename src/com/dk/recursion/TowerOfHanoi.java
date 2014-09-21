/**
 * 
 */
package com.dk.recursion;

/**
 * @author d35kumar
 *
 */
public class TowerOfHanoi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TOW(10, 'S', 'A', 'D');

	}

	/**
	 * @param n
	 *            No of disc
	 * @param s
	 *            start rod
	 * @param a
	 *            Auxiliary rod
	 * @param d
	 *            destination rod
	 */
	public static void TOW(int n, char s, char a, char d) {
		if (n == 1) {
			System.out.println("Moving disc " + n + " from " + s + " to " + d);
			return;
		}

		TOW(n - 1, s, d, a);
		System.out.println("Moving disc " + n + " from " + s + " to " + d);
		TOW(n - 1, a, s, d);

	}

}
