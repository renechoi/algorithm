import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

	/**
	 * 유클리드 호제법을 이용한다
	 *
	 * 숫자가 엄청 크게 되기 때문에 규칙이 필요하다
	 *
	 * 공약수의 길이만큼 1을 반복해 출력한다
	 */

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		long numberALength = scanner.nextLong();
		long numberBLength = scanner.nextLong();
		long result = gcd(numberALength, numberBLength);

		while (result > 0) {					// 최대 공약수 만큼 출력 스트링에 더하기 
			bufferedWriter.write("1");
			result--;
		}

		bufferedWriter.flush();
		bufferedWriter.close();
	}

	private static long gcd(long a, long b) {		// 문제에서 b는 a보다 항상 크다
		if (b == 0)								// 재귀 함수에 따라 b는 연산의 결과값
			return a;
		else
			return gcd(b, a % b);
	}
}
