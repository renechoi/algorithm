import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		long[] S = new long[N]; // 합배열
		long[] C = new long[M]; // 합배열%M을 동일하게 만들어주는 i,j를 담는 배열

		long answer = 0; // initiate answer

		S[0] = sc.nextInt();

		// 합배열 생성
		for (int i = 1; i < N; i++) {
			S[i] = S[i - 1] + sc.nextInt();
		}

		for (int i = 0; i < N; i++) {
			int remainder = (int) (S[i] % M);
			if (remainder == 0) {
				answer++;     // 구간합 자체가 0이 될 때 정답 카운팅  => 1번 계산 해결
			}
			C[remainder]++; // 나머지 개수 카운팅
		}

		for (int i = 0; i < M; i++) {
			if (C[i] > 1) {

				long cnt = C[i];                // 나머지가 같아지는 것을 만족시키는 합배열
				answer = answer + (cnt * (cnt - 1) / 2);    // 그 중 2개를 뽑는 조합 계산
			}
		}
		System.out.println(answer);

	}
}
