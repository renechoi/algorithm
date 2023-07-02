import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

	private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int N = Integer.parseInt(stringTokenizer.nextToken());
		int M = Integer.parseInt(stringTokenizer.nextToken());

		int[] ground = new int[N + 1];
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 1; i <= N; i++) {
			ground[i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		int[] groundS = new int[N + 2];
		while (M-- > 0) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int start = Integer.parseInt(stringTokenizer.nextToken());
			int end = Integer.parseInt(stringTokenizer.nextToken());
			int k = Integer.parseInt(stringTokenizer.nextToken());

			groundS[start] = groundS[start] + k;
			groundS[end + 1] = groundS[end+1] + (-k);
		}

		for (int i = 1; i <= N; i++) {
			groundS[i] = groundS[i - 1] + groundS[i];
		}

		for (int i = 1; i <=N; i++) {
			ground[i] = ground[i] + groundS[i];
		}

		StringBuilder stringBuilder = new StringBuilder();
		IntStream.range(1, ground.length).forEach(i -> stringBuilder.append(ground[i]).append(" "));
		System.out.println(stringBuilder);
	}
}
