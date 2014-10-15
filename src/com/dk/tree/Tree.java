/**
 * 
 */
package com.dk.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Questions from Karumachi book
 * 
 * @author d35kumar
 *
 */
public class Tree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = new int[] { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
				15 };
		Node root = new Node(1);
		for (int each : array) {
			insertNewNode(root, each);
		}
		BTreePrinter.printNode(root);
		// printPathToEachLeaf(root);
		printPathToParticularNode(root, 5);
		// Node head = convertBT2DLL(root);
		// while (head != null) {
		// System.out.print("  " + head);
		// head = head.right;
		// }

		// zigZagLevelOrder(root);
		// boolean i = isSibling(root, 5, 4);
		// System.out.println(" both are sibling " + i);
		// int level = levelOfNode(root, 3, 0);
		// System.out.println(level);
		// levelOrder(root);
		// System.out.println("\n Reverse level order ");
		// reverseLevelOrder(root);
		// Node n = mirror(root);
		// System.out.println("\nMirror ");
		// levelOrder(n);
		// System.out.println(depthOfTree(root) + "   " + depthOfTree1(root));
		// System.out.println("\nDepth of tree " + depthOfTree(root)
		// + " maximum sun in level " + maxSumInLevel(root));
		// System.out.println("Ancestor of 1 are ");
		// printAllAncestar(root, 1);
		// System.out.println();

		// Node common = findCommonAncestor(root, 4, 8);
		// System.out.println("Common ancestor of " + common);
		// zigZagLevelOrder1(root);
		int count = countSameHorizontalDistanceNodePair(root);
		System.out.println("\n========>" + count);

	}

	static int countSameHorizontalDistanceNodePair(Node root) {
		int count = 0;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		queue.add(null);
		boolean previousNodeHadRightChild = false;
		while (!queue.isEmpty()) {
			Node currentNode = queue.poll();
			if (currentNode == null) {
				if (!queue.isEmpty()) {
					queue.add(null);
				}
				previousNodeHadRightChild = false;
			} else {
				if (currentNode.left != null) {
					queue.add(currentNode.left);
					if (previousNodeHadRightChild)
						count++;
				}
				if (currentNode.right != null) {
					queue.add(currentNode.right);
					previousNodeHadRightChild = true;
				} else {
					previousNodeHadRightChild = false;
				}
			}
		}

		return count;
	}

	static boolean printPathToParticularNode(Node root, int targetNode) {
		if (root == null)
			return false;
		if ((int) root.data == targetNode
				|| printPathToParticularNode(root.left, targetNode)
				|| printPathToParticularNode(root.right, targetNode)) {
			System.out.print("   " + root.data);
			return true;
		}
		return false;

	}

	static void printPathToEachLeaf(Node root) {
		printPathToEachLeaf(root, new ArrayList<Node>(), 0);
	}

	static void printPathToEachLeaf(Node root, ArrayList<Node> path, int index) {
		if (root == null) {
			System.out.println("There is no elemenet in tree");
			return;
		}
		if (path.size() <= index) {
			path.add(index++, root);
		} else {
			path.set(index++, root);
		}

		if (root.left == null && root.right == null) {
			System.out.println("Path till leaf node " + root.data);
			for (Node node : path) {
				System.out.print("	" + node.data);
			}
			System.out.println();
			// path.remove(path.size() - 1);

		} else {
			printPathToEachLeaf(root.left, path, index);
			printPathToEachLeaf(root.right, path, index);
		}
	}

	private static void insertNewNode(Node root, int data) {
		Node newNode = new Node(data);
		// if (root == null)
		// return new Node(data);
		// else {
		Queue<Node> q = new ArrayDeque<Node>();
		q.add(root);
		while (!q.isEmpty()) {
			Node temp = q.poll();
			if (temp.left == null) {
				temp.left = newNode;
				break;
			} else {
				q.add(temp.left);
			}

			if (temp.right == null) {
				temp.right = newNode;
				break;
			} else {
				q.add(temp.right);
			}
		}
	}

	/**
	 * Keep on searching the node, and when found return same to it;s parent,
	 * While
	 * 
	 * @param root
	 * @param a
	 * @param b
	 * @return
	 */
	private static Node findCommonAncestor(Node root, int a, int b) {
		if (root == null)
			return null;
		System.out.println("Processing Node  " + root.data);
		Node left, right;
		if (root.data.compareTo(a) == 0 || root.data.compareTo(b) == 0) {
			return root;
		}
		left = findCommonAncestor(root.left, a, b);
		right = findCommonAncestor(root.right, a, b);
		if (left != null && right != null)
			return root;
		else
			return left != null ? left : right;
	}

	/**
	 * @param root
	 * @param nodeData
	 * @return
	 */
	public static boolean printAllAncestar(Node root, int nodeData) {
		if (root == null) {
			return false;// not found
		}
		if ((root.left != null && root.left.data.compareTo(nodeData) == 0)
				|| (root.right != null && root.right.data.compareTo(nodeData) == 0)
				|| printAllAncestar(root.left, nodeData)
				|| printAllAncestar(root.right, nodeData)) {
			System.out.println("	" + root.data);
			return true;
		}
		return false;
	}

	/**
	 * @param root
	 */
	public static void preOrder(Node root) {
		if (root == null)
			return;
		System.out.print(root.data);
		preOrder(root.left);
		preOrder(root.right);

	}

	/**
	 * @param root
	 */
	public static void levelOrder(Node root) {
		if (root == null)
			return;
		Queue<Node> q = new ArrayDeque<Node>();
		q.add(root);
		while (!q.isEmpty()) {
			Node n = q.poll();
			System.out.print(n.data + " ");
			if (n.left != null)
				q.add(n.left);
			if (n.right != null)
				q.add(n.right);
		}

	}

	/**
	 * @param root
	 */
	public static void zigZagLevelOrder1(Node root) {
		Stack<Node> s1 = new Stack<Node>();
		MarkerNode marker = new MarkerNode();
		// Stack<Node> s2 = new Stack<Node>();
		boolean L2R = true;
		s1.push(marker);
		s1.push(root);

		while (!s1.isEmpty()) {
			Node temp = s1.pop();
			if (temp instanceof MarkerNode) {
				L2R = !L2R;
				if (!s1.isEmpty())
					s1.add(marker);
			} else {
				System.out.println("   " + temp);
				if (L2R) {
					if (temp.left != null)
						s1.push(temp.left);
					if (temp.right != null)
						s1.push(temp.right);
				} else {
					if (temp.right != null)
						s1.push(temp.right);
					if (temp.left != null)
						s1.push(temp.left);
				}
			}

		}
	}

	public static void zigZagLevelOrder2(Node root) {
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		boolean L2R = true;
		s1.push(root);
		while (!(s1.isEmpty() && s2.isEmpty())) {
			if (L2R) {
				if (!s1.isEmpty()) {
					Node temp = s1.pop();
					System.out.println("   " + temp);
					if (temp.left != null)
						s2.push(temp.left);
					if (temp.right != null)
						s2.push(temp.right);
				} else {
					L2R = false;
				}
			} else {
				if (!s2.isEmpty()) {
					Node temp = s2.pop();
					System.out.println("   " + temp);
					if (temp.right != null)
						s1.push(temp.right);
					if (temp.left != null)
						s1.push(temp.left);
				} else {
					L2R = true;
				}
			}
		}
	}

	/**
	 * NOT completed*************************
	 * 
	 * @param root
	 */
	public static void zigZagLevelOrder(Node root) {
		if (root == null)
			return;
		// Queue<Node<Comparable<?>>> q = new LinkedList<Node<Comparable<?>>>();
		// MarkerNode marker = new MarkerNode();
		// boolean leftToRight = false;
		// q.add(root);
		// q.add(marker);
		// while (!q.isEmpty()) {
		// Node temp = q.poll();
		// if (temp instanceof MarkerNode) {
		// leftToRight = !leftToRight;
		// if (!q.isEmpty())
		// q.add(marker);
		// } else {
		// System.out.println(" current processed node "+temp);
		// if (leftToRight) {
		// if (temp.left != null) {
		// q.add(temp.left);
		// }
		// if (temp.right != null)
		// q.add(temp.right);
		// } else {
		// if (temp.right != null) {
		// q.add(temp.right);
		// }
		// if (temp.left != null) {
		// q.add(temp.left);
		// }
		// }
		// }
		// }

	}

	public static boolean isSibling(Node root, int a, int b) {
		if (root == null || root.left == null || root.right == null)
			return false;
		return (root.left.data.compareTo(a) == 0 && root.right.data
				.compareTo(b) == 0)
				|| (root.left.data.compareTo(b) == 0 && root.right.data
						.compareTo(a) == 0)
				|| isSibling(root.left, a, b)
				|| isSibling(root.right, a, b);
	}

	public static void reverseLevelOrder(Node root) {
		if (root == null)
			return;
		Stack<Node> s = new Stack<>();
		Queue<Node> q = new ArrayDeque<Node>();
		q.add(root);
		Node temp;
		while (!q.isEmpty()) {
			temp = q.poll();
			if (temp.right != null) {
				q.add(temp.right);
			}
			if (temp.left != null) {
				q.add(temp.left);
			}
			s.add(temp);
		}
		while (!s.isEmpty()) {
			System.out.print("	" + s.pop());
		}

	}

	public static Node mirror(Node root) {
		if (root == null)
			return null;
		else {
			Node newRoot = new Node(root.data);
			newRoot.left = mirror(root.right);
			newRoot.right = mirror(root.left);
			return newRoot;
		}

	}

	/**
	 * Do level order traversing and increment the count at each level
	 * 
	 * @param root
	 * @return
	 */
	public static int depthOfTree(Node root) {
		int depth = 0;
		MarkerNode marker = new MarkerNode();
		Queue<Node> q = new ArrayDeque<Node>();
		q.add(root);
		q.add(marker);// add a marker in queue, which indicates end of
						// level
		while (!q.isEmpty()) {
			Node temp = q.poll();
			if (temp instanceof MarkerNode) {
				if (!q.isEmpty()) {
					q.add(marker);
					depth++;
				}
			} else {
				if (temp.left != null) {
					q.add(temp.left);
				}
				if (temp.right != null) {
					q.add(temp.right);
				}
			}
		}

		return depth;
	}

	/**
	 * @param root
	 * @return
	 */
	public static int depthOfTree1(Node root) {
		if (root == null)
			return -1;
		return Math.max(depthOfTree1(root.left), depthOfTree1(root.right)) + 1;
	}

	/**
	 * Level of node
	 * 
	 * @param root
	 * @param data
	 * @param level
	 * @return
	 */
	public static int levelOfNode(Node root, int data, int level) {
		// System.out.println("Current node " + root);
		if (root == null)
			return 0;
		if (root.data.compareTo(data) == 0) {
			// System.out.println("Hurrey found level is " + level);
			return level;
		}
		// System.out.println("Checking left of " + root);
		int l = levelOfNode(root.left, data, level + 1);
		if (l != 0)
			return l;
		// System.out.println("Checking right of " + root);
		return levelOfNode(root.right, data, level + 1);
	}

	/**
	 * While doing level order traversing, keep track of sum of each level
	 * 
	 * @param root
	 * @return
	 */
	public static int maxSumInLevel(Node root) {
		if (root == null)
			return 0;
		int maxSum = Integer.MIN_VALUE;
		int currentSum = 0;
		MarkerNode marker = new MarkerNode();
		Node temp;
		Queue<Node> q = new ArrayDeque<Node>();
		q.add(root);
		q.add(marker);
		while (!q.isEmpty()) {
			temp = q.poll();

			if (temp instanceof MarkerNode) {
				if (currentSum > maxSum)
					maxSum = currentSum;
				currentSum = 0;
				if (!q.isEmpty()) {
					q.add(marker);
				}
			} else {
				if (temp.left != null)
					q.add(temp.left);
				if (temp.right != null)
					q.add(temp.right);
				currentSum = currentSum + (int) temp.data;
			}

		}
		return maxSum;
	}

	static Node convertBT2DLL(Node root) {
		if (root == null)
			return null;
		root = convertBT2DLLUtil(root);
		for (; root.left != null; root = root.left)
			;
		return root;

	}

	private static Node convertBT2DLLUtil(Node root) {
		if (root == null) {
			return null;
		}
		if (root.left != null) {
			Node left = convertBT2DLLUtil(root.left);
			for (; left.right != null; left = left.right)
				;
			left.right = root;
			root.left = left;
		}
		if (root.right != null) {
			Node right = convertBT2DLLUtil(root.right);
			for (; right.left != null; right = right.left)
				;

			root.right = right;
			right.left = root;
		}
		return root;
	}
}

class MarkerNode<T extends Comparable<T>> extends Node<T> {
	boolean leftToRight;

	/**
	 * @return the leftToRight
	 */
	public boolean isLeftToRight() {
		return leftToRight;
	}

	/**
	 * @param leftToRight
	 *            the leftToRight to set
	 */
	public void setLeftToRight(boolean leftToRight) {
		this.leftToRight = leftToRight;
	}

}