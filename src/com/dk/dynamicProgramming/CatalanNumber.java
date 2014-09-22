/**
 * 
 */
package com.dk.dynamicProgramming;

/**
 * Catalan numbers are a sequence of natural numbers that occurs in many
 * interesting counting problems like following.
 * 
 * 1) Count the number of expressions containing n pairs of parentheses which
 * are correctly matched. For n = 3, possible expressions are ((())), ()(()),
 * ()()(), (())(), (()()).
 * 
 * 2) Count the number of possible Binary Search Trees with n keys (See this)
 * 
 * 3) Count the number of full binary trees (A rooted binary tree is full if
 * every vertex has either two children or no children) with n+1 leaves.
 * 
 * See this for more applications.
 * 
 * The first few Catalan numbers for n = 0, 1, 2, 3, … are 1, 1, 2, 5, 14, 42,
 * 132, 429, 1430, 4862, …
 * 
 * 
 * Reference:- http://www.geeksforgeeks.org/program-nth-catalan-number/
 * 
 * @author d35kumar
 *
 */
public class CatalanNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(i + "   " + getCatlanNumber1(i));
		}

	}

	/**
	 * Recursive implementation
	 * 
	 * @param n
	 * @return
	 */
	public static int getCatalanNumber(int n) {
		if (n == 0)
			return 1;
		int cat = 0;
		for (int i = 0; i < n; i++) {
			cat += getCatalanNumber(i) * getCatalanNumber(n - i - 1);
		}

		return cat;
	}

	/**
	 * Dynamin programming bottom up appraoch
	 * 
	 * @param n
	 * @return
	 */
	public static int getCatlanNumber1(int n) {
		int[] catalan = new int[n + 1];
		catalan[0] = 1;
		if (n > 0)// safe case for n=0;
			catalan[1] = 1;

		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				catalan[i] += catalan[j] * catalan[i - j - 1];
			}
		}
		return catalan[n];
	}

}
