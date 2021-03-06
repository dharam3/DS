package com.dk.string;

import java.util.Stack;

public class StackQuestions {

}

@SuppressWarnings("serial")
class StackWithMin extends Stack<Integer> {

	int minSoFar = Integer.MAX_VALUE;

	@Override
	public Integer push(Integer item) {
		if (item < minSoFar) {
			minSoFar = item;
		}
		return super.push(item);
	}

	@Override
	public synchronized Integer pop() {
		return super.pop();
	}

	@Override
	public synchronized Integer peek() {
		return super.peek();
	}
}
