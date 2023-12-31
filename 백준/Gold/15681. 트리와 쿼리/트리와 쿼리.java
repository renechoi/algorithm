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
	private static int[] subtreeSize;
	private static boolean[] visited;

	private static StringTokenizer receiveInput(BufferedReader bufferedReader) throws IOException {
		return new StringTokenizer(bufferedReader.readLine());
	}

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));

		StringTokenizer stringTokenizer = receiveInput(bufferedReader);
		int N = parseInt(stringTokenizer.nextToken()); // node counts
		int R = parseInt(stringTokenizer.nextToken()); // root number
		int Q = parseInt(stringTokenizer.nextToken()); // query counts

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

		visited = new boolean[N + 1]; // 정점 번호가 1부터 시작하므로
		subtreeSize = new int[N + 1];

		dfs(R); // 루트 노드부터 DFS 시작

		for (int i = 0; i < Q; i++) {
			int queryNode = Integer.parseInt(bufferedReader.readLine());
			System.out.println(subtreeSize[queryNode]);
		}

	}

	private static int dfs(int node) {
		if (subtreeSize[node] != 0) {  // N이 항상 2개 이상 주어지므로 0을 체크해도 됨 
			return subtreeSize[node];
		}

		visited[node] = true;
		subtreeSize[node] = 1; // 각 노드는 자기 자신을 포함하여 최소 1의 크기를 가짐

		for (int child : adjList.get(node)) {
			if (!visited[child]) {
				subtreeSize[node] += dfs(child);
			}
		}
		return subtreeSize[node];
	}
}