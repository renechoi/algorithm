
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(bufferedReader.readLine());
		char[][] candyBox = new char[N][N];

		for (int i = 0; i < N; i++) {
			candyBox[i] = bufferedReader.readLine().toCharArray();
		}

		int max = 1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (j + 1 < N && isRowAdjacentDifferent(i, j, candyBox)) {
					swap(candyBox, i, i, j, j + 1);
					max = Math.max(max, Math.max(findColumnMax(candyBox), findRowMax(candyBox)));
					swap(candyBox, i, i, j, j + 1);
				}

				if (i + 1 < N && isColumnAdjacentDifferent(i, j, candyBox)) {
					swap(candyBox, i,i + 1, j,  j);
					max = Math.max(max, Math.max(findColumnMax(candyBox), findRowMax(candyBox)));
					swap(candyBox, i,i + 1, j,  j);
				}

			}
		}

		System.out.println(max);

	}

	private static boolean isRowAdjacentDifferent(int i, int j, char[][] candyBox) {
		return candyBox[i][j] != candyBox[i][j + 1];
	}

	private static boolean isColumnAdjacentDifferent(int i, int j, char[][] candyBox) {
		return candyBox[i][j] != candyBox[i + 1][j];
	}

	private static void swap(char[][] candyBox, int row1, int row2, int col1, int col2) {
		char temp = candyBox[row1][col1];
		candyBox[row1][col1] = candyBox[row2][col2];
		candyBox[row2][col2] = temp;
	}

	private static int findRowMax(char[][] map) {
		int N = map.length;
		int maxRow = 0;
		for (int row = 0; row < N; row++) {
			int len = 1;
			for (int col = 1; col < N; col++) {
				if (map[row][col] == map[row][col - 1]) {
					len++;
				} else {
					maxRow = Math.max(maxRow, len);
					len = 1;
				}
			}
			maxRow = Math.max(maxRow, len);
		}
		return maxRow;
	}

	private static int findColumnMax(char[][] map) {
		int N = map.length;
		int maxColumn = 0;
		for (int column = 0; column < N; column++) {
			int len = 1;
			for (int row = 1; row < N; row++) {
				if (map[row][column] == map[row-1][column]) {
					len++;
				} else {
					maxColumn = Math.max(maxColumn, len);
					len = 1;
				}
				maxColumn = Math.max(maxColumn, len);
			}
		}
		return maxColumn;
	}

}

