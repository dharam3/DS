/**
 * 
 */
package com.dk.sorting;

import java.util.Arrays;

/**
 * @author d35kumar
 *
 */
public class CountingSort {

	/**
	 * 
	 */
	public CountingSort() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = { 2, 5, 3, 1, 4, 6, 8, 7 };
		System.out.println("Input array " + Arrays.toString(input));
		int[] output = sort(input, 8);
		System.out.println(Arrays.toString(output));
	}

	/**
	 * @param a
	 * @param k
	 *            All elements are less or equal to this element
	 * @return
	 */
	static int[] sort(int[] a, int k) {
		int auxiallary[] = new int[k + 1];
		int[] output = new int[a.length];

		for (int element : a) {
			auxiallary[element] += 1;
		}

		for (int i = 1; i <= k; i++) {
			auxiallary[i] += auxiallary[i - 1];
		}
		for (int i = a.length - 1; i >= 0; i--) {
			output[auxiallary[a[i]] - 1] = a[i];
			// auxiallary[a[i]] = auxiallary[a[i]] - 1;
			auxiallary[a[i]]--;
		}
		return output;
	}

}
