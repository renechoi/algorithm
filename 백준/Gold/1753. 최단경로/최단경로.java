import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	/**
	 * 최단 경로 구하기 로직은
	 * min(현재의 최단 거리 + 에지, 타겟의 최단거리) 로 구할 수 있다
	 */

	private static int numberOfNodes, numberOfEdges, numberOfStartingNode;
	private static int[] distances;
	private static boolean[] visited;
	private static ArrayList<edge>[] adjacentNodes;
	private static final PriorityQueue<edge> nodeInOutQueue = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		setup();
		dijkstraAlgorithm();
		drawAnswer();
	}

	private static void dijkstraAlgorithm() {
		nodeInOutQueue.add(new edge(numberOfStartingNode, 0));        // e.g. (1,0) -> 큐에 1이 들어가고
		distances[numberOfStartingNode] = 0;                    // 초기값은 0에서 시작함 (시작하는 노드이므로)

		while (!nodeInOutQueue.isEmpty()) {
			edge current = nodeInOutQueue.poll();
			int currentNode = current.node;
			if (visited[currentNode]) {
				continue; // 방문한 노드라면 건너뛰기
			}
			visited[currentNode] = true;

			for (int i = 0; i < adjacentNodes[currentNode].size(); i++) {    // 현재 노드의 에지 개수 만큼 반복문 수행
				edge edge = adjacentNodes[currentNode].get(i);
				int node = edge.node;
				int distance = edge.distance;
				if (distances[node] > distances[currentNode] + distance) {
					// 타깃 노드의 이미 설정된 (있다면) 최단 거리 > 현재 노드까지의 거리 + 타깃까지의 거리
					// 기존에 이미 설정된 값이 작다면 if 문을 건너뜀 = 값을 갱신하지 않음
					// => 그럼으로써 최소값 유지
					distances[node] = distance + distances[currentNode];        // 거리 업데이트
					nodeInOutQueue.add(new edge(node, distances[node]));
				}
			}
		}
	}

	private static void drawAnswer() {
		for (int i = 1; i <= numberOfNodes; i++) {
			if (visited[i])
				System.out.println(distances[i]);
			else
				System.out.println("INF");
		}
	}

	private static void setup() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		numberOfNodes = Integer.parseInt(stringTokenizer.nextToken());
		numberOfEdges = Integer.parseInt(stringTokenizer.nextToken());
		numberOfStartingNode = Integer.parseInt(bufferedReader.readLine());

		distances = new int[numberOfNodes + 1];
		visited = new boolean[numberOfNodes + 1];
		adjacentNodes = new ArrayList[numberOfNodes + 1];

		initializeDistances();
		initializeAdjacentNodes();
		saveAdjacentNodes(bufferedReader);
	}

	private static void saveAdjacentNodes(BufferedReader bufferedReader) throws IOException {
		StringTokenizer stringTokenizer;
		for (int i = 0; i < numberOfEdges; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int nodeFrom = Integer.parseInt(stringTokenizer.nextToken());
			int nodeTo = Integer.parseInt(stringTokenizer.nextToken());
			int nodeDistance = Integer.parseInt(stringTokenizer.nextToken());
			adjacentNodes[nodeFrom].add(new edge(nodeTo, nodeDistance));

			/**
			 * 인접 리스트 저장 예
			 * 1 -> (2,2) (3,3)
			 * 2 -> (3,4) (4,5)
			 * 3 -> (4,6)
			 * 4
			 * 5 -> (1,1)
			 */
		}
	}

	private static void initializeAdjacentNodes() {
		for (int i = 1; i <= numberOfNodes; i++) {
			adjacentNodes[i] = new ArrayList<>();
		}
	}

	private static void initializeDistances() {
		for (int i = 0; i <= numberOfNodes; i++) {
			distances[i] = Integer.MAX_VALUE;
		}
	}
}

class edge implements Comparable<edge> {
	int node, distance;

	edge(int node, int distance) {
		this.node = node;
		this.distance = distance;
	}

	public int compareTo(edge edge) {
		if (this.distance > edge.distance) {
			return 1;
		} else {
			return -1;
		}
	}
}
