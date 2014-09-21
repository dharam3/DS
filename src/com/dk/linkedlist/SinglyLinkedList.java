/**
 * 
 */
package com.dk.linkedlist;

/**
 * @author d35kumar
 *
 */
public class SinglyLinkedList {

	int data;
	SinglyLinkedList next;

	SinglyLinkedList(int data) {
		this.data = data;
	}

	public void addNext(SinglyLinkedList next) {
		this.next = next;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return data + "-->" + next;
	}

	public SinglyLinkedList reverse() {
		SinglyLinkedList head = this;
		SinglyLinkedList prev = head;
		head = head.next;
		prev.next = null;
		while (head != null) {
			SinglyLinkedList next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}

}
