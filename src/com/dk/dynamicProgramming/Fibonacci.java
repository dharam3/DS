/**
 * 
 */
package com.dk.dynamicProgramming;

/**
 * This is to experience the time taken to calculate the 100th fibonacci number
 * by different implementation
 * 
 * @author d35kumar
 *
 */
public class Fibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int number = 40;
		long startTime = System.nanoTime();
		// int fib = topDownApproach(40, new int[41]);
		int fib = efficientOne(40);
		long timeTaken = System.nanoTime() - startTime;

		System.out.println("Time to calculate fibnacci of " + number + " is "
				+ timeTaken + "  Caclulated value is " + fib);
	}

	/**
	 * Time to calculate fibonacci of 40 is 700441860 Calculated value is
	 * 102334155
	 * 
	 * @param n
	 * @return
	 */
	public static int getFibonacciNumber(int n) {
		if (n < 2)
			return n;
		return getFibonacciNumber(n - 1) + getFibonacciNumber(n - 2);
	}

	/**
	 * Tabulization( bottom up approach ) taking<br>
	 * Time taken to calculate fibonacci of 40 is 5527 nanosecond by this
	 * function
	 * 
	 * @param n
	 * @return
	 */
	public static int bottomUp(int n) {
		int tab[] = new int[n + 1];
		tab[0] = 0;
		tab[1] = 1;
		for (int i = 2; i <= n; i++) {
			tab[i] = tab[i - 1] + tab[i - 2];
		}
		return tab[n];
	}

	/**
	 * Time taken to calculate fibonacci of 40 is 10658 nanosecond by this
	 * function
	 * 
	 * @param n
	 * @param table
	 * @return
	 */
	public static int topDownApproach(int n, int table[]) {
		if (n < 2)
			return n;
		if (table[n] != 0) {
			return table[n];
		} else {
			table[n] = topDownApproach(n - 1, table)
					+ topDownApproach(n - 2, table);
		}

		return table[n];
	}

	/**
	 * Most efficient calculation of Fibonacci number
	 * 
	 * Time taken to calculate fibonacci of 40 is 2763 nanosecond by this
	 * function
	 * 
	 * @param n
	 * @return
	 */
	public static int efficientOne(int n) {
		if (n < 2)
			return n;
		int prevPrev = 0;
		int prev = 1;
		int fib = 0;
		for (int i = 2; i <= n; i++) {
			fib = prev + prevPrev;
			prevPrev = prev;
			prev = fib;
		}
		return fib;
	}

}
