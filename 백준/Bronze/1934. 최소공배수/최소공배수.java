import java.util.*;
public class Main {

	/**
	 * A, B 두 수의 최소 공배수는 A * B / 최대 공약수 공식으로 구할 수 있다
	 *
	 * i) 유클리드 호제법을 활용해 최대 공약수를 구한다
	 * ii) 최소 공배수 공식을 활용해 답을 구한다
	 *
	 * 유클리드 호제법 예시 => gcd(6, 10)
	 * 10 % 6 = 4
	 *      6 % 4 = 2
	 *      	4 % 2 = 0
	 */

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int numberOfTest = scanner.nextInt();

		for (int i = 0; i < numberOfTest; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int result = a * b / gcd(a, b);
			System.out.println(result);
		}
	}

	public static int gcd(int a, int b) {		// 문제에서 b는 a보다 항상 크다
		if (b == 0)								// 재귀 함수에 따라 b는 연산의 결과값
			return a;
		else
			return gcd(b, a % b);
	}
}
