import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	private static int[][] sudoku;
	private static boolean finish;
	private static ArrayList<Integer> blankX;
	private static ArrayList<Integer> blankY;

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		sudoku = new int[9][9];
		blankX = new ArrayList<>();
		blankY = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 0; j < 9; j++) {
				int number = Integer.parseInt(stringTokenizer.nextToken());
				sudoku[i][j] = number;

				if (number == 0) {
					blankX.add(i);
					blankY.add(j);
				}
			}
		}

		dfs(0);

		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(sudoku[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static void dfs(int depth) {
		if (depth == blankX.size()) {
			finish = true;
			return;
		}

		int blankNumberX = blankX.get(depth);
		int blankNumberY = blankY.get(depth);

		for (int i = 1; i <= 9; i++) {

			if (!isSameNumberAtRow(blankNumberX, i) && !isSameNumberAtCol(blankNumberY, i) && !isSameNumberAt3x3(blankNumberX, blankNumberY, i)) {
				sudoku[blankNumberX][blankNumberY] = i;
				dfs(depth + 1);
			}

			if (finish) {
				return;
			}
		}
		sudoku[blankNumberX][blankNumberY] = 0;
	}

	private static boolean isSameNumberAtRow(int x, int checkNumber) {

		for (int i = 0; i < 9; i++) {
			if (sudoku[x][i] == checkNumber) {
				return true;
			}
		}
		return false;
	}

	private static boolean isSameNumberAtCol(int y, int checkNumber) {
		for (int i = 0; i < 9; i++) {
			if (sudoku[i][y] == checkNumber) {
				return true;
			}
		}
		return false;
	}

	private static boolean isSameNumberAt3x3(int x, int y, int checkNumber) {
		int boxX = (x / 3) * 3;
		int boxY = (y / 3) * 3;

		for (int i = boxX; i < boxX + 3; i++) {
			for (int j = boxY; j < boxY + 3; j++) {
				if (i == x && j == y) {
					continue;
				}

				if (sudoku[i][j] == checkNumber) {
					return true;
				}
			}

		}
		return false;
	}
}

