import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	private static char[][] map;
	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bufferedReader.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], ' ');
		}

		star(0, 0, N);

		drawAnswer();
	}

	private static void star(int startingX, int startingY, int N) {
		if (N == 1) {
			map[startingX][startingY] = '*';
			return;
		}

		int recursiveN = N / 3;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (!isEmpty(i, j)) {
					star(startingX + (recursiveN * i), startingY + (recursiveN * j), recursiveN);
				}
			}
		}
	}

	private static boolean isEmpty(int i, int j) {
		return i == 1 && j == 1;
	}

	private static void drawAnswer() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < N; i++) {
			stringBuilder.append(map[i]).append("\n");
		}
		System.out.print(stringBuilder);
	}
}
