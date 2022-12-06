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
		dfs(0);
		System.out.println(stringBuilder);
	}

	private static void dfs(int depth) {
		if (depth == M) {
			for (int number : sequence) {
				stringBuilder.append(number).append(" ");
			}
			stringBuilder.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
//			if (!visited[i]) {
//				visited[i] = false;

			sequence[depth] = i;
			dfs(depth + 1);

//				visited[i] = false;
		}
	}
}

