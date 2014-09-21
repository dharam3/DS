package com.dk.dynamicProgramming;

public class KnapSack {

	public static void main(String[] args) {
		// int wt[] = {1, 2, 3};
		// int val[] = {2, 4, 8};
		// int W = 3;

		int wt[] = { 10, 20, 30 };
		int val[] = { 60, 100, 120 };
		int W = 50;

		int maxVal = knapSack(W, wt, val);
		System.out.println("Maximum Value possible for weight " + W + " is: "
				+ maxVal);

	}

	// Returns the maximum value that can be put in a knapsack of capacity W
	static int knapSack(int W, int wt[], int val[]) {
		int i, w;
		int n = wt.length;
		int K[][] = new int[n + 1][W + 1];

		// Build table K[][] in bottom up manner
		for (i = 0; i <= n; i++) {
			// Each column represents unique weight upto max weight W
			for (w = 0; w <= W; w++) {
				if (i == 0 || w == 0) // reset for top row or leftmost column
					K[i][w] = 0;
				else if (wt[i - 1] <= w) // Max of {current ith value + matrix
											// row above for reduced weight} OR
											// {value one row above in same
											// column}
					K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]],
							K[i - 1][w]);
				else
					K[i][w] = K[i - 1][w];
			}
		}

		printTable(K, n + 1, W + 1);
		return K[n][W];
	}

	static void printTable(int table[][], int rows, int cols) {
		System.out.println("Table");
		for (int j = 0; j < cols; j++) {
			System.out.print(j + "\t");
		}
		System.out.println("");
		for (int j = 0; j < cols; j++) {
			System.out.print("--------");
		}
		System.out.println("");

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(table[i][j] + "\t");
			}
			System.out.println("");
		}
	}

}