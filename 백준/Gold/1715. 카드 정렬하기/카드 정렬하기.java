import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	private static int NumberOfCardSets;

	/**
	 * 적은 거 두개를 먼저 고르고
	 * 끝날때까지 합쳐나가는 로직이 기본 로직이다
	 *
	 * 주어지는 데이터 중 가장 작은 카드 세트 a와 b로 새로운 한 세트를 만들며
	 * 이때 우선순위 큐를 이용한다
	 */

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		NumberOfCardSets = scanner.nextInt();

		PriorityQueue<Integer> cardSets = cardSets(scanner);

		System.out.println(addUpAlgorithm(cardSets));
	}

	private static int addUpAlgorithm(PriorityQueue<Integer> cardSets) {
		int sum = 0;
		int cardSet2;
		int cardSet1;
		while (cardSets.size() != 1) {
			cardSet1 = cardSets.remove();
			cardSet2 = cardSets.remove();
			sum += cardSet1 + cardSet2;
			cardSets.add(cardSet1 + cardSet2);
		}
		return sum;
	}

	private static PriorityQueue<Integer> cardSets(Scanner scanner) {
		// 우선순위큐 오름차순 자동 정렬
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < NumberOfCardSets; i++) {
			int data = scanner.nextInt();
			pq.add(data);
		}
		return pq;
	}
}
