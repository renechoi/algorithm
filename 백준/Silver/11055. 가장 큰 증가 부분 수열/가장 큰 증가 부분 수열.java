import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int[] numbers;
	private static int[] dp;

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());

		dp = new int[1001];
		numbers = new int[1001];
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 1; i <= N; i++) {
			int number = Integer.parseInt(stringTokenizer.nextToken());
			numbers[i] = number;
			dp[i] = number;
		}

		int sumMax = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				if (isLis(i, j) && isSumAsMax(i, j)) {        // lis 이면서도 더했을 때 더 커야 되므로
					dp[i] = dp[j] + numbers[i];
				}
			}
			sumMax = Math.max(sumMax, dp[i]);
		}

		System.out.println(sumMax);
	}

	private static boolean isSumAsMax(int i, int j) {
		return dp[i] < dp[j] + numbers[i];
	}

	private static boolean isLis(int i, int j) {
		return numbers[i] > numbers[j];
	}
}
