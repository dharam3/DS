/**
 * 
 */
package com.sed.unionFind;

/**
 * @author d35kumar
 *
 */
public class UnionFind3 extends UF {

	// used for 3rd implementation
	final int sz[];

	public UnionFind3(int n) {
		super(n);
		sz = new int[n];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sed.unionFind.UF#isConnected(int, int)
	 */
	@Override
	public boolean isConnected(int a, int b) {
		return root(a) == root(b);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sed.unionFind.UF#union(int, int)
	 */
	@Override
	public void union(int p, int q) {
		int rootP = root(p);
		int rootQ = root(q);
		if (rootP == rootQ)
			return;
		// make smaller tree the child of bigger tree
		if (sz[p] > sz[q]) {
			// size of tree in which p is residing is greater than of q's tree
			// so q's parent should be p's root
			obj[rootQ] = rootP;
			// also increase the root of P tree;
			sz[rootP] += sz[rootQ];
		} else {
			// it means q's tree is larger than or equal to p's tree
			obj[rootP] = rootQ;
			sz[rootQ] += sz[rootP];
		}

	}

}
