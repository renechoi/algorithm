import java.util.Scanner;

public class Main {

	/**
	 * 먼저 에라토스테네스의 체를 통해 소수를 구한다
	 * 소수로 판명된 숫자들에 대해 펠린드롬 검증을 수행한다
	 *
	 * 펠린드롬 판별은 숫자를 char 배열로 만들어 판별한다
	 * 처음과 끝을 가리키는 포인터를 부여하고
	 * 두 값이 같으면 starting은 뒤로 (++) ending은 앞으로(--) 이동
	 * S < E가 되면 반복문 종료하며 모든 값이 같다면 펠린드롬으로 판별한다
	 */

	private static int[] numbersWithEratosthenes;
	private static int startingNumber;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		startingNumber = scanner.nextInt();
		numbersWithEratosthenes = numbersWithEratosthenes(setUp());

		System.out.println(mainAlgorithm());
	}

	private static int mainAlgorithm() {
		int i = startingNumber;
		while (true) { 						// 소수로 구한 수들을 검증한다
			if (isPrime(i)) {
				int answer = numbersWithEratosthenes[i];
				if (isPalindrome(numbersWithEratosthenes[i])) {
					return answer;
				}
			}
			i++;
		}
	}
	
	private static boolean isPrime(int i) {
		return numbersWithEratosthenes[i] != 0;
	}

	private static int[] numbersWithEratosthenes(int[] numbersWithEratosthenes) {
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

	private static int[] setUp() {
		int[] numbersWithEratosthenes = new int[10000001];

		for (int i = 2; i < numbersWithEratosthenes.length; i++) {
			numbersWithEratosthenes[i] = i;
		}
		return numbersWithEratosthenes;
	}

	private static boolean isPalindrome(int number) {
		char numbers[] = String.valueOf(number).toCharArray();
		int startingPoint = 0;
		int endingPoint = numbers.length - 1;
		while (startingPoint < endingPoint) {
			if (numbers[startingPoint] != numbers[endingPoint])
				return false;
			startingPoint++;
			endingPoint--;
		}
		return true;
	}
}

