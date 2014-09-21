import java.util.ArrayList;
import java.util.Iterator;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * 
 */

/**
 * @author d35kumar
 *
 */
public abstract class General {

	static volatile int p = 0;

	/**
	 * @param args
	 * @throws ScriptException
	 */
	public static void main(String[] args) throws ScriptException {
		Day day = Day.MONDAY;
		System.out.println(day);
		// System.out.println("This is first line of main ");
		// TestInterface.TestClass t= new TestClass();
		 testCountTrailingZero();
//		 testFindSmallestNumber();
		// final int a = pow(2, 3);

		// System.out.format("%s %s", "Power of 2 and 3 is ", a);
		// testArray();

//		evaluate();
	}

	public static void evaluate() throws ScriptException {
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		String foo = "40+2";
		System.out.println(engine.eval(foo));
	}

	private static void testCountTrailingZero() {
		for (int i = 125; i < 126; i++) {
			System.out.println("Number for trailing zero for factorial " + i
					+ "is " + countTrailingZero(i));
		}
	}

	/**
	 * Count the trailing zero of factorial of given number
	 */
	public static int countTrailingZero(int n) {
		int count = 0;
		for (int i = 5; n / i >= 1; i *= 5) {
			count += n / i;
		}
		return count;
	}

	private static void testFindSmallestNumber() {
		assert 27 == findSmallestNumber(14);
		assert 49 == findSmallestNumber(36);
		assert 455 == findSmallestNumber(100);
		assert 11 == findSmallestNumber(1);
		assert 77 == findSmallestNumber(49);
		assert -1 == findSmallestNumber(13);
		System.out.println("All test case passed ");
	}

	/**
	 * Given a number ‘n’, find the smallest number ‘p’ such that if we multiply
	 * all digits of ‘p’, we get ‘n’. The result ‘p’ should have minimum two
	 * digits.
	 * 
	 * Examples:
	 * 
	 * Input: n = 36 Output: p = 49 // Note that 4*9 = 36 and 49 is the smallest
	 * such number
	 * 
	 * Input: n = 100 Output: p = 455 // Note that 4*5*5 = 100 and 455 is the
	 * smallest such number
	 * 
	 * Input: n = 1 Output:p = 11 // Note that 1*1 = 1
	 * 
	 * Input: n = 13 Output: Not Possible
	 */
	static int findSmallestNumber(int n) {
		if (n < 10) {
			return n + 10;
		} else {
			ArrayList<Integer> array = new ArrayList<>();
			for (int i = 9; i > 1; i--) {
				while (n % i == 0) {
					n = n / i;
					array.add(i);
				}
			}

			Iterator<Integer> it = array.iterator();
			StringBuilder sb = new StringBuilder();
			while (it.hasNext()) {
				sb.append(it.next());
			}
			sb.reverse();
			return sb.length() == 0 ? -1 : Integer.parseInt(sb.toString());
		}
	}

	static int pow(int a, int b) {
		int v = 1;
		if (b > 0) {
			if ((b & 2) != 0) {
				v = a * v;
			}
			v = v * pow(a * a, b >> 1);
		}
		return v;
		// return a * pow(a, b - 1);
		// return ((b & 2) == 0) ? pow(a, b >> 1) * pow(a, b >> 1)
		// : pow(a, b >> 1) * pow(a, b >> 1) * a;
	}

	public static void testArray() {
		int[] A = { 1, 2, 3 };
		int[] B = { 2, 3, 4 };
		int[] C = { 8 };
		int[] D = { 8, 9, 9 };
		int[] E = { 8, 9, 6, 7 };
		int[] F = { 8, 6, 5 };
		int maxNumber = array(A, B, C, D, E, F);
		System.out.println(maxNumber);
	}

	/**
	 * A=[1 2 3] <br>
	 * B=[2 3 4]<br>
	 * C=[8]<br>
	 * D=[8 9 9]<br>
	 * E=[8 9 6 7]<br>
	 * F=[8 6 5 ]
	 * 
	 * @param array
	 * @return
	 */
	public static int array(int[]... array) {
		int maxNumber = 0;
		int maxIndex = 0;// max number of element among all array
		for (int ar[] : array) {
			if (maxIndex < ar.length)
				maxIndex = ar.length;
		}
		int numberComputed = 0;
		for (int i = 0; i < maxIndex; i++) {// for scanning each digit
			int maxIthDigit = 0;
			for (int j = 0; j < array.length; j++) {// for scanning each array
				// find out maximum ith digit among all array
				if (i < array[j].length) {
					// check if this digit belog to previous number
					if (maxIthDigit < array[j][i]) {
						maxIthDigit = array[j][i];
					}

				}
			}
			numberComputed = numberComputed * 10 + maxIthDigit;

		}

		return maxNumber;
	}

}
