/**
 * 
 */
package com.dk.array;


/**
 * 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15, … a longest increasing
 * subsequence is
 * 
 * 0, 2, 6, 9, 13, 15. This subsequence has length six; the input sequence has
 * no seven-member increasing subsequences. The longest increasing subsequence
 * in this example is not unique: for instance,
 * 
 * 0, 4, 6, 9, 11, 15 or 0, 4, 6, 9, 13, 15
 * 
 * @author d35kumar
 *
 */
public class LIS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
		// { 0, 1, 1, 2, 1, 2,
		LIS lis = new LIS();
		int max = lis.maxIS(a);
		System.out.println(max);
//		System.out.println(lis.squareRoot(49));

	}

	int maxIS(int[] a) {
		int list[] = new int[a.length];
		int max = 1;
		for (int i = 1; i < a.length; i++) {
			int maxI = list[i];
			for (int j = 0; j < i; j++) {
				if (a[i] > a[j] && (list[j] + 1) > maxI) {
					maxI = list[j] + 1;
				}
			}
			list[i] = maxI;
		}

		for (int i = 0; i < list.length; i++) {
			System.out.println(i + "   " + list[i]);
			if (max < list[i])
				max = list[i];
		}

		return max + 1;

	}

	/* Returns the square root of n. Note that the function */
	float squareRoot(float n) {
		/*
		 * We are using n itself as initial approximation This can definitely be
		 * improved
		 */
		float x = n;
		float y = 1;
		double e = 0.000001; /* e decides the accuracy level */
		while (x - y > e) {
			x = (x + y) / 2;
			y = n / x;
		}
		return x;
	}
}
