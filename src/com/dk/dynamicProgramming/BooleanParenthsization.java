/**
 * 
 */
package com.dk.dynamicProgramming;

/**
 * Given a boolean expression with following symbols.
 * 
 * Symbols 'T' ---> true <br>
 * 'F' ---> false<br>
 * And following operators filled between symbols
 * 
 * Operators & ---> boolean AND<br>
 * | ---> boolean OR <br>
 * ^ ---> boolean XOR <br>
 * 
 * Count the number of ways we can parenthesize the expression so that the value
 * of expression evaluates to true.
 * 
 * @author d35kumar
 *
 */
public class BooleanParenthsization {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean[] symbols = { true, true, false, true };
		char[] operator = "|&^".toCharArray();
		symbols = new boolean[] { true, false, true };
		operator = "^&".toCharArray();
		int n = getNumberOfParenthesization(symbols, operator);
		System.out.println(n);
	}

	/**
	 * @param symbol
	 * @param operater
	 * @return
	 */
	static int getNumberOfParenthesization(boolean[] symbol, char[] operater) {
		int n = symbol.length;
		int T[][] = new int[n][n];
		int F[][] = new int[n][n];
		// initialize base case
		for (int i = 0; i < n; i++) {
			if (symbol[i]) {
				T[i][i] = 1;
			} else {
				F[i][i] = 1;
			}
		}

		for (int gap = 1; gap < n; gap++) {
			for (int i = 0, j = gap; j < n; ++i, ++j) {
				T[i][j] = 0;
				F[i][j] = 0;

				for (int g = 0; g < gap; g++) {

					// Find place of parenthesization using current value
					// of gap
					int k = i + g;

					// Store Total[i][k] and Total[k+1][j]
					int tik = T[i][k] + F[i][k];
					int tkj = T[k + 1][j] + F[k + 1][j];
					// Follow the recursive formulas according to the current
					// operator
					if (operater[k] == '&') {
						T[i][j] += T[i][k] * T[k + 1][j];
						F[i][j] += (tik * tkj - T[i][k] * T[k + 1][j]);
					}
					if (operater[k] == '|') {
						F[i][j] += F[i][k] * F[k + 1][j];
						T[i][j] += (tik * tkj - F[i][k] * F[k + 1][j]);
					}
					if (operater[k] == '^') {
						T[i][j] += F[i][k] * T[k + 1][j] + T[i][k]
								* F[k + 1][j];
						F[i][j] += T[i][k] * T[k + 1][j] + F[i][k]
								* F[k + 1][j];
					}
				}
			}
		}

		return T[0][n - 1];
	}
}
