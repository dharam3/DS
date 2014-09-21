/**
 * 
 */
package com.dk.stack;

import java.util.EmptyStackException;

/**
 * @author d35kumar
 *
 */
public class StackWithArray {

	private int[] array;
	int topIndex = -1;

	/**
	 * 
	 */
	public StackWithArray(int capacity) {
		array = new int[capacity];
	}

	/**
	 * @param data
	 * @return
	 * @throws StackFullException
	 */
	public void push(int data) throws StackFullException {
		topIndex++;
		if (topIndex >= array.length)
			throw new StackFullException(
					"Stack is full, which is having capacity of "
							+ array.length);
		array[topIndex] = data;
	}

	public int pop() throws EmptyStackException {
		if (topIndex == -1)
			throw new EmptyStackException();
		return array[topIndex--];
	}

	/**
	 * @return
	 */
	public boolean isEmpty() {
		return topIndex == -1;
	}

	public boolean hasMoreCapacity() {
		return topIndex < array.length;
	}

	/**
	 * @return
	 */
	public int peek() {
		return array[topIndex];
	}

	public void reverseStack() throws StackFullException {
		if (isEmpty())
			return;
		int data = pop();
		reverseStack();
		System.out.print(data+"  ");
		recursivePush(data);
	}

	private void recursivePush(int data) throws StackFullException {
		if (isEmpty()) {
			push(data);
			return;
		}
		int temp = pop();
		recursivePush(data);
		push(temp);
	}
}

@SuppressWarnings("serial")
class StackFullException extends Exception {
	public StackFullException(String message) {
		super(message);
	}
}
