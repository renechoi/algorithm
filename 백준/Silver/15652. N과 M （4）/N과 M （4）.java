import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int[] sequence;
	private static boolean[] visited;
	private static int N;
	private static int M;
	private static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		N = Integer.parseInt(stringTokenizer.nextToken());
		M = Integer.parseInt(stringTokenizer.nextToken());

		sequence = new int[M];
		visited = new boolean[N + 1];
		dfs(1, 0);
		System.out.print(stringBuilder);
	}

	private static void dfs(int start, int depth) {
		if (depth == M) {
			for (int number : sequence) {
				stringBuilder.append(number).append(" ");
			}
			stringBuilder.append("\n");
			return;
		}

		for (int i = start; i <= N; i++) {
			sequence[depth] = i;
			dfs(i, depth + 1);
		}
	}
}
