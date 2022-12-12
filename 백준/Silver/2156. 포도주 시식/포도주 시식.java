import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());

		int[] dp = new int[10001];
		int[] wines = new int[10001];
		for (int i = 0; i < N; i++) {
			wines[i] = Integer.parseInt(bufferedReader.readLine());
		}

		dp[0] = wines[0];
		dp[1] = dp[0] + wines[1];
		dp[2] = Math.max(Math.max(wines[1] + wines[2], dp[0] + wines[2]), dp[1]);

		for (int i = 3; i < N; i++) {
			dp[i] = Math.max(Math.max(dp[i - 3] + wines[i - 1] + wines[i], dp[i - 2] + wines[i]), dp[i - 1]);
		}
		System.out.println(dp[N - 1]);
	}
}
