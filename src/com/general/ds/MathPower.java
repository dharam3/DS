/**
 * 
 */
package com.general.ds;

/**
 * @author d35kumar
 *
 */
public class MathPower {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MathPower math = new MathPower();
		assert math.pow(2, 3)==8;
		assert math.pow(2, 4)==16;
		System.out.println("******DONE******");
	}

	/**
	 * Computes X ^ y
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	int pow(int x, int y) {
		int temp = 0;
		if (y == 0)
			return 1;
		temp = pow(x, y >> 1);
		if (y % 2 == 0)
			return temp * temp;
		else
			return temp * temp * x;

	}
}
