/**
 * 
 */
package com.dk.linkedlist;

/**
 * @author d35kumar
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// SinglyLinkedList head = new SinglyLinkedList(5);
		// SinglyLinkedList temp = head;
		// for (int i = 4; i > 0; i--) {
		// temp.next = new SinglyLinkedList(i);
		// temp = temp.next;
		// }
		// System.out.println(head);
		// testSLLWithAuxPointer();
		// head = head.reverse();
		// reverse(head, 3);
		// recursiveReverse(head);
		// System.out.println(h);

		// printPossible("", 3, 0);
		testDLLWithAux();

	}

	public static void testDLLWithAux() {
		DLL head = new DLL(1);
		DLL temp = head;
		for (int i = 2; i < 6; i++) {
			DLL d = new DLL(i);
			temp.next = d;
			temp = d;
		}

		System.out.println(temp.data);
		// while (head != null) {
		// System.out.print(head.data + "  ");
		// head = head.next;
		// }
	}

	static void testSLLWithAuxPointer() {
		SLLWithAuxPointer sll = new SLLWithAuxPointer(1);
		SLLWithAuxPointer temp = sll;
		for (int i = 2; i <= 5; i++) {
			temp.next = new SLLWithAuxPointer(i);
			temp = temp.next;
		}
		System.out.println(sll);
	}

	/*
	 * private static void sort(SinglyLinkedList linkedList, int firstIndex, int
	 * lastIndex) {
	 * 
	 * }
	 */
	public static SinglyLinkedList reverse(SinglyLinkedList head, int k) {
		SinglyLinkedList prev = head;
		int index = 0;
		while (head.next != null && index < k) {
			SinglyLinkedList next = head.next;
			head.next = prev;
			prev.next = next;
			prev = head;
			head = head.next;
			index++;
		}
		head.next = reverse(head.next, k);
		return head;
	}

	/**
	 * Return nth node, if there is n node from current node, otherwise null
	 * 
	 * @param head
	 * @param n
	 * @return
	 */
	public SinglyLinkedList getNthNode(SinglyLinkedList head, int n) {
		for (int i = 0; i < n; i++) {
			if (head.next == null) {
				break;
			}
			head = head.next;
		}
		return head;
	}

	public static SinglyLinkedList reverseRecusrsively(
			SinglyLinkedList currentNode) {
		SinglyLinkedList next = currentNode.next;
		SinglyLinkedList head;
		if (currentNode == null || next == null) {
			head = currentNode;
			return currentNode;
		}

		SinglyLinkedList rest = reverseRecusrsively(next);
		rest.next = currentNode;
		currentNode.next = null;
		return currentNode;
	}

	static SinglyLinkedList h;

	public static void recursiveReverse(SinglyLinkedList currentNode) {
		// check for empty list
		if (currentNode == null)
			return;

		/*
		 * if we are at the TAIL node: recursive base case:
		 */
		if (currentNode.next == null) {
			// set HEAD to current TAIL since we are reversing list
			h = currentNode;
			return; // since this is the base case
		}

		recursiveReverse(currentNode.next);
		currentNode.next.next = currentNode;
		currentNode.next = null; // set "old" next pointer to NULL
	}

}
