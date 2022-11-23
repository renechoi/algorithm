import java.util.Scanner;

public class Main {

	private static int N; 		// 자리수 전역 변수로 설정

	public static void main(String[] args) {

		// 왼쪽부터 1자리, 2자리 ... N자리 소수여야 하므로
		// 1자리 소수인 2, 3, 5, 7에부터 시작하는
		// dfs 알고리즘

		N = new Scanner(System.in).nextInt();

		dfs(2, 1);
		dfs(3, 1);
		dfs(5, 1);
		dfs(7, 1);
	}

	private static void dfs(int number, int digit) {
		if (digit == N) {
			if (isPrime(number)) {                    // 현재 숫자가 소수라면 그대로 출력
				System.out.println(number);
			}
			return;                                    // 다음 숫자로 넘어가기
		}

		for (int i = 1; i < 10; i++) {
			if (i % 2 != 0 && isPrime(number * 10 + i)) {            // 짝수인 경우 탐색 제외 + 소수라면 재귀 함수로 다음 자리 탐색
				dfs(number * 10 + i, digit + 1);
			}
		}
	}

	private static boolean isPrime(int number) {
		for (int i = 2; i <= number / 2; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}