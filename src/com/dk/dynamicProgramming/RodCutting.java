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
		System.out.println(maxValue(arr));
		// int v=2;
		// v+=v++;
		// System.out.println(v);

	}

	/**
	 * @param price
	 * @return
	 */
	static int maxValue(int[] price) {
		int NUMBER = price.length;
		int[] value = new int[NUMBER + 1];

		for (int i = 1; i <= NUMBER; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				max = Math.max(max, price[j] + value[i - j - 1]);
			}
			// value at index i in this array says that for rod of length i,
			// this is maximum revenue that can be generated.
			// it just calculates the value, doesn't give any detail about how
			// to cut it.
			value[i] = max;
		}

		return value[NUMBER];
	}
}
