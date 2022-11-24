import java.util.Scanner;
public class Main {

	private static int startingNumber;
	private static int endingNumber;

	/**
	 * 에라토스테네스의 체를 이용한 기본 소수 구하기 문제
	 *
	 * 총 두회의 반복문을 돌면서 소수를 판단한다
	 *
	 * i) 1번째 반복문
	 * - 순서대로 숫자를 가져오며, 뒤의 숫자들을 판단하는 근이된다
	 * - 해당 숫자의 배수를 추후 반복문에서 제거한다
	 * - 기준이 되는 숫자들 (본 반복문에서의 i)은 주어진 ending number의 제곱근까지만 가져와도 된다
	 * - 그 이후 숫자들은 배수 제거에 따라서 이미 필터링이 되었을 것이기 때문이다
	 *
	 * ii) 2번째 반복문
	 * - 첫 번째 반복문에서 가져온 숫자들의 배수를 탐색하며 제거한다
	 * - 여기서는 0으로 전환하는 것으로 제거의 의미를 갖는다
	 */

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		startingNumber = scanner.nextInt();
		endingNumber = scanner.nextInt();

		int[] eratosthenes = receiveNumbers();
		mainAlgorithm(eratosthenes);
		printAnswer(eratosthenes);
	}

	private static void mainAlgorithm(int[] Eratosthenes) {
		for (int i = 2; i <= Math.sqrt(endingNumber); i++) { // 제곱근 까지만 초기 숫자들을 가져온다
			if (Eratosthenes[i] == 0) {						 // 0으로 초기화 된 것에 대해서 패스
				continue;
			}
			for (int j = i + i; j <= endingNumber; j = j + i) { // 배수 지우기 = 0으로 전환 
				Eratosthenes[j] = 0;
			}
		}
	}

	private static void printAnswer(int[] Eratosthenes) {
		for (int i = startingNumber; i <= endingNumber; i++) {
			if (Eratosthenes[i] != 0) {
				System.out.println(Eratosthenes[i]);
			}
		}
	}

	private static int[] receiveNumbers() {
		int[] Eratosthenes = new int[endingNumber + 1];

		for (int i = 2; i <= endingNumber; i++) {
			Eratosthenes[i] = i;
		}
		return Eratosthenes;
	}
}
