/**
 * 
 */
package com.dk.sorting;

/**
 * @author d35kumar
 *
 */
public class QuickSort {
	int[] array;
	int totalNumber;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 5, 4, 3, 27, 8, 943, 2343, 2 };
		QuickSort q = new QuickSort();
		q.sort(array);
		for (int i : array) {
			System.out.print(i+" ");
		}
	}

	private void sort(int[] array) {
		if (array == null || array.length == 0)
			return;
		this.array = array;
		totalNumber = array.length;
		quickSort(0, totalNumber - 1);
	}

	private int quickSort(int lo, int hi) {
		int i = lo, j = hi;
		int pivot = array[(lo + hi) >> 1];
		while (i <= j) {
			while (array[i] < pivot)
				i++;
			while (pivot < array[j])
				j--;
			if (i <= j) {
				exchg(i, j);
				i++;
				j--;
			}
		}
		if (lo < j)
			quickSort(lo, j);
		if (i < hi)
			quickSort(i, hi);
		return j;
	}

	private void exchg(int i, int j) {
		if (i == j)
			return;
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
