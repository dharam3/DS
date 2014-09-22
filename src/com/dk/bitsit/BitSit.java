/**
 * 
 */
package com.dk.bitsit;

/**
 * @author d35kumar
 *
 */
public class BitSit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// assert isKthBitSet(2, 1);
		/*
		 * for (int i = 1; i < 10; i++) System.out.println(isKthBitSet(15, i));
		 */
		// testNumberOfBit();
		testIsPalindrom();
	}

	/**
	 * @param x
	 *            Given number
	 * @param k
	 *            Bit position
	 * @return true if kth bit is set in number x, false otherwise
	 */
	private static boolean isKthBitSet(int x, int k) {
		return ((x & (1 << (k - 1))) != 0);
	}

	private static void testNumberOfBit() {
		assert 1 == countNumberOfBits(4);
		assert 2 == countNumberOfBits(3);
		assert 4 == countNumberOfBits(15);
		assert 1 == countNumberOfBits(16);
		System.out.println("DONE");
	}

	/**
	 * This runs only for number of 1's there in number. e.g. for 1010 loop will
	 * run only for two times
	 * 
	 * @param n
	 * @return
	 */
	static int countNumberOfBits(int n) {
		int count = 0;
		while (n != 0) {
			n &= n - 1;
			count++;
		}
		return count;
	}

	private static void testIsPalindrom() {
		assert isPalindrom(1);
		assert !isPalindrom(2);
		assert isPalindrom(5);
		assert !isPalindrom(10);
		assert isPalindrom(15);
		assert !isPalindrom(16);
		System.out.println("testIsPalindrom DONE");
	}

	/**
	 * Given an integer ‘x’, write a function that returns true if binary
	 * representation of x is palindrome else return false.
	 */

	private static boolean isPalindrom(int n) {
		int msbPosition = 32;
		int mask = ~Integer.MAX_VALUE;
		// First find out the the MSB set bit position
		while (msbPosition != 0) {
			if ((mask & n) != 0) {
				break;
			}
			msbPosition--;
			mask = mask >> 1;
		}

		for (int left = 1, right = msbPosition; right > left; left++, right--) {
			if (((n & (1 << (left - 1))) != 0) != ((n & (1 << (right - 1))) != 0)) {
				return false;
			}
		}
		return true;
	}
}
