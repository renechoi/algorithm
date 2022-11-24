import java.util.*;
public class Main {
	/**
	 * 제곱수로 나누어떨어지지 않는 수를 찾는 문제이다
	 *
	 * 나누어 떨어지지 않는다는 것은 나머지가 0이라는 뜻이다
	 *
	 * 정답이 아닌 숫자를 먼저 찾아보면
	 * i) 제곱수인 것을 찾기 (x * x)
	 * ii) 제곱수로 나누어떨어지는 수를 찾기
	 *
	 * 예를 들어 1 ~ 10까지 중, 4, 9는 제곱수이며, 8은 제곱수 4로 나누어 떨어지는 수이다
	 *
	 * 에라토스테네스의 체의 소수 판별 로직으로 이와 같은 숫자들을 구할 수 있다.
	 *
	 * i) 먼저 1은 제외되므로 2부터 시작 = > 2 * 2 = 4
	 * ii) 해당 숫자의 배수가 되는 1 * 4, 2 * 4 선별  (3 * 4는 범위 벗어남으로 제외)
	 * iii) 범위를 벗어나는 숫자가 나왔으므로 다음 숫자 판단 => 3 * 3 = 9
	 * iv) 마찬가지로 1 * 9 까지 선별
	 */

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long startingNumber = scanner.nextLong();
		long endingNumber = scanner.nextLong();
		boolean[] numberInRange = new boolean[(int) (endingNumber - startingNumber + 1)]; // 주어진 숫자의 범위 만큼의 배열 생성

		for (long i = 2; i * i <= endingNumber; i++) {	// 2부터 판단 시작
			long pow = i * i;
			long start_index = proceeding(startingNumber, pow);
			for (long n = start_index; pow * n <= endingNumber; n++) {			// 제곱수에 n배를 한 값으로 반복문
				numberInRange[(int) ((n * pow) - startingNumber)] = true;		// 인덱싱을 고려해 -1 처리
			}
		}

		System.out.println(answer(startingNumber, endingNumber, numberInRange));
	}

	private static int answer(long startingNumber, long endingNumber, boolean[] numberInRange) {
		int count = 0;
		for (int i = 0; i <= endingNumber - startingNumber; i++) {
			if (!numberInRange[i]) {
				count++;
			}
		}
		return count;
	}

	private static long proceeding(long startingNumber, long pow) {
		long start_index = startingNumber / pow;

		if (!isRemainderExist(startingNumber, pow))
			start_index++;
		return start_index;
	}

	private static boolean isRemainderExist(long startingNumber, long pow) {
		return startingNumber % pow == 0;
	}
}
