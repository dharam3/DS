/**
 * 
 */

/**
 * @author d35kumar
 *
 */
public class PrintParenthesis {

	/**
	 * 
	 */
	public PrintParenthesis() {

	}

	public static void main(String[] args) {
		PrintParenthesis pp = new PrintParenthesis();
		pp.printPossible("", 4, 0);
	}

	/**
	 * @param s
	 *            Starting String, this string is getting appended with open and
	 *            closed pointer
	 * @param o
	 *            Number of open paranthesis
	 * @param c
	 *            Number of closed parenthesis
	 */
	void printPossible(String s, int o, int c) {
		if (o == 0 && c == 0) {
			System.out.println(s + "  ");
			return;
		}

		if (o > 0) {
			printPossible(s + "(", o - 1, c + 1);

		}
		if (c > 0) {
			printPossible(s + ")", o, c - 1);
		}
	}

}
