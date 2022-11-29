import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int[] numbers;
	private static int N;
	private static int S;
	private static int answer;

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		N = Integer.parseInt(stringTokenizer.nextToken());
		S = Integer.parseInt(stringTokenizer.nextToken());

		numbers = new int[N];

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		dfs(0, 0);

		System.out.println(S == 0 ? answer - 1 : answer);
	}

	private static void dfs(int depth, int sum) {

		if (depth >= N) {
			if (sum == S) {
				answer++;
			}
			return;
		}

		dfs(depth + 1, sum + numbers[depth]);
		dfs(depth + 1, sum);

	}
}
