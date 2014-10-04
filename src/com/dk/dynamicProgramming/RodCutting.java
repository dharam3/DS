/**
 * 
 */
package com.dk.dynamicProgramming;

/**
 * Given a rod of length n inches and an array of prices that contains prices of
 * all pieces of size smaller than n. Determine the maximum value obtainable by
 * cutting up the rod and selling the pieces. For example, if length of the rod
 * is 8 and the values of different pieces are given as following, then the
 * maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
 * 
 * 
 * length | 1 2 3 4 5 6 7 8 <br>
 * --------------------------------------------<br>
 * price | 1 5 8 9 10 17 17 20<br>
 * 
 * And if the prices are as following, then the maximum obtainable value is 24
 * (by cutting in eight pieces of length 1)<br>
 * 
 * length | 1 2 3 4 5 6 7 8 <br>
 * --------------------------------------------<br>
 * price | 3 5 8 9 10 17 17 20<br>
 * 
 * @author d35kumar
 *
 */
public class RodCutting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
		maxValue(arr);
		// int v=2;
		// v+=v++;
		// System.out.println(v);

	}

	/**
	 * @param price
	 *            array of price of each length rod
	 */
	static void maxValue(int[] price) {
		int NUMBER = price.length;
		// This is to store the value, which can be achieved for particular length of rod.
		// value[1] says max revenue which, can be generated from length of rod 1
		// value[2] says max revenue which can be generated from length of rod 2 and so on,
		// note that for 0 length it is 0, as we can't generate from 0 length rod
		int[] value = new int[NUMBER + 1];
		// This array store the length of the rod, which should be first cut.
		// e.g. for length 1, it will store 1, as there is no cut required
		// for length 2, it will store 2, if there is not required to gain the maximum values
		// or 1, if it requires cut in 1 and 1 size and so on 
		int[] solution = new int[NUMBER + 1];
		// calculate the optimum solution for each length one by one 
		// first for length 1, and then for 2, and so on.
		// we will using previous calculated value for less size length 
		for (int i = 1; i <= NUMBER; i++) {
			// initialize maximum value, that can be achieved with Integer.MIN_VALUE
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++) {
				// price[0] means price of rod length 1, price of[1] means price of length 2 and so on 
				if (max < (price[j] + value[i - j - 1])) {
					max = price[j] + value[i - j - 1];
					solution[i] = j + 1;
				}
			}
			// value at index i in this array says that for rod of length i,
			// this is maximum revenue that can be generated.
			value[i] = max;

		}
		int n = NUMBER;
		System.out.println("Cut rod into ");
		while (n > 0) {
			System.out.print(solution[n] + "  ");
			n = n - solution[n];
		}
		System.out.println("\nMaximum output that can be achieved is "
				+ value[NUMBER]);
//		return value[NUMBER];
	}
}
