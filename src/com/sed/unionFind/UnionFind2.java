/**
 * 
 */
package com.sed.unionFind;

/**
 * @author d35kumar
 *
 */
public class UnionFind2 extends UF {
	public UnionFind2(int n) {
		super(n);
	}

	@Override
	public boolean isConnected(int p, int q) {
		return root(p) == root(q);
	}

	@Override
	/**
	 * Make first element's parent the child of first's root
	 * @param p
	 * @param q
	 */
	public void union(int p, int q) {
		// change parent's of root of p to root of q
		int rootP = root(p);
		int rootQ = root(q);
		obj[rootP] = rootQ;
	}
}
