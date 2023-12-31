import static java.lang.Integer.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	private static List<List<Integer>> adjList;
	private static int[] parents;
	private static boolean[] visited;

	private static StringTokenizer receiveInput(BufferedReader bufferedReader) throws IOException {
		return new StringTokenizer(bufferedReader.readLine());
	}

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));

		StringTokenizer stringTokenizer = receiveInput(bufferedReader);
		int N = parseInt(stringTokenizer.nextToken());

		adjList = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			adjList.add(new ArrayList<>());
		}

		for (int i = 0; i < N - 1; i++) {
			stringTokenizer = receiveInput(bufferedReader);
			int a = Integer.parseInt(stringTokenizer.nextToken());
			int b = Integer.parseInt(stringTokenizer.nextToken());
			adjList.get(a).add(b);
			adjList.get(b).add(a);
		}

		parents = new int[N + 1];
		visited = new boolean[N + 1];

		findParents(1);

		for (int i = 2; i <= N; i++) {
			System.out.println(parents[i]);
		}

	}

	private static void findParents(int currentNode) {
		// 현재 노드를 방문 처리
		visited[currentNode] = true;

		// 인접 리스트를 순회
		for (int adjacent : adjList.get(currentNode)) {
			// 인접 노드가 방문되지 않았다면
			if (!visited[adjacent]) {
				// 인접 노드의 부모를 현재 노드로 설정
				parents[adjacent] = currentNode;
				// 인접 노드를 방문
				findParents(adjacent);
			}
		}
	}
}
