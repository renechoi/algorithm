import java.io.*;
public class Main {

	/**
	 * 오일러피 함수의 정의는 P[n]의 값은 곧 1 ~ n 범위에서 n과 서로소인 자연수의 개수라는 뜻이다
	 * 수학 공식을 구현하는 문제라고 보면 되겠다
	 *
	 * 에라토스테네스의 체를 이용해서
	 * 배열의 값을 함수의 결과값으로 업데이트해준다
	 */

	private static long givenNumber;
	private static long numberOfPrimeFactors;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		givenNumber = Long.parseLong(br.readLine());
		numberOfPrimeFactors = givenNumber;

		eulerPhiWithEratos();

		System.out.println(numberOfPrimeFactors);
	}

	private static void eulerPhiWithEratos() {
		for (long element = 2; element <= Math.sqrt(givenNumber); element++) { 					// 에라토스테네스의 체 계산시 제곱근까지만 진행
			if (isPrime(element)) { 			// p가 소인수라면
				numberOfPrimeFactors = eulerPhiFunction(element);								// 답 구하기
				while (isPrime(element)) {
					givenNumber /= element;
				}
			}
		}

		// 제곱까지만 연산을 했기 때문에 누락되는 마지막 값 연산
		if (givenNumber > 1) {
			numberOfPrimeFactors = eulerPhiFunction(givenNumber);
		}
	}

	private static long eulerPhiFunction(long element) {
		return numberOfPrimeFactors - numberOfPrimeFactors / element;
	}

	private static boolean isPrime(long p) {
		return givenNumber % p == 0;
	}
}
