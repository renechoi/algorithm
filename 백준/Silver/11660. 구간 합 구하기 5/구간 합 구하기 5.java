
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int N = Integer.parseInt(stringTokenizer.nextToken());
		int M = Integer.parseInt(stringTokenizer.nextToken());

		int[][] numbers = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 1; j <= N; j++) {
				numbers[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}

		int[][] Snumbers = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				Snumbers[i][j] = numbers[i][j] + Snumbers[i - 1][j] + Snumbers[i][j - 1] - Snumbers[i - 1][j - 1];
			}
		}

		StringBuilder stringBuilder = new StringBuilder();
		int answer = 0;
		while (M-- > 0) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int x1 = Integer.parseInt(stringTokenizer.nextToken());
			int y1 = Integer.parseInt(stringTokenizer.nextToken());
			int x2 = Integer.parseInt(stringTokenizer.nextToken());
			int y2 = Integer.parseInt(stringTokenizer.nextToken());
			answer = Snumbers[x2][y2] - Snumbers[x2][y1 - 1] - Snumbers[x1 - 1][y2] + Snumbers[x1 - 1][y1 - 1];
			stringBuilder.append(answer).append("\n");
		}

		System.out.println(stringBuilder);
	}
}
