package com.general.ds;

/**
 * 
 */

/**
 * @author d35kumar
 *
 */
public class NumberToExcelColumn {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Going to check the function ");
		assert convertToExcelColumn(26).equals("Z");
		assert convertToExcelColumn(1).equals("A");
		assert convertToExcelColumn(52).equals("AZ");
		assert convertToExcelColumn(51).equals("AY");
		assert convertToExcelColumn(80).equals("CB");
		assert convertToExcelColumn(676).equals("YZ");
		assert convertToExcelColumn(702).equals("ZZ");
		assert convertToExcelColumn(705).equals("AAC");
		System.out.println("All passed ");
	}

	public static String convertToExcelColumn(int number) {
		StringBuilder sb = new StringBuilder();
		while (number > 0) {
			int remainder = number % 26;
			if (remainder == 0) {
				sb.append('Z');
				number = number / 26 - 1;
			} else {
				sb.append((char) (64 + remainder));
				number = number / 26;
			}

		}
		return sb.reverse().toString();
	}

}
