import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static long[] dp;

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int testCases = Integer.parseInt(bufferedReader.readLine());

		dp = new long[100 + 6];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2;

		for (int i = 0; i < testCases; i++) {
			int N = Integer.parseInt(bufferedReader.readLine());
			System.out.println(dpWave(N));
		}
	}

	private static long dpWave(int N) {
		for (int i = 6; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 5];
		}
		return dp[N];
	}
}
