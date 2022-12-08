import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int[][][] dp;

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		dp = new int[21][21][21];
		while (true) {
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int number1 = Integer.parseInt(stringTokenizer.nextToken());
			int number2 = Integer.parseInt(stringTokenizer.nextToken());
			int number3 = Integer.parseInt(stringTokenizer.nextToken());

			if (number1 == -1 && number2 == -1 && number3 == -1) {
				break;
			}

			System.out.printf("w(%d, %d, %d) = %d\n", number1, number2, number3, w(number1, number2, number3));
		}
	}

	private static int w(int a, int b, int c) {
		if (a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}

		if (a > 20 || b > 20 || c > 20) {
			return w(20, 20, 20);
		}

		if (dp[a][b][c] != 0) {
			return dp[a][b][c];
		}

		if (a < b && b < c) {
			return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
		}

		return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
	}
}
