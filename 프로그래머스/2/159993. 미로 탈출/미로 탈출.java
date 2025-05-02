
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

	public int solution(String[] maps) {

		MapGraph graph = new MapGraph().init(maps);

		int distStartToLever = bfs(graph, graph.start, graph.lever);
		if (distStartToLever == -1) {
			return -1;
		}

		int distLeverToEnd = bfs(graph, graph.lever, graph.end);
		if (distLeverToEnd == -1) {
			return -1;
		}

		return distStartToLever + distLeverToEnd;
	}

	private int bfs(MapGraph mapGraph, Node start, Node target) {

		int n = mapGraph.nodes.length;
		int m = mapGraph.nodes[0].length;
		int[][] dist = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dist[i][j] = -1;
			}
		}

		Queue<Node> queue = new LinkedList<>();
		dist[start.x][start.y] = 0;
		queue.add(start);

		while (!queue.isEmpty()) {
			Node current = queue.poll();
			if (current == target)
				return dist[current.x][current.y];

			for (Node nxt : mapGraph.getAdjacentNodes(current)) {
				if (nxt.isWall || dist[nxt.x][nxt.y] != -1) {
					continue;
				}
				dist[nxt.x][nxt.y] = dist[current.x][current.y] + 1;
				queue.add(nxt);
			}
		}
		return -1;
	}

	public static class MapGraph {
		public Node[][] nodes;
		public Node start;
		public Node lever;
		public Node end;

		public MapGraph init(String[] maps) {
			int n = maps.length;
			int m = maps[0].length();
			nodes = new Node[n][m];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					char ch = maps[i].charAt(j);
					Node node = new Node(i, j);

					if (ch == 'S') {
						node.isStart = true;
						this.start = node;
					} else if (ch == 'E') {
						node.isEnd = true;
						this.end = node;
					} else if (ch == 'L') {
						node.isLever = true;
						this.lever = node;
					}

					if (ch == 'X') {
						node.isWall = true;
					}

					nodes[i][j] = node;
				}
			}
			return this;
		}

		public List<Node> getAdjacentNodes(Node node) {
			List<Node> adjacentNodes = new ArrayList<>(4);
			int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
			for (int[] dir : directions) {
				int nx = node.x + dir[0];
				int ny = node.y + dir[1];
				if (isValid(nx, ny))
					adjacentNodes.add(nodes[nx][ny]);
			}
			return adjacentNodes;
		}

		private boolean isValid(int x, int y) {
			return x >= 0 && x < nodes.length && y >= 0 && y < nodes[0].length;
		}
	}

	public static class Node {
		int x, y;
		boolean isStart, isEnd, isLever, isWall;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	
}
