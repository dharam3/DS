/**
 * 
 */
package com.sed.unionFind;

import com.sed.lib.StdOut;

/**
 * @author d35kumar
 *
 */
public class UnionFindTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// StdOut.print("Enter number of objects ");
		int numberOfObjects = 5;// StdIn.readInt();
		UF un = new UnionFind3(numberOfObjects);

		un.union(1, 2);
		un.union(2, 4);
		un.union(2, 3);
		StdOut.println();
		StdOut.println(un.isConnected(1, 4));
		StdOut.println(un.isConnected(1, 3));
		StdOut.println(un.isConnected(0, 3));
		// while(!StdIn.isEmpty()){
		// int p= StdIn.readInt();
		// int q= StdIn.readInt();
		// if(!un.isConnected(p, q)){
		// un.union(p, q);
		// StdOut.print(p+"  "+q);
		// }
		// }
		// System.out.println("Done ");
	}

}
