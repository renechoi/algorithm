
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

class Solution {

	public int solution(int[][] board) {
		Board gameBoard = new Board(board);
		return bfs(gameBoard);
	}

	public int bfs(Board board) {

		Queue<Road> queue = new ArrayDeque<>();

		Node startRight = new Node(0, 0, Dir.RIGHT);
		Node startDown = new Node(0, 0, Dir.DOWN);

		board.recordStartCost(startRight);
		board.recordStartCost(startDown);

		queue.add(new Road(startRight, 0));
		queue.add(new Road(startDown, 0));

		while (!queue.isEmpty()) {
			Road currentRoad = queue.poll();
			Node currentNode = currentRoad.node;
			int currentCost = currentRoad.accumulatedCost;

			if (board.isGoal(currentNode)) {
				continue;                      // 다른 방향이 더 쌀 수도 있으니 계속 탐색
			}

			for (Node nextNode : currentNode.next(board)) {
				int nextCost = currentCost + currentNode.moveCostTo(nextNode);
				if (board.updateIfCheaper(nextNode, nextCost)) {
					queue.add(new Road(nextNode, nextCost));
				}
			}
		}
		return board.minGoalCost();
	}

	public static class Board {
		public int[][] map;
		public int N;
		public int[][][] costs; // [행][열][방향] = 비용 <- visited 까지 포함

		public Board(int[][] arr) {
			this.map = arr;
			this.N = arr.length;
			this.costs = new int[N][N][4];
			Arrays.stream(costs).forEach(plane -> Arrays.stream(plane).forEach(line -> Arrays.fill(line, Integer.MAX_VALUE))); // plain: 평면 , line: 1차원 행들
		}

		public boolean updateIfCheaper(Node node, int cost) {
			int dirIndex = node.getDirIndex();
			if (cost < costs[node.row][node.col][dirIndex]) {
				costs[node.row][node.col][dirIndex] = cost;
				return true;
			}
			return false;
		}

		public int minGoalCost() {
			return Arrays.stream(costs[N - 1][N - 1]).min().orElse(Integer.MAX_VALUE);
		}

		public boolean inRange(Node p) {
			return 0 <= p.row && p.row < N && 0 <= p.col && p.col < N;
		}

		public boolean canMoveTo(Node p) {
			return inRange(p) && map[p.row][p.col] == 0;
		}

		public boolean isGoal(Node p) {
			return p.row == N - 1 && p.col == N - 1;
		}

		public void recordStartCost(Node startNode) {
			updateIfCheaper(startNode, 0);
		}
	}

	/**
	 * 어느 칸에 어떤 방향으로부터 왔는지 == 위치 + 방향
	 */
	public static class Node {
		public int row;
		public int col;
		public Dir dir;

		public Node(int row, int col, Dir dir) {
			this.row = row;
			this.col = col;
			this.dir = dir;
		}

		public List<Node> next(Board board) {
			List<Node> list = new ArrayList<>(4);
			for (Dir nextDir : Dir.values()) {
				Node nextNode = nextDir.step(this);
				if (board.canMoveTo(nextNode)) {
					list.add(nextNode);
				}
			}
			return list;
		}

		public int moveCostTo(Node nextNode) {
			return this.dir.moveCostTo(nextNode.dir);
		}

		public int getDirIndex() {
			return this.dir.ordinal();
		}

	}

	public enum Dir {
		UP(-1, 0),
		DOWN(1, 0),
		LEFT(0, -1),
		RIGHT(0, 1);

		public final int deltaRow;
		public final int deltaCol;

		Dir(int deltaRow, int deltaCol) {
			this.deltaRow = deltaRow;
			this.deltaCol = deltaCol;
		}

		public Node step(Node node) {
			return new Node(node.row + deltaRow, node.col + deltaCol, this);
		}

		/**
		 * 180° “후진”은 실제로 탐색 대상이긴 하지만 (네 방향 모두 열어보므로)
		 * 이미 더 싼 값이 dist에 기록돼 있으면 {@code updateIfCheaper } 단계에서 걸러지므로,
		 * 즉, “뒤로 한 칸” 갔다가 다시 앞으로 오는 경로는 결국 더 비싸서
		 * 최종 답에는 포함되지 않으므로
		 * “축(가로·세로)이 같은가?” 만으로 충분히 판단할 수 있다.
		 */
		int moveCostTo(Dir next) {
			boolean sameAxis = isBothXAxis(next) || isBothYAxis(next);
			return sameAxis ? 100 : 100 + 500;
		}

		private boolean isBothYAxis(Dir next) {
			return this.deltaCol == 0 && next.deltaCol == 0;
		}

		private boolean isBothXAxis(Dir next) {
			return this.deltaRow == 0 && next.deltaRow == 0;
		}
	}

	public static class Road {
		public Node node;
		public int accumulatedCost;

		public Road(Node node, int accumulatedCost) {
			this.node = node;
			this.accumulatedCost = accumulatedCost;
		}
	}

}
