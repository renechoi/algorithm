import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
public class Main {

	/**
	 * 아이디어 자체는 어렵지 않다.
	 * 결국 큰 수씩 골라서 한세트로 만들어주고 이를 더하면 되는 것이다.
	 *
	 * 다만 문제에서 주어지는 숫자의 범위가 음수를 포함한다.
	 *
	 * 따라서 양수, 1, 0, 음수 => 4개의 세트로 나눠서 계산한다
	 *
	 * i) 양수
	 * => 내림차순 정렬한 뒤 최댓값부터 차례대로 곱한 후 더한다
	 * => 원소가 1개가 된다면 그대로 더한다
	 *
	 * ii) 음수
	 * => 정렬 필요 없이(우선순위 큐 자동 오름차순 정렬) 최솟값부터 차례대로 곱한 후 더한다
	 * => 원소가 1개가 된다면 1) 0이 있다면 0과 함께 사라지도록 한다 2) 0이 없다면 그대로 더한다
	 *
	 * iii) 1을 카운트해주지 않았으므로 1이 있다면 마지막에 1을 더한다
	 *
	 */

	private static int numberCounts;
	private static PriorityQueue<Integer> positiveNumbers;
	private static PriorityQueue<Integer> negativeNumbers;
	private static int numberOneCounts;
	private static int numberZeroCounts;
	private static int answerSummation;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// 카드 묶음의 수 저장
		numberCounts = scanner.nextInt();

		positiveNumbers = new PriorityQueue<>(Collections.reverseOrder());
		negativeNumbers = new PriorityQueue<>();

		saveNumbers(scanner);

		calculatePositiveNumbers();
		calculateNegativeNumbers();
		calculateNumberOneCounts();

		System.out.println(answerSummation);
	}

	private static void calculateNumberOneCounts() {
		answerSummation = answerSummation + numberOneCounts;
	}

	private static void calculateNegativeNumbers() {
		while (negativeNumbers.size() > 1) {
			int smallest = negativeNumbers.remove();
			int secondSmallest = negativeNumbers.remove();
			answerSummation = answerSummation + smallest * secondSmallest;
		}

		if (!negativeNumbers.isEmpty()) {
			if (numberZeroCounts == 0) {
				answerSummation = answerSummation + negativeNumbers.remove();
			}
		}
	}

	private static void calculatePositiveNumbers() {
		while (positiveNumbers.size() > 1) {
			int largest = positiveNumbers.remove();
			int secondLargest = positiveNumbers.remove();
			answerSummation = answerSummation + largest * secondLargest;
		}

		if (!positiveNumbers.isEmpty()) {
			answerSummation = answerSummation + positiveNumbers.remove();
		}
	}

	private static void saveNumbers(Scanner scanner) {
		for (int i = 0; i < numberCounts; i++) {
			int numbers = scanner.nextInt();

			if (numbers > 1) {
				positiveNumbers.add(numbers);
			} else if (numbers == 1) {
				numberOneCounts++;
			} else if (numbers == 0) {
				numberZeroCounts++;
			} else {
				negativeNumbers.add(numbers);
			}
		}
	}
}
