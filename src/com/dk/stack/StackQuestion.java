/**
 * 
 */
package com.dk.stack;

/**
 * @author d35kumar
 *
 */
public class StackQuestion {

	static final int STACK_CAPACITY=4;
	/**
	 * @param args
	 * @throws StackFullException 
	 */
	public static void main(String[] args) throws StackFullException {
		StackWithArray stack = new StackWithArray(STACK_CAPACITY);
		int i=0;
		while(i<STACK_CAPACITY){
			stack.push(i++);
		}
//		System.out.println("Stack elements are ");
//		while(!stack.isEmpty()){
//			System.out.print("	"+stack.pop());
//		}
		stack.reverseStack();
//		System.out.println("Stack elements in reverse order are ");
//		while(!stack.isEmpty()){
//			System.out.print("  "+stack.pop());
//		}
//		stack.printInReverse();
	}
	
	

}


class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
	}

	public void insert(int data) {
		// scan till last
		while (next != null)
			next = next.next;
		this.next = new Node(data);
	}
}
