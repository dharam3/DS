/**
 * 
 */
package com.dk.array;

import java.util.Arrays;

/**
 * An array contains both positive and negative numbers in random order.
 * Rearrange the array elements so that positive and negative numbers are placed
 * alternatively. Number of positive and negative numbers need not be equal. If
 * there are more positive numbers they appear at the end of the array. If there
 * are more negative numbers, they too appear in the end of the array.
 * 
 * For example, if the input array is [-1, 2, -3, 4, 5, 6, -7, 8, 9], then the
 * output should be [9, -7, 8, -3, 5, -1, 2, 4, 6]
 * 
 * @author d35kumar
 *
 */
public class RearrangePositiveNegativeNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = { -1, 2, -3, 4, 5, 6, -7, 8, 9 };
		reArrange(a);
		System.out.println(Arrays.toString(a));
	}

	public static void reArrange(int a[]) {
		int j = -1;
		for (int i = 0; i < a.length; i++) {
			if (a[i] < 0) {
				j++;
				swap(a, i, j);
			}
		}
		int pos = j + 1, neg = 0;
		while (pos < a.length && neg < a.length && a[neg] < 0) {
			swap(a, neg, pos);
			pos++;
			neg += 2;
		}
	}

	private static void swap(int[] a, int m, int n) {
		if (m == n)
			return;
		a[m] = a[m] ^ a[n];
		a[n] = a[m] ^ a[n];
		a[m] = a[m] ^ a[n];
	}
}
