
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static Node[][] map;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stringTokenizer.nextToken());
		map = new Node[n][n];
		for (int i = 0; i < n; i++) {
			stringTokenizer = new StringTokenizer(br.readLine());
			String row = stringTokenizer.nextToken().trim();
			for (int j = 0; j < n; j++) {
				int type = row.charAt(j) - '0';
				map[i][j] = new Node(i, j, type);
			}
		}

		List<Integer> 단지수 = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				Node current = map[i][j];
				if (current.isHome() && !current.visited) {
					int count = bfs(current);
					단지수.add(count);
				}
			}
		}

		Collections.sort(단지수);
		StringBuilder sb = new StringBuilder();
		sb.append(단지수.size()).append('\n');
		for (int cnt : 단지수) {
			sb.append(cnt).append('\n');
		}
		System.out.print(sb);
	}

	public static int bfs(Node start) {
		Queue<Node> queue = new ArrayDeque<>();
		start.markVisited();
		queue.offer(start);

		int count = 1;

		while (!queue.isEmpty()) {
			Node current = queue.poll();
			List<Node> adjacentHomes = current.getAdjacentHomes();
			for (Node home : adjacentHomes) {
				home.markVisited();
				queue.offer(home);
				count++;
			}
		}

		return count;

	}

	public static class Node {
		int x;
		int y;
		int type;
		boolean visited;

		public Node(int x, int y, int type) {
			this.x = x;
			this.y = y;
			this.type = type;
			this.visited = false;
		}

		private boolean isHome() {
			return type == 1;
		}

		List<Node> getAdjacentHomes() {
			List<Node> neighbors = new ArrayList<>(4);
			int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
			for (int[] d : dirs) {
				int nx = x + d[0];
				int ny = y + d[1];
				if (0 <= nx && nx < n && 0 <= ny && ny < n) {
					Node adj = map[nx][ny];
					if (adj.isHome() && !adj.visited) {
						neighbors.add(adj);
					}
				}
			}
			return neighbors;
		}

		public void markVisited() {
			this.visited = true;
		}
	}

}