/**
 * 
 */
package com.dk.sorting.problem;

/**
 * Given an unsorted array arr[0..n-1] of size n, find the minimum length
 * subarray arr[s..e] such that sorting this subarray makes the whole array
 * sorted.
 * 
 * Examples: 1) If the input array is [10, 12, 20, 30, 25, 40, 32, 31, 35, 50,
 * 60], your program should be able to find that the subarray lies between the
 * indexes 3 and 8.
 * 
 * 2) If the input array is [0, 1, 15, 25, 6, 7, 30, 40, 50], your program
 * should be able to find that the subarray lies between the indexes 2 and 5.
 * 
 * @author d35kumar
 *
 */
public class UnsortedSubArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = { 0, 1, 15, 25, 6, 7, 30, 40, 50 };// { 10, 12, 20, 30, 25,
														// 40, 32, 31, 35, 50,
														// 60 };
		findMinUnsortedSubArray(a);

	}

	private static void findMinUnsortedSubArray(int[] a) {
		int start = 1, end = a.length - 1, index = 0;
		for (index = 1; index < a.length; index++) {
			if (a[index] < a[index - 1]) {
				start = index - 1;
				break;
			}
		}
		if (index == a.length)
			System.out.println("Arrays is already sorted, nothing to do");
		for (index = a.length - 2; index >= start; index--) {
			if (a[index] > a[index + 1]) {
				end = index + 1;
				break;
			}
		}
		while (true) {
			if (start == 0 || end == a.length)
				break;
			boolean done = false;
			if (findMin(a, start, end) < a[start - 1]) {
				start--;
			} else
				done = true;
			if (findMax(a, start, end) > a[end]) {
				end++;
			} else {
				if (done)
					break;
			}
		}

		System.out.println("Start index " + start + " end Index " + (end - 1));

	}

	static int findMax(int[] a, int start, int end) {
		int max = a[start];
		for (int i = start + 1; i <= end; i++) {
			if (max < a[i])
				max = a[i];
		}
		return max;
	}

	static int findMin(int[] a, int start, int end) {
		int min = a[start];
		for (int i = start + 1; i <= end; i++) {
			if (min > a[i])
				min = a[i];
		}
		return min;
	}

}
