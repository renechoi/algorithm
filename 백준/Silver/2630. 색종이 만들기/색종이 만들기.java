import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	private static int white = 0;
	private static int blue = 0;
	private static int[][] paper;
	private static int size;
	private static BufferedReader bufferedReader;

	public static void main(String[] args) throws IOException {

		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(bufferedReader.readLine());

		getColoredPaper();
		divideAndConquer(0, 0, size);

		System.out.println(white);
		System.out.println(blue);

	}

	private static void getColoredPaper() throws IOException {
		paper = new int[size][size];
		for (int i = 0; i < size; i++) {
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
			for (int j = 0; j < size; j++) {
				paper[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}
	}

	public static void divideAndConquer(int x, int y, int size) {
		if (isColorSame(x, y, size)) {
			countColor(x, y);
			return;
		}

		int divided = size / 2;
		divideAndConquer(x, y + divided, divided);
		divideAndConquer(x, y, divided);
		divideAndConquer(x + divided, y, divided);
		divideAndConquer(x + divided, y + divided, divided);
	}

	private static boolean isColorSame(int x, int y, int size) {
		int thisColor = paper[x][y];
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (thisColor != paper[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	private static void countColor(int x, int y) {
		if (paper[x][y] == 0) {
			white++;
			return;
		}
		blue++;
	}
}
