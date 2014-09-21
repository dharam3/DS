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
		for (int i = 1; i < 10; i++)
			System.out.println(isKthBitSet(15, i));

	}

//	private static boolean isBitPalindrom(){
//		
//	}
	private static boolean isKthBitSet(int x, int k) {
		return ((x & (1 << (k - 1))) != 0);
	}

}
