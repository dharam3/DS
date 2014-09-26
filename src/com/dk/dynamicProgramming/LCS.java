package com.dk.dynamicProgramming;


/**
 * Given two sequences, find the length of longest subsequence present in both
 * of them. A subsequence is a sequence that appears in the same relative order,
 * but not necessarily contiguous. For example, “abc”, “abg”, “bdf”, “aeg”,
 * ‘”acefg”, .. etc are subsequences of “abcdefg”. So a string of length n has
 * 2^n different possible subsequences.
 * 
 * @author d35kumar
 *
 */
public class LCS {

	public static void main(String[] args) {
		char X[] = "AGGTAB".toCharArray();
		char Y[] = "GXTXAYB".toCharArray();
		System.out.println(calculateLongestSubSequence(X, Y));

	}

	/**
	 * @param a
	 * @param b
	 * @return
	 */
	static int calculateLongestSubSequence(char[] a, char[] b) {
		final int M = a.length;
		final int N = b.length;
		int[][] dp = new int[M + 1][N + 1];

		for (int i = 0; i <= M; i++) {
			for (int j = 0; j <= N; j++) {
				if (i == 0 || j == 0) {
					// if either of string length is 0, there is nothing to
					// count as subsequence
					dp[i][j] = 0;
				} else if (a[i - 1] == b[j - 1]) {
					// if the character at same index in both string is same
					// then up this level, max subsequence can be 1+ the
					// previous subsequence
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		printMatrix(dp);
		printLongestCommonSubsequence(dp, a, b);
		return dp[a.length][b.length];
	}

	private static void printMatrix(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + "	");
			}
			System.out.println();
		}
	}

	/**
	 * This will print the largest common subsequence
	 * 
	 * @param a
	 * @param x
	 * @param y
	 */
	private static void printLongestCommonSubsequence(int[][] a, char[] x,
			char[] y) {
		StringBuilder sb = new StringBuilder();
		for (int i = a.length - 1, j = a[0].length - 1; i > 0 && j > 0;) {
			if (x[i - 1] == y[j - 1]) {
				sb.append(x[i - 1]);
				i--;
				j--;
			} else {
				if (a[i - 1][j] > a[i][j - 1]) {
					i--;
				} else {
					j--;
				}
			}
		}
		System.out.println("" + sb.reverse());
	}

}
