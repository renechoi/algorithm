import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class Main {

	/**
	 * 이분 그래프라함은 인접한 노드끼리는 집합하지 않게 즉, 그래프 노드를 두 가지 색깔로 칠할 때 인접하면 다른 색을 갖는 그래프
	 *
	 * 이분 그래프를 판별하는 방법은 visited 베열에 체크할 때 A, B 형태로 입력을 하고
	 * 만약 노드가 방문에서 체크를 하는 시점에 해당 노드가 같은 것으로 체크가 되어 있다면
	 * = 인접한 노드로서 다른 체크가 되어야 하는데 같은 체크로 되어 있는 상황이므로
	 * 이분 그래프가 아니라는 것을 판단한다
	 *
	 * i)
	 * 1 2 3 4
	 * A _ _ _
	 *
	 * ii)
	 * 1 2 3 4
	 * A B _ _
	 *
	 * iii)
	 * 1 2 3 4
	 * A B A _
	 *
	 * iV)
	 * 1 2 3 4
	 * A B A B
	 *
	 * V)
	 * 1 2 3 4
	 * A B A B
	 * => 이때 4는 2로 연결이 되어야 하는 상황에서 B가 같은 것으로 체크
	 * => 이분 그래프가 아님을 판단
	 *
	 */

	static ArrayList<Integer>[] adjacentNodes;
	static int[] judgingBipartite;
	static boolean visited[];
	static boolean isSameSet;

	public static void main(String[] args) throws Exception {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(bufferedReader.readLine());

		for (int t = 0; t < testCase; t++) {

			String[] nodeInfo = bufferedReader.readLine().split(" ");
			int node = Integer.parseInt(nodeInfo[0]);
			int edge = Integer.parseInt(nodeInfo[1]);

			calculationSetup(bufferedReader, node, edge);

			for (int i = 1; i <= node; i++) {
				if (isSameSet)							// dfs 탐색시 설정
					dfs(i);
				else
					break;
			}

			initializeCheck();

			if (isSameSet)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

	private static void initializeCheck() {
		judgingBipartite[1] = 0;
	}

	private static void calculationSetup(BufferedReader bufferedReader, int node, int edge) throws IOException {
		visited = new boolean[node + 1];
		judgingBipartite = new int[node + 1];
		isSameSet = true;

		initializeAdjacentNodes(node);
		storeAdjacentNodes(bufferedReader, edge);
	}

	private static void storeAdjacentNodes(BufferedReader bufferedReader, int edge) throws IOException {
		String[] nodeInfo;
		for (int i = 0; i < edge; i++) {
			nodeInfo = bufferedReader.readLine().split(" ");
			int Start = Integer.parseInt(nodeInfo[0]);
			int End = Integer.parseInt(nodeInfo[1]);
			adjacentNodes[Start].add(End);
			adjacentNodes[End].add(Start);
		}
	}

	private static void initializeAdjacentNodes(int node) {
		adjacentNodes = new ArrayList[node + 1];
		for (int i = 1; i <= node; i++) {
			adjacentNodes[i] = new ArrayList<Integer>();
		}
	}

	public static void dfs(int node) {
		visited[node] = true;
		for (int currentNode : adjacentNodes[node]){
			if (!visited[currentNode]) {
				judgingBipartite[currentNode] = (judgingBipartite[node] + 1) % 2; // 체크 배열에 체크 = 방식은 0 ,1 방식으로
				dfs(currentNode);
			}
			else if (judgingBipartite[node] == judgingBipartite[currentNode]){ // 체크 배열에서 확인시 현재 방문하는 노드가 기존 본인의 노드와 같다면 false로 체크하고 반복문 탈출
				isSameSet = false;
			}
		}
	}
}
