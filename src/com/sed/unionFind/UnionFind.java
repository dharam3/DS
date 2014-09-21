/**
 * 
 */
package com.sed.unionFind;


/**
 * First implementation
 * 
 * @author d35kumar
 *
 */
public class UnionFind extends UF {

	/**
	 * @param n
	 *            number of elements
	 */
	public UnionFind(int n) {
		super(n);
	}

	public boolean isConnected(int a, int b) {
		checkRange(a);
		checkRange(b);
		return obj[a] == obj[b];
	}

	/* (non-Javadoc)
	 * @see com.sed.unionFind.UF#union(int, int)
	 */
	public void union(int a, int b) {
		checkRange(a);
		checkRange(b);
		int valA = obj[a];
		int valB = obj[b];
		for (int i = 0; i < obj.length; i++) {
			if (obj[i] == valA)
				obj[i] = valB;
		}
	}

}
