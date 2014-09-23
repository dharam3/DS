/**
 * 
 */
package com.dk.dynamicProgramming;

/**
 * Given a matrix of integers ( -ve and +ve number), find out the sub matrix
 * which is having maximum sum
 * 
 * @author d35kumar
 *
 */
public class SubMatrixWithMaxSum {

	/**
	 * 
	 */
	public SubMatrixWithMaxSum() {
	}

	public static void main(String[] args) {
		test();
	}

	public static void test() {
		int M[][] = { { 1, 2, -1, -4, -20 }, { -8, -3, 4, 2, 1 },
				{ 3, 8, 10, 1, 3 }, { -4, -1, 1, 7, -6 } };
		SubMatrixPos sub = getMaxSum(M);
		System.out.println(sub.left + ", " + sub.top + "  " + sub.right + ", "
				+ sub.bottom);

	}

	/**
	 * @param a
	 * @return
	 */
	private static SubMatrixPos getMaxSum(int a[][]) {
		SubMatrixPos maxSubMat = new SubMatrixPos();
		int rowCount = a.length, columnCount = a[0].length;
		int max = 0;
		
		for (int left = 0; left < columnCount; ++left) {
			int temp[] = new int[rowCount];
			for (int right = left; right < columnCount; ++right) {
				for (int i = 0; i < rowCount; i++) {
					temp[i] += a[i][right];
				}
				Triplet<Integer, Integer, Integer> t = MaxSubArray.maxSubArray(
						temp, 0, rowCount - 1);
				if (max < t.u) {
					max = t.u;
					maxSubMat.left = left;
					maxSubMat.right = right;
					maxSubMat.top = t.s;
					maxSubMat.bottom = t.t;
				}
			}

		}
		return maxSubMat;
	}

	static class SubMatrixPos {
		int top, left, right, bottom;
	}

}
