import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		// 배열 크기와 질의의 수 받기
		int N = Integer.parseInt(stringTokenizer.nextToken());
		int quizCounts = Integer.parseInt(stringTokenizer.nextToken());

		// 2차원 배열 생성
		int Array[][] = new int[N + 1][N + 1];

		// 2차원 배열 획득
		for (int i = 1; i <= N; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());

			for (int j = 1; j <= N; j++) {
				Array[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}

		// 획득한 2차원 배열을 합배열로 재구성

		int sumArray[][] = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				sumArray[i][j] = sumArray[i][j - 1] + sumArray[i - 1][j] - sumArray[i - 1][j - 1] + Array[i][j];
			}
		}

		// 질의 수를 반복하며 새로 입력 받은 인자들로 구간합 위치를 찾아 답 출력
		for (int i = 0; i < quizCounts; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int x1 = Integer.parseInt(stringTokenizer.nextToken());
			int y1 = Integer.parseInt(stringTokenizer.nextToken());
			int x2 = Integer.parseInt(stringTokenizer.nextToken());
			int y2 = Integer.parseInt(stringTokenizer.nextToken());

			int result = sumArray[x2][y2] - sumArray[x1 - 1][y2] - sumArray[x2][y1 - 1] + sumArray[x1 - 1][y1 - 1];
			System.out.println(result);
		}

	}
}
