import java.util.Scanner;

public class Main {

	/**
	 * 먼저 에라토스테네스의 체를 통해 소수를 구한다
	 * 이후 해당 수의 제곱이 1000을 넘어서지 않으면 정답으로 카운트 한다
	 * <p>
	 * 로직 자체는 간단하지만
	 * <p>
	 * 숫자가 커지면서 long형을 초과하는 경우가 발생한다
	 * 따라서 제곱을 계산해줄 때 이항정리하여 a * a <= b 형태가 아닌 a <= b / a 형태로 판단한다
	 */

	private static long[] numbersWithEratosthenes;
	private static long startingNumber;
	private static long endingNumber;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		startingNumber = scanner.nextLong();
		endingNumber = scanner.nextLong();
		numbersWithEratosthenes = numbersWithEratosthenes(setUp());

		System.out.println(mainAlgorithm());
	}

	private static int mainAlgorithm() {
		int count = 0;
		for (int i = 2; i < 10000001; i++) {
			if (isPrime(i)) {
				long prime = numbersWithEratosthenes[i];
				while (isFindingContinue(i, prime)) {
					if (isSatisfySquareCondition(i, prime)) {
						count++;
					}
					prime = prime * numbersWithEratosthenes[i];
				}
			}
		}
		return count;
	}

	private static boolean isFindingContinue(int i, double prime) {
		return (double) numbersWithEratosthenes[i] <= (double) endingNumber / prime;
	}

	private static boolean isSatisfySquareCondition(int i, double prime) {
		return (double) numbersWithEratosthenes[i] >= (double) startingNumber / prime;
	}

	private static boolean isPrime(int i) {
		return numbersWithEratosthenes[i] != 0;
	}

	private static long[] numbersWithEratosthenes(long[] numbersWithEratosthenes) {
		for (int i = 2; i <= Math.sqrt(numbersWithEratosthenes.length); i++) {
			if (numbersWithEratosthenes[i] == 0) {
				continue;
			}
			for (int j = i + i; j < numbersWithEratosthenes.length; j = j + i) {
				numbersWithEratosthenes[j] = 0;
			}
		}
		return numbersWithEratosthenes;
	}

	private static long[] setUp() {
		long[] numbersWithEratosthenes = new long[10000001];

		for (int i = 2; i < numbersWithEratosthenes.length; i++) {
			numbersWithEratosthenes[i] = i;
		}
		return numbersWithEratosthenes;
	}
}
