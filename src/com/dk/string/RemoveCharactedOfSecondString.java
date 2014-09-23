/**
 * 
 */
package com.dk.string;

import java.util.TreeSet;

/**
 * @author d35kumar
 *
 */
public class RemoveCharactedOfSecondString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		assert "dhend".equals(removeCharacter("dharmendra", "Kumar"));
		assert "bcde".equals(removeCharacter("abcde", "Kumar"));
		System.out.println("Done ");
	}

	/**
	 * Remove all character from first string, which appears in 2nd string
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	private static String removeCharacter(String str1, String str2) {
		StringBuilder sb = new StringBuilder();
		// First make a tree set of all character of second String
		// Because searching in tree set will be very fast
		TreeSet<Character> set = new TreeSet<Character>();
		for (char ch : str2.toCharArray()) {
			set.add(ch);
		}
		// now go through each character of 1st string and if that character is
		// not available in tree set include it in output
		for (char ch : str1.toCharArray()) {
			if (set.contains(ch))
				continue;
			sb.append(ch);
		}
		return sb.toString();
	}
}
