/**
 * 
 */
package com.dk.array;

/**
 * Given an array of n integers, find the 3 elements such that a[i] < a[j] <
 * a[k] and i < j < k in 0(n) time. If there are multiple such triplets, then
 * print any one of them.
 * 
 * @author d35kumar
 *
 */
public class Find3Number {

	/**
	 * 
	 */
	public Find3Number() {

	}

	public static void main(String[] args) {
		int arr[] = { 12, 11, 10, 5, 6, 2, 30 };
		findNumbers(arr);
	}

	/**
	 * O ( n ) implementation with extra space O (n)
	 * 
	 * @param a
	 */
	static void findNumbers(int a[]) {
		int smaller[] = new int[a.length];
		int greater[] = new int[a.length];

		smaller[0] = -1; // there is no element in left of first element, which
							// is smaller than it
		int min = 0;
		for (int i = 1; i < a.length; i++) {
			if (a[i] <= a[min]) {
				min = i;
				smaller[i] = -1;
			} else {
				smaller[i] = min;
			}
		}
		int max = a.length - 1;
		greater[a.length - 1] = -1;
		for (int i = a.length - 2; i >= 0; i--) {
			if (a[i] >= a[max]) {
				max = i;
				greater[i] = -1;
			} else {
				greater[i] = max;
			}
		}

		for (int i = 1; i < a.length - 2; i++) {
			if (smaller[i] != -1 && greater[i] != -1) {
				System.out.println("Elements found are " + a[smaller[i]]
						+ " < " + a[i] + " < " + a[greater[i]]);
			}
		}
	}

}
