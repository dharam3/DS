/**
 * 
 */
package com.dk.tree;

import java.util.Stack;

/**
 * @author d35kumar
 *
 */
public class BST {
	// Node root;

	public BST(int data) {
		// root = new Node(data);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Node<Comparable<?>> root = createBalancedBST(array, 0, array.length - 1);
		// Node root = new Node(6);
		// // insertNode(root, 5);
		// insertNode(root, 7);
		// insertNode(root, 9);
		// insertNode(root, 4);
		// System.out.println(root + "  " + root.left + " " + root.right);
		// inOrder(root);
		preOrder(root);
		System.out.println("\n\n");
		BTreePrinter.printNode(root);
//		System.out.println(isBST(root));
	}

	public static Node<Comparable<?>> createBalancedBST(int[] a, int startIndex,
			int endIndex) {
		if (startIndex > endIndex)
			return null;
		int midIndex = (startIndex + endIndex) >> 1;
		Node<Comparable<?>> n = new Node<Comparable<?>>(a[midIndex]);
		n.left = createBalancedBST(a, startIndex, midIndex - 1);
		n.right = createBalancedBST(a, midIndex + 1, endIndex);
		return n;
	}

	/**
	 * In-order non recursive
	 * 
	 * @param root
	 */
	public static void inOrder(Node<Integer> root) {
		// Queue<Node> q= new ArrayDeque<Node>();
		Stack<Node> s = new Stack<>();
		System.out.println("Inorder tranversal without recursion");
		while (true) {
			while (root != null) {
				s.push(root);
				root = root.left;
			}
			if (s.isEmpty())
				break;
			root = s.pop();
			System.out.print("   " + root);
			root = root.right;
		}

	}

	public static void preOrder(Node<Comparable<?>> root) {
		Stack<Node<Comparable<?>>> s = new Stack<Node<Comparable<?>>>();
		System.out.println("Preorder");
		while (true) {
			while (root != null) {
				System.out.print("  " + root.data);
				s.push(root);
				root = root.left;
			}
			if (s.isEmpty())
				break;

			root = s.pop();
			root = root.right;
		}
	}

	private static void insertNode(Node<Integer> root, int data) {
		if (root == null) {
			root = new Node<Integer>(data);
			return;
		}
		// left subtree condition
		if (root.data.compareTo(data) > 0) {
			if (root.left == null) {
				root.left = new Node<Integer>(data);
				return;
			} else {
				insertNode(root.left, data);
			}
		} else if (root.data.compareTo(data) < 0) {// right sub-tree case
			if (root.right == null) {
				root.right = new Node<Integer>(data);
				return;
			} else {
				insertNode(root.right, data);
			}
		}
	}

//	private static boolean isBST(Node<Comparable<?>> root) {
//		if (root == null)
//			return true;
//		boolean isCurrentLevelValid = (root.left == null || root.data
//				.compareTo( root.left.data) > 0)
//				&& (root.right == null || root.data
//						.compareTo(root.right.data) < 0);
//		return isCurrentLevelValid && isBST(root.left) && isBST(root.right);
//	}
}
