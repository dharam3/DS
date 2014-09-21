/**
 * 
 */
package com.dk.linkedlist;

/**
 * @author d35kumar
 *
 */
public class SLLWithAuxPointer {
	SinglyLinkedList linkedlist;
	SinglyLinkedList auxPointer;
	SLLWithAuxPointer next;

	/**
	 * 
	 */
	public SLLWithAuxPointer(int data) {
		linkedlist = new SinglyLinkedList(data);
	}

	public void setAuxiallaryPointer(SinglyLinkedList aux) {
		this.auxPointer = aux;
	}

	public void setNextSll(SLLWithAuxPointer next) {
		this.next = next;
		this.next.linkedlist = next.linkedlist;
	}

	public String toString() {
		return linkedlist.toString() + " AND "
				+ (auxPointer != null ? auxPointer.toString() : " NULL");
	}
}
