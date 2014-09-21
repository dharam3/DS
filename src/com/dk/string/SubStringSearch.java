package com.dk.string;

/**
 * 
 */

/**
 * KMP algorithm for searching the text 
 * 
 * @author d35kumar
 *
 */
public class SubStringSearch {
	int dfa[][];
	int M;// Number of character in pattern

	/**
	 * @param pattern
	 */
	public SubStringSearch(String pattern) {
		M = pattern.length();
		final int R = 256;// number of distinct character in string
		dfa = new int[R][M];
		char ch = pattern.charAt(0);
		// initialize the element at top left corner of matrix with 1;
		dfa[ch][0] = 1;
		// For each character of pattern
		// starting from 1st position, as first character is already used to
		// move to state 1
		for (int x = 0, j = 1; j < M; j++) {
			// copy the data from marked position X
			for (int c = 0; c < R; c++) {
				dfa[c][j] = dfa[c][x];
			}
			ch = pattern.charAt(j);
			// for this particular character change the state to next state
			dfa[ch][j] = j + 1;
			// Update X
			x = dfa[ch][x];
		}

	}

	public int search(String text) {
		int i = 0, j = 0;
		for (i = 0; i < text.length() && j < M; i++) {
			j = dfa[text.charAt(i)][j];
		}
		// if J has reached to totocl character, 
		// means match is found, and we should return the starting index of pattern
		if (j == M)
			return i - j;
		else
			return -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String text = "AABBAABABABBB";
		String pattern = "BABAA";
		SubStringSearch sss = new SubStringSearch(pattern);
		int index = sss.search(text);
		System.out.println(index);
	}

}
