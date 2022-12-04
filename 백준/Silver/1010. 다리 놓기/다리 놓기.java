import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int[][] combinationMap;

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(bufferedReader.readLine());

		while (testCase-- > 0) {
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int n = Integer.parseInt(stringTokenizer.nextToken());
			int r = Integer.parseInt(stringTokenizer.nextToken());

			initializeCombinationMap(r);
			getCombinationMap(r);
			System.out.println(combinationMap[r][n]);
		}

	}

	private static int combination(int n, int r) {
		if (n == r || r == 0) {
			return 1;
		}
		return combination(n - 1, r - 1) + combination(n - 1, r);
	}

	private static void getCombinationMap(int N) {
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				binomialFormula(i, j);
			}
		}
	}

	private static void binomialFormula(int i, int j) {
		combinationMap[i][j] = combinationMap[i - 1][j] + combinationMap[i - 1][j - 1];
	}

	private static void initializeCombinationMap(int N) {
		combinationMap = new int[N + 1][N + 1];
		for (int i = 0; i <= N; i++) {
			combinationMap[i][1] = i;
			combinationMap[i][0] = 1;
			combinationMap[i][i] = 1;
		}
	}
}
