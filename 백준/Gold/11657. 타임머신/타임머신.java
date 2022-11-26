import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	/**
	 * 문제에서 "어떤 도시로 가는 과정에서 시간을 무한히 오래 전으로 되돌릴 수 있다면"
	 * 이라는 표현은 음의 사이클에서 N-1회 이상 탐색을 한다면 음의 가중치 때문에
	 * 최소 비용이 한없이 작아진다는 것을 의미한다
	 * <p>
	 * 이는 벨만 포드 알고리즘의 특징인 전체 그래프 상에서 음수 사이클의 존재 여부를
	 * 판단할 수 있는 특징을 시사하는 것이라 할 수 있다
	 * <p>
	 * 벨만포드 알고리즘은 모든 경우의 수를 다 탐색하며 최소 비용을 찾는데 원리는 다음과 같다
	 * 1) 모든 간선을 탐색, 단 노드는 한번이라도 계산된 노드에 대해서 계산함
	 * => "노드의 거리!= 무한대"
	 * 2) 즉, 이를 위해 처음 노드 (e.g. 1)는 0으로 초기화하고 시작
	 * 3) 다른 노드는 무한대로 초기화
	 * 4) 최소값을 찾아야 하므로 타겟 노드의 거리 > 이전 노드 + 가중치라면 업데이트
	 * => 최소값으로 업데이트 됨
	 * <p>
	 * 위의 로직을 N-1만큼 반복
	 * => 로직을 마치고 다시 한번 반복을 수행했을 때 값이 업데이트 되는 것이 있다면 음수가 존재한다고 판단
	 */

	private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static int numberOfNodes, numberOfEdges;
	static long[] distances;
	static Edge[] edges;
	private static boolean isNegativeCycleDetected;

	public static void main(String[] args) throws IOException {
		setUp();
		bellmanFordAlgorithm();
	}

	private static void bellmanFordAlgorithm() {
		distances[1] = 0;        // 출발을 0으로 초기화

		for (int i = 1; i < numberOfNodes; i++) {  // N-1개 만큼 반복
			for (int j = 0; j < numberOfEdges; j++) {
				Edge edge = edges[j];
				// 더 작은 최단거리 가 있는 경우 갱신
				if (isNodeEverVisited(edge) && isEdgeHasShortRoute(edge)) {
					distances[edge.nodeEnding] = distances[edge.nodeStarting] + edge.distance;
				}
			}
		}

		// 1회 더 반복함으로써 음의 사이클 확인
		// 여기서는 업데이트 해줄 필요 없이 boolean 값만 체크

		checkNegativeCycle();
		drawAnswer();
	}

	private static void checkNegativeCycle() {
		for (int i = 0; i < numberOfEdges; i++) {
			Edge edge = edges[i];
			if (isNodeEverVisited(edge) && isEdgeHasShortRoute(edge)) {
				isNegativeCycleDetected = true;
				break;
			}
		}
	}

	private static void setUp() throws IOException {
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		numberOfNodes = Integer.parseInt(stringTokenizer.nextToken());
		numberOfEdges = Integer.parseInt(stringTokenizer.nextToken());
		edges = new Edge[numberOfEdges + 1];    // 에지 리스트 배열
		distances = new long[numberOfNodes + 1];
		Arrays.fill(distances, Integer.MAX_VALUE); // 최단거리 배열을 INF로 초기화

		saveNodes();
	}

	private static void saveNodes() throws IOException {
		StringTokenizer stringTokenizer;
		for (int i = 0; i < numberOfEdges; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int nodeStarting = Integer.parseInt(stringTokenizer.nextToken());
			int nodeEnding = Integer.parseInt(stringTokenizer.nextToken());
			int nodeDistance = Integer.parseInt(stringTokenizer.nextToken());
			edges[i] = new Edge(nodeStarting, nodeEnding, nodeDistance);
		}
	}

	private static boolean isEdgeHasShortRoute(Edge edge) {
		return distances[edge.nodeEnding] > distances[edge.nodeStarting] + edge.distance;
	}

	private static boolean isNodeEverVisited(Edge edge) {
		return distances[edge.nodeStarting] != Integer.MAX_VALUE;
	}

	private static void drawAnswer() {
		if (!isNegativeCycleDetected) {
			for (int i = 2; i <= numberOfNodes; i++) {
				if (distances[i] == Integer.MAX_VALUE)
					System.out.println("-1");
				else
					System.out.println(distances[i]);
			}
		} else { // 음의 cycle이 있는 경우
			System.out.println("-1");
		}
	}
}

class Edge {
	int nodeStarting, nodeEnding, distance;

	public Edge(int nodeStarting, int nodeEnding, int distance) {
		this.nodeStarting = nodeStarting;
		this.nodeEnding = nodeEnding;
		this.distance = distance;
	}
}
