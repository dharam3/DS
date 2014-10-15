/**
 * 
 */
package com.dk.array;

/**
 * Given an array of N number, and an integer X, find two integer such that
 * their sum is equal to X.
 * 
 * @author d35kumar
 *
 */
public class PrintPair {
	static final int RANGE = 50;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int A[] = { 1, 4, 45, 6, 10, 8 };
		/*
		 * int n = 47; print(A, n);
		 */
		assert print(A, 5);
		assert print(A, 46);
		assert print(A, 7);
		assert print(A, 11);
		assert print(A, 9);
		assert print(A, 16);
		assert print(A, 12);
	}

	/**
	 * 
	 * O ( n ) implementation, but with extra space of O ( R ) , where R is the
	 * range of number in array
	 * 
	 * @param arr
	 * @param sum
	 * @return
	 */
	private static boolean print(int[] arr, int sum) {
		boolean[] t = new boolean[RANGE];

		for (int i = 0; i < arr.length; i++) {
			int remain = sum - arr[i];
			if (remain >= 0 && t[remain]) {
				System.out
						.println("Number found are " + remain + ", " + arr[i]);
				return true;
			}
			t[arr[i]] = true;
		}
		System.out.println("No such number found");
		return false;
	}

	/**
	 * O ( n^2 ) implementation with no extra space
	 * 
	 * @param arr
	 * @param sum
	 * @return
	 */
	private static boolean print1(int[] arr, int sum) {
		for (int i = 0; i < arr.length; i++) {
			int remaining = sum - arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				if (remaining == arr[j]) {
					System.out.println("Number found for " + sum + " is "
							+ arr[i] + ", " + remaining);
					return true;
				}
			}
		}
		System.out.println("No such element found ");
		return false;
	}
}
