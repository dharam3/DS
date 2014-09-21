package com.dk.string;

public class StringQuestion {

	public static void main(String args[]) {
		 //System.out.println(reverseRec("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
		String s=" the sky is blue ";
		System.out.println(">>"+reverseString(s)+"<<");
//		String text = "dharmendra kumar";
		// System.out.println(removeDuplicates(text.toCharArray()));
		// System.out.println(encodeString(text));
//		System.out.println(compressString("abbbbbccaa"));
		 float a=(float) 3.0;
	}

	private static String reverseString(String s){
	String[] parts = s.trim().split("\\s+");
	StringBuilder out = new StringBuilder();
	if (parts.length > 0) {
	    for (int i = parts.length - 1; i >= 0; i--) {
	    	out.append(parts[i]);
	    	out.append(" ");
	    }
//	    out += parts[0];
	}
	return out.toString();
	}
	
	static String reverse(String text) {
		int index = 0, length = text.length();
		char[] charArray = text.toCharArray();
		while (index < (length >> 1)) {
			char ch = charArray[index];
			charArray[index] = charArray[length - index - 1];
			charArray[length - index - 1] = ch;
			index++;
		}
		return new String(charArray);
	}
	public static String reverseRec(String s){
		if(s.length()<2) return s;
		return reverse(s.substring(1))+ s.charAt(0);
	}
	
	static String reverseThroughRecursion(char[] charArray, int replace,
			int with) {
		if (replace >= with) {
			return new String(charArray);
		}
		char ch = charArray[replace];
		charArray[replace] = charArray[with];
		charArray[with] = ch;
		return reverseThroughRecursion(charArray, replace + 1, with - 1);
	}

	// static String replaceDuplicateCharacterwithSpace(String text) {
	//
	// }
	// / Haven't checked the functionality of this function,
	public static String removeDuplicates(char[] str) {
		if (str == null)
			return null;
		int len = str.length;
		if (len < 2)
			return new String(str);

		int tail = 1;

		for (int i = 1; i < len; ++i) {
			int j;
			for (j = 0; j < tail; ++j) {
				if (str[i] == str[j])
					break;
			}
			if (j == tail) {
				str[tail] = str[i];
				++tail;
			}
		}
		str[tail] = 0;
		return new String(str);
	}

	public static String encodeString(String text) {
		StringBuilder sb = new StringBuilder();
		int index = 0, length = text.length();
		while (index < length) {
			char ch = text.charAt(index);
			if (ch == ' ')
				sb.append("%20");
			else
				sb.append(ch);
			index++;
		}

		return sb.toString();
	}

	/**
	 * Implement a method to perform basic string compression using the counts
	 * of repeated characters. For example, the string aabcccccaaa would become
	 * a2blc5a3. If the "compressed" string would not become smaller than the
	 * original string, your method should return the original string.
	 * 
	 * @return
	 */
	public static String compressString(String text) {
		StringBuilder sb = new StringBuilder();
		char[] array = text.toCharArray();
		int length = text.length();
		// while(index<length){
		// char charToAppend=array[index];
		// sb.append(charToAppend);
		// int count=0;
		// while(array[index]==charToAppend){
		// count++;
		// index++;
		// if(index==length)break;
		// }
		// sb.append(count);
		// }
		char charToCompare = array[0];
		int count = 1;
		sb.append(charToCompare);
		for (int i = 1; i < length; i++) {
			if (array[i] == charToCompare) {
				count++;
			} else {
				if (count > 1)
					sb.append(count);
				sb.append(array[i]);
				count = 1;
				charToCompare = array[i];
			}
		}
		if(count>1) sb.append(count);
		return sb.toString();
	}

}
