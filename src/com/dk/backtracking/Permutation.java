/**
 * 
 */
package com.dk.backtracking;

/**
 * @author d35kumar
 *
 */
public class Permutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		permute("ABC", 0, 2);
	}

	private static void permute(String str, int startIndex, int endIndex) {
		if (startIndex == endIndex) {
			System.out.println(str);
		} else {
			for (int j = startIndex; j < endIndex; j++) {
				swap(str, startIndex, j);
				permute(str, startIndex + 1, endIndex);
				swap(str, startIndex, j);
			}
		}

	}

	private static void swap(String s, int i, int j) {
		if (i == j)
			return;
		char ithChar = s.charAt(i);
		char jthChar = s.charAt(j);

	}

	/*
	 * public static void permute(String s, int i) {
	 * 
	 * int sLength = s.length(); if (i == sLength) System.out.println(s); else {
	 * for (int j = i; j < sLength; j++) { swap(s, i, j); permute(s, i + 1);
	 * swap(s, i, j); } }
	 * 
	 * }
	 * 
	 * private static void swap(String s, int i, int j) { if (i == j) return;
	 * char ch = s.charAt(i); char ch1 = s.charAt(j); StringBuilder sb = new
	 * StringBuilder(); sb.append(s.substring(0, i - 1)); sb.append(ch1);
	 * sb.append(s.substring(i + 1, j - 1)); sb.append(ch1);
	 * sb.append(s.substring(j + 1)); s = sb.toString(); }
	 */

}
