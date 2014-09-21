/**
 * 
 */
package com.dk.tricky;

/**
 * Given a stream of characters, find the first non-repeating character from
 * stream. You need to tell the first non-repeating character in O(1) time at
 * any moment.
 * 
 * @author d35kumar
 *
 */
public class FirstNonRepititive {
	/**
	 * if value for any character is false in this array , it means, that
	 * character has not appeared yet, or has appeared only once so far, after
	 * receiving it 2nd time we will make it true, and it will remain true
	 */
	boolean[] rept = new boolean[256];
	/**
	 * This is pointing to the node of linked list for that particular character
	 */
	Node[] inDLL = new Node[256];
	/**
	 * Head pointer of the DLL
	 */
	Node head;
	/**
	 * Tail pointer of the DLL
	 */
	Node tail;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FirstNonRepititive f = new FirstNonRepititive();
		char stream[] = "geeksforgeeksandgeeksquizfor".toCharArray();
		// char stream[] = "abb".toCharArray();
		for (char ch : stream) {
			System.out.println("Putting " + ch);
			f.process(ch);
			System.out.println(f.getFirstNonReptitative());
		}

	}

	/**
	 * Requirement here is this function should execute in O ( 1)
	 * 
	 * @return
	 */
	public char getFirstNonReptitative() {
		char ch = 0;
		if (head != null)
			ch = head.ch;
		return ch;
	}

	/**
	 * Receiving the character, we should process it and upadte DS accordignly
	 * 
	 * @param ch
	 */
	public void process(char ch) {
		// if this character is already appeared, I don't need to do anything
		if (!rept[ch]) {
			// Execution reached here means this character is appearing for this
			// first time or 2nd time
			if (inDLL[ch] == null) {
				// this means character has appeared for the first time
				inDLL[ch] = new Node(ch);
				if (head == null) {
					head = inDLL[ch];
					tail = inDLL[ch];
				} else {
					tail.next = inDLL[ch];
					inDLL[ch].prev = tail;
					tail = tail.next;
				}
			} else {
				// character has appeared for the 2nd time
				rept[ch] = true;
				Node temp = inDLL[ch];
				inDLL[ch] = null;
				if (temp.prev == null && temp.next == null) {
					head = null;
					tail = null;
				} else {
					if (temp.prev != null) {
						temp.prev.next = temp.next;
					} else {
						head = temp.next;
					}
					if (temp.next != null) {
						temp.next.prev = temp.prev;
					} else {
						tail = tail.prev;
					}
				}
			}
		}

		// this character has appeared for the 2nd time

	}

	/**
	 * @author d35kumar
	 *
	 */
	class Node {
		char ch;
		Node prev;
		Node next;

		Node(char ch) {
			this.ch = ch;
		}
	}
}
