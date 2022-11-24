import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static List<Integer> answer;
	static int N, M, K, X;
	static ArrayList<Integer>[] adjacentNodes;
	static int[] visited;

	public static void main(String[] args) {

		answer = new ArrayList<>();

		Scanner scan = new Scanner(System.in);
		receiveNodeInfo(scan);
		initializeAdjacentNodes();
		storeNodeInfo(scan);
		initializeVisitedList();

		BFS(X);
		drawAnswer();
	}

	private static void receiveNodeInfo(Scanner scanner) {
		N = scanner.nextInt(); 				// 노드의 수
		M = scanner.nextInt(); 				// 에지의 수
		K = scanner.nextInt(); 				// 만족해야 하는 최단 거리 (에지의 수)
		X = scanner.nextInt(); 				// 출발 노드의 번호
	}

	private static void drawAnswer() {
		for (int i = 0; i <= N; i++) {
			if (visited[i] == K) {
				answer.add(i);
			}
		}

		if (answer.isEmpty()) {
			System.out.println("-1");
			return;
		}

		Collections.sort(answer);

		for (int temp : answer) {
			System.out.println(temp);
		}

	}

	private static void initializeVisitedList() {
		visited = new int[N + 1];  			//방문 배열 초기화

		for (int i = 0; i <= N; i++) {
			visited[i] = -1;				// 최초 방문 기록을 0으로 하기 때문에 구분을 위해 -1로 초기화
		}
	}

	private static void storeNodeInfo(Scanner scanner) {
		for (int i = 0; i < M; i++) {
			int node = scanner.nextInt();
			int edge = scanner.nextInt();
			adjacentNodes[node].add(edge);
		}
	}

	private static void initializeAdjacentNodes() {
		adjacentNodes = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			adjacentNodes[i] = new ArrayList<>();
		}
	}

	private static void BFS(int node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		visited[node]++;

		while (!queue.isEmpty()) {
			int currentNode = queue.poll();
			for (int i : adjacentNodes[currentNode]) {
				if (visited[i] == -1) {							// 방문을 안했던 노드라면
					visited[i] = visited[currentNode] + 1;		// 기록하는 내용은 이전 노드 거리 + 1
					queue.add(i);
				}
			}
		}
	}
}
