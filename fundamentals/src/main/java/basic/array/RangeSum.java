package basic.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RangeSum {
	public static void main(String[] args) {

		test();
	}

	@Test
	private static void test() {
		Assertions.assertArrayEquals(
			new int[][] {
				{0, 0, 0, 0, 0},
				{0, 1, 3, 6, 10},
				{0, 3, 8, 15, 24},
				{0, 6, 15, 27, 42},
				{0, 10, 24, 42, 64}
			},
			calculateTwoDimensionalRangeSum(new int[][] {
				{0, 0, 0, 0, 0},
				{0, 1, 2, 3, 4},
				{0, 2, 3, 4, 5},
				{0, 3, 4, 5, 6},
				{0, 4, 5, 6, 7}})
		);

		Assertions.assertEquals(27, calculateSumWithRangeSum(2, 2, 3, 4,
			calculateTwoDimensionalRangeSum(new int[][] {
				{0, 0, 0, 0, 0},
				{0, 1, 2, 3, 4},
				{0, 2, 3, 4, 5},
				{0, 3, 4, 5, 6},
				{0, 4, 5, 6, 7}}
			)));

		Assertions.assertEquals(6, calculateSumWithRangeSum(3, 4, 3, 4,
			calculateTwoDimensionalRangeSum(new int[][] {
				{0, 0, 0, 0, 0},
				{0, 1, 2, 3, 4},
				{0, 2, 3, 4, 5},
				{0, 3, 4, 5, 6},
				{0, 4, 5, 6, 7}}
			)));

		Assertions.assertEquals(64, calculateSumWithRangeSum(1, 1, 4, 4,
			calculateTwoDimensionalRangeSum(new int[][] {
				{0, 0, 0, 0, 0},
				{0, 1, 2, 3, 4},
				{0, 2, 3, 4, 5},
				{0, 3, 4, 5, 6},
				{0, 4, 5, 6, 7}}
			)));
	}

	private static int[][] calculateTwoDimensionalRangeSum(int[][] numbers) {
		int[][] Snumbers = new int[numbers.length][numbers.length];
		for (int i = 1; i < numbers.length; i++) {
			for (int j = 1; j < numbers.length; j++) {
				Snumbers[i][j] = numbers[i][j] + Snumbers[i - 1][j] + Snumbers[i][j - 1] - Snumbers[i - 1][j - 1];
			}
		}
		return Snumbers;
	}

	private static int calculateSumWithRangeSum(int x1, int y1, int x2, int y2, int[][] Snumbers) {
		return Snumbers[x2][y2] - Snumbers[x2][y1 - 1] - Snumbers[x1 - 1][y2] + Snumbers[x1 - 1][y1 - 1];
	}
}
