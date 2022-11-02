import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int numberCounts = Integer.parseInt(stringTokenizer.nextToken());
		int quizCounts = Integer.parseInt(stringTokenizer.nextToken());

		long[] S = new long[numberCounts + 1];        // 0번째 것에서 -1이 되어버리니까 1번재부터 반복문을 돌리기 위해

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		// 합 배열 생성하기
		for (int i = 1; i <= numberCounts; i++) {
			S[i] = S[i - 1] + Integer.parseInt(stringTokenizer.nextToken());
		}

		// 질의 개수 만큼 돌면서 새롭게 들어오는 입력을 받고 해당 범위로 설정된 구간합 출력
		for (int q = 0; q < quizCounts; q++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int i = Integer.parseInt(stringTokenizer.nextToken());
			int j = Integer.parseInt(stringTokenizer.nextToken());
			System.out.println(S[j] - S[i - 1]);
		}

	}
}
