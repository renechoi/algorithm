import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	// 상위 배열을 A B C로 설정하고 숫자를 통해 물통을 특정한다 => e.g. 배열[0] -> 배열[0] = A -> B
	// A->B, A->C, B->A, B->C, C->A, C->B 6개의 이동 케이스를 설정
	static int[] Sender = {0, 0, 1, 1, 2, 2};
	static int[] Receiver = {1, 2, 0, 2, 0, 1};

	static boolean[][] visited;                                //A B의 무게를 체크하기 위한 방문 배열
	static boolean[] answer;
	static int[] waterBucket;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		setUp(scanner);

		bfs();
		drawAnswer();
	}

	private static void setUp(Scanner scan) {
		waterBucket = new int[3];                                        // A B C 물의 양이 주어진다 = 이를 담는 물통으로 초기화
		waterBucket[0] = scan.nextInt();
		waterBucket[1] = scan.nextInt();
		waterBucket[2] = scan.nextInt();

		visited = new boolean[201][201];                        // 200리터
		answer = new boolean[201];
	}

	private static void drawAnswer() {
		for (int i = 0; i < answer.length; i++) {
			if (answer[i]) System.out.print(i + " ");
		}
	}

	public static void bfs() {
		Queue<buckets> queue = new LinkedList<>();
		queue.add(new buckets(0, 0));                // q에서 노드 가져오기

		visited[0][0] = true;
		answer[waterBucket[2]] = true;

		while (!queue.isEmpty()) {
			buckets buckets = queue.poll();
			int A = buckets.A;
			int B = buckets.B;
			int C = waterBucket[2] - A - B; // C가 가득차서 시작하며 물의 양은 바뀌지 않으므로 전체 - A -B 일 때 C

			// A->B, A->C, B->A, B->C, C->A, C->B 6개의 케이스를 탐색
			for (int k = 0; k < 6; k++) {
				int[] next = {A, B, C};
				next[Receiver[k]] += next[Sender[k]];
				next[Sender[k]] = 0;

				if (isTargetBucketOverflow(k, next)) {
					handleOverFlow(k, next);
				}

				if (!visited[next[0]][next[1]]) {
					visited[next[0]][next[1]] = true;
					queue.add(new buckets(next[0], next[1]));

					if (isBucketAEmpty(next)) {
						answer[next[2]] = true;        // A의 물의 양이 0이면 => 정답인 C의 물의 양을 구한 케이스 
					}
				}
			}
		}
	}

	private static boolean isBucketAEmpty(int[] next) {
		return next[0] == 0;
	}

	private static void handleOverFlow(int k, int[] next) {
		next[Sender[k]] = next[Receiver[k]] - waterBucket[Receiver[k]];
		next[Receiver[k]] = waterBucket[Receiver[k]];
	}

	private static boolean isTargetBucketOverflow(int k, int[] next) {
		return next[Receiver[k]] > waterBucket[Receiver[k]];
	}
}


class buckets {
	int A;
	int B;

	public buckets(int A, int B) {
		this.A = A;
		this.B = B;
	}
}
