import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	/**
	 * 최소 신장 트리 알고리즘 기본 문제라고 할 수 있다
	 * <p>
	 * 방향이 없는 그래프에서 모든 노드를 포함하되, 사이클이 없는 형태를 신장 트리라고하며
	 * 가중치의 값이 최소화될 때 최소 신장 트리라고 한다
	 * <p>
	 * 이를 만들기 위해 크루스칼 알고리즘을 사용한다
	 * <p>
	 * 크루스칼 알고리즘은 다음 단계로 수행된다
	 * 1) 노드와 에지 정보를 통해 에지 리스트로 그래프를 구현한다
	 * 2) 사이클 형성을 확인하기 위해 유니온 파인드 방식을 사용하므로 유니온 파인드 배열도 생성 후 초기화한다 (노드=인덱스대로)
	 * 3) 그래프 데이터에 담긴 에지들에서 가중치 기준으로 오름차순 정렬한다 (이때 Comparable 함수를 사용해 정렬을 컨트롤 할 수 있다)
	 * 4) 가중치가 낮은 에지를 선택, 2개의 노드가 앚기 연결되지 않았다면 연결하고 연결이 되었다면 연결하지 않는다
	 * => 이때 연결되어 있는 여부는 대표 노드의 일치 여부 확인을 통해 판단한다
	 * => 여기서 사용하는 것이 유니온 파인드 방식이다  (find 함수로 같은 부모인지 확인, union 연산으로 대표노드끼리 연결)
	 */

	static int[] parent;
	static PriorityQueue<edgeInfo> edgeInfo;                // 자동 정렬을 위해 우선순위 큐를 사용한다
	private static int edgeUsed;
	private static int distanceMin;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int numberOfNodes = scanner.nextInt();
		int numberOfEdges = scanner.nextInt();

		initializeParent(numberOfNodes);
		saveEdgeInfo(scanner, numberOfEdges);
		kruskalAlgorithm(numberOfNodes);

		System.out.println(distanceMin);

	}

	private static void kruskalAlgorithm(int numberOfNodes) {
		while (edgeUsed < numberOfNodes - 1) {         // N -1 번 반복
			edgeInfo edge = edgeInfo.poll();
			assert edge != null;
			if (!isConnected(edge)) {
				/**
				 * edge의 저장 형태는 다음과 같다
				 * e.g.
				 * edge       1   2   3
				 * nodes1     1   2   1
				 * nodes2     2   3   2
				 * distance   1   2   3
				 *
				 * 따라서 여기서 edge를 꺼내어 두 노드를 비교하는데
				 * starting과 ending 노드의 finding을 수행 => find(1) vs find(2)
				 * => 같지 않으므로 연결되며 parent에서 2는 1로 바뀐다 (union에서 수행) + 정답 배열에 거리 정보 plus  
				 * => 또한 1회 돌았기 때문에 edgeUsed도 ++
				 */

				union(edge.nodeStarting, edge.nodeEnding);
				distanceMin = distanceMin + edge.distance;
				edgeUsed++;
			}
		}
	}

	private static boolean isConnected(edgeInfo edge) {
		return find(edge.nodeStarting) == find(edge.nodeEnding); // 두 노드의 부모가 같다면 연결되어 있는 것이므로
	}

	private static void saveEdgeInfo(Scanner scanner, int numberOfEdges) {
		edgeInfo = new PriorityQueue<>();
		for (int i = 0; i < numberOfEdges; i++) {
			int nodeStarting = scanner.nextInt();
			int nodeEnding = scanner.nextInt();
			int distance = scanner.nextInt();
			edgeInfo.add(new edgeInfo(nodeStarting, nodeEnding, distance));
		}
	}

	private static void initializeParent(int numberOfNodes) {
		parent = new int[numberOfNodes + 1];
		for (int i = 0; i < numberOfNodes; i++) {
			parent[i] = i;
		}
	}

	private static void union(int node1, int node2) {
		node1 = find(node1);
		node2 = find(node2);
		if (node1 != node2) {
			parent[node2] = node1;
		}
	}

	private static int find(int node) {
		if (node == parent[node])
			return node;
		else
			return parent[node] = find(parent[node]);
	}
}

class edgeInfo implements Comparable<edgeInfo> {
	int nodeStarting;
	int nodeEnding;
	int distance;

	edgeInfo(int nodeStarting, int nodeEnding, int distance) {
		this.nodeStarting = nodeStarting;
		this.nodeEnding = nodeEnding;
		this.distance = distance;
	}

	@Override
	public int compareTo(edgeInfo edge) {
		// compareTo 함수를 통해 가중치 기준으로 오름차순 정렬을 하도록 설정한다
		return this.distance - edge.distance;
	}
}
