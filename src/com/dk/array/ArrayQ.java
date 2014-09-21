/**
 * 
 */
package com.dk.array;

/**
 * @author d35kumar
 *
 */
public class ArrayQ {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = { 3, 3, 2, 3 };// { 12, 1, 12, 3, 12, 1, 1, 2, 3, 3 };
		ArrayQ arrayQ = new ArrayQ();
		int i = arrayQ.findUniqueueElement(arr);
		System.out.println("=======>" + i);

		// int arr[] = { 2, 3, 3, 2, 4, 1, 4 };
		// int i = arrayQ.findUniqueElement1(arr);
		// System.out.println(i);

	}

	/**
	 * Given an array where every element occurs three times, except one element
	 * which occurs only once. Find the element that occurs once. Expected time
	 * complexity is O(n) and O(1) extra space.
	 * 
	 * Input: arr[] = {12, 1, 12, 3, 12, 1, 1, 2, 3, 3}<br>
	 * Output: 2
	 * 
	 * http://www.geeksforgeeks.org/find-the-element-that-appears-once/
	 */
	int findUniqueueElement(int[] arr) {
		int ones = 0, twos = 0;

		int notThree=0;

		// Let us take the example of {3, 3, 2, 3} to understand this
		for (int ele : arr) {
			System.out.println(" One " + Integer.toBinaryString(ones));
			System.out.println(" Two " + Integer.toBinaryString(twos));
			System.out.println(" Three " + Integer.toBinaryString(notThree));
			/*
			 * The expression "one & ele" gives the bits that are there in both
			 * 'ones' and new element from arr[]. We add these bits to 'twos'
			 * using bitwise OR
			 * 
			 * Value of 'twos' will be set as 0, 3, 3 and 1 after 1st, 2nd, 3rd
			 * and 4th iterations respectively
			 */
			twos |= ones & ele;

			/*
			 * XOR the new bits with previous 'ones' to get all bits appearing
			 * odd number of times
			 * 
			 * Value of 'ones' will be set as 3, 0, 2 and 3 after 1st, 2nd, 3rd
			 * and 4th iterations respectively
			 */
			ones ^= ele;

			/*
			 * The common bits are those bits which appear third time So these
			 * bits should not be there in both 'ones' and 'twos'.
			 * common_bit_mask contains all these bits as 0, so that the bits
			 * can be removed from 'ones' and 'twos'
			 * 
			 * Value of 'common_bit_mask' will be set as 00, 00, 01 and 10 after
			 * 1st, 2nd, 3rd and 4th iterations respectively
			 */
			notThree = ~(ones & twos);

			/*
			 * Remove common bits (the bits that appear third time) from 'ones'
			 * 
			 * Value of 'ones' will be set as 3, 0, 0 and 2 after 1st, 2nd, 3rd
			 * and 4th iterations respectively
			 */
			ones &= notThree;

			/*
			 * Remove common bits (the bits that appear third time) from 'twos'
			 * 
			 * Value of 'twos' will be set as 0, 3, 1 and 0 after 1st, 2nd, 3rd
			 * and 4th iterations respectively
			 */
			twos &= notThree;

			System.out.println("" + Integer.toBinaryString(ones) + "  "
					+ Integer.toBinaryString(twos));
		}

		return ones;

	}

	/**
	 * Given an array in which every element appears twice except once. Find out
	 * the element which appears only once.
	 * 
	 * @param arr
	 * @return
	 */
	int findUniqueElement1(int arr[]) {
		int val = 0;
		for (int ele : arr) {
			val ^= ele;
		}
		return val;
	}

}
