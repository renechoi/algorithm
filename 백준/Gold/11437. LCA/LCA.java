import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	/**
	 * 일반적인 최소 공통 조상 구하기
	 * <p>
	 * 인접리스트로 트리 데이터 구하기
	 * 탐색 알고리즘을 통해 깊이 데이터 구하기
	 * <p>
	 * => 최소 공통 조상 구하기 로직
	 * <p>
	 * i) 깊이가 다르다면
	 * => 더 깊은 쪽을 1개씩 올려줌
	 * => 이때 두 노드가 같아진다면 공통 조상으로 판별
	 * <p>
	 * ii) 깊이가 같다면
	 * => 동시에 올려줌
	 * => 같은 노드가 될때까지 반복 => 같아지면 공통 조상으로 판별
	 */

	static ArrayList<Integer>[] tree;
	static int[] depth;
	static int[] parent;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfNodes = scanner.nextInt();

		initializeTree(numberOfNodes);
		saveAdjacentNodes(scanner, numberOfNodes);

		depth = new int[numberOfNodes + 1];
		parent = new int[numberOfNodes + 1];
		visited = new boolean[numberOfNodes + 1];

		bfsWithDepth();

		getLcaAndDrawAnswer(scanner);
	}


	private static void saveAdjacentNodes(Scanner scanner, int numberOfNodes) {
		for (int i = 0; i < numberOfNodes - 1; i++) {
			int node1 = scanner.nextInt();
			int node2 = scanner.nextInt();
			tree[node1].add(node2);
			tree[node2].add(node1);
		}
	}

	private static void initializeTree(int numberOfNodes) {
		tree = new ArrayList[numberOfNodes + 1];
		for (int i = 1; i <= numberOfNodes; i++) {
			tree[i] = new ArrayList<>();
		}
	}


	private static void bfsWithDepth() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);        // 출발 노드부터 시작
		visited[1] = true;

		int depth = 1;
		int nodesAtThisLevel = 1;
		int count = 0;

		while (!queue.isEmpty()) {
			int thisNode = queue.poll();
			for (int nodeAdjacent : tree[thisNode]) {
				if (!visited[nodeAdjacent]) {
					visited[nodeAdjacent] = true;

					queue.add(nodeAdjacent);
					parent[nodeAdjacent] = thisNode;    // 부모 배열에 부모 노드 저장 = for문 바깥에서 안쪽의 node를 꺼낸 node가 곧 부모노드
					Main.depth[nodeAdjacent] = depth;        // depth 배열에 현재 깊이 저장 = 깊이는 1부터 시작
				}
			}

			count++;                                    // thisNode에서 꺼낸 인접 노드가 전부 끝나면 count++

			if (count == nodesAtThisLevel) {                    // 해당 레벨에서 더 이상 할 게 없다면 count 초기화 = 0
				count = 0;
				nodesAtThisLevel = queue.size();                // 위에서 넣은 element가 들어있는 만큼이 현재 레벨에서 탐색해주어야 하는 노드
				depth++;
			}
		}
	}

	private static int lca(int node1, int node2) {

		// swap을 통해 작은 쪽과 큰 쪽을 세팅해줌
		// 1번이 더 작은 상황이 됨
		if (depth[node1] < depth[node2]) {
			int nodeForSwap = node1;
			node1 = node2;
			node2 = nodeForSwap;
		}

		// 위에서 세팅한 노드를 기준으로 depth 맞추기
		// 작은쪽이 1번이므로 depth가 다르다면 1번을 올려줌 = 1번에 부모 노드가 할당됨으로써 올라가는 효과
		while (depth[node1] != depth[node2]) {
			node1 = parent[node1];
		}

		// 같아질때까지 한 단계씩 올려주기
		while (node1 != node2) {
			node1 = parent[node1];
			node2 = parent[node2];
		}

		return node1;
	}

	private static void getLcaAndDrawAnswer(Scanner scanner) {
		int numberOfQueries = scanner.nextInt();
		for (int i = 0; i < numberOfQueries; i++) {
			int node1 = scanner.nextInt();
			int node2 = scanner.nextInt();
			System.out.println(lca(node1, node2));
		}
	}
}
