/**
 * 
 */
package com.dk.sorting;

import java.util.Scanner;

/**
 * @author d35kumar
 *
 */
public class QuickSortSelf {

	public static <T extends Comparable<T>> void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter intergers with comma seperated");
		String list = scan.next();
		scan.close();
		String[] items = list.split(",");
		Integer integer[] = new Integer[items.length];
		for (int i = 0; i < items.length; i++) {
			integer[i] = Integer.parseInt(items[i]);
		}
		QuickSortSelf quickSort = new QuickSortSelf();
		quickSort.sort(integer, 0, integer.length - 1);

		for (Integer each : integer)
			System.out.print("	" + each);
		// QuickSortSelf<Comparable<T> quick= new QuickSortSelf<>();
	}

	private <T extends Comparable<T>> void sort(T[] list, int lo, int hi) {
		if ((hi - lo) <= 0)
			return;
		int splitPoint = partition(list, lo, hi);
		sort(list, lo, splitPoint - 1);// left subarray recursion
		sort(list, splitPoint + 1, hi);// right subarray recursion
	}

	private <T extends Comparable<T>> int partition(T[] list, int lo, int hi) {
		T pivot = list[lo];
		int leftPointer = lo + 1, rightPointer = hi;
		while (true) {
			// Move the left pointer till element is less than the pivot or
			// left pointer is less than right pointer

			while (leftPointer <= rightPointer) {
				if (list[leftPointer].compareTo(pivot) < 0)
					leftPointer++;
				else
					break;
			}

			while (rightPointer > leftPointer) {
				if (list[rightPointer].compareTo(pivot) > 0)
					rightPointer--;
				else
					break;
			}
			if (leftPointer >= rightPointer)
				break;
			// if left and right pointer haven't crossed each other
			swap(list, leftPointer, rightPointer);
			leftPointer++;
			rightPointer--;

		}
		// Now swap the pivot with left-1;
		swap(list, lo, leftPointer - 1);
		return leftPointer - 1;
	}

	private <T extends Comparable<T>> void swap(T[] list, int a, int b) {
		if (a == b)
			return;
		T temp = list[a];
		list[a] = list[b];
		list[b] = temp;
	}
}
