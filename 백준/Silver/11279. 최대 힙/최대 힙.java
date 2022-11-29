import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfCommands = scanner.nextInt();

		// 우선순위 큐에서 최대힙을 구현하도록 reverseOrder를 해준다
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < numberOfCommands; i++) {
			int numberX = scanner.nextInt();
			if (numberX == 0) {
				if (queue.isEmpty()) {
					System.out.println(0);
					continue;
				}
				System.out.println(queue.poll());
				continue;
			}
			queue.add(numberX);
		}
	}
}
