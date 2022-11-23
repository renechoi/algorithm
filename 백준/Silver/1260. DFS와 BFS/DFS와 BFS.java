import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	private static boolean[] visited;
	private static ArrayList<Integer>[] adjacentNodes;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();    // 주어지는 node
		int M = sc.nextInt();   // 주어지는 edge
		int startNumber = sc.nextInt();

		adjacentNodes = new ArrayList[N + 1];
		visited = new boolean[N];

		for (int i = 1; i <= N; i++) {
			adjacentNodes[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			int node1 = sc.nextInt();
			int node2 = sc.nextInt();
			adjacentNodes[node1].add(node2);
			adjacentNodes[node2].add(node1);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(adjacentNodes[i]);        // 오름차순 정렬
		}


		initializeCheckVisited(N);
		dfs(startNumber);
		System.out.println();        // 문단 나누기 용도

		initializeCheckVisited(N);
		bfs(startNumber);
		System.out.println();
	}

	private static void dfs(int node) {
		System.out.print(node + " ");			// newLine은 제외한 print
		visited[node] = true;
		for (int i : adjacentNodes[node]) {
			if (!visited[i]) {                // 방문을 안한 것이라면
				dfs(i);                        // 재귀적 호출
			}
		}
	}

	private static void bfs(int node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		visited[node] = true;

		while (!queue.isEmpty()) {        // bfs는 que를 쓰므로 비어있는지를 확인한다
			int thisNode = queue.poll();
			System.out.print(thisNode + " ");

			for (int i : adjacentNodes[thisNode]) {
				if (!visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}

	private static void initializeCheckVisited(int N) {
		visited = new boolean[N + 1];
	}
}
