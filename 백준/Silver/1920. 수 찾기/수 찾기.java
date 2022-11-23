import java.util.Arrays;
import java.util.Scanner;
public class Main {

	private static boolean isFind;

	public static void main(String[] args) {

		/**
		 * 이진 탐색 기본 문제
		 */

		Scanner scanner = new Scanner(System.in);

		int[] sortedNumbers = getNumbers(scanner);
		Arrays.sort(sortedNumbers);

		mainAlgorithm(scanner, sortedNumbers);
	}

	private static void mainAlgorithm(Scanner scanner, int[] sortedNumbers) {
		int M = scanner.nextInt();

		for (int i = 0; i < M; i++) {
			isFind = false;
			int numbersToBeFound = scanner.nextInt();

			isFind = binarySearch(sortedNumbers, numbersToBeFound);
			printAnswer();
		}
	}

	private static void printAnswer() {
		if (isFind) {
			System.out.println(1);
			return;
		}
		System.out.println(0);
	}

	private static int[] getNumbers(Scanner scanner) {
		int N = scanner.nextInt();
		int[] sortedNumbers = new int[N];

		for (int i = 0; i < N; i++) {
			sortedNumbers[i] = scanner.nextInt();
		}
		return sortedNumbers;
	}

	private static boolean binarySearch(int[] sortedNumbers, int target) {
		int startIdx = 0;
		int endIdx = sortedNumbers.length - 1;

		while (startIdx <= endIdx) {
			int setMedium = (startIdx + endIdx) / 2;
			int midIdx = sortedNumbers[setMedium];

			if (midIdx > target) {
				endIdx = setMedium - 1;
			} else if (midIdx < target) {
				startIdx = setMedium + 1;
			} else {
				isFind = true;
				break;
			}
		}
		return isFind;
	}
}
