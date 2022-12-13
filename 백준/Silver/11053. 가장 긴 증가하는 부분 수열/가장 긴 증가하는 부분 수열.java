import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());

		int[] dp = new int[1001];
		int[] numbers = new int[1001];
		StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
		for (int i = 1; i <= N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
		}

		int count = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				if (numbers[i] > numbers[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			count = Math.max(count, dp[i]);
		}

		System.out.println(count);
	}
}
