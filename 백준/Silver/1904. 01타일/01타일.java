import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	private static int[] dp;

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bufferedReader.readLine());

		dp = new int[N + 2];
		dp[1] = 1;
		dp[2] = 2;
		System.out.println(dpTile(N));
	}

	private static int dpTile(int N) {
		for (int i = 3; i <= N; i++) {
			dp[i] = dp[i - 2] + dp[i - 1];
			dp[i] %= 15746;
		}
		return dp[N];
	}
}
