/**
 * 
 */
package com.dk.backtracking;

/**
 * 
 * Given a set of n integers, divide the set in two subsets of n/2 sizes each
 * such that the difference of the sum of two subsets is as minimum as possible.
 * If n is even, then sizes of two subsets must be strictly n/2 and if n is odd,
 * then size of one subset must be (n-1)/2 and size of other subset must be
 * (n+1)/2.
 * 
 * For example, let given set be {3, 4, 5, -3, 100, 1, 89, 54, 23, 20}, the size
 * of set is 10. Output for this set should be {4, 100, 1, 23, 20} and {3, 5,
 * -3, 89, 54}. Both output subsets are of size 5 and sum of elements in both
 * subsets is same (148 and 148). Let us consider another example where n is
 * odd. Let given set be {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4}. The
 * output subsets should be {45, -34, 12, 98, -1} and {23, 0, -99, 4, 189, 4}.
 * The sums of elements in two subsets are 120 and 121 respectively.
 * 
 * @author d35kumar
 *
 */
public class TugOfWar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4};
		TOW(arr);

	}

	private static void TOW(int[] array) {
		boolean[] currentCondition = new boolean[array.length];
		boolean[] finalSolution = new boolean[array.length];
		int sum = 0;
		int minDiff = Integer.MAX_VALUE;
		for (int v : array)
			sum += v;

		TOWUtil(array, currentCondition, 0, finalSolution, minDiff, sum, sum, 0);
		
		System.out.println("First array ");
		for(int i=0;i<finalSolution.length;i++){
			if(finalSolution[i])
				System.out.print(array[i]+",   ");
		}
		
		System.out.println("\nSecond array ");
		for(int i=0;i<finalSolution.length;i++){
			if(!finalSolution[i])
				System.out.print(array[i]+",   ");
		}

	}

	private static void TOWUtil(int[] array, boolean[] currentCondition,
			int noOfSelectedElements, boolean[] finalSolution,
			int minDifference, int sum, int currentSum, int currentPosition) {
		int n = array.length;
		if (currentPosition == n) {
			//System.out.println("DONE");// print all elements
			return;
		}
		if (n / 2 - noOfSelectedElements > n - currentPosition) {
			// System.out.println("Not enough element. ");
			return;
		}
		TOWUtil(array, currentCondition, noOfSelectedElements, finalSolution,
				minDifference, sum, currentSum, currentPosition + 1);
		noOfSelectedElements++;
		currentSum += array[currentPosition];
		currentCondition[currentPosition] = true;

		// checks if a solution is formed
		if (noOfSelectedElements == n / 2) {
			// checks if the solution formed is better than the best solution so
			// far
			if (Math.abs(sum / 2 - currentSum) < minDifference) {
				minDifference = Math.abs(sum / 2 - currentSum);
				for (int i = 0; i < n; i++)
					finalSolution[i] = currentCondition[i];
				//System.out.println("MinDifference is " + minDifference);
			}
		} else {
			// consider the cases where current element is included in the
			// solution
			TOWUtil(array, currentCondition, noOfSelectedElements,
					finalSolution, minDifference, sum, currentSum,
					currentPosition + 1);
		}

		// removes current element before returning to the caller of this
		// function
		currentCondition[currentPosition] = false;

	}
}
