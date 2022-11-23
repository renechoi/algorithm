import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static boolean[] visited;
	static int[] distance;
	static ArrayList<edge>[] adjacentNodes;

	public static void main(String[] args) {

		/**
		 * 문제 해결의 아이디어는
		 * 임의의 수에서 거리를 계산했을 때 가장 먼 거리에 있는 노드는
		 * 반드시 최대 경로로 설정되는 두 개의 노드 중 하나일 것이라는 것이다
		 * <p>
		 * 이 개념을 바탕으로 먼저 1개의 노드를 구하고
		 * 그 숫자에서부터 다시 최대 거리에 있는 노드를 구하면
		 * 해당 두 노드의 거리가 최대 거리가 된다
		 * <p>
		 * 거리를 측정하기 위해 임시의 배열을 설정한다
		 */

		Scanner scanner = new Scanner(System.in);
		int numberOfNodes = scanner.nextInt();                    // 입력 받는 노드의 개수

		setUptAdjacentNodesStorage(numberOfNodes);
		saveNodeMap(scanner, numberOfNodes);
		bfs(1);        // 임의의 점 (1로 세팅)에서 bfs 탐색
		bfs(findMaxDistanceNode(numberOfNodes));        // 가장 큰 값을 지니는 노드를 찾고 해당 노드를 시작점으로 지정

		System.out.println(Arrays.stream(distance).max().getAsInt());    // 최대값을 출력
	}

	private static int findMaxDistanceNode(int numberOfNodes) {
		int Max = 1;

		for (int i = 2; i <= numberOfNodes; i++) {
			if (distance[Max] < distance[i])
				Max = i;
		}

		initializeCalculationModules(numberOfNodes);
		return Max;
	}

	private static void initializeCalculationModules(int numberOfNodes) {
		distance = new int[numberOfNodes + 1];
		visited = new boolean[numberOfNodes + 1];
	}

	private static void saveNodeMap(Scanner sc, int numberOfNodes) {
		for (int i = 0; i < numberOfNodes; i++) {
			int thisNode = sc.nextInt();
			while (true) {
				int otherNode = sc.nextInt();
				if (otherNode == -1) break;
				int cost = sc.nextInt();
				adjacentNodes[thisNode].add(new edge(otherNode, cost));
			}
		}
		initializeCalculationModules(numberOfNodes);
	}

	private static void setUptAdjacentNodesStorage(int N) {
		adjacentNodes = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adjacentNodes[i] = new ArrayList<>();
		}
	}

	private static void bfs(int node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		visited[node] = true;

		while (!queue.isEmpty()) {
			int now_node = queue.poll();

			for (edge edge : adjacentNodes[now_node]) {
				int otherNode = edge.edge;
				int cost = edge.value;

				if (!visited[otherNode]) {
					visited[otherNode] = true;
					queue.add(otherNode);
					Main.distance[otherNode] = Main.distance[now_node] + cost;    // 거리 배열 업데이트 로직
				}
			}
		}
	}
}


class edge {
	int edge;
	int value;

	public edge(int edge, int cost) {
		this.edge = edge;
		this.value = cost;
	}
}
