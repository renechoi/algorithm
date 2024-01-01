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
	private static int connected;
	private static boolean[] visited;

	private static StringTokenizer receiveInput(BufferedReader bufferedReader) throws IOException {
		return new StringTokenizer(bufferedReader.readLine());
	}

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));

		StringTokenizer stringTokenizer = receiveInput(bufferedReader);
		int computers = parseInt(stringTokenizer.nextToken()); // computer counts
		stringTokenizer = receiveInput(bufferedReader);
		int pairs = parseInt(stringTokenizer.nextToken()); // pair counts

		adjList = new ArrayList<>();
		for (int i = 0; i <= computers; i++) {
			adjList.add(new ArrayList<>());
		}

		for (int i = 0; i < pairs; i++) {
			stringTokenizer = receiveInput(bufferedReader);
			int a = Integer.parseInt(stringTokenizer.nextToken());
			int b = Integer.parseInt(stringTokenizer.nextToken());
			adjList.get(a).add(b);
			adjList.get(b).add(a);
		}

		visited = new boolean[computers + 1]; // 정점 번호가 1부터 시작하므로

		dfs(1);

		System.out.println(connected -1);
	}

	private static void dfs(int node){
		visited[node] = true;
		connected++;

		for (int integer : adjList.get(node)) {
			if (!visited[integer]){
				dfs(integer);
			}
		}
	}
}