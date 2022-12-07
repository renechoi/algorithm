import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int[] numbers;
	private static int numberCounts;
	private static long sumMin;
	private static long sumMax;
	private static int[] operators;
	private static long sum;

	public static void main(String[] args) throws IOException {
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		numberCounts = Integer.parseInt(bufferedReader.readLine());
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		numbers = new int[numberCounts];
		for (int i = 0; i < numberCounts; i++) {
			numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		operators = new int[4];
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < 4; i++) {
			operators[i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		sumMin = Integer.MAX_VALUE;
		sumMax = Integer.MIN_VALUE;
		sum = numbers[0];

		dfs(0, numbers[0]);

		System.out.println(sumMax);
		System.out.println(sumMin);

	}

	private static void dfs(int depth, int sum) {
		if (depth == numberCounts - 1) {
			if (sumMax < sum) {
				sumMax = sum;
			}
			if (sumMin > sum) {
				sumMin = sum;
			}
			return;
		}

		int number = numbers[depth + 1];
		
		for (int i = 0; i < 4; i++) {

			if (operators[i] == 0) {
				continue;
			}
			operators[i]--;
			if (i == 0) {
				dfs(depth + 1, sum+ number);
			} else if (i == 1) {
				dfs(depth + 1, sum- number);
			} else if (i == 2) {
				dfs(depth + 1, sum * number);
			} else if (i == 3) {
				dfs(depth + 1, sum / number);
			}
			operators[i]++;
		}
	}
}

