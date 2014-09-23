/**
 * 
 */
package com.dk.dynamicProgramming;

/**
 * Given a binary matrix, find out the maximum size square sub-matrix with all
 * 1s.
 * 
 * For example, consider the below binary matrix.
 * 
 * 
 * 0 1 1 0 1<br>
 * 1 1 0 1 0 <br>
 * 0 1 1 1 0<br>
 * 1 1 1 1 0<br>
 * 1 1 1 1 1<br>
 * 0 0 0 0 0<br>
 * The maximum square sub-matrix with all set bits is
 * 
 * 1 1 1<br>
 * 1 1 1<br>
 * 1 1 1<br>
 * 
 * Reference
 * http://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-
 * a-binary-matrix/
 * 
 * @author d35kumar
 *
 */
public class MatrixOf0And1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] a = { { 0, 1, 1, 0, 1 }, { 1, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 },
				{ 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0 } };
		assert 3 == findSquareMatrixwithAll1(a);

	}

	/**
	 * Find out the dimension of square submatrix, which is of maximum size
	 * 
	 * @param a
	 *            Provided matrix of 1 and 0
	 * @return the maximum dimension of square matrix with all 1, and is
	 *         submatrix of provided matrix in
	 */
	static int findSquareMatrixwithAll1(int a[][]) {
		// create a duplicate matrix of same dimension
		int d[][] = new int[a.length][a[0].length];
		int max = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				// if it first row or first column, copy the element as it is
				if (i == 0 || j == 0) {
					d[i][j] = a[i][j];
				} else {
					if (a[i][j] == 1) {
						// look at exactly top, left and top left element, find
						// out minimum among all three and add 1, that will be
						// the value of this cell
						d[i][j] = Math.min(Math.min(d[i - 1][j], d[i][j - 1]),
								d[i - 1][j - 1]) + 1;
						if (max < d[i][i])
							max = d[i][j];
					} else
						d[i][j] = 0;
				}
			}
		}

		System.out.println("Dimesion of maximum square sub array is " + max);
		return max;
	}
}
