/**
 * 
 */
package com.dk.dynamicProgramming;

/**
 * @author d35kumar
 *
 */
public class MaxSubArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22,
				15, -4, 7 };
		// int[] array = { 1, 2, 5, -6, 5 };
		Triplet<Integer, Integer, Integer> triplet = maxSubArray(array, 0,
				array.length - 1);

		System.out.println("\n\nMax sub array is from " + triplet.s + " to "
				+ triplet.t + " and sum is " + triplet.u);
		System.out.println("Starting element " + array[triplet.s]
				+ "end index " + array[triplet.t]);
	}

	public static Triplet<Integer, Integer, Integer> maxSubArray(int[] A,
			int lo, int hi) {
		// System.out.println("trying for lo " + lo + " hi " + hi);
		if (lo == hi)
			return new Triplet<Integer, Integer, Integer>(lo, hi, A[lo]);
		else {
			int mid = (lo + hi) >> 1;
			Triplet<Integer, Integer, Integer> leftSum = maxSubArray(A, lo, mid);
			Triplet<Integer, Integer, Integer> righSum = maxSubArray(A,
					mid + 1, hi);
			Triplet<Integer, Integer, Integer> crossSum = maxSubCrossingArray(
					A, lo, mid, hi);
			if (leftSum.u >= righSum.u && leftSum.u >= crossSum.u)
				return leftSum;
			else if (righSum.u >= leftSum.u && righSum.u >= crossSum.u)
				return righSum;
			else
				return crossSum;
		}

	}

	public static Triplet<Integer, Integer, Integer> maxSubCrossingArray(
			int[] A, int lo, int mid, int hi) {
		// System.out.println("maxSubCrossingArray lo " + lo + " mid " + mid
		// + " hi " + hi);
		int currentSum = 0, leftSum = Integer.MIN_VALUE;
		int index = mid, lowIndex = 0;
		while (index >= lo) {
			currentSum += A[index];
			if (currentSum > leftSum) {
				leftSum = currentSum;
				lowIndex = index;
			}
			index--;
		}
		index = mid + 1;
		currentSum = 0;
		int rightSum = Integer.MIN_VALUE, hiIndex = 0;
		while (index <= hi) {
			currentSum += A[index];
			if (currentSum > rightSum) {
				rightSum = currentSum;
				hiIndex = index;
			}
			index++;
		}
		return new Triplet<Integer, Integer, Integer>(lowIndex, hiIndex,
				leftSum + rightSum);
	}
}

class Triplet<S, T, U> {
	S s;
	T t;
	U u;

	/**
	 * @param s
	 * @param t
	 * @param u
	 */
	public Triplet(S s, T t, U u) {
		this.t = t;
		this.s = s;
		this.u = u;
	}

	/**
	 * @return the s
	 */
	public S getS() {
		return s;
	}

	/**
	 * @param s
	 *            the s to set
	 */
	public void setS(S s) {
		this.s = s;
	}

	/**
	 * @return the t
	 */
	public T getT() {
		return t;
	}

	/**
	 * @param t
	 *            the t to set
	 */
	public void setT(T t) {
		this.t = t;
	}

	/**
	 * @return the u
	 */
	public U getU() {
		return u;
	}

	/**
	 * @param u
	 *            the u to set
	 */
	public void setU(U u) {
		this.u = u;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Triplet [s=" + s + ", t=" + t + ", u=" + u + "]";
	}

}
