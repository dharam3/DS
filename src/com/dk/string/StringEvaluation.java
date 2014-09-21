/**
 * 
 */
package com.dk.string;

import java.util.Stack;

/**
 * @author d35kumar
 *
 */
public class StringEvaluation {

	/**
	 * 
	 */
	public StringEvaluation() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringEvaluation se = new StringEvaluation();

		int val = se.evaluate("2+4*6/2-2");
		System.out.println("===>" + val);
	}

	public int evaluate(String s) {
		// int val = 0;
		char[] chArray = s.toCharArray();
		Stack<Integer> operand = new Stack<>();
		Stack<Character> operator = new Stack<>();
		for (int i = 0; i < chArray.length; i++) {
			if (chArray[i] == ' ')
				continue;
			if (chArray[i] >= '0' && chArray[i] <= '9') {
				StringBuilder sb = new StringBuilder();
				// there may be two or more digit number as well.
				while (i < chArray.length && chArray[i] >= '0'
						&& chArray[i] <= '9')
					sb.append(chArray[i++]);
				i--;
				operand.push(Integer.parseInt(sb.toString()));
			} else if (chArray[i] == '(') {
				operator.push(chArray[i]);
			} else if (chArray[i] == ')') {
				while (chArray[i] != '(') {
					operand.push(opeart(operator.pop(), operand.pop(),
							operator.pop()));
				}
				operator.pop();// pop out the '('
			} else if (isOperator(chArray[i])) {
				while (!operator.isEmpty()
						&& hasHigherPrecedence(chArray[i], operator.peek())) {
					operand.push(opeart(operator.pop(), operand.pop(),
							operand.pop()));

				}
				operator.push(chArray[i]);

			}
		}
		while (!operator.isEmpty()) {
			operand.push(opeart(operator.pop(), operand.pop(), operand.pop()));
		}
		return operand.pop();

	}

	boolean isOperator(char ch) {
		boolean isOperator = false;
		switch (ch) {
		case '+':
		case '-':
		case '*':
		case '/':
			isOperator = true;
			break;
		}
		return isOperator;
	}

	int opeart(char operator, int b, int a) {
		int val = 0;
		switch (operator) {
		case '+':
			val = a + b;
			break;
		case '-':
			val = a - b;
			break;
		case '*':
			val = a * b;
			break;
		case '/':
			val = a / b;
			break;

		}
		return val;
	}

	/**
	 * 
	 * @param op1
	 * @param op2
	 * @return true if op2 has higher or equal precedence than op1
	 */
	boolean hasHigherPrecedence(char op1, char op2) {
		if (op2 == '(' || op2 == ')')
			return false;
		if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return false;

		return true;
	}
}
