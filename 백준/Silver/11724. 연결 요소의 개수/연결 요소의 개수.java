import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Integer>[] adjList;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		adjList = new ArrayList[n + 1];
		visited = new boolean[n + 1];

		for (int i = 1; i < n + 1; i++) {
			adjList[i] = new ArrayList<>();            // 인접한 요소들 자리에 새로운 배열을 만들어서 인접한 요소들을 갖고 있는다 => e.g 1이 2,5와 인접하다면 adjList[1] = [2, 5]이다
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());    // 문제에서 양 끝점으로 1,2 이와 같은 형식으로 주어진다. 곧 인접하는 노드들이다.
			int node2 = Integer.parseInt(st.nextToken());
			adjList[node1].add(node2);
			adjList[node2].add(node1);                        // 양방향이기 때문에 모두 더해서 보유한다 => 1에 [2,5] 형식으로 존재한다면 곧 1, 2, 5는 서로 인접한다
		}

		int count = 0;
		for (int i = 1; i < n + 1; i++) {
			if (!visited[i]) {  // 모든 것이 전부 방문이 되었을 때까지 반복 = 이것은 dfs 재귀 함수를 통해서 작동한다
				dfs(i);
				count++;    // 한 연결고리가 끝날 때 재귀 반복문이 종료가 될 것이므로 그것이 하나의 연결이다. 따라서 이를 count 하는 것이 곧 정답이 된다
			}
		}
		System.out.println(count);
	}

	private static void dfs(int nodes) {
		
		if (visited[nodes]) {
			return;            // 방문을 했다면 탐색을 하지 않는다
		}

		visited[nodes] = true;    // 방문을 하지 않았다면 지금 방문을 해준 것이므로 flag 처리를 해준다
		
		for (int node : adjList[nodes]) {
			if (!visited[node]) {
				dfs(node);        // 재귀적 호출
			}
		}
	}
}
