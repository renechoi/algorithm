
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {

	private static List<List<Integer>> graph;


	public int solution(int n, int[][] wires) {

		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++){
			graph.add(new ArrayList<>());
		}

		for (int[] w : wires) {
			int a = w[0];
			int b = w[1];
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		int minDiff = n;                       // 최악 = n-0

		for (int[] cut : wires) {
			int sizeA = bfs(n, cut, cut[0]);   // cut[0] 쪽 컴포넌트 크기
			int sizeB = n - sizeA;             // 나머지 쪽
			minDiff = Math.min(minDiff, Math.abs(sizeA - sizeB));
		}

		return minDiff;
	}

	/**
	 * cut 간선을 제거한 뒤, start 노드가 속한 컴포넌트 크기를 BFS로 구한다.
	 */
	private int bfs(int n, int[] cut, int start) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[n + 1];

		q.offer(start);
		visited[start] = true;

		int cnt = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
			cnt++;

			for (int next : graph.get(cur)) {
				if (isCutEdge(cur, next, cut)){ // e.g., cur = 1, next = 3, cut = [1,3]
					continue;
				}
				if (!visited[next]) {
					visited[next] = true;
					q.offer(next);
				}
			}
		}
		return cnt;
	}

	/**
	 * 잘랐다는 의미 == cut[0] - cut[1] 간선이 없다는 의미 => 탐색에서는 skip 
	 */
	private boolean isCutEdge(int a, int b, int[] cut) {
		return (a == cut[0] && b == cut[1]) || (a == cut[1] && b == cut[0]);
	}

}
