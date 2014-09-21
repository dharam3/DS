/**
 * 
 */
package com.dk.sorting.problem;

/**
 * Merge two sorted arrays of size m+n and n. First array has m elements and n
 * empty spaces in the end. Second array has n elements. Solution has to be
 * O(m+n) and inspace.Ex: Input : Array1 - 1,3,5,7,_,_,_ Array2 - 2,4,6 Output :
 * Array1 = 1,2,3,4,5,6,7
 * 
 * @author d35kumar
 *
 */
public class MergeTwoSortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 1, 3, 5, 7, 0, 0, 0 };
		int b[] = { 2, 4, 6 };
		merge(a, b);
		for (int i : a) {
			System.out.print(i + "  ");
		}

	}

	/**
	 * Well trick here is the compare the last element of both array, and which
	 * ever
	 * 
	 * @param a
	 * @param b
	 */
	static void merge(int[] a, int[] b) {
		int lastA = a.length - b.length - 1;
		int lastB = b.length - 1;
		int index = 0;
		int lastIndex = a.length - 1;
		while (index < b.length) {
			if (a[lastA] > b[lastB]) {
				a[lastIndex--] = a[lastA];
				a[lastA--] = 0;
			} else {
				a[lastIndex--] = b[lastB--];
				index++;
			}
		}

	}
}
