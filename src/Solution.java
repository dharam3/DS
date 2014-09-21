class Solution {
	public int solution(int[] A) {
		boolean temp[] = new boolean[A.length];
		boolean result = true;
		for (int i : A) {
			if (i > A.length) {
				result = false;
				break;
			}
			temp[i - 1] = true;
		}

		for (boolean b : temp) {
			result &= b;
			if (!result)
				break;
		}
		return result ? 1 : 0;
	}

	public int solutionA(int[] A) {
		int totalSum = 0;
		for (int i : A)
			totalSum += i;
		int min = Integer.MAX_VALUE;
		int sumSoFar = 0;
		for (int i : A) {
			sumSoFar += i;
			min = Math.min(min, Math.abs(totalSum - (sumSoFar << 1)));
		}
		return min;
	}

	public int solutionB(int X, int Y, int D) {
		int extraStep = (Y - X) % D == 0 ? 0 : 1;
		return ((Y - X) / D) + extraStep;
	}

	/**
	 * A zero-indexed array A consisting of N different integers is given. The
	 * array contains integers in the range [1..(N + 1)], which means that
	 * exactly one element is missing. Your goal is to find that missing
	 * element. Write a function: class Solution { public int solution(int[] A);
	 * } that, given a zero-indexed array A, returns the value of the missing
	 * element. For example, given array A such that: A[0] = 2 A[1] = 3 A[2] = 1
	 * A[3] = 5 the function should return 4, as it is the missing element.
	 * Assume that: N is an integer within the range [0..100,000]; the elements
	 * of A are all distinct; each element of array A is an integer within the
	 * range [1..(N + 1)]. Complexity: expected worst-case time complexity is
	 * O(N); expected worst-case space complexity is O(1), beyond input storage
	 * (not counting the storage required for input arguments). Elements of
	 * input arrays can be modified.
	 * 
	 * @param A
	 * @return
	 */
	public int solutionC(int[] A) {
		for (int i = 0; i < A.length; i++) {
			int v = A[i];
			if (i != A[i] - 1) {
				int swapAt = v - 1;
				if (v > A.length)
					swapAt = A.length - 1;
				A[i] = A[swapAt];
				A[swapAt] = v;
			}
		}
		int missingNumber = 0;
		for (int i = 0; i < A.length; i++) {
			if (i != A[i] - 1) {
				missingNumber = i + 1;
				break;
			}
		}
		return missingNumber;
	}

	public static void main(String args[]) {

		// int [] A={4,1,3};
		Solution s = new Solution();
		// int i=s.solution(A);
		// int A[] = { 3, -5, 4, 2, 6 };// {3,1,2,4,3};

		// int i = s.solutionA(A);
		// assert i == 2;

		// int i = s.solutionB(10, 70, 30);
		int A[] = { 4, 3, 1, 5 };
		int i = s.solutionC(A);
		System.out.println("===>" + i);
	}
}