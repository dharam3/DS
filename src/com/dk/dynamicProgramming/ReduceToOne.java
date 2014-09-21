/**
 * 
 */
package com.dk.dynamicProgramming;

/**
 * Given a number n, and operation /3, /2 and -1. Reduce the number n to 1 in
 * minimum number of steps
 * 
 * @author d35kumar
 *
 */
public class ReduceToOne {

	static int memo[];

	/**
	 * 
	 */
	public ReduceToOne() {
		// TODO Auto-generated constructor stub
	}

	private static int getMinStep(int n) {
		memo = new int[n + 1];
		if (memo != null) {
			for (int i = 0; i < memo.length; i++) {
				memo[i] = -1;
			}
		}
		return getMiniMumNumberOfOperation(n);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 1; i < 105; i++) {
			System.out.println(i + "   " + getMinOperations(i));
		}

	}

	/**
	 * Top down/memoization approach
	 * 
	 * @param n
	 * @return
	 */
	static int getMiniMumNumberOfOperation(int n) {
		if (n == 1)
			return 0;
		if (memo[n] != -1)
			return memo[n];
		int r = 1 + getMiniMumNumberOfOperation(n - 1);
		if (n % 2 == 0)
			r = Math.min(r, 1 + getMiniMumNumberOfOperation(n / 2));
		if (n % 3 == 0)
			r = Math.min(r, 1 + getMiniMumNumberOfOperation(n / 3));
		memo[n] = r;
		return r;
	}

	/**
	 * Bottom up approach
	 * 
	 * @param n
	 * @return
	 */
	static int getMinOperations(int n) {
		int dp[] = new int[n + 1];
		dp[1] = 0;
		for (int i = 2; i <= n; i++) {
			dp[i] = 1 + dp[i - 1];
			if (i % 2 == 0)
				dp[i] = Math.min(dp[i], 1 + dp[i / 2]);
			if (i % 3 == 0)
				dp[i] = Math.min(dp[i], 1 + dp[i / 3]);
		}
		return dp[n];
	}
}
