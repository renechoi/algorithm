import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static boolean check[];
	private static int N;
	private static int[][] people;
	private static int diffMin;

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(bufferedReader.readLine());

		people = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 1; j <= N; j++) {
				people[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}

		diffMin = 101;
		check = new boolean[N + 1];

		chooseTeamCombination(1, 0);
		System.out.println(diffMin);

	}

	public static void chooseTeamCombination(int idx, int depth) {

		if (depth == N / 2) {
			int start = 0;
			int link = 0;

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (check[i] && check[j]) {
						start += people[i][j];
					}
					if (!check[i] && !check[j]) {
						link += people[i][j];
					}
				}
			}
			diffMin = Math.min(Math.abs(start - link), diffMin);
			return;
		}

		for (int i = idx; i <= N; i++) {
			if (!check[i]) {
				check[i] = true;
				chooseTeamCombination(i + 1, depth + 1);
				check[i] = false;
			}
		}
	}
}
