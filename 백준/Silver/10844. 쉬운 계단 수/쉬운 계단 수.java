import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int mod = 1000000000;
		N = Integer.parseInt(bufferedReader.readLine());
		long[][] dp = new long[101][10];
		for (int i = 1; i < 10; i++) {
			dp[1][i] = 1;
		}

		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0) {
					dp[i][j] = dp[i - 1][1] % mod;
					continue;
				}
				if (j == 9) {
					dp[i][j] = dp[i - 1][8] % mod;
					continue;
				}
				dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1] ) % mod;
			}
		}
		long sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += dp[N][i];
		}

		System.out.println(sum % mod);
	}
}
