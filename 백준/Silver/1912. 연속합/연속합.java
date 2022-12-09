import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static long sum;
	private static int testCases;
	private static long[] numbers;
	private static long[] dp;

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		testCases = Integer.parseInt(bufferedReader.readLine());

		numbers = new long[testCases];
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < testCases; i++) {
			int number = Integer.parseInt(stringTokenizer.nextToken());
			numbers[i] = number;

			if (numbers[i] > sum) {
				sum = numbers[i];
			}
		}

		dp = new long[testCases];
		dp[0] = numbers[0];
		sum = numbers[0];

		sequenceSum();
		System.out.println(sum);
	}

	private static void sequenceSum() {
		for (int i = 1; i < testCases; i++) {
			dp[i] = Math.max(dp[i - 1] + numbers[i], numbers[i]);
			sum = Math.max(dp[i], sum);
		}
	}
}
