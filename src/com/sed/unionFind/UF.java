/**
 * 
 */
package com.sed.unionFind;

/**
 * @author d35kumar
 *
 */
public abstract class UF {
	final int[] obj;

	public UF(int n) {
		obj = new int[n];
		for (int i = 0; i < n; i++) {
			obj[i] = i;
		}
	}

	void checkRange(int v) throws RuntimeException {
		if (v >= obj.length)
			throw new RuntimeException(v + " Value should be less than "
					+ (obj.length - 1));
	}

	int root(int a) {
		while (obj[a] != a)
			a = obj[a];
		return a;
	}

	/**
	 * @param a
	 * @param b
	 * @return true, if a and b is connected, false otherwise
	 */
	public abstract boolean isConnected(int a, int b);

	public abstract void union(int a, int b);
}
