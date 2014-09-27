/**
 * 
 */
package com.dk.greedy;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * Create HuffMan encoding for the supplied characters and it's frequency
 * 
 * @author d35kumar
 *
 */
public class HuffmanCoding {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char[] ch = { 'a', 'b', 'c', 'd', 'e', 'f' };
		int[] freq = { 5, 9, 12, 13, 16, 45 };
		CharFreq[] charFreq = new CharFreq[ch.length];
		for (int i = 0; i < ch.length; i++) {
			charFreq[i] = new CharFreq(ch[i], freq[i]);
		}
		caculateHuffManEncoding(charFreq);
		System.out.println("\n===================================");
		System.out
				.println("HuffMan code calculated for each character are as ");
		for (CharFreq chf : charFreq) {
			System.out.println(chf.ch + "    "
					+ Integer.toBinaryString(chf.huffMan));
		}

	}

	/**
	 * 
	 * @param charFreq
	 */
	static void caculateHuffManEncoding(CharFreq[] charFreq) {
		Queue<CharFreq> pQueue = new PriorityQueue<HuffmanCoding.CharFreq>();
		List<CharFreq> chF = Arrays.asList(charFreq);
		pQueue.addAll(chF);
		// Create Huffman tree
		while (pQueue.size() > 1) {
			CharFreq left = pQueue.remove();
			CharFreq right = pQueue.remove();
			CharFreq internal = new CharFreq(left.freq + right.freq, left,
					right);
			pQueue.add(internal);
		}

		// huffManEncoding(pQueue.remove(), new StringBuilder());
		huffManEncoding(pQueue.remove(), 0);

	}

	/**
	 * @param rootNode
	 * @param code
	 *            Starting with 0
	 * @return It is used for just calculating the huffrecursion value further.
	 *         It's is not returning any final value
	 */
	static int huffManEncoding(CharFreq rootNode, int code) {
		if (!rootNode.isLeafNode()) {
			// While going left left shift one bit, so that 0 will be appended
			// at last
			code = code << 1;
			code = huffManEncoding(rootNode.left, code);
			// while going right, left shift 1 bit and Or with 1, so that 1 will
			// be appended at last
			code = (code << 1) | 1;
			code = huffManEncoding(rootNode.right, code);
		} else {
			rootNode.huffMan = code;
		}
		// While going back right shift by one bit, to discard it
		return code >> 1;
	}

	/**
	 * Same as above function, but using StringBuilder instead of int. This is
	 * only for readability purpose. <br>
	 * This is for traversing the tree and assigning the huffman code when leaf
	 * node is encountered
	 * 
	 * @param rootNode
	 *            Root node of the tree
	 * @param code
	 *            Empty stringBuilder, which
	 */
	static void huffManEncoding(CharFreq rootNode, StringBuilder code) {
		if (!rootNode.isLeafNode()) {
			// While going left append 0
			code.append(0);
			huffManEncoding(rootNode.left, code);
			// while going right, append 1
			code.append(1);
			huffManEncoding(rootNode.right, code);
		} else {
			rootNode.huffMan = Integer.parseInt(code.toString());
		}
		// remove the last character while going back
		if (code.length() > 0)
			code.deleteCharAt(code.length() - 1);
	}

	/**
	 * @author d35kumar
	 *
	 */
	static class CharFreq implements Comparable<CharFreq> {
		/**
		 * Character. If it's internal node, this will be blank
		 */
		char ch;
		/**
		 * Frequency of character
		 */
		int freq;
		/**
		 * If it is internal node, then it's left node
		 */
		CharFreq left;
		/**
		 * If it is internal node, then it's right node
		 */
		CharFreq right;
		/**
		 * This will be populated while traversing the huffman tree. By default
		 * -1
		 */
		int huffMan = -1;

		/**
		 * @param ch
		 * @param freq
		 */
		public CharFreq(char ch, int freq) {
			this.ch = ch;
			this.freq = freq;
		}

		/**
		 * @param ch
		 * @param freq
		 */
		public CharFreq(int freq, CharFreq left, CharFreq right) {
			this.freq = freq;
			this.left = left;
			this.right = right;
		}

		@Override
		public int compareTo(CharFreq o) {
			return this.freq - o.freq;
		}

		/**
		 * @return
		 */
		public boolean isLeafNode() {
			return left == null && right == null;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "CharFreq [ch=" + ch + ", freq=" + freq + ", huffMan="
					+ huffMan + "]";
		}

	}

}
