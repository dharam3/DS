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
	 * 
	 */
	public BitSit() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// assert isKthBitSet(2, 1);
		/*
		 * for (int i = 1; i < 10; i++) System.out.println(isKthBitSet(15, i));
		 */
		testNumberOfBit();
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
	 * This runs only for number of 1's there in number
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

}
