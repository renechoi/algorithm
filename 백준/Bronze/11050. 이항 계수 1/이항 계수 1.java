import java.util.Scanner;

public class Main {

	/**
	 * 2차원 배열에 value를 채워넣어
	 * 최종적으로 D[5][2]를 구하면 된다
	 * <p>
	 * 이때 두 가지 규칙을 사용한다
	 * i) 기본 특성
	 * - iC1 = i = i개 중 1개를 뽑는 경우의 수는 i개
	 * - iC0 = 1 = i개 중 1개도 선택하지 않는 경우의 수는 1개
	 * - iCi = 1 = i개 중 i개를 선택하는 경우의 수는 1개
	 * <p>
	 * ii) 조합의 점화식
	 * - nCk + nCk+1 = n+1Ck+1
	 */

	static int N;
	static int K;
	static int[][] combinationMap;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		K = scanner.nextInt();

		initializeCombinationMap();
		getCombinationMap();
		System.out.println(combinationMap[N][K]);
	}

	private static void getCombinationMap() {
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				binomialFormula(i, j);
			}
		}
	}

	private static void binomialFormula(int i, int j) {
		combinationMap[i][j] = combinationMap[i - 1][j] + combinationMap[i - 1][j - 1];
	}

	private static void initializeCombinationMap() {
		combinationMap = new int[N + 1][N + 1];
		for (int i = 0; i <= N; i++) {
			combinationMap[i][1] = i;
			combinationMap[i][0] = 1;
			combinationMap[i][i] = 1;
		}
	}
}
