import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		boolean[][] canvas = new boolean[101][101];

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int testCase = Integer.parseInt(stringTokenizer.nextToken());

		while (testCase-- > 0) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int x = Integer.parseInt(stringTokenizer.nextToken());
			int y = Integer.parseInt(stringTokenizer.nextToken());
			drawCanvas(canvas, x, y);
		}

		int countWidth = Arrays.deepToString(canvas).replaceAll("[^t]", "").length();
		System.out.println(countWidth);
	}

	private static void drawCanvas(boolean[][] canvas, int x, int y) {
		for (int i = x; i < x + 10; i++) {
			for (int j = y; j < y + 10; j++) {
				canvas[i][j] = true;
			}
		}
	}
}
