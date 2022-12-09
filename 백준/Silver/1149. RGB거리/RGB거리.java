import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int numberOfHouses;
	private static int[][] houses;
	private static int[][] dp;

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		numberOfHouses = Integer.parseInt(bufferedReader.readLine());

		houses = new int[numberOfHouses][numberOfHouses];
		for (int i = 0; i < numberOfHouses; i++) {
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			houses[i][0] = Integer.parseInt(stringTokenizer.nextToken());
			houses[i][1] = Integer.parseInt(stringTokenizer.nextToken());
			houses[i][2] = Integer.parseInt(stringTokenizer.nextToken());
		}

		dp = new int[numberOfHouses][3];
		dp[0][0] = houses[0][0];
		dp[0][1] = houses[0][1];
		dp[0][2] = houses[0][2];
		colorRGB();
		System.out.println(findMin(numberOfHouses));
	}

	private static void colorRGB() {
		for (int i = 1; i < numberOfHouses; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + houses[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + houses[i][1];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + houses[i][2];
		}
	}

	private static int findMin(int number) {
		int min = dp[number-1][0];
		for (int i = 1; i < 3; i++) {
			if (dp[number-1][i] < min) {
				min = dp[number-1][i];
			}
		}
		return min;
	}
}
