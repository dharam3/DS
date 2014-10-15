/**
 * 
 */
package com.dk.dynamicProgramming;

/**
 * 
 * A board has n*m cells, and there is a gift with some value (value is greater
 * than 0) in every cell. You can get gifts starting from the top-left cell, and
 * move right or down in each step, and finally reach the cell at the
 * bottom-right cell. What’s the maximal value of gifts you can get from the
 * board?<br>
 * 
 * 1, 10, 3, 8<br>
 * 12, 2, 9, 6<br>
 * 5, 7, 4, 11<br>
 * 3, 7, 16, 5<br>
 * 
 * For example, the maximal value of gift from the board above is 53, and the
 * path is 1-->12-->5-->7-->7-->16-->5.
 * 
 * @author d35kumar
 *
 */
public class MaxValueGift {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] a = { { 1, 10, 3, 8 }, { 12, 3, 9, 6 }, { 5, 7, 4, 11 },
				{ 3, 7, 16, 5 } };
		System.out.println("Maximum gift that can be calculated is "
				+ calculateMaxGift(a));
	}

	/**
	 * This can be solved through dynamic programming very easily. To get the
	 * max value i, jth cell, we can reach to it either from (i-1, j)th cell or
	 * from (i, j-1)th cell.
	 * 
	 * So the maximum gift value which can be achieved in cell (i, j) is
	 * 
	 * max( gift[i-1][j], gift[i][j-1]) + a[i][j];
	 * 
	 * @param a
	 *            gift value in each cell
	 * @return Maximum gift which can be accumulated in bottom right cell
	 */
	static int calculateMaxGift(int a[][]) {
		int R = a.length;
		int C = a[0].length;
		int maxGiftEachCell[][] = new int[R + 1][C + 1];
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				maxGiftEachCell[i][j] = Math.max(maxGiftEachCell[i - 1][j],
						maxGiftEachCell[i][j - 1]) + a[i - 1][j - 1];

			}

		}

		return maxGiftEachCell[R][C];
	}
}
