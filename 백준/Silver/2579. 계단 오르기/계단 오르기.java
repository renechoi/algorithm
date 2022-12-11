import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(bufferedReader.readLine());
		long[] stairs = new long[301];
		stairs[0] = 0;
		for (int i = 1; i <= N; i++) {
			stairs[i] = Integer.parseInt(bufferedReader.readLine());
		}

		long[] dp = new long[301];
		dp[0] = 0;
		dp[1] = stairs[1];
		dp[2] = Math.max(stairs[1] + stairs[2], stairs[2]);
		dp[3] = Math.max(stairs[1] + stairs[3], stairs[2] + stairs[3]);
		for (int i = 4; i <= N; i++) {
			dp[i] = Math.max(dp[i - 3] + stairs[i - 1] + stairs[i], dp[i - 2] + stairs[i]);
		}

		System.out.println(dp[N]);
	}
}
