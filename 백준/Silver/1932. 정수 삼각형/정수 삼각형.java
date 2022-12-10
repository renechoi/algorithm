import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int N;
	private static int[][] triangles;

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(bufferedReader.readLine());

		triangles = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 0; j < i + 1; j++) {
				triangles[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}

		for (int i = N - 1; i > 0; i--) {
			for (int j = 0; j < i; j++)
				triangles[i - 1][j] += Math.max(triangles[i][j], triangles[i][j + 1]);
		}

		System.out.println(triangles[0][0]);
	}
}
